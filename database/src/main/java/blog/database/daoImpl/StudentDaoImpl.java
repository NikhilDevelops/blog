package blog.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.database.daoService.StudentDaoService;
import blog.database.model.Student;

@Component
@Transactional
public class StudentDaoImpl implements StudentDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(student);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
	    try {
			sessionFactory.getCurrentSession().delete(student);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(student);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Student getStudentById(long userId) {
		// TODO Auto-generated method stub
	     try {
		return	(Student)sessionFactory.getCurrentSession().createQuery("from Student where userId=:id").setParameter("id",userId).getSingleResult();
		} catch (HibernateException e) {
			// TODO: handle exception
		return null;
		}
	}

}
