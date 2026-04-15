package com.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteMenuServlet")
public class DeleteMenuServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int menuId = Integer.parseInt(req.getParameter("id"));
		
		
	String sql= "delete from menu where menuId=?";
	try (	Connection con=DBConnection.getConnection();
		PreparedStatement statement = con.prepareStatement(sql);)
	{
		
		
		statement.setInt(1,	menuId );
		
		statement.executeUpdate();
		
		resp.sendRedirect("Admin/viewMenu.jsp");
		
		
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}
}
