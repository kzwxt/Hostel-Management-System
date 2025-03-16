<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Update User | Hostel</title>
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
              <a href="CustomerController?action=list">Back</a>
            </div>
            <form action="CustomerController" method="post">
            <div class="title">Customer</div>
            <div class="sales-details">
              <ul class="details">
                <li class="topic">Customer Id</li>
                <li class="topic">Customer Name</li>
                <li class="topic">Customer Phone No</li>
                <li class="topic">Customer Ic</li>
                <li class="topic">Customer Email</li>
                <li class="topic">Customer Address</li>
              </ul>
              <ul class="details">
                <li class="topic">:&emsp;<input type="text" name="customerid" value="<c:out value="${customer.customerid}"/>" size="50" readonly required><br></li>
                <li class="topic">:&emsp;<input type="text" name="customer_name" value="<c:out value="${customer.customer_name}"/>" size="50" required><br></li>
                <li class="topic">:&emsp;<input type="text" name="customer_phone" value="<c:out value="${customer.customer_phone}"/>" size="50" required></li>
                <li class="topic">:&emsp;<input type="text" name="customer_ic" value="<c:out value="${customer.customer_ic}"/>" size="50" required></li>
                <li class="topic">:&emsp;<input type="text" name="customer_email" value="<c:out value="${customer.customer_email}"/>" size="50" required></li>
                <li class="topic">:&emsp;<input type="text" name="customer_address" value="<c:out value="${customer.customer_address}"/>" size="50" required></li>
              </ul>
              <ul class="details">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
              
              </ul>
              <ul class="details">
                
              </ul>
              <ul class="details">
                
              </ul>
              
            </div>
            <input type="submit" value="Submit"class="save-button">
			<input type="reset" value="Reset"class="save-button">

		
		</form>
</body>
</html>
<!-- Author: FES -->