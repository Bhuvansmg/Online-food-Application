package com.app.DAOImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.app.model.Orders;
import com.util.DBConnection;

public class OrderDAOImpls 
{
	private static final String sql = "INSERT INTO orders (user_id, restaurant_id, orderDate, payment, address, status, totalAmount) VALUES (?, ?, ?, ?, ?, ?, ?)";;

	public int insertOrder(Orders order) {

        boolean status = false;
        int rows=0;
     
		try( Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
        

           

            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getRestaurantId());
            ps.setTimestamp(3, new Timestamp(order.getDate().getTime()));
            ps.setString(4, order.getPaymentMode());
            ps.setString(5, order.getAddress());
            ps.setString(6, order.getStatus());
            ps.setDouble(7, order.getTotalAmount());

         rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }
            if (rows == 0) {
	            throw new SQLException("Creating orders failed, no rows affected.");
	        }

	        try (ResultSet rs = ps.getGeneratedKeys()) {
	            if (rs.next()) {
	                order.setUserId(rs.getInt(1));
	            }
	        }

	    } catch (SQLException e) {
	        throw new RuntimeException("Error adding order", e);
	    }

        
		return rows;
       
	}
	public List<Orders> getOrdersByUserId(int userId) {

	    List<Orders> list = new ArrayList<>();

	    try {
	        Connection con = DBConnection.getConnection();

	        // ✅ FIXED QUERY
	        String sql = "SELECT * FROM orders WHERE user_id = ? ORDER BY orderId DESC";

	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) 
	        {
	        	 int orderid = rs.getInt("orderId");
	                int userid = rs.getInt("user_id");
	                int restaurantid = rs.getInt("restaurant_id");
	                Timestamp date = rs.getTimestamp("orderDate");
	                String payment = rs.getString("payment");
	                String address = rs.getString("address");
	                String status = rs.getString("status");
	                double totalAmount = rs.getDouble("totalAmount");
	                
	                Orders orders = new Orders(orderid,userid,restaurantid,date,payment,address,status,totalAmount);

	            list.add(orders);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
}
