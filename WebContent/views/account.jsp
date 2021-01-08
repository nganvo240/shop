<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
</head>
<body>
	<jsp:include page="/header" /> 	

	<section id="cart_items">
		<div class="container">				
			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-3">
						<div class="shopper-info">
										<p>Thông tin khách hàng:</p>			
						</div>
					</div>
					<div class="col-sm-5 clearfix">
						<div class="bill-to">						
							<div class="form-one">							
								<form>
								<input type="text" placeholder="Tên đăng nhập">
								<input type="password" placeholder="Mật khẩu">
								<input type="password" placeholder="Nhập lại mật khẩu">
															
								</form>
								<a class="btn btn-primary" href="">Lưu thay đổi</a><br><br><br>
							</div>
							<div class="form-two">
							<form>
									<input type="text" placeholder="Tên khách hàng">
									<input type="text" placeholder="Email">	
									<input type="text" placeholder="Số điện thoại*">		
								</form>
							</div>
						</div>
					</div>
								
				</div>
			</div>
			
		</div>
	</section> <!--/#cart_items-->

<jsp:include page="/views/footer.jsp"></jsp:include>

    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>