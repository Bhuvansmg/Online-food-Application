package com.app.DAO;

import java.util.List;

import com.app.model.Users;

public interface RegisterUserDAO 
{
	
	void addUser(Users u);
	Users getUser(int userId);
	void updateUser(Users u);
	void deleteUser(int userId);
	List<Users>getALLUsers();
	
	Users userLogin(String email, String password);
	int getAddUser(Users u);
	Users validation(String email);
	
	
}
