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
import java.util.HashMap;

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
        Customer customer=  new Customer(name,phone,image);
        HashMap<String, String> errors = new HashMap<>();
        if (strBirthday != null && strBirthday.length()>0){
            LocalDateTime birthday = DateTimeHelper.convertStringLocalDateTime(strBirthday);
            customer.setDob(birthday);
        }
        //validate du lieu theo kieu cui bap
        if (name == null || name.length()==0){
            errors.put("name","Please enter name");
        }
        if (phone == null || phone.length()==0){
            errors.put("phone","Please enter phone");
        }
        if (image == null || image.length()==0){
            errors.put("image","Please enter image");
        }
        if (errors.size() >0){
            req.setAttribute("customer",customer);
            req.setAttribute("action",1);
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req,resp);
            return;
        }
        if (customerModel.save(customer)!=null){
            resp.sendRedirect("/admin/customers/list");
        }else {
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req,resp);
        }


    }
}
