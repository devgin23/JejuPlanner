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

	<!-- 
	private int bno;			//임시로 주석처리해놓음 (DB에 없는 필드)
	private int planNo;			//조회 및 정렬용 필드 추가 (DB엔 있는 필드인데 VO에 없었음)(05-18)
	private String userId;
	private Date regDate;		//VO에는 있으나 DB에 없는 필드임 추가 필요함
	private String planTitle;	//필드명 변경 title -> planTitle(05-18)
	private Date startDate; 
	private String content;    필드 삭제(05-18)
	private int planTotalDay; 	//필드추가(05-18)
	private int planHit;		//필드추가(05-18)
	 -->

<div class="row">

	<!-- 계획 출력 -->
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
				<td><button type="button" onclick="location.href='/plan/view?planNo=${list.planNo}&userId=${member.userId}'">열람</button>
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