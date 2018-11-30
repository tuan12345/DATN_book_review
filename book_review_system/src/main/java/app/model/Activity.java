package app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Activity implements Serializable {
	private static final long serialVersionUID = 3632201000665068304L;
	private Integer id;
	private int objectId;
	private String type;
	private String note;
	private Date createdAt;
	@JsonIgnore
	private User user;
	private List<Like> likes;

	public Activity() {

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
