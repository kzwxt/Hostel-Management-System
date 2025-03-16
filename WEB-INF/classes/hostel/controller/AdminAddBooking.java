package hostel.controller;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import hostel.dao.BookingDAO;
import hostel.dao.CustomerDAO;
import hostel.dao.EmployeeDAO;
import hostel.dao.RoomDAO;
import hostel.model.Customer;
import hostel.model.Employee;
import hostel.model.Room;

/**
 * Servlet implementation class RoomController
 */
public class AdminAddBooking extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String action = "", forward = "";
    private static final String VIEW = "view-Employee.jsp";
    private static final String ADD = "";
    private static final String UPDATE = "update-Booking.jsp";
    private static final String LIST = "page-AddBooking-information.jsp" ;
    private int roomid;
    private int customerid;
    private int employeeid;
    private int bookid;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddBooking() {
        super();
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
        			employeeid = Integer.parseInt(request.getParameter("employeeid"));
        			request.setAttribute("employee", EmployeeDAO.getEmployee(employeeid));
                    break;
                case "update":
                    forward = UPDATE;
                    roomid = Integer.parseInt(request.getParameter("roomid"));
                    request.setAttribute("room", RoomDAO.getRoom(roomid));
                    customerid = Integer.parseInt(request.getParameter("customerid"));
                    request.setAttribute("customer", CustomerDAO.getCustomer(customerid));
                    employeeid = Integer.parseInt(request.getParameter("employeeid"));
                    request.setAttribute("employee", EmployeeDAO.getEmployee(employeeid));
                    bookid = Integer.parseInt(request.getParameter("bookid"));
                    request.setAttribute("booking", BookingDAO.getBooking(bookid));  
                    
                    request.setAttribute("rooms", RoomDAO.getAllRoom());
                    request.setAttribute("customers", CustomerDAO.getAllCustomer());
                    request.setAttribute("employees", EmployeeDAO.getAllEmployee());
                    break;
   
                case "delete":
                    forward = LIST;
                    roomid = Integer.parseInt(request.getParameter("roomid"));
                    RoomDAO.deleteRooom(roomid);
                    request.setAttribute("rooms", RoomDAO.getAllRoom());
                    customerid = Integer.parseInt(request.getParameter("customerid"));
                    CustomerDAO.deleteCustomer(customerid);
                    request.setAttribute("customers", CustomerDAO.getAllCustomer());
                    employeeid = Integer.parseInt(request.getParameter("employeeid"));
                    EmployeeDAO.deleteEmployee(employeeid);
                    request.setAttribute("employees", EmployeeDAO.getAllEmployee());
                    break;
                case "list":
                    forward = LIST;
                    request.setAttribute("rooms", RoomDAO.getAllRoom());
                    request.setAttribute("customers", CustomerDAO.getAllCustomer());
                    request.setAttribute("employees", EmployeeDAO.getAllEmployee());
                    break;
                default:
                    forward = LIST;
                    request.setAttribute("rooms", RoomDAO.getAllRoom());
                    request.setAttribute("customers", CustomerDAO.getAllCustomer());
                    request.setAttribute("employees", EmployeeDAO.getAllEmployee());
                    break;
            }
        } else {
            forward = LIST;
            request.setAttribute("rooms", RoomDAO.getAllRoom());
            request.setAttribute("customers", CustomerDAO.getAllCustomer());
            request.setAttribute("employees", EmployeeDAO.getAllEmployee());
        }
        RequestDispatcher req = request.getRequestDispatcher(forward);
        req.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Room room = new Room();

        // Retrieve input from HTML and set the values to the Room object
       
        room.setRoom_size(Integer.parseInt(request.getParameter("room_size")));
        room.setRoom_details(request.getParameter("room_details"));
        room.setRoom_price(Double.parseDouble(request.getParameter("room_price")));
        room.setRoom_type(request.getParameter("room_type"));
        room.setRoom_status(request.getParameter("room_status"));
        String roomid = request.getParameter("roomid");

        if (roomid != null && !roomid.isEmpty()) {
            room.setRoomid(Integer.parseInt(roomid));
            RoomDAO.updateRoom(room); // Call updateRoom() from RoomDAO class
        } else {
            RoomDAO.addRoom(room); // Call addRoom() from RoomDAO class
        }

        // Set attribute to a servlet request. Set the attribute name to rooms and call getAllRoom() from RoomDAO class
        request.setAttribute("rooms", RoomDAO.getAllRoom());

        // Obtain the RequestDispatcher from the request object. The pathname to the resource is listRoom.jsp
        RequestDispatcher req = request.getRequestDispatcher(LIST);

        // Dispatch the request to another resource using forward() methods of the RequestDispatcher
        req.forward(request, response);
        
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

		//Obtain the RequestDispatcher from the request object. The the pathname to the resource is listShawl.jsp
		req = request.getRequestDispatcher(LIST);

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response); 
		
		// TODO Auto-generated method stub
				Employee employee = new Employee();

				//retrieve input from HTML and set the values to the Shawl object
				employee.setEmployee_name(request.getParameter("employee_name"));
				employee.setEmployee_position(request.getParameter("employee_position"));
				employee.setEmployee_ic(request.getParameter("employee_ic"));
				employee.setEmployee_email(request.getParameter("employee_email"));
				employee.setEmployee_phone(request.getParameter("employee_phone"));
				employee.setEmployee_address(request.getParameter("employee_address"));
				employee.setEmployee_bankid(Integer.parseInt(request.getParameter("employee_bankid")));
				employee.setEmployee_username(request.getParameter("employee_username"));
				employee.setEmployee_password(request.getParameter("employee_password"));
				String employeeid = request.getParameter("employeeid");

				if(employeeid!=null) {
					employee.setEmployeeid(Integer.parseInt(employeeid));
					EmployeeDAO.updateEmployee(employee); 	//call updateShawl() from ShawlDAO class
				}
				else
					EmployeeDAO.addEmployee(employee);
				//call addShawl() from ShawlDAO class

				//set attribute to a servlet request. Set the attribute name to shawls and call getAllShawls() from ShawlDAO class
				request.setAttribute("employees", EmployeeDAO.getAllEmployee());

				//Obtain the RequestDispatcher from the request object. The the pathname to the resource is listShawl.jsp
				req = request.getRequestDispatcher(LIST);

				//Dispatch the request to another resource using forward() methods of the RequestDispatcher
				req.forward(request, response);
    }
    
}
