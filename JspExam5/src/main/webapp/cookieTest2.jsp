<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "";
	String nameValue = "";
	String name2 = "";
	String age = "";
	String cookie = request.getHeader("cookie");
	if(cookie != null){
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals("name")){
				name = c.getName();
				nameValue = c.getValue();
			} else if(c.getName().equals("age")){
				name2 = c.getName();
				age = c.getValue();
			}
		}
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>쿠키 이름 = <%= name %></h2>
<h2>쿠키 값 = <%= nameValue %></h2>
<h2>쿠키 이름 = <%= name2 %></h2>
<h2>쿠키 값 = <%= age %></h2>
</body>
</html>