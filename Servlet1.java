package com.app;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.app.DAOImpls.RegisterUserDAOImpls;
import com.app.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")

@WebServlet("/RegisterServlet")
public class Servlet1 extends HttpServlet
{

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	
	{
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String pass = req.getParameter("password");
		
		String hashpw = BCrypt.hashpw(pass, BCrypt.gensalt(12));
		System.out.println(hashpw);
		
		  try {
	            Users users = new Users(name, email, phone, address, hashpw);
	            RegisterUserDAOImpls dao = new RegisterUserDAOImpls();

	            int addUser = dao.getAddUser(users);
	            
	            if(addUser==1)
	            {
	                req.setAttribute("message", "Hi " + name + ", Registration Successful!");
	                resp.sendRedirect("login.jsp");

	            }
	            
	            else
	            {
		            // ❌ Error message
		            req.setAttribute("message", "Registration Failed!");
		            // ✅ Go back to same JSP page
			        req.getRequestDispatcher("user.jsp").forward(req, resp);

	            }
	            
	            

	        
	        } catch (Exception e) {
	            e.printStackTrace();

	          
	        }

	     
	    }
	}