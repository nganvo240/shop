<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Trang chủ</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
<!-- xử lý thanh cuộn chuyển qua lại các tin (jquery) -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</head>
<body>
	<jsp:include page="/views/header.jsp"></jsp:include>
	<%-- <jsp:include page="slider.jsp"></jsp:include> --%>
	 <jsp:include page="SlideListServlet" /> 
	
	
	     <%--  <a href="${pageContext.request.contextPath}/SlideListServlet">Danh sach sinh vien</a> --%>  
	
	<section>
		<div class="container">
			<div class="row">
				<jsp:include page="/views/category.jsp"></jsp:include>
				<jsp:include page="/views/product.jsp"></jsp:include>
			</div>
		</div>
	</section>
	<jsp:include page="/views/footer.jsp"></jsp:include>
</body>
</html>