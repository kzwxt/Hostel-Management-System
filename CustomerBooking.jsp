<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Hostel - Customer Booking</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">  

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css4/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css4/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <!-- Header Start -->
        <div class="container-fluid bg-dark px-0">
            <div class="row gx-0">
                <div class="col-lg-3 bg-dark d-none d-lg-block">
                    <a href="customerhomepage.html" class="navbar-brand w-100 h-100 m-0 p-0 d-flex align-items-center justify-content-center">
                        <h1 class="m-0 text-primary text-uppercase">Hostel</h1>
                    </a>
                </div>
                <div class="col-lg-9">
                    <div class="row gx-0 bg-white d-none d-lg-flex">
                        <div class="col-lg-7 px-5 text-start">
                            <div class="h-100 d-inline-flex align-items-center py-2 me-4">
                                <i class="fa fa-envelope text-primary me-2"></i>
                                <p class="mb-0">HOSTEL@gmail.com</p>
                            </div>
                            <div class="h-100 d-inline-flex align-items-center py-2">
                                <i class="fa fa-phone-alt text-primary me-2"></i>
                                <p class="mb-0">+601623456789</p>
                            </div>
                        </div>
                        <div class="col-lg-5 px-5 text-end">
                            <div class="d-inline-flex align-items-center py-2">
                                <a class="me-3" href="https://www.facebook.com/"><i class="fab fa-facebook-f"></i></a>
						        <a class="me-3" href="https://twitter.com/"><i class="fab fa-twitter"></i></a>
						        <a class="me-3" href="https://www.linkedin.com/"><i class="fab fa-linkedin-in"></i></a>
						        <a class="me-3" href="https://www.instagram.com/"><i class="fab fa-instagram"></i></a>
						        <a class="me-3" href="https://www.youtube.com/"><i class="fab fa-youtube"></i></a>
                            </div>
                        </div>
                    </div>
                    <nav class="navbar navbar-expand-lg bg-dark navbar-dark p-3 p-lg-0">
                        <a href="index.html" class="navbar-brand d-block d-lg-none">
                            <label class="m-0 text-primary text-uppercase">Hostel </label>
                        </a>
                        <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto py-0">
                                
                            </div>
                            <a href="customerhomepage.html" class="btn btn-primary rounded-0 py-4 px-md-5 d-none d-lg-block">Visit Our Website<i class="fa fa-arrow-right ms-3"></i></a>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Header End -->


        <!-- Page Header Start -->
        <div class="container-fluid page-header mb-5 p-0" style="background-image: url(img/carousel-1.jpg);">
            <div class="container-fluid page-header-inner py-5">
                <div class="container text-center pb-5">
                    <h1 class="display-3 text-white mb-3 animated slideInDown">Rooms</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center text-uppercase">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">Rooms</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Page Header End -->


        <!-- Booking Start -->
        <div class="container-fluid booking pb-5 wow fadeIn" data-wow-delay="0.1s">
            <div class="container">
                <div class="bg-white shadow" style="padding: 35px;">
                    <div class="row g-2">
						<h5 class="mb-0">Your Customer ID: ${customerId}</h5>
                    </div>
                </div>
            </div>
        </div>
        <!-- Booking End -->


  	 <!-- Room Start -->
          <div class="container-xxl py-5">
              <div class="container">
                  <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                      <h6 class="section-title text-center text-primary text-uppercase">Our Rooms</h6>
                      <h1 class="mb-5">Explore Our <span class="text-primary text-uppercase">Rooms</span></h1>
                  </div>

                  <div class="row g-4">
              		<c:forEach items="${rooms}" var="room" varStatus="rooms">   

                      <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                          <div class="room-item shadow rounded overflow-hidden">
                              <div class="position-relative">
                                <img class="img-fluid" src="img/room-1.jpg" alt="">
                                  <small class="position-absolute start-0 top-100 translate-middle-y bg-primary text-white rounded py-1 px-3 ms-4">Room Type: <c:out value="${room.room_type}"/></small>
                              </div>
                              <div class="p-4 mt-2">
                                  <div class="d-flex justify-content-between mb-3">
                                      <h5 class="mb-0">Room Price: RM<c:out value="${room.room_price}"/>/Night</h5>
                                  </div>
                                  <div class="d-flex mb-3">
                                      <small class="border-end me-3 pe-3"></small>
                                      <small class="border-end me-3 pe-3"></small>
                                  </div>
                                  <p class="text-body mb-3">Room Size: <c:out value="${room.room_size}"/></p>
                                  <p class="text-body mb-3">Room Details: <c:out value="${room.room_details}"/></p>
                                  <p class="text-body mb-3">Room Availability: <c:out value="${room.room_status}"/></p>
                                  <c:if test="${room.room_status != 'Unavailable' && room.room_status != 'Booked'}">
                                      <div class="d-flex justify-content-between">
                                          <a class="btn btn-sm btn-dark rounded py-2 px-4" href="AddBookingCustomerController?roomid=${room.roomid}&customerId=${customerId}&room_status=${room.room_status}">Book Now</a>
 									  </div></c:if>
                              </div>
                          </div>
                        </div>
                        </c:forEach> 
                  	</div>
                    
              </div>
          </div>
          <!-- Room End -->
                 
        
            <div class="container">
                <div class="copyright">
                    <div class="row">
                        
                        <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                            &copy; <a class="border-bottom" href="customerhomepage.html">Hostel Enterprise Sdn. Bhd</a>, All Right Reserved. 
							<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
							Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>