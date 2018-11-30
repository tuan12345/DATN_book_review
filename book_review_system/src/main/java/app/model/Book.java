package app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Book implements Serializable {
	private static final long serialVersionUID = 5974438385263559928L;
	private Integer id;
	private String tittle;
	private Date publishDate;
	private String authorName;
	private int numberOfPage;
	private String image;
	private Category category;
	private List<Review> reviews;
	private List<Mark> marks;

	public Book(Integer id, String tittle, Date publishDate, String authorName, int numberOfPage, String image,
			Category category, List<Review> reviews, List<Mark> marks) {
		this.id = id;
		this.tittle = tittle;
		this.publishDate = publishDate;
		this.authorName = authorName;
		this.numberOfPage = numberOfPage;
		this.image = image;
		this.category = category;
		this.reviews = reviews;
		this.marks = marks;
	}

	public Book(String tittle, Date publishDate, String authorName, int numberOfPage, String image,
			Category category) {
		this.tittle = tittle;
		this.publishDate = publishDate;
		this.authorName = authorName;
		this.numberOfPage = numberOfPage;
		this.image = image;
		this.category = category;
	}
	
	public Book() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
}
