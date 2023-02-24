

/**
 * 
 */
package com.signify.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.constants.SQLConstants;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.ViewEnrolledStudentsException;

/**
 * @author ALRAHIMA
 *
 */
public class ProfessorDAOImplementation implements ProfessorDAOInterface {
	// Step 1
			// JDBC driver name and database URL
			   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			   static final String DB_URL = "jdbc:mysql://localhost/crs-database";

			   //  Database credentials
			   static final String USER = "root";
			   static final String PASS = "Daraksha05@";
			   
			   
	public boolean professor_db_create(int proffId, String name,String designation,String doj)
	{
		// Step 2 
		// Declare the Connection or prepaid statement variable here 
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			     // System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      //STEP 4: Execute a query
			    //  System.out.println("Creating statement...");
			      
			    
			      stmt = conn.prepareStatement(SQLConstants.PROFESSOR_DB_CREATE);
			   
			 
			      //Bind values into the parameters.
			      stmt.setInt(1, proffId);  // This would set age
			     
			      stmt.setString(2, name);
			      stmt.setString(3,designation);
			      stmt.setString(4, doj);
			      stmt.executeUpdate();
			           
			   
			   
			
			     // rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
		
		return true;
	}
	
	public void addGrade(int studentid,String courseid,String grade,int profid) throws StudentDBViewException {
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      //System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      
			     
			      stmt = conn.prepareStatement(SQLConstants.ADD_GRADE);
			   
			 
			      //Bind values into the parameters.
			      stmt.setInt(1, studentid);  // This would set age
			      stmt.setInt(2,profid);
			      stmt.setString(3, courseid);
			      stmt.setString(4,grade);
			      //stmt.setString(5, doj);
			      stmt.executeUpdate();
			
			     // rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
				   throw new StudentDBViewException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
	
		
		return ;
		
	}
	public void viewEnrolledStudents(int pid) throws ViewEnrolledStudentsException{
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");

			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			    
			      stmt = conn.prepareStatement(SQLConstants.SEARCH_COURSE_INFO_viewEnrolledStudents);
			      stmt.setInt(1, pid);
			      ResultSet rs = stmt.executeQuery();
			      rs.next();
			     String courseid= rs.getString("courseid");
			
			     stmt = conn.prepareStatement(SQLConstants.SEARCH_STUDENTID_viewEnrolledStudents);
			      stmt.setString(1,courseid );
			      ResultSet rs1 = stmt.executeQuery();
			      
			      rs1.next();
			    
			     int id = rs1.getInt("studentid");
			     
			     stmt = conn.prepareStatement(SQLConstants.VIEW_ENROLLED_STUDENTS);
			      stmt.setInt(1,id );
			      
			      ResultSet rs2 = stmt.executeQuery();
			      rs2.next();
			      int id1 = rs2.getInt("studentid");
			         String name = rs2.getString("Student_name");
			         String branch = rs2.getString("Branch");
			         String batch=rs2.getString("Batch");
		     //Display values
		     System.out.print("ID: " + id1);
		     System.out.print(", NAME: " + name);
		     System.out.print(", BRANCH: " + branch);
		    System.out.println(", BATCH: " + branch);
		    //print of 2
		    //System.out.println("4");
			     while(rs1.next()){
			    	 int id5 = rs1.getInt("studentid");
				   
				     stmt = conn.prepareStatement(SQLConstants.VIEW_ENROLLED_STUDENTS);
				      stmt.setInt(1,id5);
				      ResultSet rs3 = stmt.executeQuery();
				      rs3.next();
				      int id3 = rs3.getInt("studentid");
				         String name3 = rs3.getString("Student_name");
				         String branch3 = rs3.getString("Branch");
				         String batch3=rs3.getString("Batch");
			     //Display values
			     System.out.print("ID: " + id3);
			     System.out.print(", NAME: " + name3);
			     System.out.print(", BRANCH: " + branch3);
			    System.out.println(", BATCH: " + branch3);
			     }
			    
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
				  throw new ViewEnrolledStudentsException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
	
		
		return ;
	}

}