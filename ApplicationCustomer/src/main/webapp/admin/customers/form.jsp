<%@ page import="com.t2010a.applicationcustomer.entity.Customer" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/12/2022
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
    int action = (int) request.getAttribute("action");
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors") ;
    String url = "/admin/customers/create";
    String title = "Create Customer";
    if(action == 2){
        title="Edit Customer";
        url = "/admin/customers/edit";
    }
    if (errors == null){
        errors = new HashMap<>();
    }

%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../inlclude/head.jsp">
        <jsp:param name="title" value="List customer"/>
</jsp:include>
<body>
<div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <jsp:include page="../inlclude/navbar.jsp"/>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:../../partials/_sidebar.html -->
        <jsp:include page="../inlclude/sidebar.jsp"/>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <%
                    if(errors != null && errors.size() > 0){
                %>
                <div class="row">
                    <div class="col-12">
                        <div class="callout callout-danger">
                            <p class="text-danger fs-6">Please fix error below</p>
                            <ul>
                                <%
                                    for (String msg: errors.values()){
                                %>
                                <li class="text-danger"><%=msg%></li>
                                <%
                                    }
                                %>
                            </ul>
                        </div>
                    </div>
                </div>
                <%}%>
                <div class="page-header">
                    <h3 class="page-title"> Customers Management </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Customers management</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><%=title%></li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h3 class="card-title"><%=title%></h3>
                                <form class="forms-sample" action="<%=url%>" method="post">
                                    <div class="form-group">
                                        <input type="hidden" name="id" value="<%=customer.getId()%>" class="form-control" placeholder="Username">

                                    </div>
                                    <div class="form-group">
                                        <label>Name</label>
                                        <input type="text" name="name" value="<%=customer.getName()%>" class="form-control" placeholder="Enter name">
                                        <%
                                            if (errors.containsKey("name")){%>
                                                <span class="text-danger">* <%=errors.get("name")%></span>
                                            <%}%>
                                    </div>
                                    <div class="form-group">
                                        <label>Phone</label>
                                        <input type="text" name="phone" value="<%=customer.getPhone()%>" class="form-control" placeholder="Enter phone">
                                        <%
                                            if (errors.containsKey("phone")){%>
                                        <span class="text-danger">* <%=errors.get("phone")%></span>
                                        <%}%>
                                    </div>

                                    <div class="form-group">
                                        <label>Image</label>
                                        <input type="text" name="image" value="<%=customer.getImage()%>" class="form-control"  placeholder="Enter image">
                                        <%
                                            if (errors.containsKey("image")){%>
                                        <span class="text-danger">* <%=errors.get("image")%></span>
                                        <%}%>
                                    </div>
                                    <div class="form-group">
                                        <label>Dob</label>
                                        <input type="date" class="form-control" name="birthday" value="<%=customer.getDobString()%>">
                                        <%
                                            if (errors.containsKey("birthday")){%>
                                        <span class="text-danger">* <%=errors.get("birthday")%></span>
                                        <%}%>
                                    </div>

                                    <button type="submit" class="btn btn-primary me-2">Submit</button>
                                    <a href="/admin/customers/list" class="btn btn-light">Cancel</a>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <jsp:include page="../inlclude/footer.jsp"/>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<jsp:include page="../inlclude/scripts.jsp"/>
</body>
</html>