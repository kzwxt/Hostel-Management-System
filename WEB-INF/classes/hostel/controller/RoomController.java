package hostel.controller;

import jakarta.servlet.RequestDispatcher;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import hostel.dao.RoomDAO;
import hostel.model.Room;


/**
 * Servlet implementation class RoomController
 */
public class RoomController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String action = "", forward = "";
    private static final String VIEW = "view-Room.jsp";
    private static final String ADD = "page-AddRoom-information.html";
    private static final String UPDATE = "update-Room.jsp";
    private static final String LIST = "list-Room.jsp";
    private int roomid;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomController() {
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
                    roomid = Integer.parseInt(request.getParameter("roomid"));
                    request.setAttribute("room", RoomDAO.getRoom(roomid));
                    break;
                case "update":
                    forward = UPDATE;
                    roomid = Integer.parseInt(request.getParameter("roomid"));
                    request.setAttribute("room", RoomDAO.getRoom(roomid));
                    break;
                case "delete":
                    forward = LIST;
                    roomid = Integer.parseInt(request.getParameter("roomid"));
                    RoomDAO.deleteRooom(roomid);
                    request.setAttribute("rooms", RoomDAO.getAllRoom());
                    break;
                case "list":
                    forward = LIST;
                    request.setAttribute("rooms", RoomDAO.getAllRoom());
                    break;
                default:
                    forward = LIST;
                    request.setAttribute("rooms", RoomDAO.getAllRoom());
                    break;
            }
        } else {
            forward = LIST;
            request.setAttribute("rooms", RoomDAO.getAllRoom());
        }
        
      
        Room dashboardData = RoomDAO.getDashboardData();
        request.setAttribute("dashboardData", dashboardData);
        
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

     // Fetch the dashboard data and set it as a request attribute
        Room dashboardData = RoomDAO.getDashboardData();
        request.setAttribute("dashboardData", dashboardData);
        
        // Obtain the RequestDispatcher from the request object. The pathname to the resource is listRoom.jsp
        RequestDispatcher req = request.getRequestDispatcher(LIST);

        // Dispatch the request to another resource using forward() methods of the RequestDispatcher
        req.forward(request, response);
    }
}
