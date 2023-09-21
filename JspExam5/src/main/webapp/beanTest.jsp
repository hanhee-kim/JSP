<%@page import="bean.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
<%

	String name = request.getParameter("name");
	Integer age = Integer.parseInt(request.getParameter("age"));
	Person person = new Person();
	person.setName(name);
	person.setAge(age);
%>
 --%>
 
<jsp:useBean id="person" class="bean.Person">
	<jsp:setProperty name="person" property="*"/>
<%--
	<jsp:setProperty name="person" property="name" param="name">
	<jsp:setProperty age="person" property="age" param="age">
 --%>
	<%-- property는 클래스의 속성명 / param 은 가져온 값의 이름 --%>
</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
<h3><%=person.getName() %></h3>
<h3><%=person.getAge() %></h3>
 --%>
 <h3><jsp:getProperty property="name" name="person"/>
 </h3>
 <h3><jsp:getProperty property="age" name="person"/>
 </h3>
</body>
</html>