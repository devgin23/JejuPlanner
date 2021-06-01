<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- jquery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<!-- bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	<!-- custom, kakaoMap css -->
	<link href="/resources/css/write.css?ver=1" rel="stylesheet" type="text/css">
	 	<title>일정 만들기</title>
	</head>

	<body>
		<header>
			<%@include file="../nav.jsp" %>
		</header>
			<section id="container">
				<!-- 로그인 유무 확인/로그인 시 -->
				<c:if test="${member.userId != null}">
					<div class="row h-100">
				        	<!-- KAKAO MAP VIEW 영역 시작-->
						<div class="col-8 map-area">
							<div class="map_wrap">
								<div id="map"
									style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
								<ul id="category">
									<li id="BK9" data-order="0"><span class="category_bg bank"></span>
										은행</li>
									<li id="MT1" data-order="1"><span class="category_bg mart"></span>
										마트</li>
									<li id="PM9" data-order="2"><span class="category_bg pharmacy"></span> 
										약국</li>
									<li id="OL7" data-order="3"><span class="category_bg oil"></span>
										주유소</li>
									<li id="CE7" data-order="4"><span class="category_bg cafe"></span>
										카페</li>
									<li id="CS2" data-order="5"><span class="category_bg store"></span>
										편의점</li>
								</ul>
							</div>
						</div>
						<!-- KAKAO MAP VIEW 영역 끝-->
						
			        	<div class="col-4 plan-area">
				        	<%@ include file="planner.jsp" %>
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
			
			</section>
	
	</body>
		<!-- KAKAO MAP JavaScript -->
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bfe80ccda6d4728072437d233285847b&libraries=services"></script>
		<!-- custom, kakaoMap JavaScript -->
		<script type="text/javascript" src="/resources/js/write.js"></script>
		<!-- bootstrap -->	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
			crossorigin="anonymous"></script>
</html>