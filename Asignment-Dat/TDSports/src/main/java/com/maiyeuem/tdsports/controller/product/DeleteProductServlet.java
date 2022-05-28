package com.maiyeuem.tdsports.controller.product;

import com.maiyeuem.tdsports.entity.Product;
import com.maiyeuem.tdsports.model.MYSQLProductModel;
import com.maiyeuem.tdsports.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {
    private ProductModel productModel;
    public DeleteProductServlet(){
        this.productModel = new MYSQLProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productModel.findById(id);
        if (product==null){
            request.setAttribute("message","Product not found!");
            request.getRequestDispatcher("errors/404.jsp").forward(request,response);
        }else{
            boolean result = productModel.delete(id);
            if (result){
                response.sendRedirect("/admin/products/list");
            }else {
                request.setAttribute("message","Action fails");
                request.getRequestDispatcher("errors/500.jsp").forward(request,response);
            }
        }
    }

}
