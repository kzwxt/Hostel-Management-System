package hostel.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import hostel.dao.BookingDAO;
import hostel.dao.RoomDAO;
import hostel.model.Booking;

/**
 * Servlet implementation class ViewBookingController
 */
@WebServlet("/ViewBooking")
 public class CustomerViewBookingController extends HttpServlet  {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerViewBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("ViewBookingController accessed");
    	try {
            int bookid = Integer.parseInt(request.getParameter("bookid"));
            Booking booking = BookingDAO.viewGetBooking(bookid);

            if (booking.getBookid() != 0) {
                request.setAttribute("booking", booking);
                RequestDispatcher view = request.getRequestDispatcher("viewbooking.jsp");
                view.forward(request, response);
            } else {
                response.getWriter().println("No booking found with bookid: " + bookid);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("Invalid bookid format.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred: " + e.getMessage());
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
