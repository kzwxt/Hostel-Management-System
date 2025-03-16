<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <!-- Document title -->
    <title>Login Staff | Hostel </title>
    <!-- Stylesheets & Fonts -->
    <link href="css2/plugins.css" rel="stylesheet">
    <link href="css2/style.css" rel="stylesheet">
     
</head>

<body>
    <!-- Body Inner -->   
    <div class="body-inner">
        <!-- Section -->
        <section class="fullscreen" style="background-color: hsl(225, 100%, 94%);">
            <div class="container container-fullscreen">
                <div class="text-middle">
                    <div class="text-center m-b-30">
                        <a href="customerhomepage.html" class="logo">
                            <img src="images/companyLogo.jpg" alt="Polo Logo" width="210" height="210">
                        </a>
                    </div>
                    <div class="row">
                        <div class="col-lg-5 center p-50 background-white b-r-6">
                            <h3>Login to your Account</h3>
					                                 <% 
					            String errorMessage = (String) request.getAttribute("errorMessage");
					            if (errorMessage != null) {
					                out.println("<div class='alert alert-danger'>" + errorMessage + "</div>");
					            }
					        %>
                            <form action="EmployeeLoginController" method="post">
                                <div class="form-group">
                                    <input type="email" class="form-control" name="email" placeholder="Email" required>
                                </div>
                                <div class="form-group m-b-5">
                                    <label class="sr-only">Password</label>
                                    <input type="password" class="form-control" name="password" placeholder="Password" required>
                                </div>
                                <div class="form-group form-inline text-left">
                                    <div class="form-check">
                                        <label>
                                            <input type="checkbox"><small class="m-l-10"> Remember me</small>
                                        </label>
                                    </div>
                                </div>
                                <div class="text-left form-group">       
                                       <button type="submit" class="btn">Login</button>
                                </div>
                            </form>
                            <p class="small">Don't have an account yet? <a href="user-register.jsp"><u>Register here.</u></a>
                            </p>
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
