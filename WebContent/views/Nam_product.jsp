<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Giày nam</title>
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

<!-- xử lý phân trang -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" />
        <script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
        <!-- JS tạo nút bấm di chuyển trang start -->
        <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
        <!-- JS tạo nút bấm di chuyển trang end -->
        <% int countProd = (Integer) request.getAttribute("countProd"); %>
        <script type="text/javascript">
            $(function () {
                var pageSize = 9; // Hiển thị 9 sản phẩm trên 1 trang
                showPage = function (page) {
                    $(".contentPage").hide();
                    $(".contentPage").each(function (n) {
                        if (n >= pageSize * (page - 1) && n < pageSize * page)
                            $(this).show();
                    });
                }
                showPage(1);
                ///** Cần truyền giá trị vào đây **///
                var totalRows = <%= countProd%>; // Tổng số sản phẩm hiển thị
                var btnPage = 5; // Số nút bấm hiển thị di chuyển trang
                var iTotalPages = Math.ceil(totalRows / pageSize);

                var obj = $('#pagination').twbsPagination({
                    totalPages: iTotalPages,
                    visiblePages: btnPage,
                    onPageClick: function (event, page) {
                        console.info(page);
                        showPage(page);
                    }
                });
                console.info(obj.data());
            });
        </script>      
        <style>
	#pagination {
	  	display: flex;
    	justify-content: center;
   		
	}
</style>
</head>

<body>
	<jsp:include page="/views/header.jsp"></jsp:include>	
	<section>
		<div class="container">
			<div class="row">
				<jsp:include page="/categoryServlet?btnType=rNam" />

	<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Giày nam</h2>																		
						<c:forEach  items="${ProductListServlet}" var="item" varStatus="loop">
						<div class="contentPage">
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
												<a href="product_detail?id=${item.id}" class="btn btn-default add-to-cart">Xem</a>											
											</div>
										</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a></li>
									</ul>																												
								</div>
								</div>
							</div>
							</div>																								    
						</c:forEach>
						</div>	
						<ul id="pagination"></ul>
				</div>
				</div>	
		</div>
	</section>			
	<jsp:include page="/views/footer.jsp"></jsp:include>
</body>
</html>