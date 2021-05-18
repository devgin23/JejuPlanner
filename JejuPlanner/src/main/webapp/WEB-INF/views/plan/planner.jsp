<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
  crossorigin="anonymous"/> -->
  
<style>
  .input-form {
  background-color: powderblue;
  }
  
  .output-form {
  background-color: #D2FFD2;
  }
</style>

<title>계획 입력 폼</title>
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
	
	<!-- 계획 입력 -->
	<div class="col-md-12 input-form">
		<p>계획 입력폼</p>
			
		<form method="post" action="">
			<table>
			<tr>
				<td>계획 번호 :</td> 
				<td><input type="text" class="form-control form-control-sm" placeholder="임시 값 ${formData.planNo}" readonly></td> <!-- 임시 필드 -->
				<td><input type="hidden" name="planNo" value=${formData.planNo}></input> hidden예정</td>
			</tr>
			<tr>
				<td>아 이 디 : </td>
				<td><input type="text" class="form-control" name="userId" placeholder="${member.userId}" readonly/></td><td>hidden예정</td>
			</tr>
			<tr>
				<td>여행 제목 : </td>
				<td><input type="text" class="form-control" name="planTitle"/></td>
			</tr>
			<tr>
				<td>여행 날짜 : </td>
				<td><input type="date" class="form-control" id="currentDate" name="planDate"/></td>
				<td>
			<div class="dropdown">
				<button class="btn btn-day btn-secondary dropdown-toggle" id="method_status" type="button" id="dropdownMenuButton" data-toggle="dropdown">
				    1일
				</button>
				<ul id="method_type" class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<li class="dropdown-item"><a href="#">1일</a></li>
				    <li class="dropdown-item"><a href="#">2일</a></li>
				    <li class="dropdown-item"><a href="#">3일</a></li>
				    <li class="dropdown-item"><a href="#">4일</a></li>
				    <li class="dropdown-item"><a href="#">5일</a></li>
				    <li class="dropdown-item"><a href="#">6일</a></li>
				    <li class="dropdown-item"><a href="#">7일</a></li>
				    <li class="dropdown-item"><a href="#">8일</a></li>
				    <li class="dropdown-item"><a href="#">9일</a></li>
   				</ul>
			</div>
				</td>
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-primary mb-3">작성</button></td>
			</tr>
			</table>
		</form>
	</div>
	<!-- 계획 입력 끝 -->
	
<!-- Option 1: Bootstrap Bundle with Popper -->
<!--
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
  crossorigin="anonymous">
</script> -->

<!-- 중요! 위 스크립트 안먹혀서 아래걸로 바꿔놓음 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

<!-- 드롭다운 값변경 스크립트 -->
<script>
$(function(){
    $(".dropdown-menu li a").click(function(){
    	$(".btn-day:first-child").text($(this).text());
    	$(".btn-day:first-child").val($(this).text());
   });
});
</script>

<!-- 여행날짜 기본 값 삽입 스크립트 -->
<script>
  document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);;
</script>

</body>
</html>