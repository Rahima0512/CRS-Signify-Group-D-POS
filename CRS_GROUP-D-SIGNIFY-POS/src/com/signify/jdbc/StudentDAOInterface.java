/**
 * 
 */
package com.signify.jdbc;

import com.signify.exception.StudentDBViewException;
import com.signify.exception.UpdatePasswordException;
import com.signify.exception.ViewUnapprovedStudentsException;

/**
 * @author HP
 *
 */
public interface StudentDAOInterface {
	public boolean student_db_create(int studentId, String name, String branch, String batch, String status );
	public void student_db_view() throws StudentDBViewException;
	public void update_pass(int id, String newpass, String oldpass) throws UpdatePasswordException;
	public void view_unapproved_stds() throws ViewUnapprovedStudentsException;
	public boolean std_login(int id,String userpass,String username);

}
