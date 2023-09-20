<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%pageContext.include("pageContextTest3.jsp"); %> 
<%-- test1에서 forward된 메세지가 test2페이지의 include로 온다????? --%>
<h2> pageContext의 forward 메소드로 포워딩된 페이지임. </h2>
</body>
</html>