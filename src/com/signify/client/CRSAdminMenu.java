/**
 * 
 */
package com.signify.client;

import java.util.Scanner;

import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.ViewEnrolledStudentsException;
import com.signify.exception.ViewGradeCardException;
import com.signify.exception.ViewUnapprovedStudentsException;
import com.signify.service.*;

/**
 * @author ALRAHIMA
 *
 */
public class CRSAdminMenu  {

	/**
	 * @param args
	 * @throws AdminExceptions 
	 * @throws StudentDBViewException 
	 * @throws CourseCreateExceptions 
	 * @throws DeleteCourseException 
	 * @throws CourseDetailsException 
	 * @throws ViewUnapprovedStudentsException 
	 * @throws CoursePamentViewException 
	 * @throws ViewGradeCardException 
	 * @throws StudentAddCourseException 
	 * @throws StudentDropCourseException 
	 * @throws ViewEnrolledStudentsException 
	 */
	public static void Adminfunc() throws AdminExceptions, StudentDBViewException, CourseCreateExceptions, DeleteCourseException, CourseDetailsException, ViewUnapprovedStudentsException, StudentDropCourseException, StudentAddCourseException, ViewGradeCardException, CoursePamentViewException, ViewEnrolledStudentsException {
		// TODO Auto-generated method stub
		String s = "\nWELCOME TO ADMIN MENU\n"+"=====================\n";
		String str="";

		int choice;
		System.out.println(s);
		Scanner scan = new Scanner(s);
		
		System.out.println("1: ADD A SUB ADMIN ");//done
		System.out.println("2: ADD PROFESSOR ");//done
		System.out.println("3: APPROVE A STUDENT REGISTRATION");//done
		
		//System.out.println("6: Generate a Report Card");
		
		//System.out.println("8: Generate a Bill");
		System.out.println("4: ADD A COURSE TO CATALOG");//done
		System.out.println("5: REMOVE A COURSE FROM CATALOG");//done
		System.out.println("6: VIEW REGISTERED COURSE");//done
		System.out.println("7: VIEW ALL REGISTERED STUDENTS"); //done 
		System.out.println("8: LOGOUT");//done
		 
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter Your Choice "); 
        choice = in.nextInt();
        //in.close();
        
		switch(choice) {
		//case statements within the switch block  
		    
		case 1: System.out.println("YOUR CHOICE: ADD A SUB ADMIN"); 
		Scanner scan1 = new Scanner(System.in);
		System.out.println("ENTER ADMIN ID ");
		 int adminId = scan1.nextInt();
		 System.out.println("ENTER ADMIN PASSWORD ");
		 String adminPass = scan1.next();
		System.out.println("ENTER ADMIN NAME ");
		 String adminName = scan1.next();
		 System.out.println("ENTER DESIGNATION ");
		 String adminDesign = scan1.next();
		 
		
		AdminInterface b= new AdminServiceIml();
		b.addAdmin(adminId,adminPass,adminName,adminDesign);
		CRSAdminMenu ay=new CRSAdminMenu();
		 ay.Adminfunc();
		
		break;    
		case 2: System.out.println("YOUR CHOICE: ADD PROFESSOR");
		
		//System.out.println(s);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("ENTER PROFESSOR ID ");
		 int proffId = scan2.nextInt();
		 System.out.println("ENTER PROFESSOR PASSWORD ");
		 String pass = scan2.next();
		System.out.println("ENTER PROFESSOR NAME ");
		 String profName = scan2.next();
		 System.out.println("ENTER DESIGNATION ");
		 String design = scan2.next();
		 System.out.println("ENTER DOJ ");
		 String doj = scan2.next();
		 
		
		AdminInterface a= new AdminServiceIml();
		a.addProfessor(proffId,pass,profName,design,doj);
		CRSAdminMenu at=new CRSAdminMenu();
		 at.Adminfunc();
		
		break;    
		case 3: System.out.println("YOUR CHOICE: APPROVE A STUDENT REGISTRATION");
		Scanner scan7 = new Scanner(System.in);
		System.out.println("\nEnter Your Choice ");
		 System.out.println("1: VIEW ALL UNAPPROVED STUDENTS ");//done
			System.out.println("2: ENTER STUDENT ID OF THE STUDENT YOU WANT TO APPROVE ");//done
			System.out.println("3: EXIT APPROVAL MENU");
		 Scanner t = new Scanner(System.in);
		int val = t.nextInt();
        
		if(val==1)
		{

        System.out.println("YOUR CHOICE: VIEW ALL UNAPPROVED STUDENTS ");
        StudentInterface y= new StudentServiceIml();
		y.view_unapproved_stds();
		CRSAdminMenu as=new CRSAdminMenu();
		 as.Adminfunc();
		}
		else if (val ==2)
		{
			 System.out.println("YOUR CHOICE: ENTER STUDENT ID OF THE STUDENT YOU WANT TO APPROVE");
			 Scanner t1 = new Scanner(System.in);
				int stdid = t1.nextInt();
				 AdminInterface approve= new AdminServiceIml();
				approve.approveStudent(stdid);
				CRSAdminMenu as=new CRSAdminMenu();
				 as.Adminfunc();
		}
		else if(val==3) {
			System.out.println("YOUR CHOICE: EXIT APPROVAL MENU");
	        CRSAdminMenu as=new CRSAdminMenu();
			 as.Adminfunc();
			 //break;

		}
		else
		{
			System.out.println("\nINVALID INPUT!");    
		}
					
		
		
		break;    
		//case 5: System.out.println("Assign a Course");  
		//break;    
		//case 6: System.out.println("Generate a Report Card");  
		//break;    
		
		case 4: System.out.println("YOUR CHOICE: ADD A COURSE TO CATALOG"); 
		
		Scanner scan3 = new Scanner(System.in);
		System.out.println("ENTER COURSE ID ");
		 String courseId = scan3.next();
		 System.out.println("ENTER COURSE NAME ");
		 String courseName = scan3.next();
		System.out.println("ENTER PROFESSOR ID ");
		 int courseProf = scan3.nextInt();
		 System.out.println("ENTER COURSE PRICE ");
		 int coursePrice = scan3.nextInt();
		 AdminInterface course= new AdminServiceIml();
			course.addCourse(courseId,courseName,courseProf, coursePrice);
			CRSAdminMenu aE=new CRSAdminMenu();
			 aE.Adminfunc();
		 
		break;    
		
		case 5: System.out.println("YOUR CHOICE: REMOVE A COURSE FROM CATALOG");  
		Scanner scan4 = new Scanner(System.in);
		System.out.println("ENTER COURSE ID ");
		 String courseId1 = scan4.next();
		 
		 AdminInterface c= new AdminServiceIml();
			c.deleteCourse(courseId1);
			CRSAdminMenu aD=new CRSAdminMenu();
			 aD.Adminfunc();
		
		break;    
		case 6: System.out.println("YOUR CHOICE: VIEW REGISTERED COURSE");  
		Scanner scan5 = new Scanner(System.in);
		System.out.println("ENTER COURSE ID ");
		 String courseId2 = scan5.next();
		 
		 AdminInterface c1= new AdminServiceIml();
			c1.viewCourseDetails(courseId2);
			CRSAdminMenu aB=new CRSAdminMenu();
			 aB.Adminfunc();		
		
		break;
		case 7: System.out.println("YOUR CHOICE: VIEW ALL REGISTERED STUDENTS");
		/*System.out.println(student_db);*/
		 AdminInterface c2= new AdminServiceIml();
			c2.viewRegisteredStudents();
		CRSAdminMenu aC=new CRSAdminMenu();
		 aC.Adminfunc();
		break;
		case 8: System.out.println("YOUR CHOICE: LOGOUT");
			CRSMainMenu m=new CRSMainMenu();
			m.Menufunc();
		break;
		default:System.out.println("\nINVALID INPUT!");    
		}    
		//Printing month of the given number  

	}

}