<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng nhập</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
		<section id="form"><!--form-->
		<div class="container">
			<div class="row">
			<%-- <form method="POST" action="${pageContext.request.contextPath}/InsertUser"> --%>
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Đăng nhập tài khoản của bạn</h2>
						<form action="#">
							<input type="text" placeholder="Name" />
							<input type="password" placeholder="Password" />
							<span>
								<input type="checkbox" class="checkbox"> 
								Keep me signed in
							</span>
							<button type="submit" class="btn btn-default">Login</button>
						</form>
					</div><!--/login form-->
				</div>
			<!-- </form> -->
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Sign up!</h2>
						<form method="POST" action="${pageContext.request.contextPath}/InsertUser">
						<!-- <form action="#"> -->
							<input type="text" name="username" placeholder="Name"/>
							<input type="email" name="email" placeholder="Email Address"/>
							<input type="password" name="password" placeholder="Password"/>
							<button type="submit" class="btn btn-default">Sign up</button>
						</form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>