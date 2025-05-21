<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EL 방식으로 파라미터 전달 받기 -->
	<h3>제품명: ${param.name } / 원산지: ${param.age }</h3>
	
	<h2>스크립틀릿 방식으로 파라미터 전달 받기</h2>
	<h2><%= request.getParameter("name") %></h2>
	<h2><%= request.getParameter("address") %></h2>
	
	<!-- form tag 로 데이터 전송 -->
	<!-- form tag 데이터 전송방식 : get / post 중 선택가능 -->
	<!-- get 방식은 queryString(get방식) 같은 방식으로 전송 -->
	
	<form action="step-3.jsp">
		이름: <input type="text" name="name">
		나이: <input type="text" name="age">
		<button type="submit">전송</button>
	</form>

</body>
</html>