<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{margin:0 auto;}

body{
	position : relative;
	height : 800px;
}

.footer{
	position : absolute;
	width : 100%;
	bottom : 0; 
}
</style>
</head>

<body>
<% 
	String ipage = (String)request.getAttribute("page");
%>
<table style="width:100%">
	<thead>
		<tr>
			<td>
			<%--
				<% pageContext.include("header.jsp"); %>
			 --%>
				<jsp:include page="header.jsp"></jsp:include>
			</td>
		</tr>
	</thead>
	<%
	if(ipage != null){
	%>
        <tbody>
            <tr>
                <td>
                    <jsp:include page=' <%=ipage+".jsp "%>'/>
                </td>
            </tr>
        </tbody>
        <%
    }
        %>
	
</table>

</body>
<div class="footer">
	<jsp:include page="footer.jsp"/>
</div>
</html>