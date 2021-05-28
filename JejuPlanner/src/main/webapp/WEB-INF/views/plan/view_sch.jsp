<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
  crossorigin="anonymous"/>
  
  <style>
  .container{
  background-color:#D2FFD2;
  }
  </style>
  
</head>
<body>
<div class="row container">
<table>
	<thead>
		<tr>
			<th class="col-md-1">dummy</th>
			<th class="col-md-1">계획번호</th>
			<th class="col-md-1">아이디</th>
			<th class="col-md-1">계획제목</th>
			<th class="col-md-1">여행 총 일수</th>
			<th class="col-md-1">일정</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${view}" var="view">
		<tr>
			<td>여행</td>
			<td>${view.planNo}</td>
			<td>${view.userId}</td>
			<td>${view.planTitle}</td>
			<td>${view.planTotalDay}</td>
			<td>${view.scheduleVOList.descript}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</div>
<%-- ${view.scheduleVOList.descript}
${view.scheduleVOList.addr}<br/> --%>

<a href="/plan/write">돌아가기</a>
</body>
</html>