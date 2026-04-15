<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.app.model.Users" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodApp - Home</title>
<link rel="stylesheet" href="home1.css">
</head>

<body>

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
        <% } else { %>
            <span>👤 <%= user.getUserName() %></span>
            <a href="logout">Logout</a>
        <% } %>
    </div>
</div>

<!-- HERO SECTION -->
<div class="hero">
    <h1>Order Food Online 🍕</h1>
    <p>Discover the best restaurants near you</p>

    <form action="restaurantServlet" method="post">
        <input type="text" name="search" placeholder="Search for restaurants or dishes...">
        <button type="submit">Search</button>
    </form>
</div>

<!-- CATEGORIES -->
<div class="categories">
    <h2>Popular Categories</h2>

    <div class="category-list">
        <div class="cat">🍕 Pizza</div>
        <div class="cat">🍔 Burger</div>
        <div class="cat">🍗 Biryani</div>
        <div class="cat">🥗 Healthy</div>
        <div class="cat">🍜 Chinese</div>
        <div class="cat">🍰 Desserts</div>
    </div>
</div>

<!-- RESTAURANT SECTION -->
<div class="restaurants">
    <h2>Top Restaurants</h2>

    <a href="restaurantServlet" class="explore-btn">Explore Restaurants →</a>
</div>

</body>
</html>