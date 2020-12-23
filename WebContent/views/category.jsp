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
							<c:forEach  items="${TypetListServlet}" var="item" varStatus="loop">
								<div class="panel panel-default">
									<div class="panel-heading">
										<input type="radio" name="" > <span class="panel-title"><a href="">${ item.name}</a></span>									
									</div>
								</div>
							</c:forEach><br>	
									<INPUT TYPE="submit" VALUE="submit" />						
						</div><!--/category-products-->
					
						
						<div class="price-range"><!--price-range-->
							<h2>Giá</h2>
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">> 2M</a></h4>
								</div>
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">1M - 2M</a></h4>
								</div>
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">500K - 1M</a></h4>
								</div>
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#"> < 500K</a></h4>
								</div>
								
						</div><!--/price-range-->
						
						<div class="shipping text-center"><!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
					
					</div>
				</div>
</body>
</html>