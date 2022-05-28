<%@ page import="com.maiyeuem.tdsports.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/25/2022
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%
  List<Product> products = (List<Product>) request.getAttribute("products");
  if (products==null){
    products = new ArrayList<>();
  }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  for (int i = 0; i < products.size(); i++) {
    Product product = products.get(i);
%>
<div class="card product-item border-0 mb-4">
  <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
    <img class="img-fluid w-100" src="<%=product.getImage()%>" alt="">
  </div>
  <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
    <h6 class="text-truncate mb-3"><%=product.getName()%>></h6>
    <div class="d-flex justify-content-center">
      <h6>$<%=product.getPrice()%></h6><h6 class="text-muted ml-2"><del>$<%=product.getPrice()%>0</del></h6>
    </div>
  </div>
  <div class="card-footer d-flex justify-content-between bg-light border">
    <a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
    <a href="/cart/add?productId=<%=product.getId()%>&quantity=1" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
  </div>
</div>
<%
  }%>