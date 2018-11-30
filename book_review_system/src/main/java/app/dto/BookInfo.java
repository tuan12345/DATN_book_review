package app.dto;

import java.util.Date;
import java.util.List;
import app.model.Category;
import app.model.Review;

public class BookInfo {
	private Integer id;
	private String tittle;
	private Date publishDate;
	private String authorName;
	private int numberOfPage;
	private String image;
	private Category category;
	private float avgStar;
	private int quantityVote;
	private List<Review> reviews;

	public BookInfo() {

	}

	public BookInfo(Integer id, String tittle, Date publishDate, String authorName, int numberOfPage, String image,
			Category category) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.publishDate = publishDate;
		this.authorName = authorName;
		this.numberOfPage = numberOfPage;
		this.image = image;
		this.category = category;
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

	public float getAvgStar() {
		return avgStar;
	}

	public void setAvgStar(List<Review> reviews) {
		if (!reviews.isEmpty()) {
			float star = 0;
			for (Review review : reviews) {
				star = star + review.getNumberOfStar();
			}
			this.avgStar = (star / reviews.size());
		} else {
			this.avgStar = 0;
		}
	}

	public int getQuantityVote() {
		return quantityVote;
	}

	public void setQuantityVote(List<Review> reviews) {
		this.quantityVote = reviews.size();
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
