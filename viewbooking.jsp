<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Booking | Hostel</title>
<style>:root {
  --surface-color: #fff;
  --curve: 40;
}

* {
  box-sizing: border-box;
}

body {
  font-family: 'Noto Sans JP', sans-serif;
  background: url("images/pexels-codioful-7130560.jpg");
  background-repeat: no-repeat;
  background-size: auto;
}

.container {
  display: flex;
  justify-content: center; /* Center the content horizontally */
  align-items: center; /* Center the content vertically */
  height: 100vh; /* Make the container take up the full height of the viewport */
}

.cards {
  display: flex;
  justify-content: center; /* Center the cards horizontally */
  align-items: center; /* Center the cards vertically */
  list-style-type: none;
}

.card {
  position: relative;
  display: block;
  max-width: 600px; /* Increased size */
  width: 100%;
  height: auto;
  border-radius: calc(var(--curve) * 1px);
  overflow: hidden;
  text-decoration: none;
}



.card__image {      
  width: 100%;
  height: auto;
}

.card__overlay {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 1;      
  border-radius: calc(var(--curve) * 1px);    
  background-color: 	#dbf3fa;      
  transform: translateY(100%);
  transition: .2s ease-in-out;
}

.card:hover .card__overlay {
  transform: translateY(0);
}

.card__header {
  position: relative;
  display: flex;
  align-items: center;
  gap: 2em;
  padding: 2em;
  border-radius: calc(var(--curve) * 1px) 0 0 0;    
  background-color: 	#dbf3fa;
  transform: translateY(-100%);
  transition: .2s ease-in-out;
}

.card__arc {
  width: 80px;
  height: 80px;
  position: absolute;
  bottom: 100%;
  right: 0;      
  z-index: 1;
}

.card__arc path {
  fill: var(--surface-color);
  d: path("M 40 80 c 22 0 40 -22 40 -40 v 40 Z");
}       

.card:hover .card__header {
  transform: translateY(0);
}

.card__thumb {
  flex-shrink: 0;
  width: 50px;
  height: 50px;      
  border-radius: 50%;      
}

.card__title {
  font-size: 1em;
  margin: 0 0 .3em;
  color: #6A515E;
}

.card__tagline {
  display: block;
  margin: 1em 0;
  font-family: "MockFlowFont";  
  font-size: .8em; 
  color: #D7BDCA;  
}

.card__status {
  font-size: .8em;
  color: #2596be;
}

.card__description {
  padding: 0 2em 2em;
  margin: 0;
  color: #2596be;
  font-family: "MockFlowFont";   
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  overflow: hidden;
}
button {
  font-family: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas,
    "Liberation Mono", "Courier New", monospace;
  font-size: 17px;
  padding: 0.7em 1.5em; /* Adjust padding to make the button smaller */
  font-weight: 500;
  background: #1f2937;
  color: white;
  border: none;
  position: relative;
  overflow: hidden;
  border-radius: 0.6em;
  cursor: pointer;
}

.gradient {
  position: absolute;
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
  border-radius: 0.6em;
  margin-top: -0.25em;
  background-image: linear-gradient(
    rgba(0, 0, 0, 0),
    rgba(0, 0, 0, 0),
    rgba(0, 0, 0, 0.3)
  );
}

.label {
font-family: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas,
    "Liberation Mono", "Courier New", monospace;
  position: relative;
  top: -1px;
}

.transition {
  transition-timing-function: cubic-bezier(0, 0, 0.2, 1);
  transition-duration: 500ms;
  background-color: rgba(16, 185, 129, 0.6);
  border-radius: 9999px;
  width: 0;
  height: 0;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

button:hover .transition {
  width: 14em;
  height: 14em;
}

button:active {
  transform: scale(0.97);
}

.white-container {
  font-size: 1em;
  margin: 0 0 .3em;
  color: #6A515E;
  background-color: #dbf3fa;
  padding: 10px;
  border-radius: 20px; /* Adjust this value to make the border more rounded */
  display: inline-block;
}</style>
</head>
<body>
<a href="customerlogin.jsp">
  <button>
    <span class="transition"></span>
    <span class="gradient"></span>
    <span class="label">Log Out</span>
  </button>
</a>
<div class="container">
 <ul class="cards">
  <li>
   <div class="white-container">
      <b>BOOKING ID: ${booking.bookid}</b>
    </div>
    <a href="" class="card">
      <img src="images/hotelimage.jpeg" class="card__image" alt="" />
      <div class="card__overlay">
        <div class="card__header">
          <svg class="card__arc" ></svg>                     
          <div class="card__header-text">
            <h3 class="card__title">${booking.customer.customer_name}</h3>            
            <span class="card__status">${booking.reservedate}</span>
          </div>
        </div>
        <p class="card__description"> 
          No of people  : ${booking.numberofpeople} <br> 
          Room Details : ${booking.room.room_details} <br> 
          Room Price    : RM ${booking.room.room_price} 
        </p>
      </div>
    </a>      
  </li>
</ul>
</div>
</body>
</html>
