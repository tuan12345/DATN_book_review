package app.service;

import java.util.List;

import app.dto.ReviewInfo;
import app.model.Review;

public interface ReviewService extends BaseService<Integer, ReviewInfo>{
	List<Review> loadReviews();
	
	List<ReviewInfo> loadReviewsForBook(int book_id);
	
	 ReviewInfo findUserRivew(Integer userId, Integer bookId);
		
	 ReviewInfo createReview(ReviewInfo reviewInfo, int bookId, int userId);
	 
	 ReviewInfo updateReview(ReviewInfo reviewInfo);
}
