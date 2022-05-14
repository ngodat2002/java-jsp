package com.t2010a.applicationcustomer.controller;

import com.t2010a.applicationcustomer.entity.Customer;
import com.t2010a.applicationcustomer.model.CustomerModel;
import com.t2010a.applicationcustomer.model.MySQLCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;


    public DeleteCustomerServlet() {
        this.customerModel = new MySQLCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerModel.findById(id);
        if (customer == null){
            req.setAttribute("message","Customer not found!");
            req.getRequestDispatcher("errors/404.jsp").forward(req,resp);

        }else {
            boolean result = customerModel.delete(id);
            if (result){
                resp.sendRedirect("/admin/customers/list");
            }else {
                req.setAttribute("message","Action fails");
                req.getRequestDispatcher("errors/500.jsp").forward(req,resp);
            }
        }
    }
}
