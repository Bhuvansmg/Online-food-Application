package com.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.DAOImpls.RestaurantDAOImpls;
import com.app.model.Restaurant;
import com.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ViewRestaurantServlet")
public class ViewRestaurantServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM restaurant");
            ResultSet rs = ps.executeQuery();

            List<Restaurant> list = new ArrayList<>();

            while (rs.next()) {
                Restaurant r = new Restaurant();
                r.setName(rs.getString("name"));
                r.setRating(rs.getFloat("rating"));
                r.setImagePath(rs.getString("imagePath"));
                r.setDeliveryTime(rs.getInt("deliveryTime"));
                list.add(r);
            }

            req.setAttribute("restaurants", list);
            req.getRequestDispatcher("Admin/viewRestaurants.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
