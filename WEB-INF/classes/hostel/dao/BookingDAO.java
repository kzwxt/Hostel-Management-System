
package hostel.dao;

import java.security.NoSuchAlgorithmException;

import java.sql.Connection;   

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hostel.dao.BookingDAO;
import hostel.model.Booking;
import hostel.dao.CustomerDAO;
import hostel.model.Customer;
import hostel.dao.RoomDAO;
import hostel.model.Room;
import hostel.model.Employee;
import hostel.dao.EmployeeDAO;
import hostel.connection.ConnectionManager;


public class BookingDAO {

  private static Connection con = null;
  private static PreparedStatement ps = null;
  private static Statement stmt = null;
  private static ResultSet rs = null;
  private String reservedate,roomavailability ;
  private static String sql;
  private static int bookid;
  private int numberofpeople;
  private int customerid;
  private int roomid;
  private int employeeid;
  
  //insert shawl
  public static void addBooking(Booking booking){
    
    //Add new booking
    try {
        //call getConnection() method
        con = ConnectionManager.getConnection();
        //3. create statement
        String sql = "INSERT INTO booking (reservedate, numberofpeople, roomavailability, customerid, roomid, employeeid) VALUES (?,?,?,?,?,?)";
        ps = con.prepareStatement(sql);
        //get values from Shawl object and set parameter values
        ps.setString(1, booking.getReservedate());
        ps.setInt(2, booking.getNumberofpeople());
        ps.setString(3, booking.getRoomavailability());
        ps.setInt(4, booking.getCustomerid());
        ps.setInt(5, booking.getRoomid());
        ps.setInt(6, booking.getEmployeeid());
        //4. execute query
        ps.executeUpdate();
        //5. close connection
        con.close();
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
  public static void updateBooking(Booking booking){
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      
      //3. create statement and get the values from Shawl object
      ps = con.prepareStatement("UPDATE booking SET reservedate=?, numberofpeople=?, roomavailability=?, customerid=?, roomid=?, employeeid=? WHERE bookid=?");
      
      //get values from Shawl object and set parameter values
      ps.setString(1, booking.getReservedate());
      ps.setInt(2, booking.getNumberofpeople());
      ps.setString(3, booking.getRoomavailability());
      ps.setInt(4, booking.getCustomerid());
      ps.setInt(5, booking.getRoomid());
      ps.setInt(6, booking.getEmployeeid());
      ps.setInt(7, booking.getBookid());
      
      //4. execute query
      ps.executeUpdate();
      
      //5. close connection
      con.close();
      
      }catch(Exception e) {
        e.printStackTrace();
      }
    
  }  
  
  
  //delete shawl
  public static void deleteBooking(int bookid){
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      //3. create statement
      String sql = "DELETE FROM booking WHERE bookid=?";
      ps = con.prepareStatement(sql);
      //set parameter values
      ps.setInt(1, bookid);
      //4. execute query
      ps.executeUpdate();
      //5. close connection
      con.close();
      }catch(SQLException e) {
        e.printStackTrace();
      }
  }
  
  
  //get shawl by id
  public static Booking getBooking(int bookid) {
    
    // create shawl object
	  Booking booking = new Booking();
    
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      //3. create statement
      ps = con.prepareStatement("SELECT * FROM booking WHERE bookid=?");
      //set parameter values
      ps.setInt(1, bookid);
      //4. execute query
      rs = ps.executeQuery();
      //process ResultSet and set the values to the Shawl object
      if(rs.next()) {
    	  booking.setBookid(rs.getInt("bookid"));
          booking.setReservedate(rs.getString("reservedate"));
          booking.setNumberofpeople(rs.getInt("numberofpeople"));
          booking.setRoomavailability(rs.getString("roomavailability"));
          booking.setCustomerid(rs.getInt("customerid"));
          booking.setRoomid(rs.getInt("roomid"));
          booking.setEmployeeid(rs.getInt("employeeid")); }
      //5. close connection
      con.close();
      }catch(Exception e) {
        e.printStackTrace();
      }
    
    
    return booking;
  }
 
  
	//get Booking by Id
	public static Booking getBookingById(int bookid) {
		Booking booking = new Booking();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "SELECT * FROM booking WHERE bookid = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookid);

			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				booking.setBookid(rs.getInt("bookid"));	  
				booking.setNumberofpeople(rs.getInt("numberofpeople"));
				booking.setRoomavailability(rs.getString("roomavailability"));
				booking.setCustomerid(rs.getInt("customerid"));
				booking.setRoomid(rs.getInt("roomid"));
				booking.setEmployeeid(rs.getInt("employeeid"));
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return booking;
	}
	
	public static List<Booking> getAllBooking(){
		  List<Booking> bookings = new ArrayList<Booking>();
		  
		  try {
			//call getConnection() method
			  con = ConnectionManager.getConnection();
			  
			  stmt = con.createStatement();
			  String sql = "SELECT * FROM booking ORDER BY bookid";
		      rs = stmt.executeQuery(sql);
		        //process ResultSet and set the values to the Shawl object
		        while(rs.next()) {
		        	Booking booking = new Booking();
		        	booking.setBookid(rs.getInt("bookid"));
		            booking.setReservedate(rs.getString("reservedate"));
		            booking.setNumberofpeople(rs.getInt("numberofpeople"));
		            booking.setRoomavailability(rs.getString("roomavailability"));
		            booking.setCustomerid(rs.getInt("customerid"));
		            booking.setRoomid(rs.getInt("roomid"));
		            booking.setEmployeeid(rs.getInt("employeeid"));
		            bookings.add(booking);}
		           
		      //5. close connection
		      con.close();
		  }catch(Exception e) {
			  
			  e.printStackTrace();
			}
		  
		  return bookings;
		  
	}
	public static Booking viewGetBooking(int bookid) {
	      Booking booking = new Booking();
	      Customer customer = new Customer();
	      Room room = new Room();
	      
	      try {
	          con = ConnectionManager.getConnection();
	          String sql = "SELECT b.bookid, b.reservedate, b.numberofpeople, c.customer_name, r.room_details, r.room_price " +
	                       "FROM booking b " +
	                       "JOIN customer c ON b.customerid = c.customerid " +
	                       "JOIN room r ON b.roomid = r.roomid " +
	                       "WHERE b.bookid = ?";
	          ps = con.prepareStatement(sql);
	          ps.setInt(1, bookid);
	          rs = ps.executeQuery();
	          
	          if (rs.next()) {
	              booking.setBookid(rs.getInt("bookid"));
	              booking.setReservedate(rs.getString("reservedate"));
	              booking.setNumberofpeople(rs.getInt("numberofpeople"));
	              customer.setCustomer_name(rs.getString("customer_name"));
	              room.setRoom_details(rs.getString("room_details"));
	              room.setRoom_price(rs.getDouble("room_price"));
	              booking.setCustomer(customer);
	              booking.setRoom(room);
	              System.out.println("Booking found: " + booking.getBookid() + ", " + customer.getCustomer_name() + ", " + room.getRoom_details());
	          } else {
	              System.out.println("No booking found with bookid: " + bookid);
	          }
	          
	          con.close();
	      } catch (SQLException e) {
	          e.printStackTrace();
	      }
	      
	      return booking;
	  }
	public static Booking login(Booking booking) throws NoSuchAlgorithmException{

		//convert the password to MD5
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT * FROM  booking WHERE bookid = ? AND customerid = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, booking.getBookid());
			ps.setInt(2, booking.getCustomerid());
			
		    //4. execute query
			rs = ps.executeQuery();

			// if user exists set the isValid variable to true
			if (rs.next()) {
				booking.setBookid(rs.getInt("bookid"));
				booking.setCustomerid(rs.getInt("customerid"));
				booking.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else{
				booking.setValid(false);
			}

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return booking;
	}
	
	public static int getLastInsertedBookId() {
	    int bookid = 0;

	    try {
	        // Call getConnection() method
	        con = ConnectionManager.getConnection();
	        // Create statement
	        String sql = "SELECT bookid FROM booking ORDER BY bookid DESC LIMIT 1";
	        ps = con.prepareStatement(sql);
	        // Execute query
	        rs = ps.executeQuery();
	        // Process ResultSet
	        if (rs.next()) {
	            bookid = rs.getInt("bookid");
	            System.out.println("Last inserted bookid: " + bookid); // Debug statement
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return bookid;
	}
	public static Booking getDashboardData() {
	      Booking data = new Booking();
	      try {
	          con = ConnectionManager.getConnection();

	          // Fetch total rooms
	          String sql = "SELECT COUNT(*) AS total FROM booking";
	          ps = con.prepareStatement(sql);
	          rs = ps.executeQuery();
	          if (rs.next()) {
	              data.setTotalBooking(rs.getInt("total"));
	          }
	          
	          
	         sql = "SELECT SUM(r.room_price) AS total_profit " +
                      "FROM Booking b " +
                      "JOIN Room r ON b.roomid = r.roomid";

	         	ps = con.prepareStatement(sql);
	         		rs = ps.executeQuery();

	         		if (rs.next()) {
	         			data.setTotalProfit(rs.getDouble("total_profit"));
	         		}
	         		
	         		
	         sql = "SELECT r.room_details " +
	                         "FROM Room r " +
	                         "JOIN ( " +
	                         "    SELECT roomid " +
	                         "    FROM Booking " +
	                         "    GROUP BY roomid " +
	                         "    ORDER BY COUNT(*) DESC " +
	                         "    LIMIT 1 " +
	                         ") AS popular_room ON r.roomid = popular_room.roomid";

	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();

	            if (rs.next()) {
	            	data.setMostbooked(rs.getString("room_details"));
	            }
	            
	      sql = "SELECT reservedate " +
                        "FROM Booking " +
                        "GROUP BY reservedate " +
                        "ORDER BY COUNT(*) DESC " +
                        "LIMIT 1";

           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();

           if (rs.next()) {
               data.setMostReserved(rs.getString("reservedate"));
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
	
	
}