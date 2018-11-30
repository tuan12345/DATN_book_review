package app.model;

public class Mark {
	private Integer id;
	private int readStatus;
	private int pageMark;
	private boolean favorite;
	private User user;
	private Book book;

	public Mark() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(int readSatatus) {
		this.readStatus = readSatatus;
	}

	public int getPageMark() {
		return pageMark;
	}

	public void setPageMark(int pageMark) {
		this.pageMark = pageMark;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
