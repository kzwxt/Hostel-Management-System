package hostel.controller;

import jakarta.servlet.RequestDispatcher;  
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import hostel.dao.BookingDAO;
import hostel.model.Booking;
import hostel.dao.CustomerDAO;
import hostel.model.Customer;
import hostel.dao.RoomDAO;
import hostel.model.Room;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class BookingController
 */
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action = "", forward = "";   
	private final String VIEW = "view-Booking.jsp";
	private final String ADD = "page-AddBooking.html";
	private final String UPDATE = "update-Booking.jsp";
	private final String LIST = "list-Booking.jsp";
	private int bookid;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "view":
                    forward = VIEW;
                    bookid = Integer.parseInt(request.getParameter("bookid"));
                    request.setAttribute("booking", BookingDAO.getBooking(bookid));
                    break;
                case "update":
                    forward = UPDATE;
                    bookid = Integer.parseInt(request.getParameter("bookid"));
                    request.setAttribute("booking", BookingDAO.getBooking(bookid));                    
                    break;
                case "delete":
                    forward = LIST;
                    bookid = Integer.parseInt(request.getParameter("bookingid"));
                    BookingDAO.deleteBooking(bookid); //Invoke
                    request.setAttribute("bookings", BookingDAO.getAllBooking());
                    break;
                case "list":
                    forward = LIST;
                    request.setAttribute("bookings", BookingDAO.getAllBooking());
                    break;
                default:
                    forward = LIST;
                    request.setAttribute("bookings", BookingDAO.getAllBooking());
                    break;
            }
        } else {
            forward = LIST;
            request.setAttribute("bookings", BookingDAO.getAllBooking());
        }
        
        Booking dashboardData = BookingDAO.getDashboardData();
        request.setAttribute("dashboardData", dashboardData);
        
        RequestDispatcher req = request.getRequestDispatcher(forward);
        req.forward(request, response);
        
       
        
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Booking booking = new Booking();
		 Room room = new Room();
		booking.setReservedate(request.getParameter("reservedate"));
		booking.setNumberofpeople(Integer.parseInt(request.getParameter("numberofpeople")));
		booking.setRoomavailability(request.getParameter("roomavailability"));
		booking.setCustomerid(Integer.parseInt(request.getParameter("customerid")));
	    booking.setRoomid(Integer.parseInt(request.getParameter("roomid")));
	    booking.setEmployeeid(Integer.parseInt(request.getParameter("employeeid")));
		
        String bookid = request.getParameter("bookid");
	
        if (bookid != null && !bookid.isEmpty()) {
            booking.setBookid(Integer.parseInt(bookid));
            BookingDAO.updateBooking(booking); // Call updateRoom() from RoomDAO class
        } else {
        	 room.setRoomid(Integer.parseInt(request.getParameter("roomid")));
     	    room.setRoom_status("Booked");
            BookingDAO.addBooking(booking); // Call addRoom() from RoomDAO class
            RoomDAO.updateRoomStatus(room);
        }

		// Set attribute to a servlet request
		request.setAttribute("bookings", BookingDAO.getAllBooking());

		Booking dashboardData = BookingDAO.getDashboardData();
        request.setAttribute("dashboardData", dashboardData);
		
		// Obtain the RequestDispatcher from the request object
		RequestDispatcher req = request.getRequestDispatcher(LIST);

		// Dispatch the request to another resource
		req.forward(request, response);
	}

	/**
	 * Utility method to parse integer values safely.
	 * 
	 * @param value the string to parse
	 * @param defaultValue the default value to return if parsing fails
	 * @return parsed integer or default value
	 */

}
