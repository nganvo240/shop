<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
.sologon {
  text-align: center;
  padding-top: 200px;
  padding-bottom: 40px;
  font-size:30px;
  font-family:Comic Sans MS cursive;
  color: rgb(161, 106, 159);
}
</style>
</head>
<body>
<footer id="footer"><!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="companyinfo">
						 <img src="images/home/footer5.jpg" alt="" /> 
							  <!-- <h2>TÌM CỬA HÀNG</h2> -->
						</div>
					</div>
					<div class="col-sm-7">
						 <div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										 <img src="images/home/footer1.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>LAVENDER</p>
								<!-- <h2>450.000 VND</h2> -->
							</div>
						</div> 
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/footer2.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>BASAS MONO</p>
								<!-- <h2>24 DEC 2014</h2> -->
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/footer3.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>VINTAS EARTH</p>
								<!-- <h2>24 DEC 2014</h2> -->
							</div>
						</div>
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/footer4.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>VINTAS N'LOOP</p>
								<!-- <h2>24 DEC 2014</h2> -->
							</div>
						</div>
						
						<p class="sologon">ANANAS - THƯƠNG HIỆU CỦA MỌI NHÀ</p>
					</div>
					<div class="col-sm-3">
						<div class="address">
							<img src="images/home/map.png" alt="" />
							<p>3 cô nàng xinh đẹp :)</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="single-widget">
							<h2 style="font-family: Arial">SẢN PHẨM</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>							
								<li><a href="#">Giày Nam</a></li>
								<li><a href="#">Giày Nữ</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2 style="font-family: Arial">VỀ CÔNG TY</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">Tuyển Dụng</a></li>
								<li><a href="#">Giới Thiệu</a></li>
								<li><a href="#">Liên hệ</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2 style="font-family: Arial">HỖ TRỢ</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">Facebook</a></li>
								<li><a href="#">Instagram</a></li>
								<li><a href="#">Twitter</a></li>
							</ul>
						</div>
					</div>
					<!-- <div class="col-sm-2">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">Company Information</a></li>
								<li><a href="#">Careers</a></li>
								<li><a href="#">Store Location</a></li>
								<li><a href="#">Affillate Program</a></li>
								<li><a href="#">Copyright</a></li>
							</ul>
						</div>
					</div> -->
					<div class="col-sm-3 col-sm-offset-1">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<form action="#" class="searchform">
								<input type="text" placeholder="Your email address" />
								<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
								<p style="font-family: Arial">đăng kí nhận Email từ shop</p>
							</form>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left"> Copyright © 2020 E-SHOPPER Inc. All rights reserved.</p>
				</div>
			</div>
		</div>
		
	</footer><!--/Footer-->
</body>
</html>