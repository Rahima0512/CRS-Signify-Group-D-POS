/**
 * 
 */
package com.signify.client;

import java.util.*;

import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.UpdatePasswordException;
import com.signify.exception.ViewEnrolledStudentsException;
import com.signify.exception.ViewGradeCardException;
import com.signify.exception.ViewUnapprovedStudentsException;
import com.signify.jdbc.CourseCatalogDAOImplementation;
import com.signify.jdbc.StudentDAOImplementation;
import com.signify.jdbc.UserDAOImplementation;
import com.signify.service.AdminServiceIml;
import com.signify.service.StudentServiceIml;

/**
 * @author HP
 *
 */
public class CRSMainMenu {
	

		/**
		 * @param args
		 * @throws AdminExceptions 
		 * @throws StudentDBViewException 
		 * @throws CourseCreateExceptions 
		 * @throws DeleteCourseException 
		 * @throws CourseDetailsException 
		 * @throws CoursePamentViewException 
		 * @throws ViewGradeCardException 
		 * @throws StudentAddCourseException 
		 * @throws StudentDropCourseException 
		 * @throws ViewUnapprovedStudentsException 
		 * @throws ViewEnrolledStudentsException 
		 */
		public static void Menufunc() throws AdminExceptions, StudentDBViewException, CourseCreateExceptions, DeleteCourseException, CourseDetailsException, StudentDropCourseException, StudentAddCourseException, ViewGradeCardException, CoursePamentViewException, ViewUnapprovedStudentsException, ViewEnrolledStudentsException {
			
			//adding admin in the database
			
			/*if(!admin_db.containsKey(9))
			{
				AdminService anew=new AdminService();
		        anew.addAdmin(9,"zero","Prem","Dean");
		        //System.out.println("mem added");
		       // flag=true;
			}*/
			System.out.println("WELCOME TO THE CSR APPLICATION\n"+"===========================\n"+"MAIN MENU\n"+"1.REGISTRATION FOR NEW STUDENT\n"+"2.LOGIN\n"+"3.UPADATE PASSWORD\n"+"4.EXIT");
			Scanner in = new Scanner(System.in);  
	        System.out.print("Enter number "); 
	        boolean c=true;
	        int x = in.nextInt();
			switch(x) {
			case 1:
				
				System.out.println("Registration for student");

				System.out.print("Enter Name ");
				String name = in.next(); 
				
				 System.out.println("ENTER PASSWORD");
				 String pass = in.next();
				 
				
				
				System.out.print("Enter Roll Number- ");
				int studentId = in.nextInt(); 
				
				System.out.print("Enter Branch- ");
				String branch=in.next();
				
				System.out.print("Enter Batch- ");
				String batch=in.next();
				StudentServiceIml snew=new StudentServiceIml();
		        snew.register(studentId,pass, name, branch, batch);
				//Student s=new Student();
				//s.Studentfunc();
				
				break;
			case 2:
				
				//boolean flag=false;
				System.out.println("\nLOGIN USER\n"+"==============");
				
				System.out.println("ENTER ID");
				int id = in.nextInt(); 
				
				System.out.println("ENTER USER NAME");
				 String username = in.next(); 
				
				 System.out.println("ENTER ROLE");
				 String role = in.next(); 
				
				  
				 System.out.println("ENTER PASSWORD");
				 String userpass = in.next();
				 boolean ans=false;
				 try {
				 if(role.equals("Professor") || role.equals("professor")||role.equals("Admin") || role.equals("admin"))
				 { 
					 UserDAOImplementation unew=new UserDAOImplementation();
				 ans=unew.login(id,userpass,username,role);
				 }
				 else if (role.equals("Student") || role.equals("student")){
					 StudentDAOImplementation stnew =new StudentDAOImplementation();
					 ans=stnew.std_login(id,userpass,username);
				 }
				 else {
					 System.out.println("\nWRONG ROLE\n");
				 }
				 if(ans==true)
				 {
					 System.out.println("\nLOGIN SUCCESS\n");
					 if(role.equals("Student") || role.equals("student"))
					 {
						 CSRStudentMenu s1=new CSRStudentMenu();
						 s1.Studentfunc(id);
					 }
					 else if(role.equals("Professor") || role.equals("professor"))
					 {
						 System.out.println("ENTER COURSE ID ");
						 String cid=in.next();
						 CRSProfessorMenu p=new CRSProfessorMenu();
						 p.Professorfunc(id,cid);
					 }
					 else if(role.equals("Admin") || role.equals("admin"))
					 {
						 CRSAdminMenu a=new CRSAdminMenu();
						 a.Adminfunc();	
					 }
					 else {
						 System.out.println("WRONG ROLE");
					 }
				 }
				 else {
					 System.out.println("\nTRY AGAIN\n");
				 }}
				 catch(StudentDBViewException e)
				 {
					 System.out.println("\nTRY AGAIN\n");
				 }
				
				 break;
				 
			case 3:
				System.out.println("\nUPDATE PASSWORD\n"+"===================");
				System.out.println("ENTER ID");
				int id1 = in.nextInt(); 
				System.out.println("ENTER ROLE");
				String role1 = in.next(); 
				System.out.println("ENTER OLD PASSWORD");
				String oldPass = in.next();
				System.out.println("ENTER NEW PASSWORD");
				String newPass = in.next();
				// if(role1.equals("Student"))
				// {
				try {
					 StudentDAOImplementation y=new StudentDAOImplementation();	
					y.update_pass(id1,newPass,oldPass);
					System.out.println("\nPASSWORD UPDATED\n");
				} catch (UpdatePasswordException e) {
					// TODO Auto-generated catch block
					System.out.println("PASSWORD NOT UPDATED");
				}
					
						 
						 
					
					 
			   break;
			case 4:
				System.out.println("EXIT");
				c=false;
				break;
				
			}
		
			//in.close();
			
		}

}
