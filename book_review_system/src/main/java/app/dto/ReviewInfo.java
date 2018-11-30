package app.dto;

import java.util.Date;

public class ReviewInfo {
	private Integer id;
	private float numberOfStar;
	private String content;
	private Date createdAt;
	private UserInfo userInfo;
	private BookInfo bookInfo;

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo info) {
		this.userInfo = info;
	}
	

	public ReviewInfo() {
		super();
	}
	

	public ReviewInfo(float numberOfStar, String content) {
		
		this.numberOfStar = numberOfStar;
		this.content = content;
		
	}

	public ReviewInfo(Integer id, float numberOfStar, String content, Date createdAt, UserInfo userInfo,BookInfo bookInfo) {
		super();
		this.id = id;
		this.numberOfStar = numberOfStar;
		this.content = content;
		this.createdAt = createdAt;
		this.userInfo = userInfo;
		this.bookInfo=bookInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getNumberOfStar() {
		return numberOfStar;
	}

	public void setNumberOfStar(float numberOfStar) {
		this.numberOfStar = numberOfStar;
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

}
