<%@ page import="com.maiyeuem.tdsports.entity.Account" %><%
    Account currentLogin = (Account) session.getAttribute("currentLogin");
%>
<nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
    <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
        <a class="navbar-brand brand-logo" href="/admin/auth/home"><img src="../assets/images/logo.svg" alt="logo" /></a>
        <a class="navbar-brand brand-logo-mini" href="/admin/auth/home"><img src="../assets/images/logo-mini.svg" alt="logo" /></a>
    </div>
    <div class="navbar-menu-wrapper d-flex align-items-stretch">
        <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
            <span class="mdi mdi-menu"></span>
        </button>
        <div class="search-field d-none d-xl-block">
            <form class="d-flex align-items-center h-100" action="#">
                <div class="input-group">
                    <div class="input-group-prepend bg-transparent">
                        <i class="input-group-text border-0 mdi mdi-magnify"></i>
                    </div>
                    <input type="text" class="form-control bg-transparent border-0" placeholder="Search products">
                </div>
            </form>
        </div>
        <%
            if(currentLogin != null){

        %>
        <ul class="navbar-nav navbar-nav-right">
            <li class="nav-item nav-profile dropdown">
                <a class="nav-link dropdown-toggle" id="profileDropdown" href="#" data-bs-toggle="dropdown" aria-expanded="false">

                    <div class="nav-profile-text">
                        <p class="mb-1 text-black"><%=currentLogin.getUsername()%></p>
                    </div>
                </a>
                <div class="dropdown-menu navbar-dropdown dropdown-menu-right p-0 border-0 font-size-sm" aria-labelledby="profileDropdown" data-x-placement="bottom-end">
                    <div class="p-2">
                        <h5 class="dropdown-header text-uppercase  ps-2 text-dark mt-2">Actions</h5>
                        <a class="dropdown-item py-1 d-flex align-items-center justify-content-between" href="/logout">
                            <span>Log Out</span>
                            <i class="mdi mdi-logout ms-1"></i>
                        </a>
                    </div>
                </div>
            </li>
        </ul>
        <%}else{%>
        <a class="btn btn-primary" href="/login">Log In</a>
        <a class="btn btn-behance" href="/register">Register</a>
        <%}%>


        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
            <span class="mdi mdi-menu"></span>
        </button>

    </div>
</nav>