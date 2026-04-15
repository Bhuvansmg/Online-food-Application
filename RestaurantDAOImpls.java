package com.app.DAOImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.DAO.RestaurantDAO;
import com.app.model.Restaurant;
import com.util.DBConnection;

public class RestaurantDAOImpls  implements RestaurantDAO
{

	  private static final String GetALLRestaurant = "Select * from restaurant";

		@Override
	    public List<Restaurant> getAllRestaurants() {

	        List<Restaurant> list = new ArrayList<>();
	        Restaurant r=null;
	        try(Connection con=DBConnection.getConnection();      
	        		PreparedStatement statement = con.prepareStatement(GetALLRestaurant);	)
	        {
	        	
	        	ResultSet rs = statement.executeQuery();
	           
				

	            while (rs.next()) {


	                int Id = rs.getInt("restaurantId");
	                String name = rs.getString("name");
	                String cuisineType = rs.getString("cuisineType");
	                int deliveryTime = rs.getInt("deliveryTime");
	                String address = rs.getString("address");
	                int admin = rs.getInt("adminUserId");
	                double rating = rs.getDouble("rating");
	                String image = rs.getString("imagePath");
	                boolean isActive = rs.getBoolean("isActive");
	                 
	                 r = new Restaurant(Id,name,cuisineType,deliveryTime,address,admin,rating,image,isActive);
	                

	                list.add(r);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }


	@Override
	public Restaurant getRestaurantById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRestaurant(Restaurant r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRestaurant(Restaurant r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRestaurant(int id) {
		// TODO Auto-generated method stub
		
	}

}