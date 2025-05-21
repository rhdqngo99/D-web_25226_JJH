<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%
		//post 방식의 한글처리
		request.setCharacterEncoding("utf-8");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>주문자 : ${param.customer }</h3>
	<h3>주문메뉴</h3>
	<c:forEach items="${paramValues.menu }" var="food" varStatus="i">
		${i.count }. ${food } <br>
	</c:forEach>
	
	<a href="step-7.jsp">step-7.jsp로 이동</a>
	
</body>
</html>