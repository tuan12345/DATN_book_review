package app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;

import app.dto.RoleInfo;
import app.dto.UserInfo;
import app.model.Role;
import app.model.User;
import app.service.UserService;
import app.util.GooglePojo;
import app.util.MailUtil;
import app.util.PasswordUtil;

public class UserServiceImpl extends BaseServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public User findById(Serializable key, boolean lock) {
		try {
			return userDAO.findById(key);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User saveOrUpdate(User entity) {
		try {
			return userDAO.saveOrUpdate(entity);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public boolean delete(User entity) {
		try {
			userDAO.delete(entity);
			return true;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public List<UserInfo> loadUsers(int page) {
		try {
			List<UserInfo> userInfos = new ArrayList<>();
			if (page == 1) {
				page = page - 1;
			} else {
				page = (page * 5) - 5;
			}

			List<User> users = userDAO.loadUsers(page);

			for (User user : users) {
				RoleInfo roleInfo = new RoleInfo(user.getRole().getId(), user.getRole().getName());
				userInfos.add(
						new UserInfo(user.getId(), user.getFullName(), user.getUserName(), user.getEmail(), roleInfo));
			}
			return userInfos;
		} catch (Exception e) {
			return Collections.emptyList();
		}

	}

	@Override
	public boolean deleteUser(int id) {
		try {
			User user = userDAO.findById(id);
			return delete(user);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public int loadRowCount() {
		try {
			return userDAO.loadRowsCount();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public User updateUser(UserInfo userInfo) {
		try {
			Role role = roleDAO.findById(userInfo.getRole().getId());
			if (role == null) {
				return null;
			}
			User user = userDAO.findByIdLock(userInfo.getId(), true);
			user.setFullName(userInfo.getName());
			user.setEmail(userInfo.getEmail());
			user.setRole(role);
			return saveOrUpdate(user);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public UserInfo findUserInfoById(int id) {
		try {
			User user = findById(id, false);
			RoleInfo roleInfo = new RoleInfo(user.getRole().getId(), user.getRole().getName());
			UserInfo userInfo = new UserInfo(user.getId(), user.getFullName(), user.getUserName(), user.getEmail(),
					roleInfo);
			return userInfo;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public User findUserById(int id, Boolean lock) {
		try {
			return userDAO.findByIdLock(id, lock);

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public UserInfo findUserInfoByUsername(String userName) {
		try {
			return ConvertModelToBean.mapUserToUserInfo(userDAO.loadUserByUserName(userName));
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public boolean updatePassword(UserInfo userInfo, Locale locale) {
		try {
			User user = userDAO.findByUserNameAndEmail(userInfo.getUserName(), userInfo.getEmail());
			if (user == null) {
				return false;
			}
			int noopPassword = PasswordUtil.randomPassword();
			User userUpdate = userDAO.findByIdLock(user.getId(), true);
			userUpdate.setPassword(PasswordUtil.passwordEndcode(String.valueOf(noopPassword)));
			saveOrUpdate(userUpdate);
			SimpleMailMessage message = MailUtil.message(MailUtil.mailName, userInfo.getEmail(),
					messageSource.getMessage("mail.subject.resetpass", null, locale),
					messageSource.getMessage("mail.reset.message", null, locale) + noopPassword);
			mailSender.send(message);
			return true;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public List<UserInfo> loadAllUsers() {
		try {
			List<UserInfo> userInfos = new ArrayList<>();
			List<User> users = userDAO.loadAllUsers();
			for (User user : users) {
				RoleInfo roleInfo = new RoleInfo(user.getRole().getId(), user.getRole().getName());
				userInfos.add(
						new UserInfo(user.getId(), user.getFullName(), user.getUserName(), user.getEmail(), roleInfo));
			}
			return userInfos;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public boolean saveUsers(List<UserInfo> userInfos) {
		try {
			Role role = roleDAO.findById(1);
			for (UserInfo userInfo : userInfos) {
				User user = new User();
				user.setUserName(userInfo.getUserName());
				user.setFullName(userInfo.getName());
				user.setEmail(userInfo.getEmail());
				user.setRole(role);
				user.setPassword(PasswordUtil.passwordEndcode(PasswordUtil.DEFAULT_PASSWORD));
				saveOrUpdate(user);
			}
			return true;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public boolean saveUser(GooglePojo userGoogle, String token) {
		try {
			Role role = roleDAO.findById(2);
			User user = new User();
			user.setRole(role);
			user.setFullName(userGoogle.getFamily_name());
			user.setEmail(userGoogle.getEmail());
			user.setPassword(token);
			user.setUserName(userGoogle.getEmail());
			saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
}
