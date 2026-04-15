package com.app;




import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdatePriceServlet")
public class UpdatePriceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        double price = Double.parseDouble(req.getParameter("price"));

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE menu SET price=? WHERE menuId=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, price);
            ps.setInt(2, id);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // redirect back to menu list
        resp.sendRedirect("Admin/viewMenu.jsp");
    }
}