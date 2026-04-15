package com.app.DAOImpls;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.DAO.MenuDAO;
import com.app.model.menu;
import com.util.DBConnection;

public class MenuDAOImpls implements MenuDAO
{

	private static final String GET_BY_MENU = "Select * from menu where restaurantId=?";

	@Override
	public List<menu> getMenuByRestaurantId(int restaurantId) 
	{
		   List<menu> list = new ArrayList<>();
		
		try(Connection con=DBConnection.getConnection();PreparedStatement statement = con.prepareStatement(GET_BY_MENU);)
		{
			menu menu =null;
			statement.setInt(1, restaurantId);
			
			  ResultSet rs = statement.executeQuery();

	            while (rs.next()) 
	            {
	             
	            	int  menuId= rs.getInt("menuId");
	            	 int Id = rs.getInt("restaurantId");
	            	 String itemName = rs.getString("itemName");
	            	 String des = rs.getString("description");
	            	 double price = rs.getDouble("price");
	            	 double rating = rs.getDouble("rating");
	            	 String img = rs.getString("imagePath");
	            	 
	            	 menu = new menu(menuId,Id,itemName,des,price,rating,img);
	            	 
	            	 list.add(menu);
	               

	               
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }


public menu getMenuById(int menuId) {

    menu menu = null;

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement("SELECT * FROM menu WHERE menuId=?")) {

        ps.setInt(1, menuId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            menu = new menu();

            menu.setMenuId(rs.getInt("menuId"));
            menu.setItemName(rs.getString("itemName"));
            menu.setPrice(rs.getDouble("price"));
            menu.setImagePath(rs.getString("imagePath"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return menu;
}
public List<menu> searchMenu(String query) {
    List<menu> list = new ArrayList<>();

    try {
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM menu WHERE itemName LIKE ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + query + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            menu m = new menu();

            m.setMenuId(rs.getInt("menuId"));
            m.setItemName(rs.getString("itemName"));
            m.setPrice(rs.getDouble("price"));
            m.setRating(rs.getDouble("rating"));
            m.setDescription(rs.getString("description"));
            m.setImagePath(rs.getString("imagePath"));
            m.setRestaurantId(rs.getInt("restaurantId"));

            list.add(m);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}


}
