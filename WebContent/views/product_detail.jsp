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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js"></script>	
<style>
input.button-add {
	font-size: 16px;
	color: #ffad33;
    background-image: url(images/buttons/cart_icon.png); /* 16px x 16px */    
    background-color: #fff5e6; /* make the button transparent */
    background-repeat: no-repeat;  /* make the background image appear only once */
    background-position: 0px 0px;  /* equivalent to 'top left' */
    border-color: #ffad33;           /* assuming we don't want any borders */
    border-width: 1px;
    cursor: pointer;        /* make the cursor like hovering over an <a> element */
    height: 45px;           /* make this the size of your image */
    width:200px;
    padding-left: 45px;     /* make text start to the right of the image */
    vertical-align: middle; /* align the text vertically centered */
}
input.button-add:hover{
	background-color: #ffd699;
}
</style>
<!-- style="background:#39e600;border-style: hidden; width:150px; height:40px; " -->
</head>
<body>
<jsp:include page="/header" /> <!-- để lấy username -->
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
					<form method="POST" action="${pageContext.request.contextPath}/bill?usernameLogin=${usernameLogin}&id=${product.id}" >				
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<h2 style="font-size:12px;">Mã: ${product.id}</h2>				
								<h2>${product.name}</h2>
								<span>
									<span><fmt:formatNumber type="number" groupingUsed="true" value="${ product.price}"/>đ</span><br><br><br>
									<p style="justify">${product.detail}</p><br>																										
									<label>								
									   <select class="select" style="width: auto;" size="1" id="options" name="options" >	
									   <option >Chọn Size</option>								   
										   <c:forEach  items="${lstsize}" var="itemSize" varStatus="loop">					   	
										     <option value="${itemSize.size}" data-max="${itemSize.quantity}">${itemSize.size}</option>				   										     			
										    </c:forEach>											    						 
									   </select>
										     Số lượng: <input type="number" name="quantity"  min="0" max="0" value=""/>										   										   		
								</label><br><br>
								</span>								
								<div class="header-middle"><!--header-middle-->										
									<c:if test="${not empty lstsize}">
										<p>Tình trạng: Còn hàng</p>
									</c:if>						
									<c:if test="${empty lstsize}">
										<p style="color: red;"> Hết hàng</p>
									</c:if>	
									<p><b>Loại:</b> ${product.type_name}</p><br>
									<!-- <button type="button" class="btn btn-fefault cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button> -->
									<input   class="button-add"  type="submit" name="action" value="Thêm vào giỏ hàng">								
								</form>
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->							
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