/**
 * 
 */
package com.signify.service;

import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentDBViewException;

/**
 * @author HP
 *
 */
public interface AdminInterface {
	public void addAdmin(int adminId, String adminPass ,String adminName,String AdminDesignation) throws AdminExceptions;
	public void addProfessor(int proffId, String pass, String name,String designation,String doj) throws AdminExceptions;
	//public void assignCourse(int studentId,String courseCode);
	public void approveStudent(int studentId) throws StudentDBViewException;
	public void viewRegisteredStudents() throws StudentDBViewException;
	//catalog
	public void addCourse(String courseId, String courseName, int courseProf,int course_price) throws CourseCreateExceptions;
	public void deleteCourse(String courseId) throws DeleteCourseException;
	public void viewCourseDetails(String courseID) throws CourseDetailsException;
}
