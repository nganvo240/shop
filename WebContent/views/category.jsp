<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sản phẩm</title>
</head>
<body>
<div class="col-sm-3">
	<div class="left-sidebar">
		<h2>Loại</h2>
		<div class="panel-group category-products" id="accordian"><!--category-productsr-Loại-->							
			<div class="panel panel-default">
				<form method="GET" action="${pageContext.request.contextPath}/type_ProductServlet?usernameLogin=${usernameLogin}" >
					<input type="hidden" name="usernameLogin" value="${usernameLogin}" />
					<div class="panel-heading"><!-- Loại nam/nữ -->										
						<c:forEach  items="${TypetListServlet}" var="item" varStatus="loop">
							<input type="radio" id="r${ item.name}" name="btnRadio" value="${ item.name}">
  							<span class="panel-title" for="r">${ item.name}</span><br> <br>
  							<c:if test="${loop.last }">
	  							<input type="radio" id="r_all" name="btnRadio" value="all" >
								<span class="panel-title" for="r_all">Tất cả</span>	
							</c:if>
						</c:forEach>																																	
					</div><!-- Loại nam/nữ -->
			</div>	
								<!-- price -->						
			<h2>Giá</h2>		
					<div class="panel-heading">
						<input type="radio" id="1M" name="btnRadioPrice" value="1M">
						<span class="panel-title" for="1M"> &ensp;> 1M</span>	<br> <br>			
								
						<input type="radio" id="500K-1M" name="btnRadioPrice" value="500K-1M">
						<span class="panel-title" for="500K-1M"> &ensp;500K-1M</span> <br> <br>
								
						<input type="radio" id="500K" name="btnRadioPrice"  value="500K">
						<span class="panel-title" for="500K"> &ensp;< 500K</span>	<br> <br>
								
						<input type="radio" id="price_all" name="btnRadioPrice" value="all">
						<span class="panel-title" for="price_all"> &ensp;Tất cả</span>
									
						<INPUT class="btnSubmitCategory" TYPE="submit" VALUE="Lọc" />
											
					</div>
				</form>	
						<!-- price -->						
		</div>
		<div class="shipping text-center"><!--shipping-->
			<img src="images/home/shipping.jpg" alt="" />
		</div><!--/shipping-->
					
	</div>
</div>
<!-- thay đổi trạng thái check của radio button -->
<script>
	var test = '${x}';
	var price = '${btnRadioPrice}';
	if (test == 'rNam'){
		document.getElementById("rNam").checked = true;
	}
	else if (test == 'rNu'){
		document.getElementById("rNữ").checked = true;
	}
	else {
		document.getElementById("r_all").checked = true;
	}
	//giá
	if (price == '1M'){
		document.getElementById("1M").checked = true;
	}
	else if (price == '500K-1M'){
		document.getElementById("500K-1M").checked = true;
	}
	else if (price == '500K'){
		document.getElementById("500K").checked = true;
	}
	else{
		document.getElementById("price_all").checked = true;
	}
</script>	
</body>
</html>