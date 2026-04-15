package com.app;

import java.io.IOException;
import java.sql.Timestamp;

import com.app.DAOImpls.OrderDAOImpls;
import com.app.DAOImpls.OrderItemDAOImpl;
import com.app.model.Cart;
import com.app.model.CartItem;
import com.app.model.OrderItems;
import com.app.model.Orders;
import com.app.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        Users user = (Users) session.getAttribute("user");
        Integer restaurantId = (Integer) session.getAttribute("restaurantId");

        String address = req.getParameter("address");
        String payment = req.getParameter("paymentMode");

        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        if (cart == null || cart.getItems().isEmpty() || restaurantId == null) {
            resp.sendRedirect("restaurantServlet");
            return;
        }

        double totalAmount = 0;

        for (CartItem item : cart.getItems().values()) {
            totalAmount += item.getCartPrice() * item.getCartQuantity();
        }

        Orders order = new Orders(
                user.getUserId(),
                restaurantId,
                new Timestamp(System.currentTimeMillis()),
                payment,
                address,
                "pending",
                totalAmount
        );

        OrderDAOImpls orderDAO = new OrderDAOImpls();
        int orderId = orderDAO.insertOrder(order);

        OrderItemDAOImpl itemDAO = new OrderItemDAOImpl();

        for (CartItem item : cart.getItems().values()) {

            int menuId = item.getCartItemId();
            double price = item.getCartPrice();
            int quantity = item.getCartQuantity();

            double totalPrice = price * quantity;

            OrderItems orderItem = new OrderItems(orderId, menuId, quantity, totalPrice);
            itemDAO.addOrderItem(orderItem);
        }

        // ✅ Clear cart
        session.removeAttribute("cart");

        // ✅ Redirect success page
        resp.sendRedirect("OrderSucess.jsp");
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
 