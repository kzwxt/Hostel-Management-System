<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard | Hostel</title>
<link rel="stylesheet" href="css2/style-homepage.css" />
<link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style>
    .charts-container {
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap; /* Allows wrapping of charts to new rows */
    }

    .chart-item {
        flex: 1;
        padding: 10px;
        min-width: 250px; /* Adjust as needed */
    }

    .chart-item canvas {
        width: 100%;
        height: 200px; /* Adjust the height as needed */
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
    <!-- Sidebar ended -->
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
              <div class="box-topic">Total Customer</div>
              <div class="number">${dashboardData.totalCustomers}</div>
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
	            <div class="bar-charts box">
	                <div class="title">Total Number Of Booking Per Month</div>
	                <div class="sales-details">
		                	<div class="chart-item">
		                    	<canvas id="roomChart4"></canvas>
		                	</div>
	                </div><br><br>
	                <div class="title">Informational Room Status</div>
	                <div class="sales-details">
		                	<div class="chart-item">
		                    	<canvas id="roomChart1"></canvas>
		                	</div>
	                </div>
	           </div>
           </div>           
           <div class="top-sales box">
	            <div class="bar-charts box">
	                <div class="title">Total Quarterly Profit</div>
	                <div class="sales-details">
		                	<div class="chart-item">
		                    	<canvas id="roomChart2"></canvas>
		                	</div>
	                </div><br><br>
	                <div class="title">Summary From Each Entities</div>
	                <div class="sales-details">
		                	<div class="chart-item">
		                    	<canvas id="roomChart3"></canvas>
		                	</div>
	                </div>
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
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
      // Sample data for the charts (replace with dynamic data)
      const totalRooms = ${dashboardData.totalRooms};
      const availableRooms = ${dashboardData.availableRooms};
      const unavailableRooms = ${dashboardData.unavailableRooms};
      const bookedRooms = ${dashboardData.bookedRooms};
      const totalCustomers = ${dashboardData.totalCustomers};
      const totalEmployee = ${dashboardData.totalEmployee};
      const totalBooking= ${dashboardData.totalBooking};
      
      const profitq1 = ${dashboardData.profitq1};
      const profitq2 = ${dashboardData.profitq2};
      const profitq3 = ${dashboardData.profitq3};
      const profitq4 = ${dashboardData.profitq4};
      
      const januaryCount = ${dashboardData.januaryCount};
      const februaryCount = ${dashboardData.februaryCount};
      const marchCount = ${dashboardData.marchCount};
      const aprilCount = ${dashboardData.aprilCount};
      const mayCount = ${dashboardData.mayCount};
      const juneCount = ${dashboardData.juneCount};
      const julyCount = ${dashboardData.julyCount};
      const augustCount = ${dashboardData.augustCount};
      const septemberCount = ${dashboardData.septemberCount};
      const octoberCount = ${dashboardData.octoberCount};
      const novemberCount = ${dashboardData.novemberCount};
      const decemberCount = ${dashboardData.decemberCount};

      // Data for the first bar chart
      const ctx1 = document.getElementById('roomChart1').getContext('2d');
      const roomChart1 = new Chart(ctx1, {
          type: 'bar',
          data: {
              labels: ['Total Rooms', 'Available Rooms', 'Unavailable Rooms', 'Booked Rooms'],
              datasets: [{
                  label: 'Number of Rooms',
                  data: [totalRooms, availableRooms, unavailableRooms, bookedRooms],
                  backgroundColor: [
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(255, 99, 132, 0.2)'
                  ],
                  borderColor: [
                      'rgba(75, 192, 192, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(255, 99, 132, 1)'
                  ],
                  borderWidth: 1
              }]
          },
          options: {
              responsive: true,
              scales: {
                  y: {
                      beginAtZero: true
                  }
              }
          }
      });

      // Data for the second pie chart
      const ctx2 = document.getElementById('roomChart2').getContext('2d');
      const roomChart2 = new Chart(ctx2, {
    	  type: 'radar',
          data: {
              labels: ['Quarter 1', 'Quarter 2', 'Quarter 3', 'Quarter 4'],
              datasets: [{
                  label: 'Quarterly Profit',
                  data: [profitq1, profitq2, profitq3, profitq4],
                  backgroundColor: [
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(255, 99, 132, 0.2)'
                  ],
                  borderColor: [
                      'rgba(75, 192, 192, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(255, 99, 132, 1)'
                  ],
                  borderWidth: 1
              }]
          },
          options: {
              responsive: true,
              scales: {
                  y: {
                      beginAtZero: true
                  }
              }
          }
      });

      // Data for the third bar chart
      const ctx3 = document.getElementById('roomChart3').getContext('2d');
      const roomChart3 = new Chart(ctx3, {
          type: 'bar',
          data: {
              labels: ['Total Rooms', 'Total Customer', 'Total Booking', 'Total Employee'],
              datasets: [{
                  label: 'Number of Rooms',
                  data: [totalRooms, totalCustomers, totalBooking, totalEmployee],
                  backgroundColor: [
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(75, 192, 192, 0.2)'
                  ],
                  borderColor: [
                      'rgba(255, 206, 86, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 99, 132, 1)',
                      'rgba(75, 192, 192, 1)'
                  ],
                  borderWidth: 1
              }]
          },
          options: {
              responsive: true,
              scales: {
                  y: {
                      beginAtZero: true
                  }
              }
          }
      });

      // Data for the fourth bar chart
      const ctx4 = document.getElementById('roomChart4').getContext('2d');
      const roomChart4 = new Chart(ctx4, {
          type: 'line', // Example type, adjust as needed
          data: {
              labels: [
            	  'January', 'February', 'March', 'April', 'May', 'June','July', 'August', 'September', 'October', 'November', 'December'], // Example labels
              datasets: [{
                  label: 'Room Usage Over Time',
                  data: [januaryCount, februaryCount, marchCount, aprilCount, mayCount, juneCount,julyCount, augustCount, septemberCount, octoberCount, novemberCount, decemberCount], // Example data
                  backgroundColor: 'rgba(75, 192, 192, 0.2)',
                  borderColor: 'rgba(75, 192, 192, 1)',
                  borderWidth: 1
              }]
          },
          options: {
              responsive: true,
              scales: {
                  y: {
                      beginAtZero: true
                  }
              }
          }
      });
    </script>
</body>
</html>
