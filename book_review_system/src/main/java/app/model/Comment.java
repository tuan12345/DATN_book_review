package app.model;

import java.util.Date;

public class Comment {
	private Integer id;
	private int prarentId;
	private String content;
	private Date createdAt;
	private User user;
	private Review review;

	public Comment() {

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

	public void setCreatedAt(Date createAt) {
		this.createdAt = createAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
}
