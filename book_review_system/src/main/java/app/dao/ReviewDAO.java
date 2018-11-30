package app.dao;

import java.util.List;

import app.model.Review;

public interface ReviewDAO extends BaseDAO<Integer, Review> {
	List<Review> loadReivews();

	List<Review> loadReviewsForBook(int book_id);

}
