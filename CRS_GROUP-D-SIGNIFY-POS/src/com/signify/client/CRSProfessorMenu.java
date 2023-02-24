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
import com.signify.service.AdminInterface;
import com.signify.service.AdminServiceIml;
import com.signify.service.ProfessorInterface;
import com.signify.service.ProfessorServiceIml;
/**
 * @author HP
 *
 */
public class CRSProfessorMenu {

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
	public static void Professorfunc(int pid,String cid) throws AdminExceptions, StudentDBViewException, CourseCreateExceptions, DeleteCourseException, CourseDetailsException, StudentDropCourseException, StudentAddCourseException, ViewGradeCardException, CoursePamentViewException, ViewUnapprovedStudentsException, ViewEnrolledStudentsException {
		// TODO Auto-generated method stub
		System.out.println("\nWELCOME TO PROFESSOR\n"+"=============\n");
		Scanner in = new Scanner(System.in);  
		System.out.println("PROFESSOR MENU");
		System.out.println("1: VIEW ENROLLED STUDENTS ");//not done
		System.out.println("2: ADD GRADE ");//done
		System.out.println("3: EXIT");//done
		
		System.out.println("Enter Your Choice ");
		int choice1 = in.nextInt();
        switch(choice1)
        {
        case 1: System.out.println("YOUR CHOICE: VIEW ENROLLED STUDENTS");
        
		ProfessorInterface star= new ProfessorServiceIml();
        star.viewEnrolledStudents(pid);
        CRSProfessorMenu aP=new CRSProfessorMenu();
			 aP.Professorfunc(pid,cid);
        break;
        case 2: System.out.println("YOUR CHOICE: ADD GRADE ");
        System.out.println("ENTER STUDENT ID ");
        int stdid=in.nextInt();
        
        
        System.out.println("ENTER GRADE ");
        String gradestd=in.next();
        

		ProfessorInterface func= new ProfessorServiceIml();
        func.add_Grade(stdid,cid,gradestd,pid);
        CRSProfessorMenu aH=new CRSProfessorMenu();
			 aH.Professorfunc(pid,cid);
        
        break;
        case 3: System.out.println("YOUR CHOICE: LOGOUT");
        CRSMainMenu m=new CRSMainMenu();
		m.Menufunc();
        break;
        default:System.out.println("INVALID INPUT!");
        }
		
		


		}
}
