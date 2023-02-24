/**
 * 
 */
package com.signify.service;

import java.util.*;

//import com.signify.client.CSRDatabasemMenu;
import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentDBViewException;
import com.signify.jdbc.AdminDAOImplementation;
import com.signify.jdbc.CourseCatalogDAOImplementation;
import com.signify.jdbc.ProfessorDAOImplementation;
import com.signify.jdbc.StudentDAOImplementation;
import com.signify.jdbc.UserDAOImplementation;

/**
 * @author Tejaswini.S.J
 *
 */
public class AdminServiceIml implements AdminInterface
{
	//Function To Add Admin Details In The Database
	public void addAdmin(int adminId, String adminPass ,String adminName,String AdminDesignation) throws AdminExceptions
    {
		try {
		UserDAOImplementation unew=new UserDAOImplementation();
		unew.create_user(adminId,adminPass,adminName,"Admin");
		
		AdminDAOImplementation stdetail= new AdminDAOImplementation();
		stdetail.admin_db_create(adminId,adminName,AdminDesignation);
		
	  System.out.println("\nADMIN ADDED\n");

		}catch(AdminExceptions e)
		{
			System.out.println("ADMIN NOT ADDED");
		}
  	  
    }
	//Function To Add Professor Details In The Database
	public void addProfessor(int proffId, String pass ,String name,String designation,String doj) throws AdminExceptions 
      {
		try {
		UserDAOImplementation unew=new UserDAOImplementation();
		unew.create_user(proffId,pass,name,"Professor");
		
		ProfessorDAOImplementation stdetail= new ProfessorDAOImplementation();
		stdetail.professor_db_create(proffId,name,designation,doj);

    	  System.out.println("\nPROFESSOR ADDED\n");
    	
		}catch(AdminExceptions e)
		{
			System.out.println("PROFESSOR NOT ADDED");
		}
		
      }
	//Function To View Registered Students Details From The Database
      public void viewRegisteredStudents() throws StudentDBViewException
      {
    	  try {
    	  StudentDAOImplementation unew=new StudentDAOImplementation();
  		unew.student_db_view();
  		
    	 }catch(StudentDBViewException e)
    	
    	  {
    		 System.out.println("STUDENT NOT REGISTERED");
    		  
    	  }
      }
      
      
      //Function To Add Course Details In The Database
      public void addCourse(String courseId, String courseName, int courseProf, int course_price) throws CourseCreateExceptions {
   
    	  try {
    	  CourseCatalogDAOImplementation cfdetail= new CourseCatalogDAOImplementation();
			cfdetail.catalog_db_create(courseId,courseName,courseProf,course_price);
	

      	  System.out.println("\nCOURSE ADDED\n");
      	  
      	
    	  }
    	  catch(CourseCreateExceptions e)
    	  {
    		  System.out.println("COURSE NOT ADDED");
    	  }
    		  
    	  }
  	      
  	
    //Function To Delete Course Details From The Database
  	public void deleteCourse(String courseId) throws DeleteCourseException {
  		
  		try {
  		CourseCatalogDAOImplementation cf1detail= new CourseCatalogDAOImplementation();
		  cf1detail.deleteCourse(courseId);
  		
		  System.out.println("\nCOURSE REMOVED\n");
  	  }catch(DeleteCourseException e)
  	  {
  		  System.out.println("COURSE NOT REMOVED");
  		 
  	  }
  		
  	}

  	 //Function To View Course Details In The Database
  	public void viewCourseDetails(String courseId) throws CourseDetailsException {
  		try {
  		CourseCatalogDAOImplementation cf1detail= new CourseCatalogDAOImplementation();
		  cf1detail.CourseDetail(courseId);
  		
    	  }catch(CourseDetailsException e)
    	  {
    		  System.out.println("COURSE CANNOT BE VIEWED");
    	  }
  	}
	@Override
	//Function Approve Student Registration In The Database
	public void approveStudent(int studentId) throws StudentDBViewException{
		// TODO Auto-generated method stub
		try {
			
			AdminDAOImplementation approve= new AdminDAOImplementation();
			approve.approvestd(studentId,"approved");
			System.out.println("\nSTUDENT APPROVED \n");
			
			

  	  }catch(StudentDBViewException e)
  	  {
  		System.out.println("\nSTUDENT CANNOT BE APPROVED\n");
  	  }
		}
		
	}

