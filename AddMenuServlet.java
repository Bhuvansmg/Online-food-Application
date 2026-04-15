package com.app;

import java.nio.file.StandardCopyOption;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AddMenuServlet")
@MultipartConfig
public class AddMenuServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String rating = req.getParameter("rating");

        // ✅ File upload
        
      

        Part filePart = req.getPart("image");

        String fileName = filePart.getSubmittedFileName();
        String dbPath = "foodimg/" + fileName;

        String uploadPath = getServletContext().getRealPath("") + "foodimg";
        File dir = new File(uploadPath);
        if (!dir.exists()) dir.mkdir();

        File file = new File(uploadPath + File.separator + fileName);

        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        
        // ✅ JDBC Insert
        try {
            Connection con=DBConnection.getConnection();
            
            int restId=3;
            String sql = "INSERT INTO menu(itemName, price, description, imagePath, restaurantId,rating) VALUES (?, ?, ?, ?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, description);
            ps.setString(4, dbPath);
            ps.setInt(5, restId);
            ps.setString(6, rating);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("Admin/addMenu.jsp");
    }
}