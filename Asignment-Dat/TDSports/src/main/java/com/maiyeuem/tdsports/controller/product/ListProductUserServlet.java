package com.maiyeuem.tdsports.controller.product;

import com.maiyeuem.tdsports.entity.Category;
import com.maiyeuem.tdsports.entity.Product;
import com.maiyeuem.tdsports.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductUserServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;
    public ListProductUserServlet(){
        this.productModel= new MYSQLProductModel();
        this.categoryModel= new MYSQLCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productModel.findAll();
        List<Category> listC = categoryModel.findAll();

        req.setAttribute("title","Product Detail");
        req.setAttribute("products",products);
        req.setAttribute("listC",listC);
        req.getRequestDispatcher("/users/page/products.jsp").forward(req,resp);

    }
}
