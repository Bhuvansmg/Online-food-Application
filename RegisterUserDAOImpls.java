package com.app.DAOImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import com.app.DAO.RegisterUserDAO;

import com.app.model.Users;
import com.util.DBConnection;

public class RegisterUserDAOImpls implements RegisterUserDAO
{

	private static final String INSERT_USERS  =" insert into users (username, password,email,phone,address,createdDate, lastLoginDate,role) values(?,?,?,?,?,?,?,?)";
	private static final   String Verify_users = "SELECT * FROM users WHERE email=? AND password=?";

	@Override
	public int getAddUser(Users u) 
	{
		int affectedRows=0 ;
		
		try(Connection con=DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(INSERT_USERS, Statement.RETURN_GENERATED_KEYS);) 
		{
			
			pstmt.setString(1, u.getUserName());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getPhoneNumber());
			pstmt.setString(5, u.getAddress());
			pstmt.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(7,new Timestamp(System.currentTimeMillis()));
			pstmt.setString(8, u.getRole());
			
			affectedRows = pstmt.executeUpdate();
			
			 if (affectedRows == 0) {
		            throw new SQLException("Creating user failed, no rows affected.");
		        }

		        try (ResultSet rs = pstmt.getGeneratedKeys()) {
		            if (rs.next()) {
		                u.setUserId(rs.getInt(1));
		            }
		        }

		    } catch (SQLException e) {
		        throw new RuntimeException("Error adding user", e);
		    }
		
		return affectedRows;
		
}

	@Override
	public Users getUser(int userId) {
		
		return null;
	}

	@Override
	public void updateUser(Users u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Users> getALLUsers() 
	{
		
		return null;
	}

	@Override
	public Users userLogin(String email, String password) 
	{

	    Users user = null;

	    try {
	        Connection con = DBConnection.getConnection();

	        

	        PreparedStatement ps = con.prepareStatement(Verify_users);
	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if(rs.next()) {
	            user = new Users(
	                rs.getString("name"),
	                rs.getString("email"),
	                rs.getString("phoneNumber"),
	                rs.getString("address"),
	                rs.getString("password")
	            );
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
		
	}

	@Override
	public void addUser(Users u) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public Users validation(String email) {
	    String SQL = "SELECT * FROM users WHERE email=?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(SQL)) 
	    {
	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return mapResultSetToUser(rs);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public Users mapResultSetToUser(ResultSet rs)
	{
	    Users users = null;

	    try {
	        users = new Users();   // ✅ directly create object

	        users.setUserId(rs.getInt("userId"));
	        users.setName(rs.getString("username"));
	        users.setEmail(rs.getString("email"));
	        users.setPassword(rs.getString("password"));
	        users.setPhoneNumber(rs.getString("phone"));
	        users.setAddress(rs.getString("address"));
	        users.setCreatedDate(rs.getTimestamp("createdDate"));
	        users.setLastLogin(rs.getTimestamp("lastLoginDate"));
	        users.setRole(rs.getString("role"));

	    } catch (SQLException e) {
	        throw new RuntimeException("Error retrieving user", e);
	    }

	    return users;
	}
	
	

}
