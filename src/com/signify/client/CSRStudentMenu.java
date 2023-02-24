/**
 * 
 */
package com.signify.client;
import java.util.ArrayList;
import java.util.List;
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
import com.signify.service.StudentServiceIml;


/**
 * @author HP
 *
 */

public class CSRStudentMenu {
	public class check_cnt{
		String crse="";
		int cnt=0;
		
		public void fun(String c,int cnt) {
			this.crse=c;
			this.cnt=cnt;
		}
		
	}

	/**
	 * @param args
	 * @throws AdminExceptions 
	 * @throws StudentDBViewException 
	 * @throws CourseCreateExceptions 
	 * @throws DeleteCourseException 
	 * @throws CourseDetailsException 
	 * @throws StudentDropCourseException 
	 * @throws StudentAddCourseException 
	 * @throws ViewGradeCardException 
	 * @throws CoursePamentViewException 
	 * @throws ViewUnapprovedStudentsException 
	 * @throws ViewEnrolledStudentsException 
	 */
	
	//public void display() {
	
	public static void Studentfunc(int id) throws AdminExceptions, StudentDBViewException, CourseCreateExceptions, DeleteCourseException, CourseDetailsException, StudentDropCourseException, StudentAddCourseException, ViewGradeCardException, CoursePamentViewException, ViewUnapprovedStudentsException, ViewEnrolledStudentsException{ 
		
		System.out.println("\nWELCOME TO STUDENT\n"+"=======================");
		Scanner in = new Scanner(System.in);  
		System.out.println("STUDENT MENU");
		
		System.out.println("1: JOIN A COURSE");//done
		System.out.println("2: DROP A COURSE");//done
		System.out.println("3: VIEW GRADE CARD");//done
		System.out.println("4: VIEW TOTAL PAYMENT");//done
		System.out.println("5: PAY FOR COURSES");//done
		System.out.println("6:LOGOUT");//done
		
		System.out.println("Enter Your Choice "); 
        int choice1 = in.nextInt();
        switch(choice1)
        {
        case 1: System.out.println("YOUR CHOICE: JOIN A COURSE");
        		
        		for(int i=0;i<4;i++) {
        			System.out.println("ENTER COURSE CODE OF COURSE YOU WANT TO REGISTER "); 
    	        	String course_choice1 = in.next();  	
    	        	StudentServiceIml object=new StudentServiceIml();
    	        	object.addCourse(course_choice1,id);
    	        }
        		CSRStudentMenu aP=new CSRStudentMenu();
   			 aP.Studentfunc(id);

        break;
        case 2: System.out.println("YOUR CHOICE: DROP A COURSE");
        System.out.println("ENTER COURSE CODE OF COURSE YOU WANT TO DROP "); 
    	String course_drop1 = in.next(); 
    	StudentServiceIml object=new StudentServiceIml();
    	object.dropCourse(course_drop1,id);
    	CSRStudentMenu aL=new CSRStudentMenu();
			 aL.Studentfunc(id);
        break;
        case 3: System.out.println("YOUR CHOICE: VIEW GRADE CARD");
        StudentServiceIml obj1=new StudentServiceIml();
    	obj1.viewGradeCard(id);

        CSRStudentMenu am=new CSRStudentMenu();
		 am.Studentfunc(id);
        break;
        case 4: System.out.println("YOUR CHOICE: VIEW TOTAL PAYMENT");
        StudentServiceIml object1=new StudentServiceIml();
        object1.viewpayment(id);
        //System.out.println("Make payment "); 
    	//String course_choice1 = in.next();
        CSRStudentMenu aK=new CSRStudentMenu();
		 aK.Studentfunc(id);
        
        break;
        case 5:System.out.println("YOUR CHOICE: PAY FOR COURSES");
        System.out.println("ENTER AMOUNT TO BE PAID "); 
    	int amount = in.nextInt(); 
    	 System.out.println("ENTER MODE OF PAYMENT"); 
     	String mode = in.next(); 
     	StudentServiceIml object5=new StudentServiceIml();
        object5.dopayment(id,amount,mode);
        CSRStudentMenu aK1=new CSRStudentMenu();
		 aK1.Studentfunc(id);
        
        case 6: System.out.println("YOUR CHOICE: LOGOUT");
        CRSMainMenu m=new CRSMainMenu();
		m.Menufunc();
        break;
        default:System.out.println("INVALID INPUT!");
        }
		
		
		
        
        
	
	}

}
