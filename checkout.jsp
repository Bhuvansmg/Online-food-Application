<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.app.model.Users, com.app.model.Cart, com.app.model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<link rel="stylesheet" href="checkout.css">
</head>

<body>

<%
Users user = (Users)session.getAttribute("user");
Cart cart = (Cart) session.getAttribute("cart");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<div class="checkout-wrapper">

    <!-- LEFT SIDE -->
    <div class="checkout-left">

        <h2>🧾 Checkout</h2>

        <!-- Saved Address -->
        <p class="saved-address">
            📍 Saved Address: <%= user.getAddress() %>
        </p>

        <form action="CheckoutServlet" method="post">

            <label>Delivery Address:</label>
            <textarea name="address" required><%= user.getAddress() %></textarea>

            <!-- PAYMENT -->
            <label>Payment Mode:</label>

            <div class="payment-options">

                <label>
                    <input type="radio" name="paymentMode" value="COD" required>
                    💵 Cash on Delivery
                </label>

                <label>
                    <input type="radio" name="paymentMode" value="UPI">
                    <img src="foodimg/upi1.png" class="pay-icon"> UPI
                </label>

                <label>
                    <input type="radio" name="paymentMode" value="CARD">
                    <img src="foodimg/debit.jpg" class="pay-icon"> Card
                </label>

            </div>

            <button type="submit">Place Order</button>

        </form>

    </div>


    <!-- RIGHT SIDE -->
    <div class="checkout-right">

    <div class="summary-box">

        <h3>🛒 Order Summary</h3>

        <%
        double subtotal = 0;

        if(cart != null && !cart.getItems().isEmpty()){
            for(CartItem item : cart.getItems().values()){
                subtotal += item.getTotalPrice();
        %>

        <div class="summary-item">
            <span><%= item.getCartName() %> x <%= item.getCartQuantity() %></span>
            <span>₹ <%= item.getTotalPrice() %></span>
        </div>

        <%
            }

            double delivery = (subtotal > 500) ? 0 : 40;
            double tax = subtotal * 0.05;
            double total = subtotal + delivery + tax;
        %>

        <!-- 🎯 FREE DELIVERY MESSAGE -->
        <% if(subtotal < 500){ %>
            <p class="offer-msg">
                Add ₹ <%= (500 - subtotal) %> more to get FREE delivery 🚚
            </p>
        <% } else { %>
            <p class="offer-msg success">
                You got FREE delivery!
            </p>
        <% } %>

        <hr>

        <div class="summary-item">
            <span>Subtotal</span>
            <span>₹ <%= subtotal %></span>
        </div>

        <div class="summary-item">
            <span>Delivery</span>
            <span>
                <% if(delivery == 0){ %>
                    <span class="free">FREE </span>
                <% } else { %>
                    ₹ <%= delivery %>
                <% } %>
            </span>
        </div>

        <div class="summary-item">
            <span>GST (5%)</span>
            <span>₹ <%= String.format("%.2f", tax) %></span>
        </div>

        <hr>

        <div class="summary-total">
            <span>Total</span>
            <span>₹ <%= String.format("%.2f", total) %></span>
        </div>

        <% } else { %>

        <p class="empty-cart">Your cart is empty</p>

        <% } %>

    </div>

</div>
</div>


</body>
</html>