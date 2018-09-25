package blog.database.daoService;

import blog.database.model.Lecturer;

public interface LecturerDaoService {

	public abstract boolean addLecturer(Lecturer lecturer);
	public abstract boolean updateLecturer(Lecturer lecturer);
	public abstract boolean deleteLecturer(Lecturer lecturer);
	public abstract Lecturer getLecturerById(long userId);
}
