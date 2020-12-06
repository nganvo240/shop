<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
 
      <h3>Chỉnh sửa danh sách hiển thị sản phẩm</h3> 
      <c:if test="${not empty sinhvien}">
         <form method="POST" action="${pageContext.request.contextPath}/editSinhVien">
            <input type="hidden" name="id" value="${sinhvien.id}" />
            <table border="0">
               <tr>
                  <td>ID</td>
                  <td style="color:red;">${sinhvien.id}</td>
               </tr>
               <tr>
                  <td>Ho ten</td>
                  <td><input type="text" name="hoten" value="${sinhvien.hoten}" /></td>
               </tr>
               <tr>
                  <td>Dia Chi</td>
                  <td><input type="text" name="diachi" value="${sinhvien.diachi}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/home">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>