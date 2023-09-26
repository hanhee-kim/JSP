<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% %>
<!DOCTYPE html>
<html>
<head>
<style> 
	h2{text-align:center;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% pageContext.include("header.jsp"); %>

<h2><%=request.getAttribute("err") %> <br><br>
<a href="main">메인으로</a></h2>

</body>
</html>