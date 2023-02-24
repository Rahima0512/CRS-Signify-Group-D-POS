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

/**
 * @author HP
 *
 */
public class CRSApplicationMenu{


	public static void main(String[] args) throws AdminExceptions, StudentDBViewException, CourseCreateExceptions, DeleteCourseException, CourseDetailsException, StudentDropCourseException, StudentAddCourseException, ViewGradeCardException, CoursePamentViewException, ViewUnapprovedStudentsException, ViewEnrolledStudentsException {
		CRSMainMenu m=new CRSMainMenu();
		m.Menufunc();
		
		boolean c=true;
		while(c) {
			CRSMainMenu mt=new CRSMainMenu();
			mt.Menufunc();
		}

	}


}