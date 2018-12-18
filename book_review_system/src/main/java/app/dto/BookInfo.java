package app.dto;

import java.util.Date;
import java.util.List;
import app.model.Category;
import app.model.Publisher;
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
	private String imageDetail;
	private Publisher publisher;
	private String description;
	private float percentStar1;
	private float percentStar2;
	private float percentStar3;
	private float percentStar4;
	private float percentStar5;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageDetail() {
		return imageDetail;
	}

	public void setImageDetail(String imageDetail) {
		this.imageDetail = imageDetail;
	}

	public void setAvgStar(float avgStar) {
		this.avgStar = avgStar;
	}

	public void setQuantityVote(int quantityVote) {
		this.quantityVote = quantityVote;
	}

	private List<Review> reviews;

	public BookInfo() {

	}

	public BookInfo(Integer id, String tittle, Date publishDate, String authorName, int numberOfPage, String image,
			Category category, String imageDetail, Publisher publisher, String description) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.publishDate = publishDate;
		this.authorName = authorName;
		this.numberOfPage = numberOfPage;
		this.image = image;
		this.category = category;
		this.imageDetail = imageDetail;
		this.publisher = publisher;
		this.description = description;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
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

	public void setPercentStar(List<Review> reviews) {
		float numberStar1 = 0;
		float numberStar2 = 0;
		float numberStar3 = 0;
		float numberStar4 = 0;
		float numberStar5 = 0;
		float numberReview = reviews.size();
		for (Review review : reviews) {
			if (review.getNumberOfStar() == 1)
				numberStar1++;
			if (review.getNumberOfStar() == 2)
				numberStar2++;
			if (review.getNumberOfStar() == 3)
				numberStar3++;
			if (review.getNumberOfStar() == 4)
				numberStar4++;
			if (review.getNumberOfStar() == 5)
				numberStar5++;
		}
		float temppercentStar1 = (float)Math.round((numberStar1 / numberReview) * 100) / 100;
		float temppercentStar2 = (float)Math.round((numberStar2 / numberReview) * 100) / 100;
		float temppercentStar3 =(float) Math.round((numberStar3 / numberReview) * 100) / 100;
		float temppercentStar4 = (float)Math.round((numberStar4 / numberReview) * 100) / 100;
		float temppercentStar5 = (float)Math.round((numberStar5 / numberReview) * 100) / 100;
		setPercentStar1(temppercentStar1 * 100);
		setPercentStar2(temppercentStar2 * 100);
		setPercentStar3(temppercentStar3 * 100);
		setPercentStar4(temppercentStar4 * 100);
		setPercentStar5(temppercentStar5 * 100);
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

	public float getPercentStar1() {
		return percentStar1;
	}

	public void setPercentStar1(float percentStar1) {
		this.percentStar1 = percentStar1;
	}

	public float getPercentStar2() {
		return percentStar2;
	}

	public void setPercentStar2(float percentStar2) {
		this.percentStar2 = percentStar2;
	}

	public float getPercentStar3() {
		return percentStar3;
	}

	public void setPercentStar3(float percentStar3) {
		this.percentStar3 = percentStar3;
	}

	public float getPercentStar4() {
		return percentStar4;
	}

	public void setPercentStar4(float percentStar4) {
		this.percentStar4 = percentStar4;
	}

	public float getPercentStar5() {
		return percentStar5;
	}

	public void setPercentStar5(float percentStar5) {
		this.percentStar5 = percentStar5;
	}
	public static void main(String[] args) {
		double rate=10.3546645;
		float a=(float) ((double)Math.round((2.0/3.0)* 100) / 100);
		System.out.println(a);
	}

}
