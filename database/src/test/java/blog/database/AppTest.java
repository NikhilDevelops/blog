package blog.database;


import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.jdbc.Clob;

import blog.database.daoService.AdminDaoService;
import blog.database.daoService.CommentDaoService;
import blog.database.daoService.LecturerDaoService;
import blog.database.daoService.PostDaoService;
import blog.database.daoService.StudentDaoService;
import blog.database.model.Admin;
import blog.database.model.Comment;
import blog.database.model.Lecturer;
import blog.database.model.Post;
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
		
	@Autowired
	private Post post;
	
	@Autowired
	private PostDaoService postDaoService;
	
	@Autowired
	private Comment comment;
	
	@Autowired
	private CommentDaoService commentDaoService;
	
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

	    java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
	    java.sql.Timestamp time=new java.sql.Timestamp(new java.util.Date().getTime());
	    
	    post.setContent("hii my name is nikhil chandra,im from hyderabad,which is in telangana,India,Asia,Earth.");
	    post.setTitle("First Post");
	    post.setDate(date);
	    post.setTime(time);
	
	    comment.setComment("first comment");
	    comment.setDate(date);
	    comment.setTime(time);
	    
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
    
    @Test
    public void addPostTest()
    {
    	adminDaoService.addAdmin(admin);
    	post.setUser(admin);
        assertEquals("addPostTestFailed",true,postDaoService.addPost(post));
        deletePost();
        deleteAdmin();
    }
    
    @Test
    public void updatePostTest()
    {
    	adminDaoService.addAdmin(admin);
    	post.setUser(admin);
    	postDaoService.addPost(post);
    	post.setContent("moved to mars.");
    	assertEquals("updatePostTestFailed",true,postDaoService.updatePost(post));
    	deletePost();
    	deleteAdmin();
    }
    
    @Test
    public void getPostTest()
    {
    	adminDaoService.addAdmin(admin);
    	post.setUser(admin);
    	postDaoService.addPost(post);
    	assertEquals("getPostTestFailed",post,postDaoService.getPostById(admin.getUserId()));
    	deletePost();
    	deleteAdmin();
    }
    
   @Test
    public void addCommentTest()
    {
    	studentDaoService.addStudent(student);
    	post.setUser(student);
    	postDaoService.addPost(post);
    	comment.setUser(student);
    	comment.setPost(post);
    	assertEquals("addCommentTestFailed",true,commentDaoService.addComment(comment));
    	deleteComment();
    	deletePost();
    	deleteStudent();
    }
   
   @Test
   public void updateCommentTest()
   {
	   studentDaoService.addStudent(student);
   	post.setUser(student);
   	postDaoService.addPost(post);
   	comment.setUser(student);
   	comment.setPost(post);
   	commentDaoService.addComment(comment);
   	comment.setComment("edited comment");
   	assertEquals("updateCommentTestFailed",true,commentDaoService.updateComment(comment));
   	deleteComment();
   	deletePost();
   	deleteStudent();
   }
   
   @Test
   public void getCommentTest()
   {
	   adminDaoService.addAdmin(admin);
	   studentDaoService.addStudent(student);
	   	post.setUser(admin);
	   	postDaoService.addPost(post);
	   	comment.setUser(student);
	   	comment.setPost(post);
	   	commentDaoService.addComment(comment);
	   	assertEquals("getCommentTestFailed",comment,commentDaoService.getCommentById(student.getUserId()));
	   	deleteComment();
	   	deletePost();
	   	deleteStudent();
	   	deleteAdmin();
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
	
	public void deletePost()
	{
		postDaoService.deletePost(post);
	}
	
	public void deleteComment()
	{
		commentDaoService.deleteComment(comment);
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
