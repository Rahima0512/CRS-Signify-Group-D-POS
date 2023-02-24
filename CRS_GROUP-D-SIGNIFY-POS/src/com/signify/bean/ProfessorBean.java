/**
 * 
 */
package com.signify.bean;

/**
 * @author HP
 *
 */
public class ProfessorBean {

	/**
	 * @param args
	 */
	//professor
	private String department;
	private String designation;
	private String doj;	
	
	//grade
	private String grade;

	

	//professor
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	//getter setter grade
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
