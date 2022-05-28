package com.maiyeuem.tdsports.controller.product;

import com.maiyeuem.tdsports.entity.Product;
import com.maiyeuem.tdsports.entity.shoppingcart.ShoppingCart;
import com.maiyeuem.tdsports.model.MYSQLProductModel;
import com.maiyeuem.tdsports.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddCartServlet extends HttpServlet {
    private ProductModel productModel;
    public AddCartServlet(){
        this.productModel = new MYSQLProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart =(ShoppingCart) session.getAttribute("shoppingCart");
        if (shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }

        try {
            int productId = Integer.parseInt(req.getParameter("productId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            Product product=  productModel.findById(productId);
            if (product== null){
                req.getRequestDispatcher("/errors/404.jsp").forward(req,resp);
                return;
            }
            if (quantity<=0){
                req.getRequestDispatcher("/errors/404.jsp").forward(req,resp);
                return;
            }
            shoppingCart.add(product,quantity);
            session.setAttribute("shoppingCart",shoppingCart);
            resp.sendRedirect("/cart/show");
        }catch (Exception ex){
            ex.printStackTrace();
            req.getRequestDispatcher("/errors/500.jsp").forward(req,resp);
        }
    }
}
