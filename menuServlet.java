package com.app;

import java.io.IOException;
import java.util.List;

import com.app.DAOImpls.MenuDAOImpls;
import com.app.model.menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/menuServlet")
public class menuServlet extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
		MenuDAOImpls menuDAOImpls = new MenuDAOImpls();
		List<menu> menuByRestaurantId = menuDAOImpls.getMenuByRestaurantId(restaurantId);
		
		req.setAttribute("menuList", menuByRestaurantId);
		req.getRequestDispatcher("menu.jsp").forward(req, resp);
	}
}
