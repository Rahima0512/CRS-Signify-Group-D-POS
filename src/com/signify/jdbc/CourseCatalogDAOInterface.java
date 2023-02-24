/**
 * 
 */
package com.signify.jdbc;

import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.ViewGradeCardException;

/**
 * @author HP
 *
 */
public interface CourseCatalogDAOInterface {
	public boolean catalog_db_create(String courseId, String courseName, int courseProf,int courseprice) throws CourseCreateExceptions;
	public void deleteCourse(String courseid1) throws DeleteCourseException;
	public void CourseDetail(String courseid1) throws CourseDetailsException;
	public boolean student_add_course(String courseId, int studentId) throws StudentAddCourseException;
	public boolean student_drop_course(String courseId, int studentId) throws StudentDropCourseException;
	public int course_payment(int stdid) throws CoursePamentViewException;
	public void add_payment_in_table(int stdid,int amount,String mode_of_payment,String status);
	public void do_course_payment(int stdid,int amount, String mode) throws CoursePamentViewException;
	public void viewGradeCard(int stdid) throws ViewGradeCardException;
}
