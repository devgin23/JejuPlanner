<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- custom css -->
    <link href="/resources/css/login.css" rel="stylesheet" type="text/css"> 
    <title>로그인</title>
</head>
<body id="body">
  <div class="bg">
	  <form name="form1" method="post" action="/member/login">
	  	<c:if test="${member == null}">
		    <div class="m1">
		    <div><h1 class="mainTitle"><span class="mainJeju">Jeju</span> <span class="mainPlanner">Planner</span></h1></div>
		      <div class=v1>
		        <table width=250 border=0 cellspacing=0 cellpadding=1 align=center >
		          <tr>
		            <td align=center width=35%><button type="button" class="button">아이디</button></td>
		            <td width=65%> <input type="text" id="userId" name="userId"></td>
		          </tr>
		          <tr>
		            <td align=center  width=35%><button type="button" class="button">비밀번호</button></td>
		            <td  width=65%> <input type="password" id="userPw" name="userPw"></td>
		          </tr>
		          <tr>
		          	<td align=center  width=50%> <button class="button" type="button" onclick="location.href='/member/register'">회원가입</button></td>
		            <td align=center  width=50%> <button class="submit">로그인</button></td>
		          </tr>
	        	</table>
	       	 </div>
 			</div>
 			</c:if>
 			<c:if test="${member != null}">
 				<% response.sendRedirect("/plan/write"); %>
 			</c:if>
			  <c:if test="${msg == false}">
			  	<script>
			  		alert("로그인 실패! 아이디 혹은 비밀번호가 틀렸습니다.");
			  	</script>
			  </c:if>
			  <c:if test="${nullMember == false}">
			  <script>
			  		alert("로그인 실패! 아이디 혹은 비밀번호가 틀렸습니다.");
			  </script>
			  </c:if>
	  </form>
  </div>
