package com.app.DAOImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.app.model.OrderItems;
import com.util.DBConnection;

public class OrderItemDAOImpl {

    public void addOrderItem(OrderItems item) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO orderitems (order_id, menu_id, quantity, totalPrice) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, item.getOrderId());
            ps.setInt(2, item.getMenuId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getTotalPrice());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Creating order item failed, no rows affected.");
            }

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                item.setOrderItemId(rs.getInt(1)); // ✅ correct ID
            } else {
                throw new SQLException("Creating order item failed, no ID obtained.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}