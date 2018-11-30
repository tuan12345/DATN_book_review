package app.dto;

public class MarkInfo {
	private Integer id;
	private int readStatus;
	private int pageMark;
	private boolean favorite;
	private UserInfo user;
	private BookInfo book;
	
	public MarkInfo(Integer id, int readStatus, int pageMark, boolean favorite, UserInfo user, BookInfo book) {
		super();
		this.id = id;
		this.readStatus = readStatus;
		this.pageMark = pageMark;
		this.favorite = favorite;
		this.user = user;
		this.book = book;
	}
	public MarkInfo() {
		super();
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
	public void setReadStatus(int readStatus) {
		this.readStatus = readStatus;
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
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public BookInfo getBook() {
		return book;
	}
	public void setBook(BookInfo book) {
		this.book = book;
	}
	

}
