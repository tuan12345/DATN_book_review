package app.dto;

import java.util.Date;

import app.model.User;

public class ActivityInfo {
	private Integer id;
	private int objectId;
	private String type;
	private String note;
	private Date createdAt;
	private User user;

	public ActivityInfo() {

	}

	public ActivityInfo(Integer id, int objectId, String type, String note, Date createdAt, User user) {
		this.id = id;
		this.objectId = objectId;
		this.type = type;
		this.note = note;
		this.createdAt = createdAt;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
