<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Booking | Hostel</title>
<meta charset="UTF-8" />
<link rel="stylesheet" href="css2/style-homepage.css" />
    <!-- Boxicons CDN Link -->
<link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style>
  .tall-select {
    height: 50px; /* Adjust the height as needed */
  }
</style>
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

      <div class="home-section">        
        <div class="home-content">
          <div class="sales-boxes">
            <div class="booking-form">
               	
             		 <a href="BookingController?action=list"class="back-button">Back</a>
                <h2>ADD BOOKING FORM</h2>
                  <form action="BookingController" method="post">
                    <label for="reservedate">RESERVE DATE:</label>
					<input type="date" id="reservedate" name="reservedate" size="50" required><br><br>

                    <label for="numberofpeople">NUMBER OF PEOPLE: </label>
                    <input type="number" name="numberofpeople" size="50"required min=1><br><br>

                    <label for="roomavailability">ROOM AVAILABILITY:</label>
                    <select name="roomavailability" class="tall-select" required>
						<option value="Available">Available</option>
						<option value="Unavailable">Unavailable</option>
					</select><br><br>
					
                    <label for="customerid">CUSTOMER ID </label>
                    <select name="customerid" class="tall-select">
                    <c:forEach items="${customers}" var="customer" varStatus="customers">      	
            			<option value="${customer.customerid}">${customer.customer_name}</option>
					</c:forEach>
                    </select><br><br>
                    
                    <label for="roomid">ROOM ID </label>
                    <select name="roomid" class="tall-select">
                    <c:forEach items="${rooms}" var="room" varStatus="rooms">
                    	<c:if test="${room.room_status == 'Available'}">
            				<option value="${room.roomid}">${room.roomid}</option>
       					</c:if>
					</c:forEach>
					</select><br><br>
                    
                    <label for="employeeid">EMPLOYEE ID </label>
                    <select name="employeeid" class="tall-select">
                    <c:forEach items="${employees}" var="employee" varStatus="employees">
            				<option value="${employee.employeeid}">${employee.employee_name}</option>
					</c:forEach>
					</select><br><br>
                    
                    <input type="submit" value="Submit" class="save-button">
					<input type="reset" value="Reset" class="save-button">
                  </form>
  </div>
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
    document.addEventListener('DOMContentLoaded', function() {
        // Get today's date in YYYY-MM-DD format
        var today = new Date();
        // Adjust for timezone offset
        today.setMinutes(today.getMinutes() - today.getTimezoneOffset());
        var todayStr = today.toISOString().split('T')[0];
        // Set the min attribute to today's date
        document.getElementById('reservedate').setAttribute('min', todayStr);
    });
</script>
</body>
</html>
<!-- Author: FES -->
