<%@page import="jstl_project.CarVO"%>
<%@page import="java.util.*"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		CarVO car = new CarVO("1234","소나타",2000);
		request.setAttribute("car", car);
	%>
	
	<!-- car 객체를 출력 requestScope는 생략가능 -->
	${requestScope.car.name } <br>
	${car.num } <br>
	${car.price } <br>
	
	${car }
	
	<hr>
	
	<%
		ArrayList<CarVO> list = new ArrayList<>();
		list.add(car);
		list.add(new CarVO("1111","그랜저", 3000));
		list.add(new CarVO("2222","모닝", 1000));
		list.add(new CarVO("3333","아반떼", 2000));
		request.setAttribute("list", list);
	%>
	
	<c:forEach items="${list }" var="cvo">
		${cvo.name } (${cvo.num })  /  ${cvo.price } <br>
		
	</c:forEach>
	
	<%-- <% String abc = "123456"; %> --%>
	
	<c:set var="abc" value="123456"></c:set>
	${abc }
	
</body>
</html>