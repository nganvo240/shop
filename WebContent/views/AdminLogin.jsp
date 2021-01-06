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
	<jsp:include page="header.jsp"></jsp:include>
		<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Đăng nhập trang Admin</h2>						
						<form method="POST" action="${pageContext.request.contextPath}/Adlogin">
							<input type="text" placeholder="Name" name="useradLogin" />
							<input type="password" placeholder="Password" name="passwordLogin"/>
							<span><input type="checkbox" class="checkbox"> Keep me signed in</span>
							<button type="submit" class="btn btn-default">Login</button>
								<c:if test="${testLogin =='1' }">
									<script type="text/javascript">alert('Tên tài khoản hoặc mật khẩu không đúng');</script>
								</c:if>			
						</form>
					</div><!--/login form-->
				</div>
			<!-- </form> -->
			</div>
		</div>
	</section><!--/form-->
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>