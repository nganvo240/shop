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
										<input type="checkbox" name=${ item.name} />  <span class="panel-title"><a href="#">${ item.name}</a></span>									
									</div>
								</div>
							</c:forEach>							
						</div><!--/category-products-->
					
						<div class="brands_products"><!--brands_products-->
							<h2>Thương hiệu</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
									<c:forEach  items="${BranchtListServlet}" var="item" varStatus="loop">									
											<li><a href="#"> <span class="pull-right">(50)</span>${ item.name}</a></li>
									</c:forEach>	
									<!-- <li><a href="#"> <span class="pull-right">(50)</span>Nike</a></li>
									<li><a href="#"> <span class="pull-right">(56)</span>Bitis</a></li>
									<li><a href="#"> <span class="pull-right">(27)</span>Adidas</a></li>
									<li><a href="#"> <span class="pull-right">(32)</span>Puma</a></li> -->
									
								</ul>
							</div>
						</div><!--/brands_products-->
						
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