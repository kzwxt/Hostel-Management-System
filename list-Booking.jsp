<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<!-- Website - www.codingnepalweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <title>Booking List | Hostel</title>
    <link rel="stylesheet" href="css2/style-homepage.css" />
    <!-- Boxicons CDN Link -->
    <link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  </head>
  <body>
    <!-- Sidebar  -->
    <div class="sidebar">
      <div class="logo-details">
        <i class="bx bxl-c-plus-plus"></i>
        <span class="logo_name">Welcome!</span>
      </div>
      <ul class="nav-links">
        <li>
          <a href="MainDashboardController" class="active">
            <i class="bx bx-grid-alt"></i>
            <span class="links_name">Dashboard</span>
          </a>
        </li>
        <li>
          <a href="RoomController?action=list">
            <i class="bx bx-box"></i>
            <span class="links_name">View/Delete Room</span>
          </a>
        </li>
        <li>
          <a href="BookingController?action=list">
            <i class="bx bx-list-ul"></i>
            <span class="links_name">View/Delete Booking</span>
          </a>
        </li>
        <li>
          <a href="CustomerController?action=list">
            <i class="bx bx-user"></i>
            <span class="links_name">View/Delete User</span>
          </a>
        </li>
        <li class="log_out">
          <a href="user-login.jsp">
            <i class="bx bx-log-out"></i>
            <span class="links_name">Log out</span>
          </a>
        </li>
      </ul>
    </div>
    <!-- Side bar ended -->
    <section class="home-section">
      <nav>
        <div class="sidebar-button">
          <i class="bx bx-menu sidebarBtn"></i>
          <span class="dashboard">Dashboard</span>
        </div>
        <div class="search-box">
          <input type="text" placeholder="Search..." />
          <i class="bx bx-search"></i>
        </div>
        <div class="profile-details">
          <img src="images/admin-dashboard-logo.png" alt="" />
          <span class="admin_name">Admin</span>
          <i class="bx bx-chevron-down"></i>
        </div>
      </nav>

      <div class="home-content">
        <div class="overview-boxes">
          <div class="box">
            <div class="right-side">
              <div class="box-topic">Total Booking</div>
              <div class="number">${dashboardData.totalBooking}</div>
              <div class="indicator">
                <i class="bx bx-up-arrow-alt"></i>
                <span class="text">Up from yesterday</span>
              </div>
            </div>
            <i class="bx bx-cart-alt cart"></i>
          </div>
          <div class="box">
            <div class="right-side">
              <div class="box-topic">Total Sale</div>
              <div class="number">RM ${dashboardData.totalProfit}</div>
              <div class="indicator">
                <i class="bx bx-up-arrow-alt"></i>
                <span class="text">Up from yesterday</span>
              </div>
            </div>
            <i class="bx bxs-cart-add cart two"></i>
          </div>
          <div class="box">
            <div class="right-side">
              <div class="box-topic">Most Booked Room</div>
              <div class="number">${dashboardData.mostbooked}</div>
              <div class="indicator">
                <i class="bx bx-up-arrow-alt"></i>
                <span class="text">Up from yesterday</span>
              </div>
            </div>
            <i class="bx bx-cart cart three"></i>
          </div>
          <div class="box">
            <div class="right-side">
              <div class="box-topic">Most Reserved date</div>
              <div class="number">${dashboardData.mostReserved}</div>
              <div class="indicator">
                <i class="bx bx-down-arrow-alt down"></i>
                <span class="text">Down From Today</span>
              </div>
            </div>
            <i class="bx bxs-cart-download cart four"></i>
          </div>
        </div>

        <div class="sales-boxes">
          <div class="recent-sales box">
            <div class="title">LIST OF BOOKING</div>
            
<div class="container">
  <div class="table">
    <div class="table-header">
      <div class="header__item">BOOK ID</div>
      <div class="header__item">RESERVE DATE</div>
      <div class="header__item">NUMBER OF PEOPLE</div>
      <div class="header__item">ROOM AVAILABILITY</div>
      <div class="header__item">CUSTOMER ID</div>
      <div class="header__item">ROOM ID</div>
      <div class="header__item">EMPLOYEE ID</div>
      <div class="header__item">VIEW</div>
      <div class="header__item">UPDATE</div>
      <div class="header__item">DELETE</div>
    </div>
    <c:forEach items="${bookings}" var="booking" varStatus="bookings">
      <div class="table-row">
        <div class="table-data"><c:out value="${booking.bookid}"/></div>
        <div class="table-data"><c:out value="${booking.reservedate}"/></div>
        <div class="table-data"><c:out value="${booking.numberofpeople}"/></div>
        <div class="table-data"><c:out value="${booking.roomavailability}"/></div>
		<div class="table-data"><a href="CustomerController?action=view&customerid=<c:out value='${booking.customerid}'/>">${booking.customerid}</a></div>
    	<div class="table-data"><a href="RoomController?action=view&roomid=<c:out value='${booking.roomid}'/>">${booking.roomid}</a></div> 
		<div class="table-data"><a href="AdminAddBooking?action=view&employeeid=<c:out value='${booking.employeeid}'/>">${booking.employeeid}</a></div>     
        <div class="table-data"><a class="button" href="BookingController?action=view&bookid=<c:out value='${booking.bookid}'/>">View</a></div>
        <div class="table-data"><a class="button" href="AdminAddBooking?action=update&bookid=<c:out value='${booking.bookid}'/>&customerid=<c:out value='${booking.customerid}'/>&employeeid=<c:out value='${booking.employeeid}'/>&roomid=<c:out value='${booking.roomid}'/>">Update</a></div>
        <div class="table-data"><button class="button" id="<c:out value="${booking.bookid}"/>"onclick="confirmationbooking(this.id)">Delete</button></div>
      </div>
    </c:forEach>
  </div>
</div>
        <div class="button" >
          <br><a href="AdminAddBooking?action=update">Add Booking</a>
        </div>	 
     </div>
    </div>
    </section>

    <script>
      let sidebar = document.querySelector(".sidebar");
      let sidebarBtn = document.querySelector(".sidebarBtn");
      sidebarBtn.onclick = function () {
        sidebar.classList.toggle("active");
        if (sidebar.classList.contains("active")) {
          sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
        } else sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
      };
    </script>
    <script>
      function confirmationbooking(bookid) {					  		 
        console.log(bookid);
        var r = confirm("Are you sure you want to delete this booking?");
        if (r == true) {				 		  
          location.href = 'BookingController?action=delete&bookingid=' + bookid;
          alert("Booking successfully deleted");			
        } else {				  
          return false;	
        }
      }
    </script>
  </body>
</html>
