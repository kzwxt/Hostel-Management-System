package hostel.controller;

/*
 * Author: FES 

 * March 2024
 */

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import hostel.connection.ConnectionManager;
import hostel.dao.BookingDAO;
import hostel.dao.RoomDAO;
import hostel.model.Booking;
import hostel.model.Room;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class ViewShawlController
 */
public class AddBookingCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookingCustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//get id from input parameter
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		int roomid = Integer.parseInt(request.getParameter("roomid"));
		String room_status = request.getParameter("room_status");
		String room_details = RoomDAO.getRoomdetails(roomid);
		
		//set attribute to a servlet request. Set the attribute name to shawl and call getShawl() from ShawlDAO class
		request.setAttribute("customerId", customerId);
		request.setAttribute("roomid", roomid);
		request.setAttribute("room_status", room_status);
		request.setAttribute("room_details", room_details);
		

		//Obtain the RequestDispatcher from the request object. The pathname to the resource is viewShawl.jsp
		RequestDispatcher req = request.getRequestDispatcher("AddBookingCustomer.jsp");
	    
	    //Dispatch the request to another resource using forward() methods of the RequestDispatcher
	    req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//create Shawl object
	    Booking booking = new Booking();
	    Room room = new Room();
	    // Handle employeeid
	    String employeeIdStr = request.getParameter("employeeid");
	    Integer employeeId = null;
	    if (employeeIdStr != null && !employeeIdStr.isEmpty()) {
	        employeeId = Integer.parseInt(employeeIdStr);
	    }
	    //retrieve input from HTML and set the values to the Shawl object
	    booking.setReservedate(request.getParameter("reservedate"));
	    booking.setNumberofpeople(Integer.parseInt(request.getParameter("numberofpeople")));
	    booking.setRoomavailability(request.getParameter("roomavailability"));
	    booking.setCustomerid(Integer.parseInt(request.getParameter("customerid")));
	    booking.setRoomid(Integer.parseInt(request.getParameter("roomid")));
	    booking.setEmployeeid(employeeId);
	    
	    room.setRoomid(Integer.parseInt(request.getParameter("roomid")));
	    room.setRoom_status("Booked");
	    BookingDAO.addBooking(booking);
	    RoomDAO.updateRoomStatus(room);
	    
	    //set attribute to a servlet request. Set the attribute name to shawls and call getAllShawls() from ShawlDAO class
	    request.setAttribute("bookings", BookingDAO.getAllBooking());
	    int customerid=booking.getCustomerid();
	    int bookid = BookingDAO.getLastInsertedBookId();
	    //Obtain the RequestDispatcher from the request object. The pathname to the resource is listShawl.jsp
	    RequestDispatcher req = request.getRequestDispatcher("AddBookingCustomer.jsp");
	    System.out.println("Customer ID: " + customerid);
	    System.out.println("Book ID: " + bookid);
	    
	    //Dispatch the request to another resource using forward() methods of the RequestDispatcher
	    response.sendRedirect("BookingSuccess.jsp?customerid=" + customerid + "&bookid=" + bookid);
		
	}

}
