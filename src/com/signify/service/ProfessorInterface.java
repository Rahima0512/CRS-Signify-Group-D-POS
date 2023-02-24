package com.signify.service;

import com.signify.exception.StudentDBViewException;
import com.signify.exception.ViewEnrolledStudentsException;

public interface ProfessorInterface {
	public void viewEnrolledStudents(int pid) throws ViewEnrolledStudentsException;
	public void add_Grade(int stid,String cid,String grade,int pid) throws StudentDBViewException ;
}
