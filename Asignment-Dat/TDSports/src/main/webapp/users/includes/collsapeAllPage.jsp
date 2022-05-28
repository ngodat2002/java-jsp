<%@ page import="com.maiyeuem.tdsports.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/26/2022
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    List<Category> listC = (List<Category>) request.getAttribute("listC");
    if (listC==null){
        listC = new ArrayList<>();
    }
%>

<%
    for (int i = 0; i < listC.size(); i++) {
        Category category = listC.get(i);
%>

<a href="/products/category?cid=<%=category.getId()%>" class="nav-item nav-link"><%=category.getName()%></a>

<%}%>