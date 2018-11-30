package app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import app.dao.CommentDAO;
import app.dao.GenericDAO;
import app.model.Comment;

public class CommentDAOImpl extends GenericDAO<Integer, Comment> implements CommentDAO{

	@Override
	public List<Comment> loadCommentByReviewId(int review_id) {
		Criteria criteria = getSession().createCriteria(Comment.class);
		criteria.createAlias("review", "rv");
		criteria.add(Restrictions.eq("rv.id", review_id));
		return criteria.list();
	}
	
}
