<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
  crossorigin="anonymous"/>
  
<style>
  .input-form {
  background-color: powderblue;
  }
  
  .output-form {
  background-color: #D2FFD2;
  }
</style>

<title>계획 입력 폼</title>
</head>
<body>

<!--
	private int planNo;
	private String userId;
	private String descript;
	private String addr;
	private int planDay;
	private int startTime;
	private int rowNo;
-->
	
	<!-- 계획 입력 -->
	<div class="col-md-12 input-form">
		<p>계획 입력폼</p>
			
		<form method="post" action="">
			<table>
			<tr>
				<td>계획 번호 :</td> 
				<td><input class="form-control form-control-sm" type="text" placeholder="임시 값 ${formData.planNo}" aria-label="readonly input example" readonly></td> <!-- 임시 필드 -->
				<td><input type="hidden" name="planNo" value=${formData.planNo}></input></td>
			</tr>
			<tr>
				<td>아 이 디 : </td>
				<td><input type="text" class="form-control" name="userId"/></td>
			</tr>
			<tr>
				<td>여행 제목 : </td>
				<td><input type="text" class="form-control" name="planTitle"/></td>
			</tr>
			<tr>
				<td>여행 날짜 : </td>
				<td><input type="date" class="form-control" name="planDate"/></td>
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-primary mb-3">작성</button></td>
			</tr>
			</table>
		</form>
	</div>
	<!-- 계획 입력 끝 -->

    
</body>
</html>


	
