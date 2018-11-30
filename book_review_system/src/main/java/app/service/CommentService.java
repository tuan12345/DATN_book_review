package app.service;

import java.util.List;

import app.dto.CommentInfo;
import app.model.Comment;

public interface CommentService extends BaseService<Integer, CommentInfo>{
	List<CommentInfo> loadCommentByReviewId(int review_id);
}
