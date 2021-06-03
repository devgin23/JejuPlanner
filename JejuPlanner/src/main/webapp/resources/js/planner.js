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
		createStringCollap = '<div>hello bitches!'+i+'</div>';
		createStringCollap += '<div class="card card-body">';
		createStringCollap += '<form id="schFrm'+i+'">';
		createStringCollap += '<input type="hidden" id="userId" name="userId" value="'+ userId +'">';
		createStringCollap += '<label>Day</label>';
		createStringCollap += '<input type="text" id="schDay'+i+'" name="planDay" value="" readonly	style="width: 20px; text-align: center"/><br/>';
		createStringCollap += '내용 : <input	type="text" id="contentInit'+i+'" name="descript"><br>';
		createStringCollap += '장소 : <input	type="text" id="placeInit'+i+'" name="addr"><br>';
		createStringCollap += '시작시간 : <select class="startTime form-select" id="startTimeInit" name="startTime"></select><br></form>';
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
				   var createDay = '<div>'+'<h4>'+ 'DAY'+ i + '</h4>';
				   createDay += '<button class="btn btn-primary"id="schAddBtn'+i+'"type="button"data-bs-toggle="collapse" data-bs-target="#collapse'+i+'"aria-expanded="false"aria-controls="collapseExample">';
				   createDay += '일정 생성';
				   createDay += '</button>';
				   createDay += '<div class="collapse" id="collapse'+i+'"></div>'
				   /*createDay += '<div id=disp'+i+'></div>';*/
				   createDay += '<table class="schTable table table-borderless">';
				   createDay += '<thead class="thead">'
				   createDay += '<th>여행시간(hidden)</th><th>설명</th><th>주소</th><th>시간</th><th></th>';
				   createDay += '</thead>'
				   createDay += '<tbody id="disp'+i+'">'
				   createDay += '</tbody>'
				   createDay += '</table>'
				   createDay += '<br/></div>';
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
			if ($('table #disp'+i+' tr').length == 0) {
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
        idx = $('button').index(this);
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
			
				//table방식으로 출력 수정
				
				schOutput+= '<tr>';
				schOutput+= '<td>' + data.startTime + '</td>';
				schOutput+= '<td>' + data.descript + '</td>';
				schOutput+= '<td>' + data.addr + '</td>';
				
				var hour = data.startTime;
				if(hour < 10) hour = "0" + hour; //1자리 수 일시 0 포맷 추가
				var min = '00';
				schOutput+= '<td>' + hour + ':' + min + '' + '</td>';
				schOutput+= '<td><input type="button" id="deletePlan'+deleteCount+'" value="-"/></td>';
				schOutput+= '</tr>';
				
				$("#disp"+data.planDay).append(schOutput);
				
        				
        			
        		
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
	$(document).on("click", 'input[id^=deletePlan]', function(){
	
		//버튼이 있는 행의 td들의 객체를 변수 선언
		var tableData = $(this).parents('tr').children();
		var deleteMap = {startTime : tableData.eq(0).html(), planDay : idx, descript : tableData.eq(1).html(), addr : tableData.eq(2).html() }
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
			var table, rows, i, j, x, y;
			var tableNum = 0;
			
			//table loop
			while(tableNum<planTotalDay){
				table = $(".schTable")[tableNum];
				rows = table.rows;
				console.log(rows);
				
				//버블정렬, 컬럼명은 무시해야하기 때문에 1부터 시작
				for (i = 1; i<(rows.length - 1); i++) {
					for(j = 1; j<(rows.length - i); j++) {
						
						//switching ,(getElementsByTagName("td")[0]에서 [0]의 의미는 첫 번째 필드를 지목한다는 뜻) 
						if(parseInt(rows[j].getElementsByTagName("td")[0].innerHTML) > parseInt(rows[j + 1].getElementsByTagName("td")[0].innerHTML)) {
							rows[j].parentNode.insertBefore(rows[j + 1], rows[j]); //insertBefore(앞의 노드를	 뒤 노드에 삽입)
						}
					}
				}
				tableNum++;
			}
		}, 100);
	});
	
	
});

/* 여행날짜 기본 값 삽입 스크립트 */
document.getElementById('startDate').value = new Date().toISOString().substring(0, 10);
