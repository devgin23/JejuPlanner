var idx;

$(function(){
	//Schedule planDay 필드 변수 선언
	
	//PlanVO 필드 변수 선언
	var userId = $('#userIdCheck').val();
	var planTitle;
	var startDate;
	var planTotalDay = 0;
	var deleteCount = 0;
	//collapse 생성 함수
	//id 마다 i 부여
	function createCollapse(i) {
		var createStringCollap;
		createStringCollap = '<div class="card card-body">';
		createStringCollap += '<form id="schFrm'+i+'">';
		createStringCollap += '<input type="hidden" id="userId" name="userId" value="'+ userId +'">';
		createStringCollap += '<input type="hidden" id="schDay'+i+'" name="planDay" value="" readonly	style="width: 20px; text-align: center"/>';
		createStringCollap += '<div class="input-group input-group-sm mb-3">'
		createStringCollap += '<span class="input-group-text" id="inputGroup-sizing-sm">장소</span>'
		createStringCollap += '<input type="text" class="form-control" id="placeInit'+i+'" name="addr"></div>'
		createStringCollap += '<div class="input-group mb-3">'
		createStringCollap += '<label class="input-group-text" for="startTimeInit">시작시간</label>'
		createStringCollap += '<select class="form-select startTime" id="startTimeInit" name="startTime"></select></div>'
		createStringCollap += '<div class="input-group">'
		createStringCollap += '<span class="input-group-text">설명</span>'
		createStringCollap += '<textarea class="form-control" id="contentInit'+i+'" name="descript"></textarea></div>'	
		createStringCollap += '<input type="button" id="schFrmSubmit'+i+'" class="btn btn-primary" data-bs-target="#collapseExample" data-bs-toggle="collapse'+i+'" value="추가">';
		createStringCollap += '</div>';
		
		$("#collapse"+i).html(createStringCollap);
	};
	
	//드롭다운 값변경 스크립트
    $(".dropdown-menu li a").click(function(){
    	$(".btn-day:first-child").text($(this).text());
    	$(".btn-day:first-child").val($(this).text());
    	//총 일수 변수 초기화
    	planTotalDay = $(this).attr('value');
   });
   // method="post" action="/plan/write/planAdd"
   // Plan 설정 유효성 검사 및 제출
	$('#planFrmSubmit').on('click', function(){
		//버튼 인덱스 값 초기화
		idx=0;
		//사용자 ID
//		userId = $('#userId').val();
		//계획타이틀 값 검사 및 초기화
		if($('#planTitle').val()==""){
			alert('일정 타이틀을 입력해주세요!');
			$('#planTitle').focus();
			return false;
		}else{
			planTitle = $('#planTitle').val();
		}
		//여행 일수 값 검사 초기화는 위 드롭다운 함수에!
		if(planTotalDay==0){
			alert('여행 일수를 선택해주세요!');
			return false;
		}
		//시작일 값 (디폴트 값 09:00)
		startDate = $('#startDate').val();
		$.ajax({
		   url: "/plan/write/planSet",
		   data: {userId: userId, planTitle: planTitle, startDate: startDate, planTotalDay: planTotalDay},
		   dataType:"json",
		   type: "POST",
		   cache : false,
		   success: function(data){
			   var planOutput = '';
			   for(var i = 1; i<=planTotalDay; i++){
				   var createDay = '<div><h4>DAY'+ i + '</h4>';
				   createDay += '<button class="btn btn-primary"id="schAddBtn'+i+'"type="button"data-bs-toggle="collapse" data-bs-target="#collapse'+i+'"aria-expanded="false"aria-controls="collapseExample">';
				   createDay += '일정 생성';
				   createDay += '</button>';
				   createDay += '<div class="collapse" id="collapse'+i+'"></div>'
				   
				   /*createDay += '<table class="schTable table table-borderless">';
				   createDay += '<thead class="thead">'
				   createDay += '<th>여행시간(hidden)</th><th>설명</th><th>주소</th><th>시간</th><th></th>';
				   createDay += '</thead>'
				   createDay += '<tbody id="disp'+i+'">'
				   createDay += '</tbody>'
				   createDay += '</table>'*/
				   
				   createDay += '<div id="disp'+i+'"></div>'
				   createDay += '</div>';
				   if(i == planTotalDay){
					   createDay += '<button type="button" class="btn btn-primary submitBtn" id="planAddBtn" style="float:right;">일정 등록</button>';
				   }
				   planOutput = planOutput + createDay;
			   }
			   $("#schDiv").html(planOutput);
			    for(var i = 1; i<=planTotalDay; i++){
				   createCollapse(i);
				   
			   }
		   },
		   error: function(){
		       alert("일정 추가 실패!");
		    }
		});
	});
	// planAdd 유효성 검사
	$(document).on('click', 'button[id=planAddBtn]', function(){
		for(var i=1; i<=planTotalDay; i++){
			//tr의 요소 길이 측정, 값이 없을 시 0
			if ($('#disp'+i+' .card').length == 0) {
				alert('DAY에 일정을 추가해 주세요!');
				return false;
			}
		}
		location.href='/plan/write/planAdd';
	});
	
	//일정 생성 버튼마다 day 순서 받아오기
	$(document).on("click", 'button[id^=schAddBtn]', function(){
		
		//startTime select에 사용될 변수 선언
		if(idx==0){
	        for(var i = 6; i<=24; i++){
				if(i<10){
				$(".startTime").append("<option value="+i+">0"+ i + ":00</option>"); //10시 이전에는 0 붙게 조건문 걸음 ex) 9:00 -> 09:00
			}
				else{
					$(".startTime").append("<option value="+i+">"+ i + ":00</option>");			
				}
				
				//기본값 09:00로 함
				$('select option[value="9"]').attr("selected",true);
			}
		}
		//버튼 tag만! index 값 변수로 받기
        idx = $('button[id^=schAddBtn]').index(this)+1;
        //다른게 열려 있는지 확인하는 로그
        console.log($('.collapse').hasClass('show'));
        console.log($('#userIdCheck').val());
        console.log(userId);
        //다른게 열려 있을 때
        if($('.collapse').hasClass('show')){
        	//modal schDay input에 값 추가
        	$("#schDay"+idx).attr({"value":idx});
        	//collapse 닫기
        	$('.collapse').removeClass('show');
        }
        //다른게 안 열려 있을 때
        else {
        	//modal schDay input에 값 추가
        	$("#schDay"+idx).attr({"value":idx});
        }
        //idx 값 확인 로그
        console.log("idx : " + idx);
    
	});
	
	//method="post" action="/plan/write/schAdd"
	$(document).on('click', 'input[id^=schFrmSubmit]', function(){
		
	    $.ajax({
	        url: "/plan/write/schAdd",
	        data: $('#schFrm'+idx).serialize(),
	        dataType:"json",
	        type: "POST",
	        success: function(data){
				deleteCount += 1;
				var schOutput='';
			
				//startTime 형태 바꾸기.
				var hour = data.startTime;
				if(hour < 10) hour = "0" + hour; //1자리 수 일시 0 포맷 추가
				var min = '00';
								
				//card형식으로 바꿈.
				schOutput+= '<div class="card" style="width: 18rem;">';
				schOutput+= '<div class="card-body cardTable">';
				schOutput+= '<h5 class="card-title">' + data.addr + '</h5>';
				schOutput+= '<h3 class="card-title" style="display:none;">' + data.startTime + '</h3>';
				schOutput+= '<h6 id="vall" class="card-subtitle mb-2 text-muted" value='+data.startTime+'>' + hour + ':' + min + '' + '</h6>';
				schOutput+= '<p class="card-text">' + data.descript + '</p>';
				schOutput+= '<button type="button" class="btn btn-primary btn-sm" id="deletePlan'+deleteCount+'">delete</button>';
				schOutput+= '</div></div>';
								
				
				
				$("#disp"+data.planDay).append(schOutput);
				
				console.log($('#vall').val());
        			
        		
	        },
	        error: function(){
	            alert("일정 추가 실패!");
	        },
	        complete: function(){
	        	$('#contentInit'+idx).val('');
        		$('#placeInit'+idx).val('');
        		/*$('#startTimeInit').val('9');*/
	        }
	    });
	});
	
	//장바구니에서 일정 빼기 버튼 (-)
	$(document).on("click", 'button[id^=deletePlan]', function(){
	
		//버튼이 있는 행의 td들의 객체를 변수 선언
		
		var deleteMap = {startTime :$(this).siblings('h3').html() , planDay : idx, descript :$(this).siblings('p').html(), addr :  $(this).siblings('h5').html()}
		
		$.ajax({
			url : "/plan/write/planDel",
			type : "POST",
			data : JSON.stringify(deleteMap),
			contentType : "application/json; charset=utf-8;",
			dataType : "text",
			success : function(data){
				
			},
			error : function() {
				alert("simpleWithObject err");
			},
			complete : function() {
				console.log(deleteMap);
			}
		});
		$(this).parent().parent().remove();
		
	});
	
	//일정정렬 스크립트
	$(document).on("click", 'input[id^=schFrmSubmit]' , function sortTable() {
		setTimeout(function() { // 동시에 입력된 일정은 정렬 안되는 문제 있어서 delay를 0.1초 주었음
			var i, j;
			var dispNum = 1;
			
			//table loop
			while(dispNum<=planTotalDay){
				var card = $('#disp'+dispNum+' .cardTable');
				var timeTag = card.children('h3');
				
				//버블정렬
				for (i = 0; i<(timeTag.length - 1); i++) {
					for(j = 0; j<(timeTag.length - i); j++) {
						//$()는 객체를 리턴, Node를 출력하고 싶으면 $()[0] 으로 해야한다
						if(parseInt(timeTag.eq(j).html()) > parseInt(timeTag.eq(j+1).html())) {
							//A.insertBefore(B,C) A,B,C 모두 Node여야 한다. A안에서 B를 C의 앞으로 보낸다.
							$('#disp'+dispNum)[0].insertBefore(timeTag.eq(j+1)[0].parentNode.parentNode, timeTag.eq(j)[0].parentNode.parentNode);
						}
					}
				}
				dispNum++;
			}
		}, 100);
	});
	
	
});

/* 여행날짜 기본 값 삽입 스크립트 */
document.getElementById('startDate').value = new Date().toISOString().substring(0, 10);
