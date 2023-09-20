<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%session.setAttribute("nickname", "firefox"); %>
<script>
   location.href="sessionTest.jsp";
</script>
<%-- contextPath 안에 모든 영역에서 공유하며 사용하는 session 
	 모든 페이지지만 모든 사람은 X 
	 한 아이피당 1개의 세션만 갖는다.( 클라이언트당 ) 
	 브라우저 자체를 닫거나 피시를 종료하면 세션 자동 만료.
	 
	 
 --%>
