package com.maiyeuem.tdsports.controller.account;

import com.maiyeuem.tdsports.entity.Category;
import com.maiyeuem.tdsports.model.*;
import com.maiyeuem.tdsports.entity.Account;
import com.maiyeuem.tdsports.model.AccountModel;
import com.maiyeuem.tdsports.model.MySQLAccountModel;
import com.maiyeuem.tdsports.util.SHA512Hasher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegisterServlet extends HttpServlet {
    private AccountModel accountModel;
    private CategoryModel categoryModel;
    public RegisterServlet(){
        this.accountModel= new MySQLAccountModel();
        this.categoryModel = new MYSQLCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> listC = categoryModel.findAll();
        req.setAttribute("account", new Account());
        req.setAttribute("listC",listC);
        req.getRequestDispatcher("/users/page/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setPasswordConfirm(confirmPassword);
        account.setEmail(email);
        account.setPhone(phone);
        if (accountModel.findByUsername(username) != null) {
            account.addErrors("username", "Username is exist.");
        }
        if (accountModel.findByEmail(email) != null) {
            account.addErrors("email", "Email is exist.");
        }
        if (account.isValid()) {
            account.setSalt(SHA512Hasher.randomString(10));
            account.setPasswordHash(SHA512Hasher.encode(account.getPassword(), account.getSalt()));
            accountModel.save(account);
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("title","Register");
            req.setAttribute("account", account);

            req.getRequestDispatcher("/users/page/register.jsp").forward(req, resp);
        }
    }
}
