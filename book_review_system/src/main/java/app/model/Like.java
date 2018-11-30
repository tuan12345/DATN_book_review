package app.model;

public class Like {
	private Integer id;
	private boolean like;
	private User user;
	private Activity activity;
	
	public Like(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
