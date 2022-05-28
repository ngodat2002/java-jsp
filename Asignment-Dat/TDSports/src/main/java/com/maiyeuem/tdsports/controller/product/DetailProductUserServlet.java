package com.maiyeuem.tdsports.controller.product;

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

public class DetailProductUserServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;
    public DetailProductUserServlet(){
        this.productModel = new MYSQLProductModel();
        this.categoryModel = new MYSQLCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        List<Category> listC = categoryModel.findAll();
        if (product==null){
            req.setAttribute("message","Product not found!");
            req.getRequestDispatcher("/errors/404.jsp");
        }else {
            req.setAttribute("title","Product Detail");
            req.setAttribute("product",product);
            req.setAttribute("listC",listC);
            req.getRequestDispatcher("/users/page/product-detail.jsp").forward(req,resp);
        }
    }
}
