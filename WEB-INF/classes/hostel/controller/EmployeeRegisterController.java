package hostel.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import hostel.dao.EmployeeDAO;
import hostel.model.Employee;

/**
 * Servlet implementation class EmployeeRegisterController
 */
public class EmployeeRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action="", forward="";   
	private final String ADD ="user-register.jsp";
	private final String LIST ="page-confirmation.html";
	private int employeeid;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegisterController() {
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
		System.out.print("im in controller");
		 Employee employee = new Employee();

	        // Retrieve input from HTML and set the values to the Employee object
	        employee.setEmployee_name(request.getParameter("name"));
	        employee.setEmployee_position(request.getParameter("position"));
	        employee.setEmployee_ic(request.getParameter("identitynum"));
	        employee.setEmployee_email(request.getParameter("email"));
	        employee.setEmployee_phone(request.getParameter("phoneNum"));
	        employee.setEmployee_address(request.getParameter("address"));
	        employee.setEmployee_bankid(Integer.parseInt(request.getParameter("accountNumber")));
	        employee.setEmployee_username(request.getParameter("username"));
	        employee.setEmployee_password(request.getParameter("password"));

	        String email = employee.getEmployee_email();

	        boolean emailExists = EmployeeDAO.isEmailUsed(email);

	        if (emailExists) {
	            request.setAttribute("error", "Email is already in use.");
	            RequestDispatcher req = request.getRequestDispatcher(ADD);
	            req.forward(request, response);
	        } else {
	            EmployeeDAO.addEmployee(employee);
	            request.setAttribute("employees", EmployeeDAO.getAllEmployee());
	            RequestDispatcher req = request.getRequestDispatcher(LIST);
	            req.forward(request, response);
	        }
	    }

}
