<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
  
<style>
	a:link {text-decoration: none; color: black;}
	a:hover {text-decoration: underline; color: black;}
	a:visited {text-decoration: none; color: black;}
	a:active {text-decoration: none; color: black;}
	
	.input-form {
		background-color: powderblue;
	}
	  
	.output-form {
		background-color: #D2FFD2;
	}
	.table, .table-striped{
		text-align: center;
	}
</style>

<title>공유 일정 목록</title>
</head>

<body>
	<header>
		<%@include file="../nav.jsp" %>
	</header>
	
	<!-- 계획 출력 시작 -->
	<div class="container">
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>	
					<tr>
						<th class="col-md-1">번호</th>
						<th class="col-md-2">여행시작날짜</th>
						<th class="col-md-5">계획제목</th>
						<th class="col-md-2">아이디</th>
						<th class="col-md-1">일수</th>
						<th class="col-md-1">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${planList}" var="planList">
						<tr>
							<td>${planList.planNo}</td>
							<td><fmt:formatDate value="${planList.startDate}" pattern="yyyy-MM-dd"/></td>
							<td><a href="<c:url value="/plan/view?planNo=${planList.planNo}&userId=${planList.userId}"/>">${planList.planTitle}</a></td>
							<td>${planList.userId}</td>
							<td>${planList.planTotalDay} 일</td>
							<td>${planList.planHit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br/>
			<button type="button" class="btn btn-secondary" onclick="location.href='/plan/write'">돌아가기</button>
		</div>		
	</div>
		<!-- 계획 출력 끝 -->
	<br/>

	<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js">
    </script>
    
</body>
</html>