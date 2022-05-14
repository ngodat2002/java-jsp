package com.t2010a.applicationcustomer.controller;

import com.t2010a.applicationcustomer.entity.Customer;
import com.t2010a.applicationcustomer.model.CustomerModel;
import com.t2010a.applicationcustomer.model.MySQLCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;
    public DetailCustomerServlet(){
        this.customerModel= new MySQLCustomerModel();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int Id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerModel.findById(Id);
        if (customer==null){
            req.setAttribute("message","Customer not found!");
            req.getRequestDispatcher("/errors/404.jsp").forward(req,resp);
        }else {
            req.setAttribute("customer",customer);
            req.getRequestDispatcher("/admin/customers/detail.jsp").forward(req,resp);
        }
    }
}
