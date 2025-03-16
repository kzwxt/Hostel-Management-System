package hostel.controller;

import jakarta.servlet.ServletException;  
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;	
import jakarta.servlet.RequestDispatcher;
import hostel.dao.RoomDAO;
import hostel.model.Room;

/**
 * Servlet implementation class CustomerBookingController
 */
public class ListCustomerBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustomerBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		
	
		//set attribute to a servlet request. Set the attribute name to shawls and call getAllShawls() from ShawlDAO class
		request.setAttribute("rooms", RoomDAO.getAllRoom());
		
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is listShawl.jsp
		RequestDispatcher req = request.getRequestDispatcher("CustomerBooking.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
}
