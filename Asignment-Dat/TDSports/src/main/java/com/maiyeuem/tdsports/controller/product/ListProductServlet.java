package com.maiyeuem.tdsports.controller.product;

import com.maiyeuem.tdsports.entity.Product;
import com.maiyeuem.tdsports.model.MYSQLProductModel;
import com.maiyeuem.tdsports.model.ProductModel;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {
    private ProductModel productModel;
    public ListProductServlet() {
        this.productModel = new MYSQLProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productModel.findAll();
        request.setAttribute("title","List Products");
        request.setAttribute("list",list);
        request.getRequestDispatcher("/admin/products/list.jsp").forward(request,response);
    }
}
