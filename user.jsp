<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="Style.css">

   
</head>
<body>
<div class="container">
    <form class="RegisterServlet" action="RegisterServlet" method="post">

        <h2>Create Account</h2>

        <div class="form-group">
            <label>Name</label>
            <input type="text" placeholder="Enter your name" name="username">
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="email" placeholder="Enter your email" name="email">
        </div>

        <div class="form-group">
            <label>Address</label>
            <input type="text" placeholder="Enter your address" name="address">
        </div>

        <div class="form-group">
            <label>Phone</label>
            <input type="text" placeholder="Enter phone number" name="phone">
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" placeholder="Enter password" name="password">
        </div>

        <button class="btn">Register</button>

        <p class="login-text">
            Already have an account? <a href="login.jsp">Login</a>
        </p>

    </form>
</div>

</body>
</html>
<!-- ✅ Popup message -->
<%
String msg = (String) request.getAttribute("message");
if(msg != null){
%>
	<script>
    alert("<%= msg %>");
	</script>
<%
}
%>

</body>
</html>