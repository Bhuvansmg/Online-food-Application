package com.app;



import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import com.app.DAOImpls.OrderDAOImpls;
import com.app.DAOImpls.OrderItemDAOImpl;
import com.app.model.Cart;
import com.app.model.CartItem;
import com.app.model.OrderItems;
import com.app.model.Orders;
import com.app.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/placeOrderServlet1")
public class placeOrderServlet1  extends HttpServlet
{
	private OrderDAOImpls orderdao;
	
	@Override
	public void init() throws ServletException
	{
			orderdao=new OrderDAOImpls();
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
			HttpSession session = req.getSession();
			Cart cart=(Cart) session.getAttribute("cart");
			Users user=(Users) session.getAttribute("loggeduserId");
			if(cart !=null && user!=null && !cart.getItems().isEmpty())
			{
				String address = req.getParameter("address");
				String payment = req.getParameter("paymentMode");
				
				
				
				
				
				
				
				

		        double totalAmount = cart.getTotalPrice();
		        
		        Orders order = new Orders();
		        order.setUserId(order.getUserId());
		        order.setRestaurantId ((int)session.getAttribute("restaurantId"));
		        order.setDate(new Timestamp(new Date().getTime()));
		        order.setAddress(order.getAddress());
		        order.setPaymentMode(order.getPaymentMode());
		        order.setTotalAmount(totalAmount);
		        order.setStatus("SUCCESS");

		        orderdao.insertOrder(order);
		        
		        
		        
		    
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
 
		        
		        
		        
		        session.removeAttribute("cart"); //clear cart
		        session.setAttribute("orders", order);
		        
		        resp.sendRedirect("order_Comformation.jsp");
			}
			else
			{
				resp.sendRedirect("cart.jsp");
			}
	}
}
