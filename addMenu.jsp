<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <!DOCTYPE html>
<html>
<head>
    <title>Add Menu</title>
    
    <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #74ebd5, #ACB6E5);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    form {
        background: #fff;
        padding: 30px 35px;
        border-radius: 12px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.15);
        width: 380px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    label {
        font-weight: 600;
        display: block;
        margin-bottom: 5px;
        color: #444;
    }

    input, textarea {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-size: 14px;
        transition: all 0.3s ease;
    }

    textarea {
        resize: none;
        height: 80px;
    }

    input:focus, textarea:focus {
        border-color: #6c63ff;
        box-shadow: 0 0 6px rgba(108,99,255,0.3);
        outline: none;
    }

    button {
        width: 100%;
        padding: 12px;
        background: #6c63ff;
        color: white;
        font-size: 16px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: 0.3s;
    }

    button:hover {
        background: #5548e0;
    }
</style>
    
    
    
    
    
</head>
<body>


<h2>Add Menu Item</h2>

<form action="../AddMenuServlet" method="post" enctype="multipart/form-data">
    
    <label>Name:</label>
    <input type="text" name="name" required>
    
    <label>Price:</label>
    <input type="number" name="price" required>
    
    <label>Description:</label>
    <textarea name="description"></textarea>
    
    <label>Image:</label>
    <input type="file" name="image">
    
    <label>Rating:</label>
    <input type="text" name="rating" required>
    
    <button type="submit">Add Menu</button>

</form>

</body>
</html>