package app.service;

import app.dto.FollowInfo;
import app.model.Follow;

public interface FollowService extends BaseService<Integer, Follow> {
	FollowInfo getFollow(int follower_id, int followed_id);

	FollowInfo createFollow(int follower_id, int followed_id);

	Boolean deleteFollow(int id);

}
