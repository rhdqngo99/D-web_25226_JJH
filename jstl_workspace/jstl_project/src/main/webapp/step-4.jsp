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
<h1>paramValues로 데이터 받기</h1>
<h3>
	과일1 : ${paramValues.food[0] } <br>
	과일2 : ${paramValues.food[1] } <br>
	과일3 : ${paramValues.food[2] } <br>
</h3>

<!-- paramValues 는 객체를 리스트(배열)로 전송 -->
<!-- c:forEach를 사용하여 출력 -->
<!-- items : 출력할 리스트 / var : 저장변수 -->
<!-- varStatus : index(번지:0부터시작), count(개수:1부터시작) -->
<c:forEach items="${paramValues.food }" var="f" varStatus="i">
	<h3>과일 ${i.index} : ${f }</h3>
</c:forEach>

<hr>

<!-- begin="시작숫자" end="끝숫자" var="변수 -->
<c:forEach begin="1" end="10" var="a">
	${a }
</c:forEach>
<hr>

<%	String friends[] = {"삼겹살","소주","족발","맥주","소고기"};
	// java Controller 에서 jsp로 데이터를 전송
	request.setAttribute("fr", friends);
%>

<c:forEach items="${requestScope.fr }" var="friend" varStatus="i">
<h3>${i.count } / ${friend }</h3>
</c:forEach>

<a href="step-5.jsp">step-5.jsp로 이동</a>

</body>
</html>