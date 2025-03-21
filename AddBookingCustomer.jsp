<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Add Booking | Hostel</title>
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
                    <a href="index.html" class="navbar-brand w-100 h-100 m-0 p-0 d-flex align-items-center justify-content-center">
                        <h1 class="m-0 text-primary text-uppercase">Hotelier</h1>
                    </a>
                </div>
                <div class="col-lg-9">
                    <div class="row gx-0 bg-white d-none d-lg-flex">
                        <div class="col-lg-7 px-5 text-start">
                            <div class="h-100 d-inline-flex align-items-center py-2 me-4">
                                <i class="fa fa-envelope text-primary me-2"></i>
                                <p class="mb-0">info@example.com</p>
                            </div>
                            <div class="h-100 d-inline-flex align-items-center py-2">
                                <i class="fa fa-phone-alt text-primary me-2"></i>
                                <p class="mb-0">+012 345 6789</p>
                            </div>
                        </div>
                        <div class="col-lg-5 px-5 text-end">
                            <div class="d-inline-flex align-items-center py-2">
                                <a class="me-3" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="me-3" href=""><i class="fab fa-twitter"></i></a>
                                <a class="me-3" href=""><i class="fab fa-linkedin-in"></i></a>
                                <a class="me-3" href=""><i class="fab fa-instagram"></i></a>
                                <a class="" href=""><i class="fab fa-youtube"></i></a>
                            </div>
                        </div>
                    </div>
                    <nav class="navbar navbar-expand-lg bg-dark navbar-dark p-3 p-lg-0">
                        <a href="index.html" class="navbar-brand d-block d-lg-none">
                            <h1 class="m-0 text-primary text-uppercase">Hotelier</h1>
                        </a>
                        <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto py-0">
                                <a href="index.html" class="nav-item nav-link">Home</a>
                                <a href="about.html" class="nav-item nav-link">About</a>
                                <a href="service.html" class="nav-item nav-link">Services</a>
                                <a href="room.html" class="nav-item nav-link active">Rooms</a>
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                                    <div class="dropdown-menu rounded-0 m-0">
                                        <a href="booking.html" class="dropdown-item">Booking</a>
                                        <a href="team.html" class="dropdown-item">Our Team</a>
                                        <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                    </div>
                                </div>
                                <a href="contact.html" class="nav-item nav-link">Contact</a>
                            </div>
                            <a href="https://htmlcodex.com/hotel-html-template-pro" class="btn btn-primary rounded-0 py-4 px-md-5 d-none d-lg-block">Premium Version<i class="fa fa-arrow-right ms-3"></i></a>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Header End -->

  <!-- Booking Start -->
  <div class="container-xxl py-5">
      <div class="container">
          <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
              <h6 class="section-title text-center text-primary text-uppercase">Room Booking</h6>
              <h1 class="mb-5">Enter <span class="text-primary text-uppercase">Your Booking Details</span></h1>
          </div>
          <div class="row g-5">
              <div class="col-lg-6">
                  <div class="row g-3">
                      <div class="col-6 text-end">
                          <img class="img-fluid rounded w-75 wow zoomIn" data-wow-delay="0.1s" src="images2/about-1.jpg" style="margin-top: 25%;">
                      </div>
                      <div class="col-6 text-start">
                          <img class="img-fluid rounded w-100 wow zoomIn" data-wow-delay="0.3s" src="images2/about-2.jpg">
                      </div>
                      <div class="col-6 text-end">
                          <img class="img-fluid rounded w-50 wow zoomIn" data-wow-delay="0.5s" src="images2/about-3.jpg">
                      </div>
                      <div class="col-6 text-start">
                          <img class="img-fluid rounded w-75 wow zoomIn" data-wow-delay="0.7s" src="images2/about-4.jpg">
                      </div>
                  </div>
              </div>
              <div class="col-lg-6">
                  <div class="wow fadeInUp" data-wow-delay="0.2s">
                      <form id="bookingForm"action="AddBookingCustomerController" method="post">
                          <div class="row g-3">
                              <div class="col-12">
                                  <div class="form-floating">
                                      <input type="text" class="form-control" id="customerid" name="customerid" value="${customerId}" readonly>
    								  <label for="ReserveDate">Customer ID </label>
                                  </div>
                              </div>                                
                              <div class="col-12">
                                  <div class="form-floating">
                                      <input type="number" class="form-control" id="numberofpeople" name="numberofpeople" required>
                                      <label for="NumOfPeople">Number of People</label>
                                  </div>
                              </div>
                              <div class="col-12">
                              	<div class="form-floating">
    								<input type="date" class="form-control" id="reservedate" name="reservedate" required>
    								<label for="reservedate">Reserve Date</label>
								</div>
                              </div>
                              <div class="col-12">
                                  <div class="form-floating">
                                      <input type="text" class="form-control" id="roomid" name="room_details" value="${room_details}" readonly>
                                      <label for="RoomId">Room Details</label>
                                  </div>
                              </div>
                              
                              
                              
                              <div class="col-12">
                                  <div class="form-floating">
                                      <input type="hidden" class="form-control" id="roomid" name="roomid" value="${roomid}">
                                  </div>
                              </div>
                              <div class="col-12">
                                  <div class="form-floating">
                                      <input type="hidden" class="form-control" id="roomavailability" name="roomavailability" value="${room_status}" >
                                  </div>
                              </div>                                    
                           	  <input type="hidden" id="employeeid" name="employeeid" value="4">                                   
                              <div class="col-12">
                                  <button class="btn btn-primary w-100 py-3" type="submit"onclick="confirmBooking(event)">Book Now</button>

                              </div>
                          </div>
                      </form>
                  </div>
              </div>
          </div>
      </div>
  </div>
  <!-- Booking End -->
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
    <script>
        function confirmBooking(event) {
            event.preventDefault(); // Prevent the form from submitting immediately

            // Display the confirmation dialog
            var confirmBooking = confirm("Are you sure you want to book this room?");

            // If the user confirms, submit the form
            if (confirmBooking) {
                document.getElementById("bookingForm").submit();
            }
        }
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