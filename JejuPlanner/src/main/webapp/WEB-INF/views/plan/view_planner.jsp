<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap Script -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<style>

  .dropdown-menu{
  	width:50px;
  	text-align:center;
  }
  .schDiv{
  	margin-right: 10px;
  }
  #plannerDiv{
  	overflow:auto; 
  	width:100%; 
  	height:90%;
  }

  /* btn-primary 색깔 바꾸기 css */
  /* .btn-primary {
    background-color: #7bc143;
    border-color: #7bc143;
    color: #FFF; }
	.btn-primary:hover,
	.btn-primary:focus {
    border-color: #6fb03a;
    background-color: #6fb03a;
    color: #FFF; }
	.btn-primary:active,
	.btn-primary:visited,
	.btn-primary:active:focus,
	.btn-primary:active:hover {
    border-color: #639d34;
    background-color: #639d34;
    color: #FFF; } */
</style>

</head>
<body>
	<input type="hidden" id="userIdCheck" value="${member.userId}">
	<div id="plannerDiv">
	<!-- 계획 입력 -->
	<div class="col-md-12">
	<form id="planFrm" name="planFrm" method="post" action="/plan/view/modify" >
		<div class="row">
			<input type="hidden" name="planNo" value="${planView.planNo}"/>
			<input type="hidden" name="userId" value="${member.userId}"/>
			<div class="form-group col-sm-12">
				<label>여행 제목</label>
				<input type="text" class="form-control" id="planTitle" name="planTitle" value="${planView.planTitle}" placeholder="일정 타이틀" readonly/>
			</div>
			<div class="form-group col-sm-6"> 
				<label>여행 날짜</label>
				<input type="date" class="form-control" id="startDate" name="startDate" value="<fmt:formatDate value="${planView.startDate}" pattern="yyyy-MM-dd"/>" readonly/>
			</div>
			
			<div class="form-group col-sm-4">
				<label>여행 일수</label>
				<select id="planTotalDayCount" class="form-select">
				  <option value="${planView.planTotalDay}" selected>${planView.planTotalDay}일</option>
				</select>
			</div>
			<div class="form-group col-sm-2">
				<input type="button" class="btn btn-primary mb-3" id="planModifyStart" name="planModifyStart" value="수정" style="float:right; margin-top: 25px;">
				<input type="submit" class="btn btn-primary mb-3" id="planModifyEnd" name="planModifyEnd" value="완료" style="float:right; margin-top: 25px; display: none;">
			</div>
		</div>
	</form>
	</div>
	<!-- 계획 입력 끝 -->
	
	<!-- 계획 출력 DIV -->
		<div id="schDiv">
			<div>
				<c:forEach var="dayCnt" begin="1" end="${planView.planTotalDay}" step="1">
					<h3>Day${dayCnt}</h3>
					<c:forEach items="${scheduleList}" var="scheduleList">
						<c:if test="${scheduleList.planDay == 1}">
							<div class="card" style="width: 18rem;">
								<div class="card-body cardTable">
								<h5 class="card-title">${scheduleList.addr}</h5>
								<h3 class="card-title" style="display:none;">${scheduleList.startTime}</h3>
								<h6 class="card-subtitle mb-2 text-muted">${scheduleList.startTime} : 00</h6>
								<p class="card-text">${scheduleList.descript}</p>
								<button type="button" class="btn btn-primary btn-sm" id="deletePlan'+deleteCount+'">delete</button>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
	</div>
	
</body>

</html>