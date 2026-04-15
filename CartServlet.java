package com.app;


import java.io.IOException;


import com.app.DAOImpls.MenuDAOImpls;
import com.app.model.Cart;
import com.app.model.CartItem;
import com.app.model.menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    

    	    HttpSession session = req.getSession();

    	    Cart cart = (Cart) session.getAttribute("cart");
    	    Integer restaurantId = (Integer) session.getAttribute("restaurantId");

    	    String action = req.getParameter("action");

    	    if (action == null) {
    	        resp.sendRedirect("menu.jsp");
    	        return;
    	    }

    	    switch (action) {

    	        // ================= ADD =================
    	        case "add":

    	            String restParam = req.getParameter("restaurantId");

    	            if (restParam == null || restParam.isEmpty()) {
    	                resp.sendRedirect("menu.jsp");
    	                return;
    	            }

    	            int newRestaurantId = Integer.parseInt(restParam);

    	            // reset cart if different restaurant
    	            if (cart == null || restaurantId == null || !restaurantId.equals(newRestaurantId)) {
    	                cart = new Cart();
    	                session.setAttribute("cart", cart);
    	                session.setAttribute("restaurantId", newRestaurantId);
    	            }

    	            addItemToCart(req, cart);
    	            break;

    	        // ================= UPDATE =================
    	        case "update":
    	            if (cart != null) {
    	                updateItemToCart(req, cart);
    	            }
    	            break;

    	        // ================= REMOVE =================
    	        case "remove":
    	            if (cart != null) {
    	                removeItemToCart(req, cart);
    	            }
    	            break;
    	    }

    	    resp.sendRedirect("cart.jsp");
    	}

  
	// ================= ADD =================
    private void addItemToCart(HttpServletRequest req, Cart cart) 
    {

      int menuId = Integer.parseInt( req.getParameter("menuId"));
      int quantity = Integer.parseInt( req.getParameter("quantity"));
     
      
      MenuDAOImpls menuDAOImpls = new MenuDAOImpls();
      
      menu menuById = menuDAOImpls.getMenuById(menuId);
      
      CartItem cartItem = new CartItem(
    		  menuId,
    		  menuById.getItemName(),
    		  menuById.getPrice(),
    		  quantity,
    		  menuById.getImagePath() 
    		  );
      cart.addItem(cartItem);
      
      
    }

    // ================= UPDATE =================
    private void updateItemToCart(HttpServletRequest req, Cart cart) {
    	
    	{

    	    int itemId = Integer.parseInt(req.getParameter("itemId"));
    	    int quantity = Integer.parseInt(req.getParameter("quantity"));

    	    if (quantity <= 0) {
    	        cart.removeItem(itemId);
    	    } else {
    	        cart.updateItem(itemId, quantity);
    	    }
    	}
    	
    	
    }

    // ================= REMOVE =================

    private void removeItemToCart(HttpServletRequest req, Cart cart) {
    	{

    	    int itemId = Integer.parseInt(req.getParameter("itemId"));
    	    cart.removeItem(itemId);
    	}
    	
    	
    }
}
   
