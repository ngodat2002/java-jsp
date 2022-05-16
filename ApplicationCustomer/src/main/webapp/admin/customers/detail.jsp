<%@ page import="com.t2010a.applicationcustomer.entity.Customer" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../inlclude/head.jsp"></jsp:include>
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
                    <h3 class="page-title"> Customers Management </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Customers management</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Customer detail</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h3 class="card-title">Customer Detail</h3>
                                <p class="text-success fs-6">CustomerId: <%=customer.getId()%></p>
                                <p class="text-success fs-6">Name: <%=customer.getName()%></p>
                                <p class="text-success fs-6">Phone: <%=customer.getPhone()%></p>
                                <p class="text-success fs-6">Image: <%=customer.getImage()%></p>
                                <p class="text-success fs-6">DOB: <%=customer.getDob()%></p>
                                <a href="/admin/customers/list" class="btn btn-light">Back to list</a>
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