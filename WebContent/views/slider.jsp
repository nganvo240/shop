<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<div class="carousel-inner">
						
							<c:forEach  items="${SlideListServlet}" var="item" varStatus="loop">
									<c:if test="${loop.first }">
										<div class="item active">
									</c:if>
									<c:if test="${ not loop.first}">
										<div class="item">
									</c:if>
										<div class="col-sm-6">
											<h1><span>E</span>-SHOPPER</h1>
											<h2>${ item.title}</h2>
											<p> ${ item.description} </p>
											<button type="button" class="btn btn-default get">Get it now</button>
										</div>
										<div class="col-sm-6"> 
											<img style="width:100%" src=${ item.img}>										
										</div>								
										</div>																								    
							</c:forEach>						
						</div><!-- close <div class="carousel-inner"> -->
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div> <!-- close <div id="slider-carousel" class="carousel slide" data-ride="carousel"> -->
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
</body>
</html>