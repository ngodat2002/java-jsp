<%@ page import="com.maiyeuem.tdsports.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.maiyeuem.tdsports.entity.Category" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/25/2022
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Product> products = (List<Product>) request.getAttribute("products");
  if (products==null){
    products = new ArrayList<>();
  }
  List<Category> listC = (List<Category>) request.getAttribute("listC");
  if (listC==null){
    listC = new ArrayList<>();
  }
%>
<div class="col-lg-3 d-none d-lg-block">
  <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
    <h6 class="m-0">Categories</h6>
    <i class="fa fa-angle-down text-dark"></i>
  </a>
  <nav class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0" id="navbar-vertical">
    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
      <%
        for (int i = 0; i < listC.size(); i++) {
          Category category = listC.get(i);
      %>

      <a href="/products/category?cid=<%=category.getId()%>" class="nav-item nav-link"><%=category.getName()%></a>

      <%}%>
    </div>
  </nav>
</div>