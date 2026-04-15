<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    form {
        background: #ffffff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        width: 350px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 5px;
        color: #555;
    }

    input, select {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border-radius: 5px;
        border: 1px solid #ccc;
        outline: none;
        transition: 0.3s;
    }

    input:focus, select:focus {
        border-color: #007bff;
        box-shadow: 0 0 5px rgba(0,123,255,0.3);
    }

    button {
        width: 100%;
        padding: 10px;
        background: #007bff;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 5px;
        cursor: pointer;
        transition: 0.3s;
    }

    button:hover {
        background: #0056b3;
    }
</style>


</head>
<body>

<h2>Add Restaurant</h2>

<form action="<%=request.getContextPath()%>/AddRestaurantServlet" 
      method="post" enctype="multipart/form-data">

    <label>Name:</label>
    <input type="text" name="name">

    <label>Address:</label>
    <input type="text" name="address">

    <label>Rating:</label>
    <input type="text" name="rating">

    <label>Image:</label>
    <input type="file" name="image">

    <label>Cuisine Type:</label>
    <select name="cuisineType">
        <option value="South Indian">South Indian</option>
        <option value="North Indian">North Indian</option>
        <option value="Chinese">Chinese</option>
        <option value="Japanese">Japanese</option>
    </select>

    <label>Delivery Time (minutes):</label>
    <input type="text" name="deliveryTime">

    <button type="submit">Add Restaurant</button>
</form>


</body>
</html>