package blog.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.database.daoService.CommentDaoService;
import blog.database.model.Comment;

@Component
@Transactional
public class CommentDaoImpl implements CommentDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
	try {
		sessionFactory.getCurrentSession().save(comment);
		return true;
	} catch (HibernateException e) {
		// TODO: handle exception
		return false;
	}
	}

	@Override
	public boolean deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(comment);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateComment(Comment comment) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().update(comment);
		return true;
		} catch (HibernateException  e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Comment getCommentById(long userId) {
		// TODO Auto-generated method stub
		try {
		return	(Comment)sessionFactory.getCurrentSession().createQuery("from Comment where user_userId=:id").setParameter("id",userId).getSingleResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
