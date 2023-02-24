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
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.ViewGradeCardException;
import com.signify.utils.DBUtils;

/**
 * @author ALRAHIMA
 *
 */
public class CourseCatalogDAOImplementation implements CourseCatalogDAOInterface {
	// Step 1
			// JDBC driver name and database URL
			   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
			   static final String DB_URL = "jdbc:mysql://localhost/crs-database";

			   //  Database credentials
			   static final String USER = "root";
			   static final String PASS = "Daraksha05@";
	//private Connection conn;
	public boolean catalog_db_create(String courseId, String courseName, int courseProf,int courseprice) throws CourseCreateExceptions
	{
		//conn=DBUtils.getConnection();
		// Step 2 
		// Declare the Connection or prepaid statement variable here 
		  Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");

			  
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      stmt = conn.prepareStatement(SQLConstants.ADD_COURSE_CATALOG);
	
			      stmt.setString(1, courseId);  // This would set age
			      stmt.setString(2,courseName);
			      stmt.setInt(3, courseProf);
			      stmt.setInt(4, courseprice);
			      stmt.executeUpdate();
			  
			     // rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException | ClassNotFoundException se){
			      //Handle errors for JDBC
			      //se.printStackTrace();
				   throw new CourseCreateExceptions();
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
			  // System.out.println("Registered Student Preview");
			//end main	
		
		return true;
	}
	
	public void deleteCourse(String courseid1) throws DeleteCourseException {
		//conn=DBUtils.getConnection();
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			
			   Class.forName("com.mysql.cj.jdbc.Driver");

			     conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
			      stmt = conn.prepareStatement(SQLConstants.DELETE_COURSE_CATALOG);
			      stmt.setString(1, courseid1);  // This would set age
			      stmt.executeUpdate();
			    stmt.close();
			      conn.close();
			   }catch(SQLException | ClassNotFoundException  se){
			 
				   throw new DeleteCourseException();
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
			  // System.out.println("Registered Student Preview");
			//end main	
		
		return;
		
	}
	public void CourseDetail(String courseid1) throws CourseDetailsException
	{
		//conn=DBUtils.getConnection();
		 Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");

			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		stmt = conn.prepareStatement(SQLConstants.COURSE_DETAILS);
		  stmt.setString(1, courseid1);
	      ResultSet rs = stmt.executeQuery();
	      rs.next();

	      //STEP 5: Extract data from result set
	      
	         //Retrieve by column name
	        
	         String id = rs.getString("courseid");
	         String name = rs.getString("course_name");
	         String prof = rs.getString("prof_name");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", name: " + name);
	         System.out.print(", prof: " + prof);
	         
	 
	      //STEP 6: Clean-up environment
	     // rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException | ClassNotFoundException se){
		   throw new CourseDetailsException();
	     
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
	
	
	
	
	
	public boolean student_add_course(String courseId, int studentId) throws StudentAddCourseException
	{
		
		///conn=DBUtils.getConnection();
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   int setprice=0;
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");

			
			   conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
		
			      
			  	stmt = conn.prepareStatement(SQLConstants.SEARCH_COURSE_INFO);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			 int price  = rs.getInt("course_price");
	         String cid = rs.getString("courseid");
	         if(cid.equals(courseId)) {
	        	 setprice=price;
	        	 break;
	         }
		}
			   
			      stmt = conn.prepareStatement(SQLConstants.ADD_STD_COURSE);
			   
			 
			      //Bind values into the parameters.
			      stmt.setInt(1, studentId);  // This would set age
			      stmt.setString(2,courseId);
			      stmt.setInt(3, setprice);
			      stmt.executeUpdate();
	
			      stmt.close();
			      conn.close();
			   }catch(SQLException | ClassNotFoundException se){
			     throw new StudentAddCourseException();
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
	public boolean student_drop_course(String courseId, int studentId) throws StudentDropCourseException
	{
		//conn=DBUtils.getConnection();
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			     // System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			     
			      stmt = conn.prepareStatement(SQLConstants.STD_DROP_COURSE);
			      stmt.setString(1, courseId);
			      stmt.setInt(2, studentId);
			      // This would set age
			      stmt.executeUpdate();
			           
			   
			   
			  
			      stmt.close();
			      conn.close();
			   }catch(SQLException | ClassNotFoundException se){
			      throw new StudentDropCourseException();
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
			  // System.out.println("Registered Student Preview");
			//end main	
		
		
		return true;
	}
	public int course_payment(int stdid) throws CoursePamentViewException
	{
		//conn=DBUtils.getConnection();	
		Connection conn = null;
		   PreparedStatement stmt = null;
		   int count=0;
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			     
			      stmt = conn.prepareStatement(SQLConstants.COURSE_PAYMENT);
			      stmt.setInt(1,stdid);
			      
			      ResultSet rs = stmt.executeQuery();
			     
			      while (rs.next())
			      {
			    	  int price  = rs.getInt("course_price");
			    	  count=count+price;
			      }
			      //
			
			     // rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException | ClassNotFoundException se){
				   throw new CoursePamentViewException();
			      
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
			  // System.out.println("Registered Student Preview");
			//end main	
		
		return count;
	}
	public void add_payment_in_table(int stdid,int amount,String mode_of_payment,String status)
	{
		//conn=DBUtils.getConnection();
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");

			     conn = DriverManager.getConnection(DB_URL,USER,PASS);
			     
			      stmt = conn.prepareStatement(SQLConstants.ADD_PAYMENT_IN_TABLE);
			   
			   
			      stmt.setInt(1, stdid);  // This would set age
			      stmt.setInt(2,amount);
			      stmt.setString(3,mode_of_payment);
			      stmt.setString(4, status);
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
			   }//end try
			   //System.out.println("Goodbye!");
			}//end main
	
	public void do_course_payment(int stdid,int amount, String mode) throws CoursePamentViewException
	{
		//conn=DBUtils.getConnection();
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			  Class.forName("com.mysql.jdbc.Driver");

			     conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
			      stmt = conn.prepareStatement(SQLConstants.SEARCH_DO_COURSE_PAYMENT);
			      stmt.setInt(1, stdid); 
			      ResultSet rs = stmt.executeQuery();
			      rs.next();
			      int totalpay= rs.getInt("total_payment");
			    		  
			    	if(totalpay==amount)
			    	{
			    		 
			    		 stmt = conn.prepareStatement(SQLConstants.DO_COURSE_PAYMENT);
			    		
					      stmt.setString(1,mode);
					      stmt.setString(2, "PAYMENT DONE");
					      stmt.setInt(3, stdid);
					      stmt.executeUpdate();
					      System.out.println("\nPAYMENT DONE\n");
					  
			    	}
			    	else {
			    		System.out.println("WRONG AMOUNT PAID, TRY AGAIN LATER");
			    	}
			 
			      
			      stmt.close();
			      conn.close();
			   }catch(SQLException | ClassNotFoundException se){
			     throw new CoursePamentViewException();
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
	
	public void viewGradeCard(int stdid) throws ViewGradeCardException {
		//conn=DBUtils.getConnection();
		Connection conn = null;
		   PreparedStatement stmt = null;
		   int count=0;
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");

			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			    
			      
			      stmt = conn.prepareStatement(SQLConstants.VIEW_GRADE_CARD);
			      stmt.setInt(1,stdid);
			      
			      ResultSet rs = stmt.executeQuery();
			      while (rs.next())
			      {
			    	  
			    	  String cid =rs.getString("Courseid");
			    	  String gd=rs.getString("grade");
			    	  System.out.println("COURSE ID "+ cid+", GRADE "+gd+"\n");
			    	  
			    	 
			      }
			      
			     // rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException | ClassNotFoundException se){
			      throw new ViewGradeCardException();
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
		
		return;
		
	}
	}
	
	


