<%@ page import="java.util.List" %>
<%@ page import="com.t2010a.applicationcustomer.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/12/2022
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Customer> listCustomer = (List<Customer>)request.getAttribute("listCustomer");
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../inlclude/head.jsp">
    <jsp:param name="title" value="List customer"/>
</jsp:include>
<body>
<div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <jsp:include page="../inlclude/navbar.jsp"></jsp:include>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:../../partials/_sidebar.html -->
        <jsp:include page="../inlclude/sidebar.jsp"></jsp:include>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title"> Customer Management </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Customer management</a></li>
                            <li class="breadcrumb-item active" aria-current="page">List customers</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">List Customers</h4>
                               <a href="/admin/customers/create" class="btn btn-success">Create customers</a>

                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Name</th>
                                        <th>Phone</th>
                                        <th>Image</th>
                                        <th>Date Of Birth</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <%
                                        for (Customer cs: listCustomer) {
                                    %>
                                    <tr>
                                        <th><%=cs.getId()%></th>
                                        <td><%=cs.getName()%></td>
                                        <td><%=cs.getPhone()%></td>
                                        <td><%=cs.getImage()%></td>
                                        <td><%=cs.getDob()%></td>
                                        <td><label class="badge badge-danger">Pending</label></td>
                                        <td>
                                            <a href="/admin/customers/detail?id=<%=cs.getId()%>"><i class="mdi mdi-glasses size-big"></i></a> |
                                            <a href="/admin/customers/edit?id=<%=cs.getId()%>"> <i class="mdi mdi-border-color size-big"></i></a> |
                                            <a href="/admin/customers/delete?id=<%=cs.getId()%>" onclick="return confirm('Are you sure?')"><i class="mdi mdi-delete size-big"></i></a>
                                        </td>
                                    </tr>

                                    <% }%>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <jsp:include page="../inlclude/footer.jsp"></jsp:include>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<jsp:include page="../inlclude/scripts.jsp"></jsp:include>
</body>
</html>