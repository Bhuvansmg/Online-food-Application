package com.app;

import java.io.IOException;
import java.util.List;

import com.app.DAOImpls.RestaurantDAOImpls;
import com.app.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/restaurantServlet")
public class RestaurantServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 RestaurantDAOImpls restaurantDAOImpls = new RestaurantDAOImpls();
    	 List<Restaurant> allRestaurants = restaurantDAOImpls.getAllRestaurants();
    	 		
        
     
      request.setAttribute("restaurants",allRestaurants );
       RequestDispatcher rd = request.getRequestDispatcher("Restaurant.jsp");
       rd.forward(request, response);
    }
}