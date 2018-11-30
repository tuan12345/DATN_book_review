package app.dto;

import java.util.Date;

public class CommentInfo {
	private Integer id;
	private int prarentId;
	private String content;
	private Date createdAt;
	private UserInfo user;
	private ReviewInfo review;

	public CommentInfo(Integer id, String content, Date createdAt, UserInfo user) {
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.user = user;
	}

	public CommentInfo(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPrarentId() {
		return prarentId;
	}

	public void setPrarentId(int prarentId) {
		this.prarentId = prarentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public ReviewInfo getReview() {
		return review;
	}

	public void setReview(ReviewInfo review) {
		this.review = review;
	}

}
