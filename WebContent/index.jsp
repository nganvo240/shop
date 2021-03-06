<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
	<jsp:include page="/header" /> 
	<%-- <jsp:include page="slider.jsp"></jsp:include> --%>
	 <jsp:include page="/SlideListServlet" /> 	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
						<div class="left-sidebar">
								<div class="shipping text-center"><!--shipping-->
												<img src="images/home/tet1.jpg" alt="" />
											</div><!--/shipping-->
								<div class="shipping text-center"><!--shipping-->
										<img src="images/home/shipping.jpg" alt="" />
									</div><!--/shipping-->
									
						</div>
				</div>
				<!-- nội dung hiển thị sản phẩm -->
				<div class="col-sm-9 padding-left">	<!-- col-sm-9 padding-left :tạm thời-->			
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Sản phẩm nổi bật</h2>	
												
						<c:forEach  items="${ProductListServlet}" var="item">
							<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center" >
											<img src=${ item.img} />											
											<h2>${ item.name}</h2>
											<fmt:formatNumber type="number" groupingUsed="true" value="${ item.price}"/> đ
										</div>
										<!-- hiệu ứng khi lướt chuột qua sản phẩm -->										
										<div class="product-overlay">
											<div class="overlay-content">
												<p>${ item.name}</p>
												<a href="product_detail?id=${item.id}&usernameLogin=${usernameLogin}" class="btn btn-default add-to-cart">Xem</a>																							
											</div>
										</div>
								</div>
								<%-- <div class="choose">
								<form method="POST" action="${pageContext.request.contextPath}/bill?id=${item.id}&usernameLogin=${usernameLogin}" >						
									<ul class="nav nav-pills nav-justified">
										<li class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i><input type="submit" name="action" value="Thêm vào giỏ hàng"></li>
									</ul>																
								</div>	 --%>						
								</div>
							</div>																															    
						</c:forEach>
						</form><%-- <c:import url="/cart?id=${item.id}"/> --%>
				</div>
				</div>
					
				<div class="shipping text-center"><!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
				<!-- kết thúc nội dung hiển thị sản phẩm -->
			</div>
		</div>
	</section>
	<jsp:include page="/views/footer.jsp"></jsp:include>
	
	
	
	
	
<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>

</body>
</html>