<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
<!-- xử lý thanh cuộn chuyển qua lại các tin (jquery) -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
<style>
body {
  font-family: Arial;
}
* {
  box-sizing: border-box;
}

form.example input[type=text] {
  padding: 10px;
  font-size: 12px;
  border: none;
  float: left;
  height: 25px;
  width: 180px;
  background: #f1f1f1;
}

form.example button {
  float: left;
  height: 25px;
  width: 19%;
  padding-top: 6px;
  background: #FE980F;
  color: white;
  font-size: 12px;
  border: none;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #FE980F;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}
/* số lượng sản phẩm trong giỏ hàng */
.badge:after{
	content:attr(value);
	background-size: 75% 50%;
	font-size:13px;
	background: yellow;
	color: black;
	border-radius:50%;
	padding:3px;
	position:relative;
	left:-8px;
	top:-10px;
	opacity:0.9;

}
</style>
</head>
<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> info@gmail.com</a></li>
								<li><a href="${pageContext.request.contextPath}/Adlogin"><i class="fa fa-lock"></i>Admin</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="https://www.facebook.com/groups/utehcmc"><i class="fa fa-facebook"></i></a></li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-md-4 clearfix">
						<div class="logo pull-left">
							<a href="${pageContext.request.contextPath}/home?usernameLogin=${usernameLogin}"><img src="images/home/logo1.jpg" alt="" /></a>
						</div>					
					</div>
					<form method="GET" action="header">
						<div class="col-md-8 clearfix">
							<div class="shop-menu clearfix pull-right">
								<ul class="nav navbar-nav">								
									<li><a href="${pageContext.request.contextPath}/account?usernameLogin=${usernameLogin}"><i class="fa fa-user" style="color:#FE980F;"></i> <span >${usernameLogin}</span></a></li>																
									<li><a href="${pageContext.request.contextPath}/cart?usernameLogin=${usernameLogin}"><i class="fa badge"  value="${numProduct}" style="font-size:19px; color:#FE980F; background:white;padding:0px;">  &#xf07a;</i></a></li>
									<li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-lock"></i> 
									
										<c:if test="${not empty usernameLogin }">
											Đăng xuất
										</c:if>
										<c:if test="${empty usernameLogin }">
											Đăng nhập
										</c:if>
									</a></li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="${pageContext.request.contextPath}/home?usernameLogin=${usernameLogin}" >Trang chủ</a></li>
								<li><a href="${pageContext.request.contextPath}/product?usernameLogin=${usernameLogin}" >Sản phẩm</a> </li>  
								<li><a href="${pageContext.request.contextPath}/contact?usernameLogin=${usernameLogin}">Liên hệ</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<form method="GET" action="${pageContext.request.contextPath}/searchResultsServlet" class="example" style="margin:auto; max-width:300px">
							  <input type="text" placeholder="Tên sản phẩm..." name="search" value="">
							  <button type="submit"><i class="fa fa-search"></i></button>
							</form>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>