<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<!-- custom css -->
<link href="/resources/css/list.css" rel="stylesheet" type="text/css">
<title>내 일정 목록</title>
</head>
<body>
	<header>
		<%@include file="../nav.jsp" %>
	</header>
	<!-- 계획 출력 시작 -->
	<c:if test="${member.userId != null}">
		<div class="container">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>	
						<tr>
							<th class="col-md-1">번호</th>
							<th class="col-md-2">여행 시작날짜</th>
							<th class="col-md-1">일수</th>
							<th class="col-md-4">계획 제목</th>
							<th class="col-md-2">아이디</th>
							<th class="col-md-2">작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${planListForUser}" var="planListForUser">
							<tr>
								<td>${planListForUser.planNo}</td>
								<td><fmt:formatDate value="${planListForUser.startDate}" pattern="yyyy-MM-dd"/></td>
								<td>${planListForUser.planTotalDay} 일</td>
								<td><a href="<c:url value="/plan/view?planNo=${planListForUser.planNo}&userId=${planListForUser.userId}"/>">${planListForUser.planTitle}</a></td>
								<td>${planListForUser.userId}</td>
								<td><fmt:formatDate value="${planListForUser.regDate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 계획 출력 끝 -->
				<!-- 페이징 -->
				<div class="col-md-offset-3">
					<ul class="pagination justify-content-center">
					<c:if test="${page.prev}">
						<li class="page-item"><a href="/plan/list/user?userId=${member.userId}&num=${page.startPageNum -1}${page.searchTypeAndKeyword}">이전</a></li>
					</c:if>
					<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
						<c:if test="${page.num != num}">
							<li class="page-item"><a class="page-link" href="/plan/list/user?userId=${member.userId}&num=${num}${page.searchTypeAndKeyword}">${num}</a></li>
						</c:if>
						<c:if test="${page.num == num}">
							<li class="page-item active"><a class="page-link" class="page-link"href="/plan/list/user?userId=${member.userId}&num=${num}${page.searchTypeAndKeyword}">${num}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${page.next}">
						<li class="page-item"><a class="page-link" href="/plan/list/user?userId=${member.userId}&num=${page.endPageNum +1}${page.searchTypeAndKeyword}">다음</a></li>
					</c:if>
					</ul>
				</div>
				<!-- 페이징 끝 -->
				<div>
					<span class="search-form">
						<select name="searchType" class="form-select">
							<option value="planTitle" <c:if test="${page.searchType eq 'planTitle'}">selected</c:if>>제목</option>
						</select>
					 
						<input type="text" class="input-keyword" name="keyword" value="${page.keyword}"/>
						<button class="btn btn-primary" type="submit" id="searchBtn">검색</button>
					</span>
					<button type="button" class="btn btn-secondary" onclick="location.href='/plan/write'">돌아가기</button>
				</div>
			</div>		
		</div>
	</c:if>
	<c:if test="${member.userId == null}">
		<script>
			alert("로그인이 필요합니다.");
			document.location.href="/";
		</script>
	</c:if>
	<script>
		document.getElementById("searchBtn").onclick = function () {
		var searchType = document.getElementsByName("searchType")[0].value;
		var keyword =  document.getElementsByName("keyword")[0].value;
		location.href="/plan/list/user?userId=${member.userId}&num=1&searchType="+searchType+"&keyword="+keyword;
		};
	</script>
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
			crossorigin="anonymous">d</script> 
</body>
</html>