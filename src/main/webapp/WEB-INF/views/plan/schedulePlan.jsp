<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
 	 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
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
	<script type="text/javascript">
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
		})
		function fn_valiChk(){
			var regForm = $("form[name='writeForm'] .chk").length;
			for(var i = 0; i<regForm; i++){
				if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
					alert($(".chk").eq(i).attr("title"));
					return true;
				}
			}
		}
	</script>
	<body>
		<header>
			<%@include file="nav.jsp" %>
		</header>
		
		
		
			<section id="container">
				<form name="writeForm" method="post" action="/plan/schedulePlan">
					<!-- 로그인 유무 확인/로그인 시 -->
					<c:if test="${member.userId != null}">
					<div class="row h-100">
			        	<div class="col-8 map-area">로그인 되어 있음</div>
			        	<div class="col-4 plan-area"><%@ include file="planner.jsp" %></div>
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
			
				</form>
			</section>
					
				
				
			
	</body>
</html>