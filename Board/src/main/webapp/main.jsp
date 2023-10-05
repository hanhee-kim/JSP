<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
a ,b{
	display: inline-block;
	line-height: 110px;
}

#header {
	height: 110px;
	display:flex;
}

.logo {
	width: 100px;
	height: 100px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<img class="logo" src="image?file=catLogo.png">&nbsp;&nbsp;
		<c:choose>
			<c:when test="${user eq Empty }">
				<a href="login">로그인</a>&nbsp;&nbsp;
				<a href="join">회원가입</a>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
			
				<b>${user.name }</b>&nbsp;&nbsp;
				<a href="logout">로그아웃</a>&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>

		<a href="boardlist">게시판목록</a>
		<br>
		<br>
	</div>
</body>
</html>