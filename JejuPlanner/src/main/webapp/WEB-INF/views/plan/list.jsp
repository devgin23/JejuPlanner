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
						<th class="col-md-2">여행 시작날짜</th>
						<th class="col-md-5">계획 제목</th>
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
			<!-- 계획 출력 끝 -->
			<!-- 페이징 -->
			<div>
				<c:if test="${page.prev}">
					<span>[ <a href="/plan/list?num=${page.startPageNum -1}${page.searchTypeAndKeyword}">이전</a> ]</span>
				</c:if>
				<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
					<span>
						<c:if test="${page.num != num}">
							<a href="/plan/list?num=${num}${page.searchTypeAndKeyword}">${num}</a>
						</c:if>
						<c:if test="${page.num == num}">
							<b>${num}</b>
						</c:if>
					</span>
				</c:forEach>
				<c:if test="${page.next}">
					<span>[ <a href="/plan/list?num=${page.endPageNum +1}${page.searchTypeAndKeyword}">다음</a> ]</span>
				</c:if>
			</div>
			<!-- 페이징 끝 -->
			<div>
				<select name="searchType">
					<option value="planTitle" <c:if test="${page.searchType eq 'planTitle'}">selected</c:if>>제목</option>
					<option value="userId" <c:if test="${page.searchType eq 'userId'}">selected</c:if>>아이디</option>
				</select>
			 
				<input type="text" name="keyword" value="${page.keyword}"/>
				<button type="submit" id="searchBtn">검색</button>
			</div>
			<br/>
			<button type="button" class="btn btn-secondary" onclick="location.href='/plan/write'">돌아가기</button>
		</div>		
	</div>
	<br/>

	<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js">
    </script>
   	<script>

		 document.getElementById("searchBtn").onclick = function () {
		    
		  var searchType = document.getElementsByName("searchType")[0].value;
		  var keyword =  document.getElementsByName("keyword")[0].value;
		  
		  console.log(searchType)
		  console.log(keyword)
		  location.href="/plan/list?num=1"+"&searchType="+searchType+"&keyword="+keyword;
		 };
	</script>
    
</body>
</html>