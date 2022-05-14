package com.t2010a.applicationcustomer.controller;

import com.t2010a.applicationcustomer.entity.Customer;
import com.t2010a.applicationcustomer.model.CustomerModel;
import com.t2010a.applicationcustomer.model.MySQLCustomerModel;
import com.t2010a.applicationcustomer.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class EditCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public EditCustomerServlet() {
        this.customerModel = new MySQLCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Customer customer = customerModel.findById(id);
        if (customer==null){
            req.setAttribute("message","Customer not found!");
            req.getRequestDispatcher("/errors/404.jsp").forward(req,resp);
        }else{
            req.setAttribute("customer",customer);
            req.setAttribute("action",2);
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Customer existingCustomer = customerModel.findById(id);
        if (existingCustomer==null){
            req.setAttribute("message","Customer not found!");
            req.getRequestDispatcher("/errors/404.jsp").forward(req,resp);
        }else{
            String name= req.getParameter("name");
            String phone = req.getParameter("phone");
            String image = req.getParameter("image");
            String strBirthday = req.getParameter("birthday");
            System.out.println(name);
            LocalDateTime birthday = DateTimeHelper.convertStringLocalDateTime(strBirthday);
            Customer customer = new Customer(name,phone,image,birthday);
            if (customerModel.update(id,customer)!=null){
                resp.sendRedirect("/admin/customers/list");
            }else{
                req.setAttribute("customer",customer);
                req.setAttribute("action",2);
                req.getRequestDispatcher("/admin/customers/form.jsp").forward(req,resp);

            }
        }
    }
}
