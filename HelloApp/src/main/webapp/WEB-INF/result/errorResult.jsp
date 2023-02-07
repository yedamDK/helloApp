<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>result/errorResult.jsp http://localhost:8081/HelloApp/errorPage.do</title>
</head>
<body>
	<h3>처리중 에러가 발생!</h3>
	
	<c:set var="myname" value="홍길동"></c:set> <!-- 담아줄때 set 선언(지정)할 때는 var -->
	<c:out value="${myname }"></c:out> <!-- 출력할때 out 값은 value -->
	<p>${myname }</p>
	
	<!-- set : 변수에 값을 담아주고싶을때 사용 -->
    <!-- c : 태그를 의미 -->
    <!--  % String name = "홍길동" % 과 같은 의미임 -->
    <!--  var라는 속성에다가 value를 집어넣음 -->
    <c:set var="myname" value="홍길동"></c:set> 
    <!--  c:out 은 값을 불러옴(출력) -->
    <c:out value="${myname}"></c:out>
    <!-- 이런식으로 값을줘도됨 -->
    <p>${myname }</p>

	
	
	<c:set var="score" value="75"></c:set>
	<c:if test="${score >60 }"><!-- 조건문 if 값은 test -->
		<p>합격!</p>
	</c:if>
	<c:if test="${score !=70 }">
		<p>불합격!</p>
	</c:if>
	
	<!-- if else 구문 choose otherwise -->
	<c:choose> 
		<c:when test="${score > 90 }"><p>A</p></c:when>
		<c:when test="${score > 80 }"><p>B</p></c:when>
		<c:when test="${score > 70 }"><p>C</p></c:when>
		<c:otherwise><p>D</p></c:otherwise>
	</c:choose>
	
	<!-- class라는 attribute에다가도 넣어줄수있음 -->
	<c:forEach begin="1" end="10" var="num">
		<p class='<c:out value="${num }" />' >${num }</p>	
	</c:forEach>
	
	<p>3단 출력하기</p>
	<c:set var="dan" value="3"></c:set>
	<table border="1">
		<c:forEach begin="1" end="9" var="i">
			<tr><td>${dan }</td><td>*</td><td>${i }</td><td> = ${dan*i }</td></tr>
		</c:forEach>
	</table>
	
	<c:forEach items="${empList }" var="emp">
		<p>사번: ${emp.employeeId }, 이름: ${emp.firstName }, 이메일: ${emp.email}, 직무: ${emp.jobId }</p>	
	</c:forEach>
	
	
	<h3>Expression Language (EL)</h3>
	//간단한 표현식만 나타낼 수 있다.
	<p>${3>5 }</p>
	<p>${'test'=='test' }</p>
	<p>${5-4 }</p>
	<p>${5*4 }</p>
	<p>${id } EL안에서 ${id } => getAttribute()</p> 
	<p>${id eq null }로그인하면 false 로그아웃하면 true</p>
	<p>${empty id} 로그인하면 false 로그아웃하면 true</p>
	<p>${obj } </p>
	<p>ID: ${obj.memberId } </p>
	<p>Name: ${obj.memberName } </p>
	<p>List: ${empList } </p>
	
	
	<p>html 안에 자바코드 제거 => jstl 연습.</p>
	
	
</body>
</html>