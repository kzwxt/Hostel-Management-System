
package hostel.dao;

import java.sql.Connection;  


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hostel.model.*;
import hostel.connection.ConnectionManager;


public class MainDashboardDAO {

  private static Connection con = null;
  private static PreparedStatement ps = null;
  private static Statement stmt = null;
  private static ResultSet rs = null;
  private String room_details,room_type,room_status;
  private static String sql;
  private int roomid,room_size;
  private double room_price;
  
  //insert shawl
  
  public static MainDashboard getMainDashboardData() {
      MainDashboard data = new MainDashboard();
      try {
          con = ConnectionManager.getConnection();

          // Fetch total rooms
          String sql = "SELECT COUNT(*) AS total FROM room";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setTotalRooms(rs.getInt("total"));
          }

          sql = "SELECT COUNT(*) AS total FROM customer";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setTotalCustomers(rs.getInt("total"));
          }
          
          sql = "SELECT COUNT(*) AS total FROM booking";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setTotalBooking(rs.getInt("total"));
          }
          sql = "SELECT COUNT(*) AS total FROM employee";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setTotalEmployee(rs.getInt("total"));
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
          
       // January
          sql = "SELECT COUNT(*) AS january FROM Booking WHERE MONTH(reservedate) = 1 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setJanuaryCount(rs.getInt("january"));
          }

          // February
          sql = "SELECT COUNT(*) AS february FROM Booking WHERE MONTH(reservedate) = 2 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setFebruaryCount(rs.getInt("february"));
          }

          // March
          sql = "SELECT COUNT(*) AS march FROM Booking WHERE MONTH(reservedate) = 3 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setMarchCount(rs.getInt("march"));
          }

          // April
          sql = "SELECT COUNT(*) AS april FROM Booking WHERE MONTH(reservedate) = 4 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setAprilCount(rs.getInt("april"));
          }

          // May
          sql = "SELECT COUNT(*) AS may FROM Booking WHERE MONTH(reservedate) = 5 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setMayCount(rs.getInt("may"));
          }

          // June
          sql = "SELECT COUNT(*) AS june FROM Booking WHERE MONTH(reservedate) = 6 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setJuneCount(rs.getInt("june"));
          }

          // July
          sql = "SELECT COUNT(*) AS july FROM Booking WHERE MONTH(reservedate) = 7 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setJulyCount(rs.getInt("july"));
          }

          // August
          sql = "SELECT COUNT(*) AS august FROM Booking WHERE MONTH(reservedate) = 8 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setAugustCount(rs.getInt("august"));
          }

          // September
          sql = "SELECT COUNT(*) AS september FROM Booking WHERE MONTH(reservedate) = 9 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setSeptemberCount(rs.getInt("september"));
          }

          // October
          sql = "SELECT COUNT(*) AS october FROM Booking WHERE MONTH(reservedate) = 10 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setOctoberCount(rs.getInt("october"));
          }

          // November
          sql = "SELECT COUNT(*) AS november FROM Booking WHERE MONTH(reservedate) = 11 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setNovemberCount(rs.getInt("november"));
          }

          // December
          sql = "SELECT COUNT(*) AS december FROM Booking WHERE MONTH(reservedate) = 12 AND YEAR(reservedate) = 2024";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if (rs.next()) {
              data.setDecemberCount(rs.getInt("december"));

          }
          
          
          
          
          sql = "SELECT SUM(r.room_price) AS total_profit_q1 " +
                  "FROM Booking b " +
                  "JOIN Room r ON b.roomid = r.roomid " +
                  "WHERE b.reservedate BETWEEN '2024-01-01' AND '2024-03-31'";
		   ps = con.prepareStatement(sql);
		   rs = ps.executeQuery();
		   if (rs.next()) {
			   data.setProfitq1(rs.getDouble("total_profit_q1"));
		   }
          
          
           sql= "SELECT SUM(r.room_price) AS total_profit_q2 " +
                  "FROM Booking b " +
                  "JOIN Room r ON b.roomid = r.roomid " +
                  "WHERE b.reservedate BETWEEN '2024-04-01' AND '2024-06-30'";
		   ps = con.prepareStatement(sql);
		   rs = ps.executeQuery();
		   if (rs.next()) {
		        data.setProfitq2(rs.getDouble("total_profit_q2"));
		   }
		
		   // Quarter 3
		   sql= "SELECT SUM(r.room_price) AS total_profit_q3 " +
		                  "FROM Booking b " +
		                  "JOIN Room r ON b.roomid = r.roomid " +
		                  "WHERE b.reservedate BETWEEN '2024-07-01' AND '2024-09-30'";
		   ps = con.prepareStatement(sql);
		   rs = ps.executeQuery();
		   if (rs.next()) {
			   data.setProfitq3(rs.getDouble("total_profit_q3"));
		   }
		
		   // Quarter 4
		   sql= "SELECT SUM(r.room_price) AS total_profit_q4 " +
		                  "FROM Booking b " +
		                  "JOIN Room r ON b.roomid = r.roomid " +
		                  "WHERE b.reservedate BETWEEN '2024-10-01' AND '2024-12-31'";
		   ps = con.prepareStatement(sql);
		   rs = ps.executeQuery();
		   if (rs.next()) {
			   data.setProfitq4(rs.getDouble("total_profit_q4"));
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