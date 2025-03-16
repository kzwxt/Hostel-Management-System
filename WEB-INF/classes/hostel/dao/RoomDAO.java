
package hostel.dao;

import java.sql.Connection;  


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hostel.model.Customer;
import hostel.model.Room;
import hostel.connection.ConnectionManager;


public class RoomDAO {

  private static Connection con = null;
  private static PreparedStatement ps = null;
  private static Statement stmt = null;
  private static ResultSet rs = null;
  private String room_details,room_type,room_status;
  private static String sql;
  private int roomid,room_size;
  private double room_price;
  
  //insert shawl
  public static void addRoom(Room room){
    
    //complete the code here
    try {
        //call getConnection() method
        con = ConnectionManager.getConnection();
        //3. create statement
        String sql = "INSERT INTO room(room_size,room_details,room_price,room_type,room_status)VALUES(?,?,?,?,?)";
        ps = con.prepareStatement(sql);
        //get values from Shawl object and set parameter values
        ps.setInt(1, room.getRoom_size());
        ps.setString(2, room.getRoom_details());
        ps.setDouble(3, room.getRoom_price());
        ps.setString(4, room.getRoom_type());
        ps.setString(5, room.getRoom_status());
        //4. execute query
        ps.executeUpdate();
        //5. close connection
        con.close();
      }catch(SQLException e) {
        e.printStackTrace();
      }
    
  }  
  
  
  //update shawl
  public static void updateRoom(Room room){
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      
      //3. create statement and get the values from Shawl object
      ps = con.prepareStatement("UPDATE room SET room_size=?,room_details=?,room_price=?,room_type=?,room_status=? WHERE roomid=?");
      
      //get values from Shawl object and set parameter values
      ps.setInt(1, room.getRoom_size());
      ps.setString(2, room.getRoom_details());
      ps.setDouble(3, room.getRoom_price());
      ps.setString(4, room.getRoom_type());
      ps.setString(5, room.getRoom_status());
      ps.setInt(6, room.getRoomid());
      
      //4. execute query
      ps.executeUpdate();
      
      //5. close connection
      con.close();
      
      }catch(Exception e) {
        e.printStackTrace();
      }
    
  }  
  
  
  //delete shawl
  public static void deleteRooom(int roomid){
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      //3. create statement
      String sql = "DELETE FROM room WHERE roomid=?";
      ps = con.prepareStatement(sql);
      //set parameter values
      ps.setInt(1, roomid);
      //4. execute query
      ps.executeUpdate();
      //5. close connection
      con.close();
      }catch(SQLException e) {
        e.printStackTrace();
      }
  }
  
  
  //get shawl by id
  public static Room getRoom(int roomid) {
    
    // create shawl object
    Room room = new Room();
    
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      //3. create statement
      ps = con.prepareStatement("SELECT * FROM room WHERE roomid=?");
      //set parameter values
      ps.setInt(1, roomid);
      //4. execute query
      rs = ps.executeQuery();
      //process ResultSet and set the values to the Shawl object
      if(rs.next()) {
      room.setRoomid(rs.getInt("roomid"));
      room.setRoom_size(rs.getInt("room_size"));
      room.setRoom_details(rs.getString("room_details"));
      room.setRoom_price(rs.getDouble("room_price"));
      room.setRoom_type(rs.getString("room_type"));
      room.setRoom_status(rs.getString("room_status"));
      }
      //5. close connection
      con.close();
      }catch(Exception e) {
        e.printStackTrace();
      }
    
    
    return room;
  }
  
  
  //get all shawls
  public static List<Room> getAllRoom(){

List<Room> rooms= new ArrayList<Room>();

    //complete the code here
    try {
        //call getConnection() method
        con = ConnectionManager.getConnection();
        //3. create statement
        stmt = con.createStatement();
        String sql = "SELECT * FROM room ORDER BY roomid";
        //4. execute query
        rs = stmt.executeQuery(sql);
        //process ResultSet and set the values to the Shawl object
        while(rs.next()) {
        Room room  = new Room();
        room.setRoomid(rs.getInt("roomid"));
        room.setRoom_size(rs.getInt("room_size"));
        room.setRoom_details(rs.getString("room_details"));
        room.setRoom_price(rs.getDouble("room_price"));
        room.setRoom_type(rs.getString("room_type"));
        room.setRoom_status(rs.getString("room_status"));
        rooms.add(room);
      }
      //5. close connection
      con.close();
      }catch(Exception e) {
        e.printStackTrace();
      }
    
    
    return rooms;
  }  
  
  public static Room getDashboardData() {
      Room data = new Room();
      try {
          con = ConnectionManager.getConnection();

          // Fetch total rooms
          String sql = "SELECT COUNT(*) AS total FROM room";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setTotalRooms(rs.getInt("total"));
          }

          // Fetch available rooms
          sql = "SELECT COUNT(*) AS available FROM room WHERE room_status = 'Available'";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setAvailableRooms(rs.getInt("available"));
          }

          // Fetch unavailable rooms
          sql = "SELECT COUNT(*) AS unavailable FROM room WHERE room_status = 'Unavailable'";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setUnavailableRooms(rs.getInt("unavailable"));
          }

          // Fetch booked rooms
          sql = "SELECT COUNT(*) AS booked FROM room WHERE room_status = 'Booked'";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setBookedRooms(rs.getInt("booked"));
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
  public static void updateRoomStatus(Room room){
	    //complete the code here
	    try {
	      //call getConnection() method
	      con = ConnectionManager.getConnection();
	      
	      //3. create statement and get the values from Shawl object
	      ps = con.prepareStatement("UPDATE room SET room_status=? WHERE roomid=?");
	      
	      //get values from Shawl object and set parameter value
	      ps.setString(1, room.getRoom_status());
	      ps.setInt(2, room.getRoomid());
	      
	      //4. execute query
	      ps.executeUpdate();
	      
	      //5. close connection
	      con.close();
	      
	      }catch(Exception e) {
	        e.printStackTrace();
	      }
	    
	  }  
  
  public static String getRoomdetails(int roomid) {
	    String room_details = " ";

	    try {
	        // Call getConnection() method
	        con = ConnectionManager.getConnection();
	        // Create statement
	        String sql = "SELECT room_details FROM room WHERE roomid =?";
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, roomid);
	        // Execute query
	        rs = ps.executeQuery();
	        // Process ResultSet
	        if (rs.next()) {
	            room_details = rs.getString("room_details");
	            System.out.println("Room details got " + room_details); // Debug statement
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

	    return room_details;
	}
}