package blog.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.database.daoService.LecturerDaoService;
import blog.database.model.Lecturer;

@Component
@Transactional
public class LecturerDaoImpl implements LecturerDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(lecturer);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(lecturer);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(lecturer);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Lecturer getLecturerById(long userId) {
		// TODO Auto-generated method stub
		try {
		return 	(Lecturer)sessionFactory.getCurrentSession().createQuery("from Lecturer where userId=:id").setParameter("id", userId).getSingleResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
