package app.service;

import java.util.List;

import app.dto.ResponseReviewInfo;
import app.dto.ReviewInfo;
import app.model.Review;

public interface ReviewService extends BaseService<Integer, ReviewInfo>{
	List<Review> loadReviews();
	
	List<ReviewInfo> loadReviewsForBook(int book_id);
	
	 ReviewInfo findUserRivew(Integer userId, Integer bookId);
		
	 ReviewInfo createReview(ReviewInfo reviewInfo, int bookId, int userId);
	 
	 ReviewInfo updateReview(ReviewInfo reviewInfo);
	 
	 List<ReviewInfo> loadReviewsByPage(Integer page,Integer maxResult,Integer book_id);
	 
	 Integer page(Long countReview,Integer maxResult);
	 
	 List<ResponseReviewInfo> loadAjxReview(Integer page,Integer book_id,Integer maxResult);
	 
	 List<ResponseReviewInfo> loadReviewUseful(Integer page,Integer book_id,Integer maxResult);
}
