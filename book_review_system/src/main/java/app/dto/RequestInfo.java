package app.dto;

import java.util.Date;

public class RequestInfo {
	private Integer id;
	private int status;
	private Date createdAt;
	private String bookTittle;
	private String bookAuthor;
	private UserInfo user;
	private CategoryInfo categoryInfo;
	
	public RequestInfo() {
		super();
	}
	public RequestInfo(Integer id, int status, Date createdAt, String bookTittle, String bookAuthor, UserInfo user,
			CategoryInfo category) {
		super();
		this.id = id;
		this.status = status;
		this.createdAt = createdAt;
		this.bookTittle = bookTittle;
		this.bookAuthor = bookAuthor;
		this.user = user;
		this.categoryInfo = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getBookTittle() {
		return bookTittle;
	}
	public void setBookTittle(String bookTittle) {
		this.bookTittle = bookTittle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public CategoryInfo getCategory() {
		return categoryInfo;
	}
	public void setCategory(CategoryInfo category) {
		this.categoryInfo = category;
	}
	

}
