$(function(){
	//Schedule planDay 필드 변수 선언
	var idx;
	//PlanVO 필드 변수 선언
	var userId;
	var planTitle;
	var startDate;
	var planTotalDay=0;
	
	//startTime select에 사용될 변수 선언
	for(var i = 1; i<=24; i++){
		if(i<10){
		$(".startTime").append("<option value="+i+">0"+ i + ":00</option>"); //10시 이전에는 0 붙게 조건문 걸음 ex) 9:00 -> 09:00
	}
		else{
			$(".startTime").append("<option value="+i+">"+ i + ":00</option>");			
		}
		//기본값 09:00로 함
		$('select option[value="9"]').attr("selected",true);
	}
	
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
		//사용자 ID
		userId = $('#userId').val();
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
				   var createDay = '<h4>'+ 'DAY'+ i + '</h4>';
				   createDay += '<button class="btn btn-primary"id="schAddBtn"type="button"data-bs-toggle="collapse" data-bs-target="#collapseExample"aria-expanded="false"aria-controls="collapseExample">';
				   createDay += '일정 생성';
				   createDay += '</button>';
				   /*createDay += '<div id=disp'+i+'></div>';*/
				   createDay += '<table id="disp'+i+'" class="schTable table table-borderless">';
				   createDay += '<thead class="thead">'
				   createDay += '<th>여행시간(hidden)</th><th>설명</th><th>주소</th><th>시간</th>';
				   createDay += '</thead>'
				   createDay += '</table>'
				   createDay += '<br/>';
				   if(i == planTotalDay){
					   createDay += '<button type="button" class="btn btn-primary submitBtn"  id="planAddBtn" onclick="location.href=\'/plan/write/planAdd\'" style="float:right;">일정 등록</button>';
				   }
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
	$(document).on("click", "#schAddBtn", function(){
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
        				
        				/* 
    	        		schOutput+= '<div>';
    	        		schOutput+= '<h5>'+ data.descript + '</h5>';
    	        		schOutput+= '<p>' + data.addr +'</p>';
    	        		//var hour = data.startTime/100;
    	        		//var min = data.startTime-(hour*100);
    	        		var hour = data.startTime;
    	        		var min = '00';
    	        		schOutput+= '<p>' + hour +'시 '+ min+'분' +'</p>';
    	        		schOutput+= '</div>';
    	        		$("#disp"+i).append(schOutput);
    	        		*/
        				
        				//table방식으로 출력 수정
        				schOutput+= '<tbody>';
        				schOutput+= '<tr>';
        				schOutput+= '<td>' + data.startTime + '</td>';
        				schOutput+= '<td>' + data.descript + '</td>';
        				schOutput+= '<td>' + data.addr + '</td>';
        				var hour = data.startTime;
        				if(hour < 10) hour = "0" + hour; //1자리 수 일시 0 포맷 추가
        				var min = '00';
        				schOutput+= '<td>' + hour + ':' + min + '' + '</td>';
        				schOutput+= '</tr>';
        				$("#disp"+i).append(schOutput);
        				schOutput+= '</tbody>';
        			}
        		}
	        },
	        error: function(){
	            alert("일정 추가 실패!");
	        },
	        complete: function(){
	        	$('#contentInit').val('');
        		$('#placeInit').val('');
        		/*$('#startTimeInit').val('9');*/
	        }
	    });
	});
	
	//일정정렬 스크립트
	$(document).on("click", "#schFrmSubmit", function sortTable() {
		setTimeout(function() { // 동시에 입력된 일정은 정렬 안되는 문제 있어서 delay를 0.1초 주었음
			var table, rows, i, j, x, y;
			var tableNum = 0;
			console.log("planTotalDay : ");
			
			//table loop
			while(tableNum<planTotalDay){
				console.log("tableNum : " + table);
				table = $(".schTable")[tableNum];
				console.log(table);
				rows = table.rows;
				
				//버블정렬, 컬럼명은 무시해야하기 때문에 1부터 시작
				for (i = 1; i<(rows.length - 1); i++) {
					for(j = 1; j<(rows.length - i); j++) {
						
						//switching ,(getElementsByTagName("td")[0]에서 [0]의 의미는 첫 번째 필드를 지목한다는 뜻) 
						if(parseInt(rows[j].getElementsByTagName("td")[0].innerHTML) > parseInt(rows[j + 1].getElementsByTagName("td")[0].innerHTML)) {
							
							//구조 분해 할당 : [3, 5] = [5, 3]  --> [5, 3]
							[rows[j].getElementsByTagName("td")[0].innerHTML,rows[j + 1].getElementsByTagName("td")[0].innerHTML]
							=[rows[j+1].getElementsByTagName("td")[0].innerHTML,rows[j].getElementsByTagName("td")[0].innerHTML];
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
