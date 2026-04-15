<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.app.model.Restaurant,java.util.List,com.app.model.Users" %>
  <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FoodApp</title>
    <link rel="stylesheet" href="rest1.css" >
 
   
</head>
<!-- NAVBAR -->
<div class="navbar">
    <div class="logo">🍔 FoodApp</div>

    <div class="nav-links">
        <a href="home.jsp">Home</a>
        <a href="cart.jsp">Cart 🛒</a>

        <% 
            Users user = (Users) session.getAttribute("user");

            if(user == null) { 
        %>
            <a href="login.jsp">Login</a>
        <% 
            } else { 
        %>
            <span>👤 <%= user.getUserName() %></span>
            <a href="logout">Logout</a>
        <% 
            } 
        %>
    </div>
</div> <!-- ✅ CLOSE NAVBAR HERE -->


<!-- CONTAINER -->
<div class="container">

<%
List<Restaurant> restaurant = (List<Restaurant>) request.getAttribute("restaurants");

if (restaurant != null && !restaurant.isEmpty()) {
    for (Restaurant res : restaurant) {
%>

<a href="menuServlet?restaurantId=<%= res.getRestaurantId() %>" class="res-link">

    <div class="card">
        <img src="<%= res.getImagePath() %>" alt="Food Image">

        <div class="card-content">
            <div class="restaurant-name"><%= res.getName() %></div>

            <div class="info">
                <span class="rating">⭐ <%= res.getRating() %></span>
                <span class="time"><%= res.getDeliveryTime() %> min</span>
            </div>

            <div class="location">📍 <%= res.getAddress() %></div>
        </div>
    </div>

</a>

<%
    }
} else {
%>

<div class="empty">
    <h2>😔 No Restaurants Found</h2>
</div>

<%
}
%>

</div> <!-- ✅ CLOSE CONTAINER -->

</body>
</html>