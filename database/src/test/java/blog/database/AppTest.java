package blog.database;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.database.daoService.AdminDaoService;
import blog.database.daoService.LecturerDaoService;
import blog.database.daoService.StudentDaoService;
import blog.database.model.Admin;
import blog.database.model.Lecturer;
import blog.database.model.Student;
import junit.framework.TestCase;
import junit.framework.TestSuite;

@SpringJUnitConfig(classes = {HibernateConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest 
{
	@Autowired
	private AdminDaoService adminDaoService;
  
	@Autowired
	private Admin admin;
	
	@Autowired
	private LecturerDaoService lecturerDaoService;

	@Autowired
	private Lecturer lecturer;
	
	@Autowired
	private StudentDaoService studentDaoService;
	
	@Autowired
	private Student student;
	
	@Before
	public void setUp()
	{
		admin.setMobile("a1234567");
	    admin.setEmail("admin@gmail.com");
	    admin.setName("admin");
	    admin.setPassword("@12345");
	    
	    lecturer.setEmail("lecturer@gmail.com");
	    lecturer.setMobile("l1234567");
	    lecturer.setName("lecturer");
	    lecturer.setPassword("@12345");
	   
	    student.setEmail("student@gmail.com");
	    student.setMobile("s1234567");
	    student.setName("student");
	    student.setPassword("@12345");
	}
	
	@Test
	public void addAdminTest()
	{
		assertEquals("addAminTestFailed",true,adminDaoService.addAdmin(admin));
	deleteAdmin();
	}
	
	@Test
	public void updateAdminTest()
	{
		adminDaoService.addAdmin(admin);
		admin.setEmail("jhdkjala");
		assertEquals("updateAdminTestFailed",true,adminDaoService.updateAdmin(admin));
		deleteAdmin();
	}
	
	@Test
	public void getAdminTest()
	{
		adminDaoService.addAdmin(admin);
		assertEquals("getAdminTestFailed",admin,adminDaoService.getAdminById(admin.getUserId()));
		deleteAdmin();
	}
	
	
	
    @Test
	public void addLecturerTest()
	{
		assertEquals("addLecturerTestFailed",true, lecturerDaoService.addLecturer(lecturer));
	  deleteLecturer();
	}
    
    @Test
    public void updateLecturerTest()
    {
    	lecturerDaoService.addLecturer(lecturer);
    	lecturer.setEmail("dgsj");
    	assertEquals("updateLecturerTestFailed",true,lecturerDaoService.updateLecturer(lecturer));
    	deleteLecturer();
    }
    
    @Test
    public void getLecturerTest()
    {
    	lecturerDaoService.addLecturer(lecturer);
    	assertEquals("getLecturerTestFailed",lecturer,lecturerDaoService.getLecturerById(lecturer.getUserId()));
    	deleteLecturer();
    }
	
    @Test
	public void addStudentTest()
	{
		assertEquals("addStudentTestFailed",true,studentDaoService.addStudent(student));
		deleteStudent();
	}
	
    @Test
    public void updateStudentTest()
    {
    	studentDaoService.addStudent(student);
    	student.setEmail("fghjk");
    	assertEquals("updateStudentTestFailed",true,studentDaoService.updateStudent(student));
    	deleteStudent();
    }
    
    @Test
    public void getStudentTest()
    {
    	studentDaoService.addStudent(student);
    	assertEquals("getstudentTestFailed",student,studentDaoService.getStudentById(student.getUserId()));
    	deleteStudent();
    }
	
	public void deleteStudent()
	{
		studentDaoService.deleteStudent(student);
	}
	
	public void deleteLecturer()
	{
		lecturerDaoService.deleteLecturer(lecturer);
	}
	
	public void deleteAdmin()
	{
		adminDaoService.deleteAdmin(admin);
	}
	
	
/*		@After
	public void deleteAll()
	{
		if(studentDaoService.getStudentById(student.getUserId())!=null)
		{
			studentDaoService.deleteStudent(student);	
		}
		if(lecturerDaoService.getLecturerById(lecturer.getUserId())!=null)
		{
		lecturerDaoService.deleteLecturer(lecturer);	
		}
		if(adminDaoService.getAdminById(admin.getUserId())!=null)
		{
			adminDaoService.deleteAdmin(admin);
		}
	}
	*/
}
