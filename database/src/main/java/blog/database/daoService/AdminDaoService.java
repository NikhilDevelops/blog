package blog.database.daoService;

import blog.database.model.Admin;

public interface AdminDaoService {
	
	public abstract boolean addAdmin(Admin admin);
	public abstract boolean updateAdmin(Admin admin);
	public abstract boolean deleteAdmin(Admin admin);
	public abstract Admin getAdminById(long userId);
}
