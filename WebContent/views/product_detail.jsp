<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Chi tiết sản phẩm</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">    
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js"></script>	
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="${product.img}" alt="" />
							</div>
						</div>
			<form method="POST" action="${pageContext.request.contextPath}/bill" >
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<h2>Mã: ${product.id}</h2>				
								<h2>${product.name}</h2>
								<span>
									<span><fmt:formatNumber type="number" groupingUsed="true" value="${ product.price}"/>đ</span><br><br><br>
									<p style="justify">${product.detail}</p><br>																										
									<label>								
									   <select class="select" style="width: auto;" size="1" name="options" >	
									   <option >Chọn Size</option>								   
										   <c:forEach  items="${lstsize}" var="itemSize" varStatus="loop">					   	
										     <option value="${itemSize.size}" data-max="${itemSize.quantity}">${itemSize.size}</option>				   										     			
										    </c:forEach>											    						 
									   </select>
										     Số lượng: <input type="number" name="quantity"  min="0" max="0" value="0"/>										   										   		
								</label><br><br>
								</span>								
								<div class="header-middle"><!--header-middle-->										
									<c:if test="${not empty lstsize}">
										<p><b>Tình trạng:</b> Còn hàng</p>
									</c:if>						
									<c:if test="${empty lstsize}">
										<p><b>Tình trạng:</b> Hết hàng</p>
									</c:if>	
									<p><b>Loại:</b> ${product.type_name}</p><br>
									<button type="button" class="btn btn-fefault cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>								
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
				</form>
				
			</div>
		</div>
	</div>
	</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
$('select').change(function(){
	
    $('input[type=number]').attr('max', $(this).find(":selected").data('max'));
    $('input[type=number]').val(''); 

});
</script>
</body>
</html>