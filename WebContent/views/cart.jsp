<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Giỏ hàng</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/header.jsp" />
	<section id="cart_items">
		<div class="container">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Sản phẩm</td>
							<td class="description"></td>
							<td class="price">Giá</td>
							<td class="quantity">Số lượng</td>
							<td class="total">Tổng</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<form action="${pageContext.request.contextPath}/cart?usernameLogin=${usernameLogin}" method="get">
						<c:forEach  items="${productsCart}" var="item" varStatus="counter">
							<tr>
								<td class="cart_product">
									<a href=""><img src="${item.img}" alt="" style="max-height: 110px; max-width: 110px;"></a>
								</td>
								<td class="cart_description">
									<h4><a href="">${item.name}</a></h4>
									<p>ID: ${item.id}</p>
								</td>
								<td class="cart_price">
									<p><fmt:formatNumber type="number" groupingUsed="true" value="${ item.price}"/> đ</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<input id="quantity" type="number" name="quantity" value="${ item.quantity}" autocomplete="off" size="2">
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price"><fmt:formatNumber type="number" groupingUsed="true" value="${item.totalPrice}"/> đ</p>
								</td>	
									<td class="cart_delete">
										<form action="${pageContext.request.contextPath}/cart?usernameLogin=${usernameLogin}" method="POST">												
										<!-- <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a> -->
										<input type='hidden' name='stt' value='<c:out value="${counter.count}"/>'><%-- ${counter.count} --%>
										<input type="submit" name="action" value="X">
										</form>				
									</td>
								
							</tr>
							
							</c:forEach>	
						</form>	
					</tbody>
				</table>
			</div>
			<div class="col-sm-6">
					<div class="total_area">
					<form method="POST" action="${pageContext.request.contextPath}/cart?usernameLogin=${usernameLogin}&totalMoney=${totalMoney}"   >
						<ul>
							<li>Tổng: <span><fmt:formatNumber type="number" groupingUsed="true" value="${totalMoney}"/> đ</span></li>
						</ul>
						<input type='hidden' name='totalMoney' value='<c:out value="${totalMoney}"/>'>
					
					</div>
					</div>
		</div>
	</section> <!--/#cart_items-->
	
							
	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>Bạn muốn thanh toán?</h3>
				<p>Chọn xem bạn có mã giảm giá hoặc điểm thưởng muốn sử dụng hoặc muốn ước tính chi phí giao hàng của mình.</p>
			</div>
			<div class="row">				
				<div class="col-sm-6">					
						<input type="submit" name="action" value="Thanh toán">
						<c:if test="${testBuy =='1' }">
							<script type="text/javascript">alert('Thanh toán thành công');</script>
						</c:if>
					</form>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>


</html>