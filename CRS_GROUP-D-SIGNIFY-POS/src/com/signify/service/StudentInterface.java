package com.signify.service;

import com.signify.exception.AdminExceptions;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.ViewGradeCardException;
import com.signify.exception.ViewUnapprovedStudentsException;

public interface StudentInterface {
	//public void changePassword(String passwordNew);
	public void register(int studentId,String pwd,String name, String branch, String batch) throws AdminExceptions;
	public void viewGradeCard(int studentId ) throws ViewGradeCardException;
	public void addCourse(String courseCode,int studentid) throws StudentAddCourseException;
	//registered course
	//public void viewGrade(int studentId);
	public void dropCourse(String courseCode,int studentid) throws StudentDropCourseException;
	public void dopayment(int stdid, int amount,String mode) throws CoursePamentViewException;
	public void view_unapproved_stds() throws ViewUnapprovedStudentsException;
}
