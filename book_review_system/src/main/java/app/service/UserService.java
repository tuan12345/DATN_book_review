package app.service;

import java.util.List;
import java.util.Locale;

import app.dto.UserInfo;
import app.model.User;
import app.util.GooglePojo;

public interface UserService extends BaseService<Integer, User> {
	List<UserInfo> loadUsers(int page);

	boolean deleteUser(int id);

	int loadRowCount();

	User updateUser(UserInfo userInfo);

	UserInfo findUserInfoById(int id);

	User findUserById(int id, Boolean lock);

	UserInfo findUserInfoByUsername(String userName);

	boolean updatePassword(UserInfo userInfo, Locale locale);

	List<UserInfo> loadAllUsers();

	boolean saveUsers(List<UserInfo> userInfos);
	
	boolean saveUser(GooglePojo userGoogle, String token);
}