<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    

<%
    int id = Integer.parseInt(request.getParameter("id"));
    double price = Double.parseDouble(request.getParameter("price"));
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Price</title>
</head>
<body>

<h2>Edit Price</h2>

<form action="../UpdatePriceServlet" method="post">
    
    <input type="hidden" name="id" value="<%= id %>">

    Price: <input type="number" name="price" value="<%= price %>" required><br><br>

    <button type="submit">Update</button>

</form>

</body>
</html>