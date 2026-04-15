<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Successful</title>

<link rel="stylesheet" href="orderSuccess.css">

</head>
<body>

<div class="success-container">

    <div class="card">
    
        <!-- Success Icon -->
        <div class="checkmark">
            ✔
        </div>

        <!-- Message -->
        <h1>Order Placed Successfully!</h1>
        <p>Your food is being prepared 🍽️</p>

        <!-- Order Info -->
        <div class="order-info">
            <p><strong>Status:</strong> Pending</p>
            <p><strong>Estimated Delivery:</strong> 30-40 mins</p>
        </div>

        <!-- Buttons -->
        <div class="actions">
            <a href="restaurantServlet" class="btn">Order More</a>
            <a href="myOrders.jsp" class="btn secondary">View Orders</a>
        </div>

    </div>

</div>

</body>
</html>