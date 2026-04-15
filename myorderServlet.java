package com.app;

import java.io.IOException;
import java.util.List;

import com.app.DAOImpls.OrderDAOImpls;
import com.app.model.Orders;
import com.app.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/myOrders")
public class myorderServlet extends HttpServlet {


	

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        HttpSession session = req.getSession();
	        Users user = (Users) session.getAttribute("user");

	        if (user == null) {
	            resp.sendRedirect("login.jsp");
	            return;
	        }

	        OrderDAOImpls dao = new OrderDAOImpls();

	        List<Orders> orders = dao.getOrdersByUserId(user.getUserId());

	        req.setAttribute("orders", orders);
	        req.getRequestDispatcher("myOrders.jsp").forward(req, resp);
	    }
	}

