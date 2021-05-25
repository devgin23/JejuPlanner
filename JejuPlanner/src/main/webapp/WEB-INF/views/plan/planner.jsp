<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap Script -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>  
<style>
  .input-form {
  background-color: powderblue;
  }
  
  .output-form {
  background-color: #D2FFD2;
  }
</style>

</head>
<body>	
	<!-- 계획 입력 -->
	<div class="col-md-12 input-form">
		<form id="planFrm" name="planFrm">
			<table>
			<tr>
				<td>여행 제목 : </td>
				<td><input type="text" class="form-control" name="planTitle" }/></td>
			</tr>
			<tr>
				<td>여행 날짜 : </td>
				<td>
					<input type="date" class="form-control" id="startDate" name="satrtDate" value="<fmt:formatDate value="${view.startDate}" pattern="yyyy-MM-dd"/>"/>
				</td>
			<td>
			<div class="dropdown">
				<button class="btn btn-day btn-secondary dropdown-toggle" id="method_status" type="button" id="dropdownMenuButton" data-toggle="dropdown">
				 일수
				</button>
				<ul id="method_type" class="dropdown-menu">
					<li class="dropdown-item"><a href="#" id="planTotalDay" value="1">1일</a></li>
				    <li class="dropdown-item"><a href="#" id="planTotalDay" value="2">2일</a></li>
				    <li class="dropdown-item"><a href="#" id="planTotalDay" value="3">3일</a></li>
				    <li class="dropdown-item"><a href="#" id="planTotalDay" value="4">4일</a></li>
				    <li class="dropdown-item"><a href="#" id="planTotalDay" value="5">5일</a></li>
				    <li class="dropdown-item"><a href="#" id="planTotalDay" value="6">6일</a></li>
				    <li class="dropdown-item"><a href="#" id="planTotalDay" value="7">7일</a></li>
   				</ul>
			</div>
				</td>
			</tr>
			<tr>
				<td><input type="button" class="btn btn-primary mb-3" id="planFrmSubmit" name="planFrmSubmit" value="작성"></input></td>
			</tr>
			</table>
		</form>
	</div>
	<!-- 계획 입력 끝 -->
	<div id="schDiv"></div>
	<div id="place">장소 div</div>
	
	<!-- 일정 추가 Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">일정 짜기</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<!--private int planNo;
					private String userId;
					private String descript;
					private String addr;
					private int planDay;
					private int startTime;
					private int rowNo; --> 
				<div class="modal-body">
					<form id="schFrm">
						<input type="hidden" id="userId" name="userId" value="${member.userId}">
						<label>Day</label>
						<input type="text" id="schDay" name="planDay" value="" readonly style="width:20px; text-align: center"/><br/>
						내용 		: <input type="text" name="descript"><br> 
						장소 		: <input type="text" name="addr"><br> 
						시작시간 	: <input type="text" name="startTime"><br>
					</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
						<input type="button" id="schFrmSubmit" class="btn btn-primary" data-bs-dismiss="modal" value="추가">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<!-- Custom JavaScript -->
<script type="text/javascript" src="/resources/js/planner.js"></script>
</html>