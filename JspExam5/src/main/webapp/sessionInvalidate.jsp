<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% session.invalidate(); %>
<%-- 세션 자체를 비활성화 --%>
<script>
location.href="sessionTest.jsp";
</script>