package com.t2010a.applicationcustomer.controller;

import com.sun.javafx.binding.StringFormatter;
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

public class CreateCustomerServlet  extends HttpServlet {
    private CustomerModel customerModel;
    public CreateCustomerServlet(){
        this.customerModel=new MySQLCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customer",new Customer());
        req.setAttribute("action",1);
        req.getRequestDispatcher("/admin/customers/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //xu li validate va save
        String name= req.getParameter("name");
        String phone = req.getParameter("phone");
        String image = req.getParameter("image");
        String strBirthday = req.getParameter("birthday");
        System.out.println(name);
        LocalDateTime birthday = DateTimeHelper.convertStringLocalDateTime(strBirthday);
        Customer customer=  new Customer(name,phone,image,birthday);
        if (customerModel.save(customer)!=null){
            resp.sendRedirect("/admin/customers/list");
        }else {
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req,resp);
        }


    }
}
