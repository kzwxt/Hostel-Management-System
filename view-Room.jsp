<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Room | Hostel</title>
    <link rel="stylesheet" href="css2/style-homepage.css" />
    <!-- Boxicons CDN Link -->
    <link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta charset="ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
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
              <a onclick="history.back()">Back</a>
            </div>
            <div class="title">Room</div>
            <div class="sales-details">
              <ul class="details">
                <li class="topic">Room ID</li>
                <li class="topic">Room Size</li>
                <li class="topic">Room Details</li>
                <li class="topic">Room Price</li>
                <li class="topic">Room Type</li>
                <li class="topic">Room Status</li>
              </ul>
              <ul class="details">
  				<li class="topic">:&emsp;<c:out value="${room.roomid}"/></li>
  				<li class="topic">:&emsp;<c:out value="${room.room_size}"/> </li>
  				<li class="topic">:&emsp;<c:out value="${room.room_details}"/></li>
  				<li class="topic">:&emsp;<c:out value="${room.room_price}"/> </li>
  				<li class="topic">:&emsp;<c:out value="${room.room_type}"/></li>
  				<li class="topic">:&emsp;<c:out value="${room.room_status}"/> </li>
			  </ul>
              <ul class="details">
                
              </ul>
              <ul class="details">
                
              </ul>
            </div>
            <br>
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
	</body>
</html>
<!-- Author: FES -->