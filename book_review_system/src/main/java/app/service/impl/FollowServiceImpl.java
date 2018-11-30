package app.service.impl;

import java.io.Serializable;
import org.apache.log4j.Logger;
import app.dto.FollowInfo;
import app.dto.RoleInfo;
import app.dto.UserInfo;
import app.model.Follow;
import app.service.FollowService;

public class FollowServiceImpl extends BaseServiceImpl implements FollowService {
	private static final Logger logger = Logger.getLogger(FollowServiceImpl.class);

	@Override
	public Follow findById(Serializable key, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Follow saveOrUpdate(Follow entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Follow entity) {
		try {
			followDAO.delete(entity);
			return true;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public FollowInfo getFollow(int follower_id, int followed_id) {
		try {
			Follow follow = followDAO.getFollow(follower_id, followed_id);
			if (follow == null) {
				return null;
			}
			UserInfo follower = new UserInfo(follow.getFollower().getId(), follow.getFollower().getFullName(),
					follow.getFollower().getUserName(), follow.getFollower().getEmail(),
					new RoleInfo(follow.getFollower().getRole().getId(), follow.getFollower().getRole().getName()));
			UserInfo followed = new UserInfo(follow.getFollowed().getId(), follow.getFollowed().getFullName(),
					follow.getFollowed().getUserName(), follow.getFollowed().getEmail(),
					new RoleInfo(follow.getFollowed().getRole().getId(), follow.getFollowed().getRole().getName()));
			return new FollowInfo(follow.getId(), follower, followed);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public FollowInfo createFollow(int follower_id, int followed_id) {
		try {
			Follow follow = new Follow();
			follow.setFollowed(userDAO.findByIdLock(followed_id, false));
			follow.setFollower(userDAO.findByIdLock(follower_id, false));
			return ConvertModelToBean.mapFollowToFollowInfo(followDAO.saveOrUpdate(follow));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean deleteFollow(int id) {
		try {
			Follow follow = followDAO.findByIdLock(id, true);
			followDAO.delete(follow);
			return true;

		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

}
