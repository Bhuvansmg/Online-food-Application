<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.app.model.Cart, com.app.model.CartItem"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>

<!-- External CSS -->
<link rel="stylesheet" href="cart1.css">


</head>

<body>

	<h1 class="title">🛒 Your Cart</h1>
	<div class="cart-container">
	<%
Cart cart = (Cart) session.getAttribute("cart");

if (cart != null && !cart.getItems().isEmpty()) {
%>

<div class="cart-container">

    <% for (CartItem item : cart.getItems().values()) { %>

    <div class="cart-card">

        <!-- IMAGE + NAME -->
        <div class="top-section">
           <img src="<%= item.getCartImage() != null ? item.getCartImage() : "default.jpg" %>" 
     class="food-img">
            
            <div>
                <h3><%= item.getCartName() %></h3>
                <p>₹ <%= String.format("%.2f", item.getCartPrice()) %></p>
            </div>
        </div>

        <!-- QUANTITY -->
        <div class="qty-section">

            <form action="CartServlet" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="itemId" value="<%= item.getCartItemId() %>">
                <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
                <input type="hidden" name="quantity" value="<%= item.getCartQuantity()-1 %>">
                <button>-</button>
            </form>

            <span><%= item.getCartQuantity() %></span>

            <form action="CartServlet" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="itemId" value="<%= item.getCartItemId() %>">
                 <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
                <input type="hidden" name="quantity" value="<%= item.getCartQuantity()+1 %>">
                <button>+</button>
            </form>

        </div>

        <!-- BOTTOM -->
        <div class="bottom-section">

            <span>₹ <%= String.format("%.2f", item.getTotalPrice()) %></span>

            <form action="CartServlet" method="post">
                <input type="hidden" name="action" value="remove">
                <input type="hidden" name="itemId" value="<%= item.getCartItemId() %>">
                 <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
                <button class="remove-btn">Remove</button>
            </form>

        </div>

    </div>

    <% } %>
    <h3 >
				Total Payable: ₹
					<%= cart.getGrandTotal() %>
				</h3>

    <!-- BUTTONS -->
    <div class="cart-actions">

			
        <a class="add-btn1"
           href="menuServlet?restaurantId=<%= session.getAttribute("restaurantId") %>">
           + Add More Items
        </a>
        
        <% if(session.getAttribute("cart")!=null)
        	{
        %>

      <form action="checkout.jsp" method="post">
    	<button class="checkout-btn1">Proceed to Checkout</button>
	</form>

    </div>
    <%	} %>

</div>

<%
} else {
%>

<div class="empty-cart-container">

    <h2 class="empty">🛒 Your cart is empty</h2>
    <p>Add delicious items to get started!</p>

    <!-- ADD ITEMS BUTTON -->
    <a class="add-btn"
       href="menuServlet?restaurantId=<%= session.getAttribute("restaurantId") %>">
       🍽️ Add Items
    </a>

    <!-- CHECKOUT BUTTON (DISABLED / ALERT) -->
    <button class="checkout-btn disabled-btn"
            onclick="alert('Your cart is empty. Please add items first!')">
        Proceed to Checkout
    </button>

</div>

<%
}
%>
</div>

</body>
</html>