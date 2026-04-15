<%@ page import="java.sql.*" %>
<%@ page import="com.util.DBConnection" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Menu</title>
    
    
    <style>
    body {
        font-family: 'Segoe UI', Tahoma, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 20px;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 25px;
    }

    table {
        width: 95%;
        margin: auto;
        border-collapse: collapse;
        background: #ffffff;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 8px 20px rgba(0,0,0,0.1);
    }

    th {
        background: #343a40;
        color: white;
        padding: 12px;
        text-transform: uppercase;
        font-size: 13px;
        letter-spacing: 1px;
    }

    td {
        padding: 12px;
        text-align: center;
        border-bottom: 1px solid #eee;
    }

    tr:hover {
        background: #f9f9f9;
    }

    img {
        width: 80px;
        height: 80px;
        border-radius: 8px;
        object-fit: cover;
        transition: 0.3s;
    }

    img:hover {
        transform: scale(1.1);
    }

    a {
        text-decoration: none;
        padding: 6px 12px;
        border-radius: 5px;
        font-size: 13px;
        color: white;
        transition: 0.3s;
    }

    /* Edit Button */
    td a[href*="editMenu"] {
        background: #007bff;
    }

    td a[href*="editMenu"]:hover {
        background: #0056b3;
    }

    /* Delete Button */
    td a[href*="DeleteMenuServlet"] {
        background: #dc3545;
    }

    td a[href*="DeleteMenuServlet"]:hover {
        background: #a71d2a;
    }
</style>
    
    
    
    
</head>





<body>

<h2>Menu List</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Image</th>
        <th>Edit</th>
         <th>Delete</th>
    </tr>

<%
    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM menu";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
%>

<tr>
    <td><%= rs.getInt("menuId") %></td>
    <td><%= rs.getString("itemName") %></td>
    <td><%= rs.getDouble("price") %></td>
    <td><%= rs.getString("description") %></td>

    <td>
        <img src="../<%= rs.getString("imagePath") %>" width="100" height="100">
    </td>

    <td>
        <a href="editMenu.jsp?id=<%= rs.getInt("menuId") %>&price=<%= rs.getDouble("price") %>">
            Edit Price
        </a>
    </td>

    <!-- ✅ ADD DELETE HERE -->
    <td>
        <a href="../DeleteMenuServlet?id=<%= rs.getInt("menuId") %>" 
   onclick="return confirm('Are you sure you want to delete this item?')">
   Delete
</a>
    </td>
</tr>


<%
        }
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

</table>

</body>
</html>