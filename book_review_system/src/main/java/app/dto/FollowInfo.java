package app.dto;

public class FollowInfo {
	private int id;
	private UserInfo follower;
	private UserInfo followed;

	public FollowInfo(){
		
	}
	
	public FollowInfo(int id, UserInfo follower, UserInfo followed) {
		this.id = id;
		this.follower = follower;
		this.followed = followed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserInfo getFollower() {
		return follower;
	}

	public void setFollower(UserInfo follower) {
		this.follower = follower;
	}

	public UserInfo getFollowed() {
		return followed;
	}

	public void setFollowed(UserInfo followed) {
		this.followed = followed;
	}

}
