<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Đăng nhập tài khoản của bạn</h2>						
						<form method="POST" action="${pageContext.request.contextPath}/login">
							<input type="text" placeholder="Name" name="usernameLogin" />
							<input type="password" placeholder="Password" name="passwordLogin"/>
							<span><input type="checkbox" class="checkbox">Ghi nhớ</span>
							<button type="submit" class="btn btn-default">Đăng nhập</button>
							<c:set var="usernameLogin" value="${usernameLogin}" />
								<c:if test="${testLogin =='1' }">
									<script type="text/javascript">alert('Tên tài khoản hoặc mật khẩu không đúng');</script>
								</c:if>			
						</form>
					</div><!--/login form-->
				</div>
			<!-- </form> -->
				<div class="col-sm-1">
					<h2 class="or">hoặc</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>Đăng ký tài khoản mới!</h2>
						<form method="POST" action="${pageContext.request.contextPath}/register">
							<input type="text" name="usernameRegister" placeholder="Name"/>
							<input type="email" name="emailRegister" placeholder="Email Address"/>
							<input type="password" name="passwordRegister" placeholder="Password"/>
							<button type="submit" class="btn btn-default">Đăng ký</button>
							<c:choose>
								<c:when test="${testRegister =='2' }">
									<script type="text/javascript">alert('Đăng ký thành công');</script>
								</c:when>
								<c:when test="${testRegister =='1' }">
									<script type="text/javascript">alert('Tài khoản đã tồn tại');</script>
								</c:when>
							</c:choose>							
						</form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>