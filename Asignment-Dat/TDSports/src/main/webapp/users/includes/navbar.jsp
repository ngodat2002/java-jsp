<%@ page import="com.maiyeuem.tdsports.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/25/2022
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    Account currentLogin = (Account) session.getAttribute("currentLogin");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
    <a href="/home" class="text-decoration-none d-block d-lg-none">
        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">TADA</span>Shopper</h1>
    </a>
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
        <div class="navbar-nav mr-auto py-0">
            <a href="/home" class="nav-item nav-link active">Home</a>
            <a href="/products" class="nav-item nav-link">Shop</a>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                <div class="dropdown-menu rounded-0 m-0">
                    <a href="/cart/show" class="dropdown-item">Shopping Cart</a>
                    <a href="#" class="dropdown-item">Checkout</a>
                </div>
            </div>
            <a href="/contact" class="nav-item nav-link">Contact</a>
        </div>
        <div class="navbar-nav ml-auto py-0">
            <%
                if(currentLogin != null){
            %>
            <a class="nav-item nav-link" href="/profile"><%=currentLogin.getUsername()%></a>
            <a class="nav-item nav-link" href="/logout">Log Out</a>
            <%}else{%>
            <a class="nav-item nav-link" href="/login">Log In</a>
            <a class="nav-item nav-link" href="/register">Register</a>
            <%}%>
        </div>
    </div>
</nav>