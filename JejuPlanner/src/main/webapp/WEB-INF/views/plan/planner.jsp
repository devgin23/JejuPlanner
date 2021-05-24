<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
  crossorigin="anonymous"/> -->
  
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
	<!-- 계획 입력 -->
	<div class="col-md-12 input-form">
		<p>계획 입력폼</p>
			
		<form method="post" action="">
			<table>
			<tr>
				<td>아 이 디 : </td>
				<td><input type="text" class="form-control" name="userId" placeholder="${member.userId}" readonly/></td>
			</tr>
			<tr>
				<td>여행 제목 : </td>
				<td><input type="text" class="form-control" name="planTitle"/></td>
			</tr>
			<tr>
				<td>여행 날짜 : </td>
				<td>
					<input type="date" class="form-control" id="currentDate" name="satrtDate" value="<fmt:formatDate value="${view.startDate}" pattern="yyyy-MM-dd"/>"/>
				</td>
			<tr>
				<td>여행 일수 : </td>
				<td>
					<select class="form-select" id="planTotalDay" name="planTotalDay">
					  <option value="1" selected>1일</option>
					  <option value="2">2일</option>
					  <option value="3">3일</option>
					  <option value="4">4일</option>
					  <option value="5">5일</option>
					  <option value="6">6일</option>
					  <option value="7">7일</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-primary mb-3">작성</button></td>
			</tr>
			</table>
		</form>
	</div>
	<!-- 계획 입력 끝 -->
	

<!-- 부트스트랩 스크립트 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

<!-- 여행날짜 기본 값 삽입 스크립트 -->
<script>
  document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);;
</script>

</body>
</html>