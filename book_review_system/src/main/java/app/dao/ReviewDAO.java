package app.dao;

import java.util.List;

import app.model.Review;

public interface ReviewDAO extends BaseDAO<Integer, Review> {
	List<Review> loadReivews();

	List<Review> loadReviewsForBook(int book_id);
	
	List<Review> loadReviewsByPage(Integer page,int maxResult,int book_id);
	
	List<Review> loadReviewsUseful(Integer page,int book_id ,int maxResult);
	
	List<Review> loadAllReviewUseful();

}
