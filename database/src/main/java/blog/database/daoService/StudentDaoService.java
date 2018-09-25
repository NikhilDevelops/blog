package blog.database.daoService;

import blog.database.model.Student;

public interface StudentDaoService {

	public abstract boolean addStudent(Student student);
	public abstract boolean deleteStudent(Student student);
	public abstract boolean updateStudent(Student student);
	public abstract Student getStudentById(long userId);
}
