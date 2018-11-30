package app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import app.dto.CommentInfo;
import app.dto.RoleInfo;
import app.dto.UserInfo;
import app.model.Comment;
import app.model.Review;
import app.model.User;
import app.service.CommentService;

public class CommentServiceImpl extends BaseServiceImpl implements CommentService {
	private Logger logger = Logger.getLogger(CommentServiceImpl.class);

	@Override
	public CommentInfo findById(Serializable key, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentInfo saveOrUpdate(CommentInfo entity) {
		try {
			Date date = new Date();
			User user = userDAO.findById(entity.getUser().getId());
			Review review = reviewDAO.findById(entity.getReview().getId());
			Comment comment = new Comment();
			comment.setContent(entity.getContent());
			comment.setReview(review);
			comment.setPrarentId(1);
			comment.setUser(user);
			comment.setCreatedAt(date);
			commentDAO.saveOrUpdate(comment);
			return entity;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public boolean delete(CommentInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CommentInfo> loadCommentByReviewId(int review_id) {
		try {
			List<Comment> comments = commentDAO.loadCommentByReviewId(review_id);
			List<CommentInfo> commentInfos = new ArrayList<CommentInfo>();
			for (Comment comment : comments) {
				UserInfo userInfo = new UserInfo(comment.getUser().getId(), comment.getUser().getFullName(),
						comment.getUser().getUserName(), comment.getUser().getEmail(), new RoleInfo());
				CommentInfo commentInfo = new CommentInfo(comment.getId(), comment.getContent(), comment.getCreatedAt(),
						userInfo);
				commentInfos.add(commentInfo);
			}
			return commentInfos;
		} catch (Exception e) {
			logger.error(e);
			return Collections.emptyList();
		}
	}

}
