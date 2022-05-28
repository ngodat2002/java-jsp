package com.maiyeuem.tdsports.controller;

import com.maiyeuem.tdsports.entity.Category;
import com.maiyeuem.tdsports.entity.Product;
import com.maiyeuem.tdsports.model.CategoryModel;
import com.maiyeuem.tdsports.model.MYSQLCategoryModel;
import com.maiyeuem.tdsports.model.MYSQLProductModel;
import com.maiyeuem.tdsports.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeUserServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;
    public HomeUserServlet(){
        this.productModel= new MYSQLProductModel();
        this.categoryModel = new MYSQLCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productModel.findAll();
        List<Category> listC = categoryModel.findAll();
        req.setAttribute("title","Home");
        req.setAttribute("products",products);
        req.setAttribute("listC",listC);
        req.getRequestDispatcher("/users/page/home.jsp").forward(req,resp);
    }
}
