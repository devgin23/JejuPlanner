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

<title>일정 추가 및 순서 정렬 구현</title>
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

<div class="row">

	<!-- 일정 출력 -->
	<div class="col-md-6 output-form">
	<p>출력폼</p>
	<table>
		<thead>
			<tr>
				<th class="col-md-2">일정번호</th>
				<th class="col-md-2">아이디</th>
				<th class="col-md-2">장소</th>
				<th class="col-md-2">일정내용</th>
				<th class="col-md-2">여행일</th>
				<th class="col-md-2">정렬용순번</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.planNo}</td>
				<td>${list.userId}</td>
				<td>${list.addr}</td>
				<td>${list.descript}</td>
				<td>${list.planDay + 1} 일</td>
				<td>${list.rowNo}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<!-- 일정 출력 끝 -->
</div>
<br/>
<a href="/schedule/add">일정 추가하기</a>

	<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
      crossorigin="anonymous">
    </script>
    
</body>
</html>