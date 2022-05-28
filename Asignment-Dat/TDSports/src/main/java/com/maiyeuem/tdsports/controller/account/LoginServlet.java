package com.maiyeuem.tdsports.controller.account;

import com.maiyeuem.tdsports.entity.Account;
import com.maiyeuem.tdsports.entity.Category;
import com.maiyeuem.tdsports.model.AccountModel;
import com.maiyeuem.tdsports.model.CategoryModel;
import com.maiyeuem.tdsports.model.MYSQLCategoryModel;
import com.maiyeuem.tdsports.model.MySQLAccountModel;
import com.maiyeuem.tdsports.util.SHA512Hasher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    private AccountModel accountModel;
    private CategoryModel categoryModel;



    public LoginServlet() {
        this.accountModel = new MySQLAccountModel();
        this.categoryModel = new MYSQLCategoryModel();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> listC = categoryModel.findAll();
        req.setAttribute("title","Login");
        req.setAttribute("listC",listC);
        req.getRequestDispatcher("/users/page/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = accountModel.findByUsername(username);

        if (account != null) {
            boolean loginSuccess = SHA512Hasher.checkPassword(account.getPasswordHash(), password, account.getSalt());
            if (!loginSuccess) {
                account.addErrors("username", "Invalid information");
            }
        } else {
            account = new Account();
            account.addErrors("username", "Invalid information");
        }
        if (account.getListErrors().size() > 0) {
            req.setAttribute("account", account);
            req.getRequestDispatcher("/users/page/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("currentLogin", account);

            resp.sendRedirect("/home");
        }
    }
}
