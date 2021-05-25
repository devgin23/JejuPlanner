

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

<title>일정 입력</title>
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
	
	<!-- 일정 입력 -->
	<div class="col-md-6 input-form">
		<p>입력폼</p>
			일정 번호 : ${formData.planNo}
			
		<form method="post" action="addschedule">
			<input type="hidden" name="planNo" value=${formData.planNo}></input>
			아이디 : <input type="text" name="userId"/> <br/>
			장소 : <input type="text" name="addr"/> <br/>		
			일정 내용 : <input type="text" name="descript"/> <br/>
			여행 일 : <input type="text" name="planDay"/> <br/>
			정렬순번 : <input type="text" name="rowNo"/> <br/>
			<button type="submit">작성</button>
		</form>
	</div>
	<!-- 일정 입력 끝 -->
	
	<a href="/controller/schedulelist">목록으로 돌아가기</a>
		
</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
      crossorigin="anonymous">
    </script>
    
</body>
</html>