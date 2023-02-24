/**
 * 
 */
package com.signify.service;
import com.signify.client.*;
import com.signify.exception.AdminExceptions;

import com.signify.jdbc.CourseCatalogDAOImplementation;
import com.signify.jdbc.StudentDAOImplementation;
import com.signify.jdbc.UserDAOImplementation;
import com.signify.exception.*;
import java.util.*;

/**
 * @author HP
 *
 */
public class StudentServiceIml implements StudentInterface {
	
	 //Function To Register Student Details In The Database
	public void register(int studentId, String pwd, String name, String branch, String batch) throws AdminExceptions
	{
		try {
		UserDAOImplementation unew=new UserDAOImplementation();
		unew.create_user(studentId,pwd,name,"Student");
		
		StudentDAOImplementation stdetail= new StudentDAOImplementation();
		stdetail.student_db_create(studentId,name,branch,batch,"yet_to_approve");
		
		}
		catch(AdminExceptions e)
		{
			System.out.println("USER NOT ADDED");
		}
		
		
	}
	 //Function To View Grade  Details From The Database
	public void viewGradeCard(int studentId ) throws ViewGradeCardException
	{
		try {
		System.out.println("GRADE CARD ");
		CourseCatalogDAOImplementation o1=new CourseCatalogDAOImplementation();
		o1.viewGradeCard(studentId);
		
	}
	catch(ViewGradeCardException e)
	{
		System.out.println("GRADE NOT DISPLAYED");
	}
	
	}
	
	 //Function To Add Course Details to A Student In The Database
	public void addCourse(String courseCode,int studentid) throws StudentAddCourseException
    {
		try {
		
		CourseCatalogDAOImplementation stadd=new CourseCatalogDAOImplementation();
		stadd.student_add_course(courseCode,studentid);
  	    System.out.println("\nCOURSE IS ADDED\n");
  	
		}
		catch(StudentAddCourseException e)
		{
			System.out.println("COURSE NOT ADDED");
					}
		
    }

	//Function To Remove Course Assigned To A Student In The Database
	public void dropCourse(String courseCode,int studentid) throws StudentDropCourseException
    {
		try{
		CourseCatalogDAOImplementation stadd=new CourseCatalogDAOImplementation();
		stadd.student_drop_course(courseCode,studentid);
  	  System.out.println("COURSE ID DROPPED");
  	
		}
		catch(StudentDropCourseException e)
		{
			System.out.println("COURSE CANNOT BE DROPPED");
		}
		
    }
	//Function To View Payment Detail From The Database
	public void viewpayment(int stdid) throws CoursePamentViewException
	{
		try {
		CourseCatalogDAOImplementation stadd=new CourseCatalogDAOImplementation();
		int ans=stadd.course_payment(stdid);
		System.out.println("TOTAL PAYMENT IS " +ans);
		CourseCatalogDAOImplementation stadd1=new CourseCatalogDAOImplementation();
		//int ans=stadd.course_payment(stdid);
		stadd1.add_payment_in_table(stdid,ans,"NOT SPECIFIED","PAYMENT NOT DONE");
		
	}
	catch(CoursePamentViewException e)
	{
		System.out.println("PAYMENT CANNOT BE VIEWED");
	}
	
		
	}
	//Function To Make a Payment And Choose The Mode
	public void dopayment(int stdid, int amount,String mode) throws CoursePamentViewException
	{
		try {
		CourseCatalogDAOImplementation staddr=new CourseCatalogDAOImplementation();
		staddr.do_course_payment(stdid,amount,mode);
		}
		catch(CoursePamentViewException e)
		{
			System.out.println("PAYMENT CANNOT BE VIEWED");
		}
		
	}
	//Function To View Unapproved Student Details From The Database
	public void view_unapproved_stds() throws ViewUnapprovedStudentsException
	{
		try {
		StudentDAOImplementation glan= new StudentDAOImplementation();
		glan.view_unapproved_stds();
		}
		catch(ViewUnapprovedStudentsException e)
		{
			System.out.println("NO UNAPPROVED STUDENTS");
		}
	}
	
	
	
}
