
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
public class AdminDAOImplementation implements AdminDAOInteface {
	
			   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
			   static final String DB_URL = "jdbc:mysql://localhost/crs-database";

		
			   static final String USER = "root";
			   static final String PASS = "MyNameIs@Garvit1";
	public boolean admin_db_create(int adminId ,String adminName,String AdminDesignation)
	{
		
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");

			   
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      stmt = conn.prepareStatement(SQLConstants.ADMIN_DB_CREATE);
			   
			      stmt.setInt(1, adminId); 
			      stmt.setString(2,adminName);
			      stmt.setString(3, AdminDesignation);
			      
			      stmt.executeUpdate();
			     
			      stmt.close();
			      conn.close();
			      
			   }
		   catch(SQLException se){
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
	public void approvestd(int stdid, String status) throws StudentDBViewException
	{
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			     
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      
			     
			      stmt = conn.prepareStatement(SQLConstants.APPROVE_STD_SEARCH);
			      stmt.setInt(1, stdid); 
			      ResultSet rs = stmt.executeQuery();
			      rs.next();
			     String stat= rs.getString("status");
			   
			    	if(stat.equals("yet_to_approve"))
			    	{
			    		 
			    		 stmt = conn.prepareStatement(SQLConstants.UPDATE_STD_APPROVE);
			    		 
					      stmt.setString(1,status);
					      stmt.setInt(2, stdid);
					      stmt.executeUpdate();
					     
			    	}
			    	else {
			    		System.out.println("STUDENT ALREADY APPROVED\n");
			    	}
			    
			      
			      stmt.close();
			      conn.close();
			   }catch(SQLException | ClassNotFoundException se){
			      //Handle errors for JDBC
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
			   //System.out.println("STUDENT APPROVED!\n");
		
	}

}