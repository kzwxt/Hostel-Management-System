<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<!-- Website - www.codingnepalweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <title>Update Booking | Hostel</title>
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
        
        <div class="sales-boxes">
          <div class="recent-sales box">
            <div class="button" >
              <a href="BookingController?action=list">Back</a>
            </div>
            <form action="BookingController" method="post">
             <div class="title">Booking</div>
            	<div class="sales-details">
              <ul class="details">
                <li class="topic">Book ID</li>
                <li class="topic">Reservation Date</li>
                <li class="topic">Number of People</li>
                <li class="topic">Room Availablility</li>
                <li class="topic">Customer Id</li>
                <li class="topic">Room Id</li>
                <li class="topic">Employee ID</li>
              </ul>
              <ul class="details">
                <li class="topic">:&emsp;<input type="text" id="bookid" name="bookid" value="<c:out value="${booking.bookid}"/>" size="50" required readonly><br></li>
                <li class="topic">:&emsp;<input type="date" id="reservedate" name="reservedate" value="<c:out value="${booking.reservedate}"/>" size="50" required><br></li>
                <li class="topic">:&emsp;<input type="number" name="numberofpeople" value="<c:out value="${booking.numberofpeople}"/>" size="50" required></li>
                <li class="topic">:&emsp;<select name="roomavailability">
					<option value="<c:out value="${booking.roomavailability}"/>"><c:out value="${booking.roomavailability}"/></option>
					<option value="Available">Available</option>
					<option value="Unavailable">Unavailable</option>	
					</select></li>
				<li class="topic">:&emsp;<select name="customerid" class="tall-select">
					<option value="<c:out value="${booking.customerid}"/>"><c:out value="${customer.customer_name}"/></option>
                    <c:forEach items="${customers}" var="customer" varStatus="customers">      	
            			<option value="${customer.customerid}">${customer.customer_name}</option>
					</c:forEach>
                    </select></li>
				<li class="topic">:&emsp;<select name="roomid" class="tall-select">
				<option value="<c:out value="${room.roomid}"/>"><c:out value="${room.roomid}"/></option>
                    <c:forEach items="${rooms}" var="room" varStatus="rooms">
                    	<c:if test="${room.room_status == 'Available'}">
            				<option value="${room.roomid}">${room.roomid}</option>
       					</c:if>
					</c:forEach>
					</select></li>
				 <li class="topic">:&emsp;<select name="employeeid" class="tall-select">
				 <option value="<c:out value="${employee.employeeid}"/>"><c:out value="${employee.employee_name}"/></option>
                    <c:forEach items="${employees}" var="employee" varStatus="employees">
            				<option value="${employee.employeeid}">${employee.employee_name}</option>
					</c:forEach>
					</select></li>
              </ul>
              <ul class="details">
                
              </ul>
              <ul class="details">
                
              </ul>
            </div>
            <input type="submit" value="Submit" class="save-button">
			<input type="reset" value="Reset" class="save-button">
			</form>
            </div>
            <br>
       
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
  </body>
</html>
