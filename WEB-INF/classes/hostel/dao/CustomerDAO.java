
package hostel.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hostel.model.Booking;
import hostel.model.Customer;
import hostel.model.Room;
import hostel.connection.ConnectionManager;


public class CustomerDAO {

  private static Connection con = null;
  private static PreparedStatement ps = null;
  private static Statement stmt = null;
  private static ResultSet rs = null;
  private String customer_name,customer_phone,customer_ic,customer_email,customer_address;
  private static String sql;
  private int customerid;
  
  //insert shawl
  public static void addCustomer(Customer customer){
  
    //complete the code here
    try {
        //call getConnection() method
        con = ConnectionManager.getConnection();
        
        // Create SQL query to insert customer
        String sql = "INSERT INTO customer(customer_name,customer_phone,customer_ic,customer_email,customer_address) VALUES(?,?,?,?,?)";
        ps = con.prepareStatement(sql);
        
        // Set parameter values
        ps.setString(1, customer.getCustomer_name());
        ps.setString(2, customer.getCustomer_phone());
        ps.setString(3, customer.getCustomer_ic());
        ps.setString(4, customer.getCustomer_email());
        ps.setString(5, customer.getCustomer_address());
        
        // Execute update
        ps.executeUpdate();
        
        // Retrieve the generated customer ID
       
        
      }catch(SQLException e) {
        e.printStackTrace();
      } finally {
          try {
              if (rs != null) rs.close();
              if (ps != null) ps.close();
              if (con != null) con.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
  }
      
  
  
  //update shawl
  public static void updateCustomer(Customer customer){
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      
      //3. create statement and get the values from Shawl object
      ps = con.prepareStatement("UPDATE customer SET customer_name=?,customer_phone=?,customer_ic=?,customer_email=?,customer_address=? WHERE customerid=?");
      
      //get values from Shawl object and set parameter values
      ps.setString(1, customer.getCustomer_name());
      ps.setString(2, customer.getCustomer_phone());
      ps.setString(3, customer.getCustomer_ic());
      ps.setString(4, customer.getCustomer_email());
      ps.setString(5, customer.getCustomer_address());
      ps.setInt(6, customer.getCustomerid());
      
      //4. execute query
      ps.executeUpdate();
      
      
      //5. close connection
      con.close();
      
      }catch(Exception e) {
        e.printStackTrace();
      }
  }
    
  
  
  //delete shawl
  public static void deleteCustomer(int customerid){
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      //3. create statement
      String sql = "DELETE FROM customer WHERE customerid=?";
      ps = con.prepareStatement(sql);
      //set parameter values
      ps.setInt(1, customerid);
      //4. execute query
      ps.executeUpdate();
      //5. close connection
      con.close();
      }catch(SQLException e) {
        e.printStackTrace();
      }
  }
  
  
  //get shawl by id
  public static Customer getCustomer(int customerid) {
    
    // create shawl object
    Customer customer= new Customer();
    
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      //3. create statement
      ps = con.prepareStatement("SELECT * FROM customer WHERE customerid=?");
      //set parameter values
      ps.setInt(1, customerid);
      //4. execute query
      rs = ps.executeQuery();
      //process ResultSet and set the values to the Shawl object
      if(rs.next()) {
      customer.setCustomerid(rs.getInt("customerid"));
      customer.setCustomer_name(rs.getString("customer_name"));
      customer.setCustomer_phone(rs.getString("customer_phone"));
      customer.setCustomer_ic(rs.getString("customer_ic"));
      customer.setCustomer_email(rs.getString("customer_email"));
      customer.setCustomer_address(rs.getString("customer_address"));
      }
      //5. close connection
      con.close();
      }catch(Exception e) {
        e.printStackTrace();
      }
    
    
    return customer;
  }
  
  
  //get all shawls
  public static List<Customer> getAllCustomer(){

List<Customer> customers = new ArrayList<Customer>();

    //complete the code here
    try {
        //call getConnection() method
        con = ConnectionManager.getConnection();
        //3. create statement
        stmt = con.createStatement();
        String sql = "SELECT * FROM customer ORDER BY customerid";
        //4. execute query
        rs = stmt.executeQuery(sql);
        //process ResultSet and set the values to the Shawl object
        while(rs.next()) {
        Customer customer = new Customer();
        customer.setCustomerid(rs.getInt("customerid"));
        customer.setCustomer_name(rs.getString("customer_name"));
        customer.setCustomer_phone(rs.getString("customer_phone"));
        customer.setCustomer_ic(rs.getString("customer_ic"));
        customer.setCustomer_email(rs.getString("customer_email"));
        customer.setCustomer_address(rs.getString("customer_address"));
        customers.add(customer);
      }
      //5. close connection
      con.close();
      }catch(Exception e) {
        e.printStackTrace();
      }
    
    
    return customers;
  }
  
  public static Customer getDashboardData() {
      Customer data = new Customer();
      try {
          con = ConnectionManager.getConnection();

          // Fetch total rooms
          String sql = "SELECT COUNT(*) AS total FROM customer";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) 
          {
              data.setTotalCustomers(rs.getInt("total"));       
          }
          
          
       // Fetch past bookings
        sql = "SELECT COUNT(*) AS pastBookings " +
                       "FROM Booking " +
                       "WHERE reservedate < CURDATE()";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setCompletedReservations(rs.getInt("pastBookings"));
          }

          // Fetch upcoming bookings
          sql = "SELECT COUNT(*) AS upcomingBookings " +
                "FROM Booking " +
                "WHERE reservedate >= CURDATE()";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setUpcomingReservations(rs.getInt("upcomingBookings"));
          }
          
          sql = "SELECT customer_name " +
                  "FROM customer " +
                  "ORDER BY customerid DESC " +
                  "LIMIT 1";

          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();

          if (rs.next()) {
        	  data.setNewestCustomer(rs.getString("customer_name"));
          }
          
          
          
          
          
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          try {
              if (rs != null) rs.close();
              if (ps != null) ps.close();
              if (con != null) con.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      return data;
  }
  
  public static int getLatestID() {
      int customerId = 0;
      
      try {
          con = ConnectionManager.getConnection();

          // Fetch total rooms
          String sql = "SELECT customerid FROM customer ORDER BY customerid DESC LIMIT 1;";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) 
          {
              customerId=rs.getInt("customerId");       
          }
          
          
          
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          try {
              if (rs != null) rs.close();
              if (ps != null) ps.close();
              if (con != null) con.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      return customerId;
  }
  
	//get Customer by Id
	/*public static int getCustomerById(int customerid) {
		Customer customer = new Customer();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "SELECT * FROM customer WHERE customerid = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, customerid);

			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				customer.setCustomerid(rs.getInt("customerid"));	  
				customer.setCustomer_name(rs.getString("customer_name"));
				customer.setCustomer_phone(rs.getString("customer_phone"));
				customer.setCustomer_ic(rs.getString("customer_ic"));
				customer.setCustomer_email(rs.getString("customer_email"));
				customer.setCustomer_address(rs.getString("customer_address"));
				
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return customer;
	}*/
}