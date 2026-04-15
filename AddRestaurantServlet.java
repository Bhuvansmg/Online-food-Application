package com.app;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet("/AddRestaurantServlet")
public class AddRestaurantServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String name = req.getParameter("name");
        String address = req.getParameter("address");
        double rating = Float.parseFloat(req.getParameter("rating"));
        String cuisineType = req.getParameter("cuisineType");
        int deliveryTime = Integer.parseInt(req.getParameter("deliveryTime"));

        Part filePart = req.getPart("image");
        String fileName = filePart.getSubmittedFileName();
        String images= "RestaurantImages/" + fileName;

        // Correct path inside project
        String uploadPath = getServletContext().getRealPath("") 
                + File.separator + "RestaurantImages";

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Save file
        filePart.write(uploadPath + File.separator + fileName);

        System.out.println("Saved to: " + uploadPath);

        
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, uploadDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        
   

        try {
            Connection con = DBConnection.getConnection();
            
            int adminId =1;
            String sql = "INSERT INTO restaurant(name,address,rating,imagePath,adminUserId,cuisineType,deliveryTime) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setDouble(3, rating);
            ps.setString(4, images); // 👈 store image name
            ps.setInt(5, adminId);
            ps.setString(6, cuisineType);
            ps.setInt(7, deliveryTime); 

            ps.executeUpdate();

            resp.sendRedirect("Admin/ViewRestaurant.jsp");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}