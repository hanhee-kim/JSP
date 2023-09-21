<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%--
<%
	request.setAttribute("tel", "031-1234-5678");
	pageContext.forward(request.getParameter("forwardPage"));
%>
 --%>

<jsp:forward page='<%= request.getParameter("forwardPage") %>'>
	<jsp:param value="034-1234-5678" name="tel"/>
</jsp:forward>