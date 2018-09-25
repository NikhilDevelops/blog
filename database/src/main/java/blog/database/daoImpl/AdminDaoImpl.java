package blog.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.database.daoService.AdminDaoService;
import blog.database.model.Admin;

@Component
@Transactional
public class AdminDaoImpl implements AdminDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(admin);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(admin);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(admin);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Admin getAdminById(long userId) {
		// TODO Auto-generated method stub
		try {
		return (Admin)sessionFactory.getCurrentSession().createQuery("from Admin where userId=:id").setParameter("id",userId).getSingleResult();
				
		} catch (HibernateException  e) {
			// TODO: handle exception
			return null;
		}
	}

}
