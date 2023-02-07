<%@page import="co.yedam.emp.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%

//리턴되는 타입은 객체타입
// 아까 컨트롤러에서 넘겨준 요청정보에 searchVO가 참조하고있는 주소값을 가져옴

	EmpVO emp = (EmpVO) request.getAttribute("searchVO");
	//request 는 선언하지 않았지만 톰캣의 내장객체라 쓸 수 있음.
	//getAttribute가 모든 정보를 받아오기 위해 object 타입
	//(EmpVO) 라고 해서 EmpVO 타입으로 변환해서 받음.
	String id = (String)session.getAttribute("id");
	Integer age = (Integer) request.getAttribute("myAge");
	String id2 = (String) request.getAttribute("loginId");
%>
<%=age %>, <%=id2 %>
<h3>현재 페이지는 empDetail.do의 결과 empDetail.jsp 입니다.</h3>
<table class="table">
	<tr>
	  <th>사원번호</th><td><%=emp.getEmployeeId() %></td>	  
	</tr>
	<tr>
	  <th>FirstName</th><td><%=emp.getFirstName() %></td>	  
	</tr>	
	<tr>
	  <th>LastName</th><td><%=emp.getLastName() %></td>	  
	</tr>	
	<tr>
	  <th>메일</th><td><%=emp.getEmail() %></td>	  
	</tr>
	<tr>
	  <th>직무</th><td><%=emp.getJobId() %></td>	  
	</tr>
	
	<% if (id != null) { %>			
	<tr>
	<td colspan="2" align="center">
	<button class="btn btn-primary" onclick='location.href="empModForm.do?id=<%=emp.getEmployeeId() %>"'>수정</button>
	<button class="btn btn-warning" onclick=location.href="empRemove.do?id=<%=emp.getEmployeeId() %>">삭제</button> <!-- 0206 3교시 empRemove.do?id=?? removeEmp(int id) -->
	</td>
	</tr>
	<% } else {%>
	<% } %>
</table>

<jsp:include page="../includes/footer.jsp"></jsp:include>         