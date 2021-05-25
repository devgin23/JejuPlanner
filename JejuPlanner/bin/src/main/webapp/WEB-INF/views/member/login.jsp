<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
  <style>
    body, html {
      height: 100%;
      margin: 0;
    }

    .m1 {
      position: absolute;
      top: 15%;
      width: 100%;
      text-align: center;
      font-size: 18px;
    }
    .button, .submit{
      background-color:#74b57d; /* Green */
      border: none;
      color: white;
      padding: 10px 10px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      width: 100%;
      font-size: 16px;
      border-radius: 8px;
      font-family: Arial, Helvetica, sans-serif;
      font-weight: bold;
    }
    .v1{
      width: 100%;
      position: absolute;

    }
    a{
        font-size: 15px;
        text-decoration: none;
    }
    input[type=text] {
      width: 100%;
      padding: 10px 20px;
      margin: 8px 0;
      box-sizing: border-box;
    }
    input[type=password] {
      width: 100%;
      padding: 10px 20px;
      margin: 8px 0;
      box-sizing: border-box;
    }
    table{
 
    }
  </style>

</head>
<body>
  <div class="bg">
	  <form name="form1" method="post" action="/member/login">
	  	<c:if test="${member == null}">
		    <div class="m1">
		    <div><img src="/resources/images/Goodee_logo-remove.png"></div>
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
			  <c:if test="${msg == false}">
			  	<script>
			  		alert("로그인 실패! 아이디와 비밀번호를 확인해주세요.");
			  	</script>
			  </c:if>
	  </form>
  </div>


  
</body>
</html>