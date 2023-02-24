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

/**
 * @author ALRAHIMA
 *
 */
public class UserDAOImplementation implements UserDAOInterface {
	// Step 1
		// JDBC driver name and database URL
		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost/crs-database";

		   //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "Daraksha05@";
		   
		   
		   public boolean create_user(int id,String pass,String name,String role) throws AdminExceptions
		   {
			// Step 2 
				// Declare the Connection or prepaidstatement variable here 
				   Connection conn = null;
				   PreparedStatement stmt = null;
				   
				   try{
					   
					   // Step 3 Regiater Driver here and create connection 
					   
					   Class.forName("com.mysql.cj.jdbc.Driver");

				
					      conn = DriverManager.getConnection(DB_URL,USER,PASS);
					   
					      
					      stmt = conn.prepareStatement(SQLConstants.CREATE_USER);
					   
					 
					      //Bind values into the parameters.
					      stmt.setInt(1, id);  // This would set age
					      stmt.setString(2,name);
					      stmt.setString(3, pass);
					      stmt.setString(4, role);
					      
					      stmt.executeUpdate();
					      stmt.close();
					      conn.close();
					   }catch(SQLException | ClassNotFoundException se){
					      //Handle errors for JDBC
					      //se.printStackTrace();
						   throw new AdminExceptions();
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
					   System.out.println("\nREGISTRATION COMPLETE\n");
					//end main	
			   
			   
			   return true;
			   //return false;
		   }
		   public boolean login(int userid1, String pwd, String name,String Role1) throws StudentDBViewException
			{
			   Connection conn = null;
			   PreparedStatement stmt = null;
			   boolean flag=false;
			   
			   try{
				   
				   // Step 3 Regiater Driver here and create connection 
				   
				   Class.forName("com.mysql.cj.jdbc.Driver");

				   // Step 4 make/open  a connection 
				   
				     // System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);
				   
				      stmt = conn.prepareStatement(SQLConstants.LOGIN);
				      stmt.setLong(1,userid1);
				      stmt.setString(2,pwd);
				  
				      ResultSet rs = stmt.executeQuery();
				      rs.next();
				      String name1 = rs.getString("User_name");
				      String role = rs.getString("Role");
				      if(name1.equals(name) && role.equals(Role1) )
				      {
				    	  flag =true;
				    	  //System.out.println("xxx");
				      }
				      else 
				      {
				    	  flag =false;
				    	  //System.out.println("yyy");
				      }
				    
				      stmt.close();
				      conn.close();
				   }catch(SQLException | ClassNotFoundException se){
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
				  // System.out.println("Goodbye!");
				  
				   return flag;
				}//end main
				  

}