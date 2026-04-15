<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f4f4;
        }
        .container {
            text-align: center;
            margin-top: 50px;
        }
        a {
            display: block;
            margin: 10px;
            padding: 10px;
            background: #3498db;
            color: white;
            text-decoration: none;
            width: 200px;
            margin-left: auto;
            margin-right: auto;
            border-radius: 5px;
        }
        a:hover {
            background: rgb(255, 128, 64);
        }
    </style>
</head>

<body>


<%
String role = (String) session.getAttribute("role");

if(role == null || !role.equals("admin")) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<div class="container">
    <h1>👑 Admin Dashboard</h1>

    <a href="addRestaurant.jsp">➕ Add Restaurant</a>
   <a href="<%=request.getContextPath()%>/ViewRestaurantServlet">📋 Manage Restaurants</a>
    <a href="addMenu.jsp">🍔 Add Menu</a>
    <a href="viewMenu.jsp">📜 Manage Menu</a>
    <a href="LogoutServlet">🚪 Logout</a>
</div>

</body>
</html>