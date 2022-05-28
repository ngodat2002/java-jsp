<%@ page import="java.util.List" %>
<%@ page import="com.maiyeuem.tdsports.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.maiyeuem.tdsports.entity.Category" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/21/2022
  Time: 4:42 PM
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
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/users/includes/head.jsp">
    <jsp:param name="title" value="Product"/>
</jsp:include>

<body>
<jsp:include page="/users/includes/topbar.jsp"></jsp:include>

<!-- Navbar Start -->
<div class="container-fluid">
    <div class="row border-top px-xl-5">
        <div class="col-lg-3 d-none d-lg-block">
            <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                <h6 class="m-0">Categories</h6>
                <i class="fa fa-angle-down text-dark"></i>
            </a>
            <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                <jsp:include page="/users/includes/collsapeAllPage.jsp"></jsp:include>
                </div>
            </nav>
        </div>
        <div class="col-lg-9">
            <jsp:include page="/users/includes/navbar.jsp"></jsp:include>
        </div>
    </div>
</div>
<!-- Navbar End -->


<!-- Page Header Start -->
<div class="container-fluid bg-secondary mb-5">
    <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
        <h1 class="font-weight-semi-bold text-uppercase mb-3">Our Shop</h1>
        <div class="d-inline-flex">
            <p class="m-0"><a href="">Home</a></p>
            <p class="m-0 px-2">-</p>
            <p class="m-0">Shop</p>
        </div>
    </div>
</div>
<!-- Page Header End -->


<!-- Shop Start -->
<div class="container-fluid pt-5">
    <div class="row px-xl-5">
        <!-- Shop Sidebar Start -->
        <div class="col-lg-3 col-md-12">
            <!-- Price Start -->
            <div class="border-bottom mb-4 pb-4">
                <h5 class="font-weight-semi-bold mb-4">Filter by Categories</h5>

                <form>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" class="custom-control-input" checked id="price-all">
                        <label class="custom-control-label" for="price-all">All Categories</label>

                    </div>

                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" class="custom-control-input" id="price-1">
                        <label class="custom-control-label" for="price-1">$0 - $100</label>

                    </div>

                    </form>
            </div>
            <!-- Price End -->

        </div>
        <!-- Shop Sidebar End -->


        <!-- Shop Product Start -->
        <div class="col-lg-9 col-md-12">
            <div class="row pb-3">
                <div class="col-12 pb-1">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <form action="/search" method="get">
                            <div class="input-group">
                                <input type="text" name="search" class="form-control" placeholder="Search by name">
                                <div class="input-group-append">
                                        <button type="submit" class="input-group-text bg-transparent text-primary">
                                            <i class="fa fa-search"></i>
                                        </button>
                                </div>
                            </div>
                        </form>
                        <div class="dropdown ml-4">
                            <button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                Sort by
                            </button>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                                <a class="dropdown-item" href="#">Latest</a>
                                <a class="dropdown-item" href="#">Popularity</a>
                                <a class="dropdown-item" href="#">Best Rating</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                %>

                <div class="col-lg-4 col-md-6 col-sm-12 pb-1 h-50">
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
                            <a href="/product/detail?id=<%=product.getId()%>" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                            <a href="/cart/add?productId=<%=product.getId()%>&quantity=1" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                        </div>
                    </div>
                </div>
                <%
                    }%>

                <div class="col-12 pb-1">
                    <nav aria-label="Page navigation">
                        <ul class="pagination justify-content-center mb-3">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>


                            <li class="page-item"><a class="page-link" href="#">1</a></li>

                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Shop Product End -->
    </div>
</div>
<!-- Shop End -->

<jsp:include page="/users/includes/footer.jsp"></jsp:include>

<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


<jsp:include page="/users/includes/script.jsp"></jsp:include>
</body>

</html>