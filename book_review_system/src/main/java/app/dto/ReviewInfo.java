package app.dto;

import java.util.Date;

public class ReviewInfo {
	private Integer id;
	private int numberOfStar;
	private String content;
	private Date createdAt;
	private UserInfo userInfo;
	private BookInfo bookInfo;
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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
	

	public ReviewInfo(int numberOfStar, String content) {
		
		this.numberOfStar = numberOfStar;
		this.content = content;
		
	}

	public ReviewInfo(Integer id, int numberOfStar, String content, Date createdAt, UserInfo userInfo,BookInfo bookInfo,String title) {
		super();
		this.id = id;
		this.numberOfStar = numberOfStar;
		this.content = content;
		this.createdAt = createdAt;
		this.userInfo = userInfo;
		this.bookInfo=bookInfo;
		this.title=title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumberOfStar() {
		return numberOfStar;
	}

	public void setNumberOfStar(int numberOfStar) {
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
