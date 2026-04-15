<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.app.model.menu" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="menu1.css">
</head>

<body>

<!-- ✅ NAVBAR -->
<div class="navbar">

    <div class="logo">🍔 Foodie</div>

    <div class="nav-links">
        <a href="home.jsp">Home</a>
        <a href="restaurantServlet">Restaurants</a>
    </div>

    <!-- 🔍 SEARCH BOX -->
    <form action="SearchServlet" method="get" class="search-box">
        <input type="text" name="query" placeholder="Search food..." 
               value="<%= request.getAttribute("searchQuery") != null ? request.getAttribute("searchQuery") : "" %>">
        <button type="submit">🔍</button>
    </form>

    <div class="nav-actions">
        <a href="cart.jsp" class="cart-btn">
            🛒 Cart (<%= session.getAttribute("cart") != null 
            ? ((com.app.model.Cart)session.getAttribute("cart")).getItems().size() : 0 %>)
        </a>

       <%
    com.app.model.Users user = (com.app.model.Users) session.getAttribute("user");

    if(user != null){
%>
    <span class="user">Hi, <%= user.getUserName() %></span>
<%
    } else {
%>
    <a href="login.jsp" class="login-btn">Login</a>
<%
    }
%>
    </div>

</div> <!-- ✅ NAVBAR END -->


<%
List<menu> menuList = (List<menu>) request.getAttribute("menuList");
String searchQuery = (String) request.getAttribute("searchQuery");
%>

<!-- ✅ DYNAMIC TITLE -->
<h1 class="title">
<%= (searchQuery != null) ? "🔍 Results for: " + searchQuery : "Restaurant Menu" %>
</h1>

<!-- ✅ MENU -->
<div class="container">

<%
if(menuList != null && !menuList.isEmpty()){
    for(menu m : menuList){
%>

<div class="card">
    <img src="<%= m.getImagePath() %>" alt="Food Image">

    <div class="card-content">
        <div class="item-name"><%= m.getItemName() %></div>

        <div class="info">
            <span class="rating">⭐ <%= m.getRating() %></span>
            <span class="price">₹ <%= m.getPrice() %></span>
        </div>

        <div class="description">
            <%= m.getDescription() %>
        </div>
        
        

        <form action="CartServlet" method="post">
            <input type="hidden" name="menuId" value="<%= m.getMenuId() %>">
            <input type="hidden" name="quantity" value="1">
            <input type="hidden" name="restaurantId" value="<%= m.getRestaurantId() %>">
            <input type="hidden" name="action" value="add">

            <button type="submit" class="btn">Add to Cart</button>
        </form>
    </div>
</div>

<%
    }
} else {
%>


<h1 class="title">
<%= (searchQuery != null) ? "🔍 Results for: " + searchQuery : "Restaurant Menu" %>
</h1>

<% if(searchQuery != null){ %>
    <div style="text-align:center; margin-bottom:15px;">
        <a href="menuServlet?restaurantId=<%= session.getAttribute("restaurantId") %>" 
           class="clear-btn">
           ❌ Clear Search
        </a>
    </div>
<% }
else {%>

	
	<h2>Not Items is found</h2>


    <% } %>
      <% } %>

</div> <!-- container -->

</body>
</html>