<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
  
  /* 버튼 disabled 처리 시 회색 되는거 스타일 변경 */
  button[type="button"]:disabled { 
  background-color: #e9ecef; 
  color: #212529;
  opacity: 1;
  border:none;
  }
</style>



<title>계획 조회하기</title>
</head>
<body>
	<header>
		<%@include file="../nav.jsp" %>
		
		<!-- 열람 유저가 본인이 아닐 시 버튼 비활성화 -->

	</header>
	
	<!-- 계획 입력 -->
	<div class="col-md-12 input-form">
		<p>계획 조회</p>
			
		<form method="post" action="/plan/view/modify">
			<table>
			<tr>
				<!-- planNo hidden 필드 -->
				<td><input type="hidden" class="form-control" name="planNo" value="${view.planNo}" /></td>
			</tr>
			<tr>
				<td>아 이 디 : </td>
				<td><input type="text" class="form-control userId" name="userId" value="${view.userId}" readonly/></td>
				<td>${member.userId}, ${view.userId}</td>
			</tr>
			<tr>
				<td>여행 제목 : </td>
				<td><input type="text" class="form-control" name="planTitle" value="${view.planTitle}" readonly/></td>
			</tr>
			<tr>
				<td>여행 날짜 : </td>
				<td><input type="date" class="form-control" id="currentDate" name="startDate" value="<fmt:formatDate value="${view.startDate}" pattern="yyyy-MM-dd"/>" readonly/></td>
			</tr>
			<tr>
				<td>여행 일수 : </td>
				<td>
					<select class="form-select" id="planTotalDay" name="planTotalDay" disabled>
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
			<td><br/></td>
			</tr>
			<tr>
				<td><button type="button" class="btn btn-primary mb-3" onclick="modify_btn();">수정</button></td>
				<td><button type="submit" class="btn btn-primary mb-3">저장</button></td>
			</tr>
			<tr>
			</tr>
			</table>
		</form>
		<!-- 계획 입력 끝 -->
		
		<!-- 계획삭제 폼 -->
		<form method="post" action="/plan/view/delete">
			<input type="hidden" value="${view.planNo}" name="planNo"/>
			<input type="hidden" value="${view.userId}" name="userId"/>
			<button type="submit" class="btn btn-primary mb-3">삭제</button>
		</form>
		<!-- 계획삭제 끝 -->
	</div>
	
	<!-- 부트스트랩 스크립트 -->	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	
	<!-- 수정 활성화 스크립트 -->
	<script>
	function modify_btn() {
		alert("readonly제거");
		$('input').not('input.userId').removeAttr('readonly');
		$('#planTotalDay').removeAttr('disabled');
	}
	</script>
	
	<!-- 다른 사용자일 시 버튼 막기 -->
	<script>
	if("${member.userId}" != "${view.userId}")
		$(".btn").attr("disabled", true);
	</script>
		
</body>
</html>