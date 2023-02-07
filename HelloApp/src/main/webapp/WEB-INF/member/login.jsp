<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../includes/header.jsp"></jsp:include>
<!-- 파일 만들기  WEB-INF/member/login.jsp 0207 3교시 중간에 스트링과 action을 0207 4교시에 넣음 -->
<h3>현재 페이지는 loginForm.do의 결과 login.jsp입니다.</h3>
<%
	String msg = (String) request.getAttribute("result");
%>
<% if(msg != null) { %>
	<div><%=msg %></div>
<% } %>
<form action="login.do" method="post">
  <table class="table">
    <tr>
      <th>ID</th><td><input type="text" name="mid"></td>
    </tr>
    <tr>
      <th>Pass</th><td><input type="password" name="mpw"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="로그인">
        <input type="reset" value="취소">
      </td>
    </tr>  
  </table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>     