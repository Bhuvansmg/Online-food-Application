package com.app;

import java.io.IOException;
import java.util.List;

import com.app.DAOImpls.MenuDAOImpls;
import com.app.model.menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1️⃣ Get search text
        String query = req.getParameter("query");

        // 2️⃣ Call DAO
        MenuDAOImpls dao = new MenuDAOImpls();
        List<menu> results = dao.searchMenu(query);

        // 3️⃣ Send results to JSP
        req.setAttribute("menuList", results);
        req.setAttribute("searchQuery", query);



        // 4️⃣ Forward to result page (reuse menu.jsp or create search.jsp)
        req.getRequestDispatcher("menu.jsp").forward(req, resp);
    }
}