<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

int id = Integer.parseInt(request.getParameter("id"));


%>

<form action="../DeleteMenuServlet" method="get">


Menu Id:   <input type="number" name="id" value="<%= id %>">
<br>
<input type="submit" value="Delete">




</form>

</body>
</html>