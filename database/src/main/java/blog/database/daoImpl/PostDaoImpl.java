package blog.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.database.daoService.PostDaoService;
import blog.database.model.Post;

@Component
@Transactional
public class PostDaoImpl implements PostDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addPost(Post post) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(post);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deletePost(Post post) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(post);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updatePost(Post post) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(post);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Post getPostById(long userId) {
		// TODO Auto-generated method stub
		try {
			return (Post)sessionFactory.getCurrentSession().createQuery("from Post where user_userId=:id").setParameter("id", userId).getSingleResult();		
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	
	
	
	}

}
