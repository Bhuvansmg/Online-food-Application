<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.app.model.Restaurant,java.util.List,com.app.model.Users" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewRestaurant</title>

<style>
    body {
        font-family: 'Segoe UI', sans-serif;
        background: #f5f6fa;
        margin: 0;
        padding: 20px;
    }

    /* Main container */
    .Container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        gap: 20px;
    }

    /* Card */
    .imagecontainer {
        background: #fff;
        width: 250px;
        border-radius: 12px;
        overflow: hidden;
        box-shadow: 0 6px 15px rgba(0,0,0,0.1);
        transition: 0.3s;
        cursor: pointer;
    }

    .imagecontainer:hover {
        transform: translateY(-8px);
        box-shadow: 0 10px 25px rgba(0,0,0,0.15);
    }

    /* Image */
    .imagecontainer img {
        width: 100%;
        height: 160px;
        object-fit: cover;
    }

    /* Text container */
    .insideContain {
        padding: 12px;
        font-size: 16px;
        font-weight: 600;
        color: #333;
    }

    /* Info row */
    .info {
        display: flex;
        justify-content: space-between;
        margin-top: 8px;
        font-size: 14px;
        font-weight: normal;
    }

    .rating {
        background: #28a745;
        color: white;
        padding: 3px 8px;
        border-radius: 5px;
        font-size: 13px;
    }

    .time {
        color: #555;
        font-size: 13px;
    }

    /* Empty state */
    .empty {
        text-align: center;
        margin-top: 50px;
        color: #777;
    }
</style>


</head>
<body>



<div class="Container">

<%
List<Restaurant> restaurant = (List<Restaurant>) request.getAttribute("restaurants");

if (restaurant != null && !restaurant.isEmpty()) {
    for(Restaurant res:restaurant) {
%>

<%
String path = res.getImagePath();
if (!path.startsWith("RestaurantImages")) {
    path = "RestaurantImages/" + path;
}
%>

<div class="imagecontainer"> 
    <img src="<%=request.getContextPath()%>/<%=path%>">

    <div class="insideContain">
        <%= res.getName() %>

        <div class="info">
            <span class="rating">⭐ <%= res.getRating() %></span>
            <span class="time"><%= res.getDeliveryTime() %> min</span>
        </div>
    </div>
</div>

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

</div>
</body>
</html>