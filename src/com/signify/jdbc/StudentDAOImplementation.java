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
import com.signify.exception.AdminExceptions;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.UpdatePasswordException;
import com.signify.exception.ViewUnapprovedStudentsException;
import com.signify.utils.DBUtils;

/**
 * @author ALRAHIMA
 *
 */
public class StudentDAOImplementation implements StudentDAOInterface {
	// Step 1
			// JDBC driver name and database URL
			   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			   static final String DB_URL = "jdbc:mysql://localhost/crs-database";

			   //  Database credentials
			   static final String USER = "root";
			   static final String PASS = "MyNameIs@Garvit1";
			   //private Connection conn;
	public boolean student_db_create(int studentId, String name, String branch, String batch, String status )
	{
		// Step 2 
		// Declare the Connection or prepaid statement variable here 
		//conn=DBUtils.getConnection();
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      //System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			    
			      stmt = conn.prepareStatement(SQLConstants.REGISTER_STUDENT);
			   
			 
			      //Bind values into the parameters.
			      stmt.setInt(1, studentId);  // This would set age
			      stmt.setString(2,name);
			      stmt.setString(3, branch);
			      stmt.setString(4,batch);
			      stmt.setString(5,status);
			      stmt.executeUpdate();
			           
			
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
			   }	
		
		return true;
	}
	public void student_db_view() throws StudentDBViewException
	{
		//conn=DBUtils.getConnection();
		 Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");

			   
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			     
		stmt = conn.prepareStatement(SQLConstants.STUDENT_DB_VIEW);
		 // stmt.setInt(1, studentId);
	      ResultSet rs = stmt.executeQuery();
	      rs.next();

	      //STEP 5: Extract data from result set
	      
	         //Retrieve by column name
	        
	      String id = rs.getString("studentid");
	         String name = rs.getString("Student_name");
	         String branch = rs.getString("Branch");
	         String batch=rs.getString("Batch");
      //Display values
      System.out.print("ID: " + id);
      System.out.print(", name: " + name);
      System.out.print(", branch: " + branch);
     System.out.println(", batch: " + branch);
     
	         while(rs.next()){
	        	 String id1 = rs.getString("studentid");
		         String name1 = rs.getString("Student_name");
		         String branch1 = rs.getString("Branch");
		         String batch1=rs.getString("Batch");
	         //Display values
	         System.out.print("ID: " + id1);
	         System.out.print(", name: " + name1);
	         System.out.print(", branch: " + branch1);
	        System.out.println(", batch: " + branch1);
	         }
	    	
	      stmt.close();
	      conn.close();
	   }catch(SQLException | ClassNotFoundException se){
	      //Handle errors for JDBC
	      //se.printStackTrace();
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
	   //System.out.println("Goodbye!");
	}//end main
	public void update_pass(int id, String newpass, String oldpass) throws UpdatePasswordException
	{
		//conn=DBUtils.getConnection();
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");

			
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			     
			     
			      stmt = conn.prepareStatement(SQLConstants.SEARCH_PASS);
			      stmt.setInt(1, id); 
			      ResultSet rs = stmt.executeQuery();
			      rs.next();
			     String pwd= rs.getString("Password");
			   
			    	if(pwd.equals(oldpass))
			    	{
			    		 
			    		 stmt = conn.prepareStatement(SQLConstants.UPDATE_PASS);
			    	
					      stmt.setString(1,newpass);
					      stmt.setInt(2, id);
					      stmt.executeUpdate();
					     
			    	}
			    	else {
			    		System.out.println("\nWRONG PASSWORD.. TRY AGAIN LATER..\n");
			    	}
			     
			      
			      stmt.close();
			      conn.close();
			   }catch(SQLException | ClassNotFoundException se){
			   throw new UpdatePasswordException();
				   
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
			   }
	}
	public void view_unapproved_stds() throws ViewUnapprovedStudentsException
	{
		//conn=DBUtils.getConnection();
		 Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");


			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
		
		stmt = conn.prepareStatement(SQLConstants.VIEW_UNAPPROVED_STUDENTS);
		 // stmt.setInt(1, studentId);
	      ResultSet rs = stmt.executeQuery();
	      rs.next();

	      
	      int id = rs.getInt("studentid");
	         String name = rs.getString("Student_name");
	         String branch = rs.getString("Branch");
	         String batch=rs.getString("Batch");
     //Display values
     System.out.print("ID: " + id);
     System.out.print(", name: " + name);
     System.out.print(", branch: " + branch);
    System.out.println(", batch: " + branch);
    
	         while(rs.next()){
	        	 String id1 = rs.getString("studentid");
		         String name1 = rs.getString("Student_name");
		         String branch1 = rs.getString("Branch");
		         String batch1=rs.getString("Batch");
	         //Display values
	         System.out.print("ID: " + id1);
	         System.out.print(", name: " + name1);
	         System.out.print(", branch: " + branch1);
	        System.out.println(", batch: " + branch1);
	         }
	    	
	      //STEP 6: Clean-up environment
	     // rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
		   throw new ViewUnapprovedStudentsException();
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
	   //System.out.println("Goodbye!");
	}
	public boolean std_login(int id,String userpass,String username)
	{
		//conn=DBUtils.getConnection();
		Connection conn = null;
		   PreparedStatement stmt = null;
		   boolean flag=false;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");

			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			  
			  
			      stmt = conn.prepareStatement(SQLConstants.STUDENT_LOGIN_SEARCH);
					 stmt.setInt(1, id);
				      ResultSet rs = stmt.executeQuery();
				      rs.next();
				      String status=rs.getString("status");
				      if(status.equals("approved"))
				      {
			      stmt = conn.prepareStatement(SQLConstants.STUDENT_LOGIN);
			      stmt.setLong(1,id);
			      stmt.setString(2,userpass);
			  
			      ResultSet rs1 = stmt.executeQuery();
			      rs1.next();
			      String name1 = rs1.getString("User_name");
			     // String role = rs.getString("Role");
			      if(name1.equals(username) )
			      {
			    	  flag =true;
			    	
			      }
			      else 
			      {
			    	  flag =false;
			    	 
			      }}
				      else {
				    	  System.out.println("WAIT FOR THE ADMIN TO APPROVE..\n");
				    	  flag=false;
				      }
			    
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
			   }
			   return flag;
		//return true;
	}
	}

