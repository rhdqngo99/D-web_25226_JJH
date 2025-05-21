<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= "스크립틀릿 방식으로 처리하는 방법" %>
	<% for(int i=0; i<10; i++) {%>
	<%=i %>
	<%} %>
	
	<h1>Hello JSP World~!!</h1>
	<!-- ? : queryString 방식 주소?변수명=값&변수명=값 -->
	<!-- queryString 내에서 띄어쓰기 안됨 "" 안됨 -->
	<a href="step-1.jsp?name=홍길동&age=20">step-1.jsp로 이동</a>
</body>
</html>