$(function(){
	//Schedule planDay 필드 변수 선언
	var idx;
	//PlanVO 필드 변수 선언
	var userId;
	var planTitle;
	var startDate;
	var planTotalDay;
	//드롭다운 값변경 스크립트
    $(".dropdown-menu li a").click(function(){
    	$(".btn-day:first-child").text($(this).text());
    	$(".btn-day:first-child").val($(this).text());
    	//총 일수 변수 초기화
    	planTotalDay = $(this).attr('value');
   });
   // method="post" action="/plan/write/planAdd"
	$('#planFrmSubmit').on('click', function(){
		//사용자 ID
		userId = "${member.userId}";
		//계획타이틀 값
		planTitle = $('#planTitle').val();
		//시작일 값
		startDate = $('#startDate').val();
		$.ajax({
		   url: "/plan/write/planAdd",
		   data: {userId: userId, planTitle: planTitle, startDate: startDate, planTotalDay: planTotalDay},
		   dataType:"json",
		   type: "POST",
		   cache : false,
		   success: function(data){
			   var planOutput = '';
			   for(var i = 1; i<=planTotalDay; i++){
				   var createDay = '<h4>'+ 'DAY'+ i + '</h4>';
				   createDay += '<button type="button" class="btn btn-primary" data-bs-toggle="modal"data-bs-target="#staticBackdrop" id="addSchBtn">';
				   createDay += '일정 생성';
				   createDay += '</button>';
				   createDay += '<div id=disp'+i+'></div>';
				   createDay += '<br/>';
				   planOutput = planOutput + createDay;
			   }
			   $("#schDiv").html(planOutput);
		   },
		   error: function(){
		       alert("일정 추가 실패!");
		    }
		});
	});
	//일정 생성 버튼마다 day 순서 받아오기
	$(document).on("click", "#addSchBtn", function(){
		//버튼 tag만! index 값 변수로 받기
        idx = $('button').index(this);
		//modal schDay input에 값 추가
        $("#schDay").attr({"value":idx});
    });
	//method="post" action="/plan/write/schAdd"
	$('#schFrmSubmit').on('click', function(){
	    $.ajax({
	        url: "/plan/write/schAdd",
	        data: $('#schFrm').serialize(),
	        dataType:"json",
	        type: "POST",
	        success: function(data){
        		for(var i=1; i<=planTotalDay; i++){
        			if(data.planDay == i){
        				var schOutput='';
    	        		schOutput+= '<div>';
    	        		schOutput+= '<h5>'+ data.descript + '</h5>';
    	        		schOutput+= '<p>' + data.addr +'</p>';
    	        		var hour = data.startTime/100;
    	        		var min = data.startTime-(hour*100);
    	        		schOutput+= '<p>' + hour +'시 '+ min+'분' +'</p>';
    	        		schOutput+= '</div>';
    	        		$("#disp"+i).append(schOutput);
        			}
        		}
	        },
	        error: function(){
	            alert("일정 추가 실패!");
	        }
	    });
	});
});

/* 여행날짜 기본 값 삽입 스크립트 */
document.getElementById('startDate').value = new Date().toISOString().substring(0, 10);
