<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- jstl 사용시 태그 라이브러리 라고 하는 선언을 해줘야 함. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Query String으로 보낸 데이터 받기</h1>
	<!-- param.변수명 -->
	<h3>이름: ${param.name }</h3>
	<h3>나이: ${param.age }</h3>
	
	<hr>
	
	<h2>c:if 명령어</h2>
	<c:if test="${param.age <= 18 }">
		<h3>미성년자입니다.</h3>
	</c:if>
	<c:if test="${param.age > 18 }">
		<h3>성인입니다.</h3>
	</c:if>
	
	<!-- queryString 방식으로 name=귤&address=제주 step-2.jsp로 이동 -->
	<!-- step-2.jsp 파일에서 상품명: / 원산지: -->
	<a href="step-2.jsp?name=귤&address=제주">step-3.jsp로 이동</a>
	
</body>
</html>