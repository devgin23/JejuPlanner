<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<title>내 계획 목록</title>
</head>

<body>
	<header>
		<%@include file="../nav.jsp" %>
	</header>
	
	<div class="row">
		<!-- 계획 출력 시작 -->
		<div class="col-md-6 output-form">
		<p>내 계획 목록</p>
		<table style="background-color:#f9b208">
			<thead>
				<tr>
					<th class="col-md-2">계획번호</th>
					<th class="col-md-2">아이디</th>
					<th class="col-md-2">여행시작날짜</th>
					<th class="col-md-2">계획제목</th>
					<th class="col-md-2">여행 총 일수</th>
					<th class="col-md-2">조회수</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.planNo}</td>
					<td>${list.userId}</td>
					<td><fmt:formatDate value="${list.startDate}" pattern="yyyy-MM-dd"/></td>
					<td>${list.planTitle}</td>
					<td>${list.planTotalDay} 일</td>
					<td>${list.planHit}</td>
					<td>
						<!-- 열람방식 POST처리 -->
						<form action="/plan/view" method="post">
							<input type="hidden" name="planNo" value="${list.planNo}"></input>
							<input type="hidden" name="userId" value="${list.userId}"></input>
							<input type="submit" value="열람">
						</form>
						<!-- 열람방식 POST처리 끝-->
					</td>
				</tr>
				</c:forEach>
			</tbody>
			
		</table>
		<br/>
		<button type="button" onclick="location.href='/plan/write'">돌아가기</button>
		</div>
		<!-- 계획 출력 끝 -->
		
	</div>
	<br/>

	<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
      crossorigin="anonymous">
    </script>
    
</body>
</html>