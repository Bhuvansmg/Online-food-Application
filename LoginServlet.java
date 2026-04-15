package com.app;

import java.io.IOException;


import org.mindrot.jbcrypt.BCrypt;

import com.app.DAOImpls.RegisterUserDAOImpls;
import com.app.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException 
    {
        String username = req.getParameter("email");
        String pass = req.getParameter("password");

        HttpSession session = req.getSession();

        RegisterUserDAOImpls dao = new RegisterUserDAOImpls();
        Users users = dao.validation(username);

//        System.out.println("Email: " + username);
//        System.out.println("Password: " + pass);

        if (users != null) 
        {
            String dbpassword = users.getPassword();

            if (BCrypt.checkpw(pass, dbpassword)) 
            {
                session.setAttribute("user", users);

                String role = users.getRole();
                session.setAttribute("role", role);

                if("admin".equals(role)) {
                    resp.sendRedirect("Admin/adminDashboard.jsp");
                } else {
                    resp.sendRedirect("restaurantServlet");
                }
            } 
            else 
            {
                req.setAttribute("error", "Invalid Password");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
    }
}