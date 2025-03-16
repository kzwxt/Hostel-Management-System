<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>      

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="author" content="INSPIRO" />
    <meta name="description" content="Themeforest Template Polo">
    <!-- Document title -->
    <title>Registering Staff | Hostel</title>
    <!-- Stylesheets & Fonts -->
    <link href="css2/plugins.css" rel="stylesheet">
    <link href="css2/style.css" rel="stylesheet">
    <link href="css2/responsive.css" rel="stylesheet"> 
</head>
<body>
	<!-- Body Inner -->    
	<div class="body-inner">

        <!-- Section -->
        <section class="fullscreen" style="background-color:hsl(225, 100%, 94%) ;">
            <div class="container container-fullscreen">
                <div class="text-middle">
                    <div class="text-center m-b-30">
                        <a href="customerhomepage.html" class="logo">
                            <img src="images/companyLogo.jpg" alt="Polo Logo" width="210" height="210">
                        </a>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 center p-40 background-white b-r-6">
                            <form action = "EmployeeRegisterController" method="post" class="form-transparent-grey">
                                <div class="row">
                                    <div class="col-lg-12">
                                     <% 
            String errorMessage = (String) request.getAttribute("error");
            if (errorMessage != null) {
                out.println("<div class='alert alert-danger'>" + errorMessage + "</div>");
            }
        %>
                                        <h3>Register New Account</h3>
                                        <p> Create an account by entering the information below. If you already registered, please click
                                        <a href="user-login.jsp"><u>here</u></a></p>
                                    </div>

                                    <div class="col-lg-6 form-group">
                                        <label class="sr-only" for="name">Full Name</label>
									<input type="text" name="name" id="name" placeholder="Full Name" class="form-control" required pattern="[A-Za-z\s]+" title="Please enter only alphabetic characters">
									</div>
                                    <div class="col-lg-6 form-group">
                                        <label class="sr-only">Position</label>
                                        <input type="text" name="position" placeholder="Position" class="form-control" required>
                                    </div>
                                    <div class="col-lg-6 form-group">
                                        <label class="sr-only">IC Number</label>
                                        <input type="text" name="identitynum" placeholder="IC Number" class="form-control" required pattern="\d{12}" maxlength="12" inputmode="numeric" title="Please enter a 12-digit identification card number">
                                    </div>                               
                                    <div class="col-lg-6 form-group">
                                        <label class="sr-only">Email</label>
                                        <input type="email" name="email" placeholder="Email" class="form-control"required>
                                    </div>
                                    <div class="col-lg-6 form-group">
                                        <label class="sr-only">Phone Num</label>
                                        <input type="text" name="phoneNum" placeholder="Phone Number" class="form-control"required>
                                    </div>
                                    <div class="col-lg-6 form-group">
                                        <label class="sr-only">Address</label>
                                        <input type="text" name="address" placeholder="Address" class="form-control"required>
                                    </div>
                                    <div class="col-lg-6 form-group">
                                        <label class="sr-only">Bank Account Number</label>
										<input type="text" name="accountNumber" placeholder="Account Number" class="form-control" required pattern="\d+" maxlength="11" inputmode="numeric" title="Please enter a valid account number with only numbers">
                                    </div>
                                    <div class="col-lg-6 form-group">
                                        <label class="sr-only">Username</label>
                                        <input type="text" name="username" placeholder="Username" class="form-control"required>
                                    </div>
                                    <div class="col-lg-6 form-group">
                                        <label class="sr-only">Password</label>
                                        <input type="password" name="password" placeholder="Password" class="form-control" minlength="8" required>
                                    </div>
                                    <div class="col-lg-12 form-group">
                                    	<input type="submit" class="btn" value="Submit">
                                        <button type="reset" class="btn btn-danger m-l-10">Clear</button>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end: Section -->
    </div>
    <!-- end: Body Inner -->   

</body>
</html>