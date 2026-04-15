<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.app.model.Orders" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Orders</title>
<link rel="stylesheet" href="myorder.css">
</head>

<body>

<h1 class="title">🧾 My Orders</h1>

<div class="container">

<%
List<Orders> orders = (List<Orders>) request.getAttribute("orders");

if (orders != null && !orders.isEmpty()) {
    for (Orders order : orders) {
%>

    <div class="order-card">
        <h2>Order ID: <%= order.getOrderId() %></h2>

        <p><strong>Total:</strong> ₹<%= order.getTotalAmount() %></p>
        <p><strong>Payment:</strong> <%= order.getPaymentMode() %></p>
        <p><strong>Status:</strong> <span class="status"><%= order.getStatus() %></span></p>
        <p><strong>Date:</strong> <%= order.getDate()%></p>

    </div>

<%
    }
} else {
%>
    <p class="empty">No orders found 😔</p>
<%
}
%>

</div>

</body>
</html>