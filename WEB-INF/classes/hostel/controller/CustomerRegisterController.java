package hostel.controller;

import jakarta.servlet.ServletException; 

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import hostel.dao.EmployeeDAO;
import hostel.model.Employee;
import hostel.dao.CustomerDAO;
import hostel.model.Customer;

/**
 * Servlet implementation class RegisterController
 */
public class CustomerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher view;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        String action = request.getParameter("action");

        if ("viewBooking".equals(action)) {
            RequestDispatcher view = request.getRequestDispatcher("CustomerRegister.jsp");
            view.forward(request, response);
        } else {
            // Handle other actions or show an error page
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setCustomer_name(request.getParameter("customer_name"));
		customer.setCustomer_phone(request.getParameter("customer_phone"));
		customer.setCustomer_ic(request.getParameter("customer_ic"));
		customer.setCustomer_email(request.getParameter("customer_email"));
		customer.setCustomer_address(request.getParameter("customer_address"));
		CustomerDAO.addCustomer(customer);

        // Add customer and retrieve the generated customer ID
        
        
        // Set the customer ID as a request attribute
        request.setAttribute("customerId", CustomerDAO.getLatestID());
		
        // Forward the request to the CustomerBooking.jsp with the customer ID
		RequestDispatcher view = request.getRequestDispatcher("ListCustomerBookingController");
		view.forward(request, response);
		
	}

}
