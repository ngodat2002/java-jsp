package com.maiyeuem.tdsports.controller.product;

import com.maiyeuem.tdsports.entity.Category;
import com.maiyeuem.tdsports.entity.shoppingcart.CartItem;
import com.maiyeuem.tdsports.entity.shoppingcart.ShoppingCart;
import com.maiyeuem.tdsports.model.CategoryModel;
import com.maiyeuem.tdsports.model.MYSQLCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowCartServlet extends HttpServlet {
    private CategoryModel categoryModel;
    public  ShowCartServlet(){
        this.categoryModel= new MYSQLCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title","Shopping cart");
        List<Category> listC = categoryModel.findAll();
        req.setAttribute("listC",listC);
        req.getRequestDispatcher("/users/page/shopping-cart.jsp").forward(req,resp);
    }

}
