package com.maiyeuem.tdsports.controller;

import com.maiyeuem.tdsports.entity.Category;
import com.maiyeuem.tdsports.model.CategoryModel;
import com.maiyeuem.tdsports.model.MYSQLCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ContactServlet extends HttpServlet {
    private CategoryModel categoryModel;
    public ContactServlet(){
        this.categoryModel = new MYSQLCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> listC = categoryModel.findAll();
        req.setAttribute("title","Contact");
        req.setAttribute("listC",listC);
        req.getRequestDispatcher("/users/page/contact.jsp").forward(req,resp);
    }
}
