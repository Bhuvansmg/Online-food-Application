package com.app.DAO;

import java.util.List;

import com.app.model.Restaurant;



public interface RestaurantDAO 
{

	 List<Restaurant> getAllRestaurants();

	    Restaurant getRestaurantById(int id);

	    void addRestaurant(Restaurant r);

	    void updateRestaurant(Restaurant r);

	    void deleteRestaurant(int id);
	
}
