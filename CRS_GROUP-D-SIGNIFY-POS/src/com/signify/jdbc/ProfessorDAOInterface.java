/**
 * 
 */
package com.signify.jdbc;

import com.signify.exception.StudentDBViewException;
import com.signify.exception.ViewEnrolledStudentsException;

/**
 * @author HP
 *
 */
public interface ProfessorDAOInterface {
	public boolean professor_db_create(int proffId, String name,String designation,String doj);
	public void addGrade(int studentid,String courseid,String grade,int profid) throws StudentDBViewException;
	public void viewEnrolledStudents(int pid) throws ViewEnrolledStudentsException;
}
