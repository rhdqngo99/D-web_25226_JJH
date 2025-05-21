<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 메뉴판을 체크박스 형태로 만들어서 step-6.jsp로 전송 -->
<!-- 주문자리 1 : 어떤메뉴를 주문했는지 출력 -->

<form action="step-6.jsp" method="post">
	주문자리 : <input type="text" name="customer"> <br>
	<input type="checkbox" name="menu" value="김치찌개"> 김치찌개 <br>
	<input type="checkbox" name="menu" value="된장찌개"> 된장찌개 <br>
	<input type="checkbox" name="menu" value="순두부찌개"> 순두부찌개 <br>
	<input type="checkbox" name="menu" value="고등어구이"> 고등어구이 <br>
	<input type="checkbox" name="menu" value="갈치구이"> 갈치구이 <br>
	<input type="checkbox" name="menu" value="고등어조림"> 고등어조림 <br>
	<input type="checkbox" name="menu" value="갈치조림"> 갈치조림 <br>
	<input type="checkbox" name="menu" value="제육볶음"> 제육볶음 <br>
	<button type="submit">전송</button>
</form>
</body>
</html>