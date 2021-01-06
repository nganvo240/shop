<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng nhập</title>
<!--
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet"> 
 -->
 <style>
body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="topnav">
        <a class="active" href="${pageContext.request.contextPath}/ThongTinDon">Bill</a>
        <a href="${pageContext.request.contextPath}/billinf">Xem thông tin bill</a>
    </div>
</div>

	<!-- code table ở đây -->
	<p style="color: red;">${errorString}</p>
	<table align="center" cellpadding="10px" width="500px" border="1" cellpadding="3" cellspacing="1">
		<tr>
			<th>Mã đơn</th>
			<th>Id khách hàng</th>
			<th>Ngày mua</th>
			<th>Tổng tiền</th>
			<th>Trạng thái</th>
			
			
		</tr>
		<c:forEach items="${danhSachDonHang}" var="thuoctinh">
			<tr>
				<td>${thuoctinh.id}</td>
				<td>${thuoctinh.customer_id}</td>
				<td>${thuoctinh.date}</td>
				<td>${thuoctinh.totalMoney}</td>
				<td>${thuoctinh.status}</td>
				
			</tr>
		</c:forEach>
	</table>

	<jsp:include page="footer_nv.jsp"></jsp:include>
</body>
</html>