package hostel.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import hostel.dao.BookingDAO;
import hostel.dao.EmployeeDAO;
import hostel.model.Booking;
import hostel.model.Employee;

/**
 * Servlet implementation class EmployeeLoginController
 */
public class EmployeeLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private RequestDispatcher view;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.print("im in Employee Login Controller");
			Employee user = new Employee();
			//retrieve and set email and password
			user.setEmployee_email(request.getParameter("email"));
			user.setEmployee_password(request.getParameter("password"));
			
			user = EmployeeDAO.login(user);
			
			if(user.isValid()){
				session = request.getSession(true);
				session.setAttribute("sessionEmail", user.getEmployee_email());
				session.setAttribute("sessionPassword", user.getEmployee_password());

				
				response.sendRedirect("MainDashboardController"); // Ensure this matches the URL pattern of MainDashboardController
		        										
			}
			else {
            request.setAttribute("errorMessage", "Invalid Email or Password entered.");
            view = request.getRequestDispatcher("user-login.jsp");
            view.forward(request, response);
        }
            
        } catch (Throwable ex) {
			ex.printStackTrace();
        }
	}

}
