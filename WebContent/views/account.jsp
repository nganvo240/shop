<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Tài khoản</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
<style type="text/css">
td {
  width: 15em;
  height: 5em;
	
  text-align: right;
  vertical-align: left;
}
.btnSubmit {
	background:#FE980F; 
	color:white;
	border: none;
	width:110px;
	height:40px;
	/* margin: auto; */

	
}
</style> 
</head>
<body>
	<jsp:include page="/header" /> 	
	
		<div class="container">			
			<div class="checkout-options">
				<h2>Hồ Sơ Của Tôi</h2>
				<p>Quản lý thông tin hồ sơ để bảo mật tài khoản</p>
				<ul class="nav">
					<li>
						<label style="color:blue"> Tên đăng nhập: ${usernameLogin}</label>
					</li>
				</ul>
			</div><!--/checkout-options-->

			<div class="shopper-informations">
				<div class="row">					
					<div class="col-sm-9 padding-right">
						<form method="POST" action="${pageContext.request.contextPath}/account?usernameLogin=${usernameLogin}">
								<table border="0" align="center" cellspacing="100px" >
					               <tr>
					                  <td>Tên</td>
					                  <td><input name="name" type="text" placeholder="Tên khách hàng" value="${detailsCustomer.name}"></td>
					               </tr>
					               <tr>
					                  <td>Địa chỉ</td>
					                  <td><input name="address" type="text" placeholder="Địa chỉ" value="${detailsCustomer.address}"></td>
					               </tr>
					               <tr>
					                  <td>SĐT</td>
					                  <td><input name="tel" type="text" placeholder="Số điện thoại" value="${detailsCustomer.tel}"></td>					                  
					               </tr>					               
					               <tr>
					               		<td></td><td></td>
					               		<br>
					               		<td><input class="btnSubmit" type="submit" value="Lưu thay đổi" /></td>
					               		 
					               </tr>
					            </table>							
					        </form>    															
					</div>
									
				</div>
			</div>
			
		</div>

<jsp:include page="/views/footer.jsp"></jsp:include>

    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>