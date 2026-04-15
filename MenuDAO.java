package com.app.DAO;

import java.awt.Menu;
import java.util.List;

import com.app.model.menu;

public interface MenuDAO
{
	 List<menu> getMenuByRestaurantId(int restaurantId);
	 menu getMenuById(int id);
}
