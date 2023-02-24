package com.signify.service;

import com.signify.exception.StudentDBViewException;
import com.signify.exception.ViewEnrolledStudentsException;
import com.signify.jdbc.ProfessorDAOImplementation;

//import com.
public class ProfessorServiceIml implements ProfessorInterface{
	
	 //Function To View Enrolled Students From The Database
	public void viewEnrolledStudents(int pid) throws ViewEnrolledStudentsException{
		try {
		ProfessorDAOImplementation view=new ProfessorDAOImplementation();
		view.viewEnrolledStudents(pid);
		}
		catch(ViewEnrolledStudentsException se)
		{
			System.out.println("STUDENTS NOT DISPLAYED");
		}
	}

	//Function To Add Grade Details In The Database
	public void add_Grade(int stid,String cid,String grade,int pid) throws StudentDBViewException {
		try {
		ProfessorDAOImplementation pgrade=new ProfessorDAOImplementation();
		pgrade.addGrade(stid,cid,grade,pid);
		System.out.println("\nGRADE ADDED\n");
		
		}
		catch(StudentDBViewException e)
		{
		System.out.println("GRADE NOT ADDED");
		}
	}

	
	

}
