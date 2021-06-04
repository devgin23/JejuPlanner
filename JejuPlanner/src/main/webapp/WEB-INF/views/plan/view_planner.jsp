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

  .input-form {
  	background-color: powderblue;
  }
  
  .output-form {
  	background-color: #D2FFD2;
  }
  .dropdown-menu{
  	width:50px;
  	text-align:center;
  }
  .schDiv{
  	margin-right: 10px;
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
	<div style="overflow:auto; width:100%; height:100%;">
	<!-- 계획 입력 -->
	<div class="col-md-12">
	<form id="planFrm" name="planFrm" >
		<div class="row">
			<div class="form-group col-sm-12">
				<label>일정 타이틀</label>
				<input type="text" class="form-control" id="planTitle" name="planTitle" value="" placeholder="일정 타이틀"/>
			</div>
			<div class="form-group col-sm-6">
				<label>여행 날짜</label>
				<input type="date" class="form-control" id="startDate" name="startDate" value="<fmt:formatDate value="" pattern="yyyy-MM-dd"/>"/>
			</div>
			
			<div class="form-group col-sm-4">
				<label>여행 일수</label>
				<div class="dropdown">
					<button class="btn btn-day btn-primary dropdown-toggle" id="method_status" type="button" id="dropdownMenuButton" data-toggle="dropdown">
					 일수
					</button>
					<ul id="method_type" class="dropdown-menu"  style="text-align:center;">	
						<li class="dropdown-item"><a href="#" id="planTotalDay" value="1"><div>1일</div></a></li>
						<li class="dropdown-item"><a href="#" id="planTotalDay" value="2"><div>2일</div></a></li>
						<li class="dropdown-item"><a href="#" id="planTotalDay" value="3"><div>3일</div></a></li>
						<li class="dropdown-item"><a href="#" id="planTotalDay" value="4"><div>4일</div></a></li>
						<li class="dropdown-item"><a href="#" id="planTotalDay" value="5"><div>5일</div></a></li>
						<li class="dropdown-item"><a href="#" id="planTotalDay" value="6"><div>6일</div></a></li>
						<li class="dropdown-item"><a href="#" id="planTotalDay" value="7"><div>7일</div></a></li>
					</ul>
				</div>
			</div>
			<div class="form-group col-sm-2">
				<input type="button" class="btn btn-primary mb-3" id="planFrmSubmit" name="planFrmSubmit" value="작성" style="float:right; margin-top: 25px;">
			</div>
		</div>
	</form>
	</div>
	<!-- 계획 입력 끝 -->
	
	<!-- 계획 출력 DIV -->
	<div id="schDiv"></div>
	</div>
</body>

</html>