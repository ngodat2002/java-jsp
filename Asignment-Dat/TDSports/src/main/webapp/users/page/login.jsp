<%@ page import="com.maiyeuem.tdsports.entity.Account" %>
<%@ page import="com.maiyeuem.tdsports.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/24/2022
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    Account account = (Account) request.getAttribute("account");
    if(account == null){
        account = new Account();
    }
%>
<style>
    .error_code {
        color: #0d0d0d;
        font-size: 14px;
        border-top: 2px solid red;
        background: #f5f5f5;
        padding: 23px 30px 18px;
        margin-bottom: 50px;
    }
    .error_code ul {
        margin-left: 20px;
        margin-top: 10px;
    }
    .login-top{
        margin-top: 200px;
    }
</style>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/users/includes/head.jsp">
    <jsp:param name="title" value="Login"/>
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
        <h1 class="font-weight-semi-bold text-uppercase mb-3">Login</h1>
        <div class="d-inline-flex">
            <p class="m-0"><a href="">Home</a></p>
            <p class="m-0 px-2">-</p>
            <p class="m-0">Login</p>
        </div>
    </div>
</div>
<!-- Page Header End -->

<!-- Checkout Start -->
<div class="container-fluid">
    <div class="row px-xl-5">

        <div class="col-lg-6 login-top">
            <div class="mb-4 m4-5">
                <h4 class="font-weight-semi-bold mb-4">Login Account</h4>
                <form action="/login" method="post">
                    <%
                        if(account.getListErrors().size() > 0){
                    %>
                    <h6 class="error_code">

                        Please enter information below
                        <ul>
                            <%for (int i = 0; i < account.getListErrors().size(); i++) {
                            %>
                            <li><%=account.getListErrors().get(i)%></li>
                            <%
                                }%>
                        </ul>
                    </h6>
                    <%}%>
                    <div class="row">
                        <div class="col-md-8 form-group">
                            <label>Username*</label>
                            <input class="form-control" type="text" placeholder="Enter username" name="username">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8 form-group">
                            <label>Password*</label>
                            <input class="form-control" name="password" type="password" placeholder="Enter password">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <button type="submit" class="btn btn-primary py-2 px-4">Login</button>
                            <button type="reset" class="btn btn-primary py-2 px-4">Reset</button>

                        </div>
                    </div>
                </form>
            </div>

        </div>
        
        <div class="col-lg-6">
            <div>
                <img class="img-fluid" src="/users/img/banner.jpg" alt="">
            </div>
        </div>

    </div>
</div>
<!-- Checkout End -->

<jsp:include page="/users/includes/footer.jsp"></jsp:include>
<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


<!-- JavaScript Libraries -->
<jsp:include page="/users/includes/script.jsp"></jsp:include>
</body>

</html>