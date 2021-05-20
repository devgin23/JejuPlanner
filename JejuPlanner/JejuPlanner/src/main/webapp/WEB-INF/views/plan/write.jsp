<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	 <style>
	     html, body {
	        background-color: powderblue;
	        height: 100%;
	      	}
	    	h1 {
	        color: blue;
	      }
	      p {
	        color: red;
	      }
	      .map-area {background-color: coral; text-align: center; line-height: ;}
	      .plan-area {background-color: #ddd;}
	    .nav-item{
	      padding:15px;
	      text-align: center;
	      cursor: pointer;
	    }
	    .nav-item a {
	      text-align:center;
	      text-decoration: none;
	      color: white;
	    }
	
	    .nav-item:hover, .logout{
	      background-color: grey;
	    }
	
	    .navbar{
	      padding:0;
	    }
	    .container-fluid{
	      padding-right: 0;
	      padding-left: 30px;
	    }
	    .row{
	      width:100%;
	    }
	 </style>
	 	
	 	<title>일정 만들기</title>
	</head>
<!-- 	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='writeForm']");
			$(".write_btn").on("click", function(){
				if(fn_valiChk()){
					return false;
				}
				formObj.attr("action", "/board/write");
				formObj.attr("method", "post");
				formObj.submit();
			});
		});
		function fn_valiChk(){
			var regForm = $("form[name='writeForm'] .chk").length;
			for(var i = 0; i<regForm; i++){
				if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
					alert($(".chk").eq(i).attr("title"));
					return true;
				}
			}
		}
	</script> -->
	<body>
		<header>
			<%@include file="../nav.jsp" %>
		</header>
		
		<!-- 로그인 유무 확인/로그인 시 -->
		<c:if test="${member.userId != null}">
		<div class="row h-100">
        	<div class="col-8 map-area">로그인 되어 있음</div>
        	<div class="col-4 plan-area">
        	<%-- <%@ include file="planner.jsp" %> --%>
        	<%@ include file="schedule.jsp" %>
   			</div>
   		</div>
    	</c:if>
    	<!-- 로그인 유무 확인/비로그인 시 -->	
    	<c:if test="${member.userId == null}">
    		<p>로그인 후에 작성하실 수 있습니다.</p>
    		<script>
    			alert("로그인이 필요합니다.");
    			document.location.href="/";
    		</script>
		</c:if>
			
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
	</body>
</html>