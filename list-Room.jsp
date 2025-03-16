<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room List | Hostel</title>
<meta charset="UTF-8" />
<link rel="stylesheet" href="css2/style-homepage.css" />
    <!-- Boxicons CDN Link -->
<link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
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
              <div class="box-topic">Total Room</div>
              <div class="number">${dashboardData.totalRooms}</div>
              <div class="indicator">
                <i class="bx bx-up-arrow-alt"></i>
                <span class="text">Up from yesterday</span>
              </div>
            </div>
            <i class="bx bx-cart-alt cart"></i>
          </div>
          <div class="box">
            <div class="right-side">
              <div class="box-topic">Available Room</div>
              <div class="number">${dashboardData.availableRooms}</div>
              <div class="indicator">
                <i class="bx bx-up-arrow-alt"></i>
                <span class="text">Up from yesterday</span>
              </div>
            </div>
            <i class="bx bxs-cart-add cart two"></i>
          </div>
          <div class="box">
            <div class="right-side">
              <div class="box-topic">Unavailable Room</div>
              <div class="number">${dashboardData.unavailableRooms}</div>
              <div class="indicator">
                <i class="bx bx-up-arrow-alt"></i>
                <span class="text">Up from yesterday</span>
              </div>
            </div>
            <i class="bx bx-cart cart three"></i>
          </div>
          <div class="box">
            <div class="right-side">
              <div class="box-topic">Booked Room</div>
              <div class="number">${dashboardData.bookedRooms}</div>
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
            <div class="title">LIST OF ROOM</div>
            
<div class="container">
  <div class="table">
    <div class="table-header">
      <div class="header__item">Room ID</div>
      <div class="header__item">Room Size</div>
      <div class="header__item">Room Details</div>
      <div class="header__item">Room Price</div>
      <div class="header__item">Room Type</div>
      <div class="header__item">Room Status</div>
      <div class="header__item">View</div>
      <div class="header__item">Update</div>
      <div class="header__item">Delete</div>
    </div>
    <c:forEach items="${rooms}" var="room" varStatus="rooms">
      <div class="table-row">
        <div class="table-data"><c:out value="${room.roomid}"/></div>
        <div class="table-data"><c:out value="${room.room_size}"/></div>
        <div class="table-data"><c:out value="${room.room_details}"/></div>
        <div class="table-data"><c:out value="${room.room_price}"/></div>
        <div class="table-data"><c:out value="${room.room_type}"/></div>
        <div class="table-data"><c:out value="${room.room_status}"/></div>
        <div class="table-data"><a class="button" href="RoomController?action=view&roomid=<c:out value='${room.roomid}'/>">View</a></div>
        <div class="table-data"><a class="button" href="RoomController?action=update&roomid=<c:out value='${room.roomid}'/>">Update</a></div>
        <div class="table-data"><button class="button" id="<c:out value="${room.roomid}"/>" onclick="confirmationRoom(this.id)">Delete</button></div>
      </div>
    </c:forEach>
  </div>
</div>
        <div class="button" >
          <br><a href="page-AddRoom-information.html">Add Room</a>
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
      function confirmationRoom(roomid) {					  		 
        console.log(roomid);
        var r = confirm("Are you sure you want to delete this room?");
        if (r == true) {				 		  
          location.href = 'RoomController?action=delete&roomid=' + roomid;
          alert("Room successfully deleted");			
        } else {				  
          return false;	
        }
      }
    </script>
</body>
</html>
<!-- Author: FES -->