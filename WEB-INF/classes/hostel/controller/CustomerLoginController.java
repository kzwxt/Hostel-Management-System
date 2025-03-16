package hostel.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import hostel.dao.BookingDAO;
import hostel.model.Booking;

import java.io.IOException;

public class CustomerLoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HttpSession session;
    private RequestDispatcher view;

    public CustomerLoginController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Booking booking = new Booking();
            int bookid = Integer.parseInt(request.getParameter("bookid"));
            int customerid = Integer.parseInt(request.getParameter("customerid"));

            booking.setBookid(bookid);
            booking.setCustomerid(customerid);

            booking = BookingDAO.login(booking);
            if (booking.isValid()) {
                session = request.getSession(true);
                session.setAttribute("sessionbookid", booking.getBookid());
                session.setAttribute("sessioncustomerid", booking.getCustomerid());

                request.setAttribute("bookid", bookid);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerViewBookingController");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("loginFailed", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("customerlogin.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
            request.setAttribute("loginFailed", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customerlogin.jsp");
            dispatcher.forward(request, response);
            
        }
    }
}
