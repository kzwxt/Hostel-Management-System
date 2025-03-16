package hostel.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import hostel.model.Customer;
import hostel.model.Room;
import hostel.dao.CustomerDAO;
import hostel.dao.RoomDAO;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action="", forward="";   
	private final String VIEW ="view-User.jsp";
	private final String ADD ="";
	private final String UPDATE ="update-User.jsp";
	private final String LIST ="list-User.jsp";
	private int customerid;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
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
                    customerid = Integer.parseInt(request.getParameter("customerid"));
                    request.setAttribute("customer", CustomerDAO.getCustomer(customerid));
                    break;
                case "update":
                    forward = UPDATE;
                    customerid = Integer.parseInt(request.getParameter("customerid"));
                    request.setAttribute("customer", CustomerDAO.getCustomer(customerid));
                    break;
                case "delete":
                    forward = LIST;
                    customerid = Integer.parseInt(request.getParameter("customerid"));
                    CustomerDAO.deleteCustomer(customerid);
                    request.setAttribute("customers", CustomerDAO.getAllCustomer());
                    break;
                case "list":
                    forward = LIST;
                    request.setAttribute("customers", CustomerDAO.getAllCustomer());
                    break;
                default:
                    forward = LIST;
                    request.setAttribute("customers", CustomerDAO.getAllCustomer());
                    break;
            }
        } else {
            forward = LIST;
            request.setAttribute("customers", CustomerDAO.getAllCustomer());
        }
        
        Customer dashboardData = CustomerDAO.getDashboardData();
        request.setAttribute("dashboardData", dashboardData);
        
        RequestDispatcher req = request.getRequestDispatcher(forward);
        req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer customer = new Customer();

		//retrieve input from HTML and set the values to the Shawl object
		customer.setCustomer_name(request.getParameter("customer_name"));
		customer.setCustomer_phone(request.getParameter("customer_phone"));
		customer.setCustomer_ic(request.getParameter("customer_ic"));
		customer.setCustomer_email(request.getParameter("customer_email"));
		customer.setCustomer_address(request.getParameter("customer_address"));
		String customerid = request.getParameter("customerid");

		if(customerid!=null) {
			customer.setCustomerid(Integer.parseInt(customerid));
			CustomerDAO.updateCustomer(customer); 	//call updateShawl() from ShawlDAO class
		}
		else
			CustomerDAO.addCustomer(customer); 		//call addShawl() from ShawlDAO class

		//set attribute to a servlet request. Set the attribute name to shawls and call getAllShawls() from ShawlDAO class
		request.setAttribute("customers", CustomerDAO.getAllCustomer());

		// Fetch the dashboard data and set it as a request attribute
        Customer dashboardData = CustomerDAO.getDashboardData();
        request.setAttribute("dashboardData", dashboardData);
		
		//Obtain the RequestDispatcher from the request object. The the pathname to the resource is listShawl.jsp
		RequestDispatcher req = request.getRequestDispatcher(LIST);

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response); 
	}
	

}
