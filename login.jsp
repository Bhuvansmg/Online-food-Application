<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="StyleSheet" href="style1.css">
</head>
<body>

<div class="container">

<h2>Login</h2>

<form action="LoginServlet" method="post">

<div class="form-group">
<label>Email</label>
<input type="email" name="email" required>
</div>

<div class="form-group">
<label>Password</label>
<input type="password" name="password" required>
</div>

<button type="submit">Login</button>

</form>

<p class="login-text">
New user? <a href="user.jsp">Create your account</a>
</p>

</div>


<!-- ✅ Popup message -->
<%
String msg = (String) request.getAttribute("error");
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