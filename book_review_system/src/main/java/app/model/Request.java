package app.model;

import java.util.Date;

public class Request {
	private Integer id;
	private int status;
	private Date createdAt;
	private String bookTittle;
	private String bookAuthor;
	private User user;
	private Category category;

	public Request() {

	}

	public Request(Date createdAt, String bookTittle, String bookAuthor, User user, Category category) {
		super();
		this.createdAt = createdAt;
		this.bookTittle = bookTittle;
		this.bookAuthor = bookAuthor;
		this.user = user;
		this.category = category;
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

	public void setCreatedAt(Date createAt) {
		this.createdAt = createAt;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
