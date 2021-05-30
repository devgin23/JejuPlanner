$(function(){
	//Schedule planDay 필드 변수 선언
	var idx;
	//PlanVO 필드 변수 선언
	var userId;
	var planTitle;
	var startDate;
	var planTotalDay;
	
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
	$('#planFrmSubmit').on('click', function(){
		//사용자 ID
		userId = $('#userId').val();
		//계획타이틀 값
		planTitle = $('#planTitle').val();
		//시작일 값
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
        				var min = '00';
        				schOutput+= '<td>' + hour + '시' + min + '분' + '</td>';
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
});


$(document).on("click", "#sortTable", function sortTable() {
	var table, rows, switching, i, x, y, shouldSwitch;
	
	table = $(".schTable")[0]; // [0]는 몇번 째 테이블에 접근할 것인지 명시해주는 키워드 (id 선택자를 쓰면 없어도 됨)
	switching = true;
	
	while (switching) {
		
		switching = false;
		rows = table.rows;
		
		//table head는 무시해야하기 때문에 i = 1부터 시작
		for (i = 1; i < (rows.length - 1); i++) {
			index = i;
			
			// ("TD")[0]는 첫번 째 필드를 의미한다. (startTime에 접근한다는 뜻)
			x = rows[i].getElementsByTagName("td")[0].innerHTML;
			y = rows[i + 1].getElementsByTagName("td")[0].innerHTML;
			
			console.log("x의 값 : " + x);
			console.log("y의 값 : " + y);
			
			if (x > y) {
				shouldSwitch = true;
				break;
			}
		}
		if (shouldSwitch) {
			rows[i].parentNode.insertBefore(rows[i + 1], rows[i]); //insertBefore : 특정 위치 앞에 노드 삽입
			switching = true;

		}
	}
});



/* 여행날짜 기본 값 삽입 스크립트 */
document.getElementById('startDate').value = new Date().toISOString().substring(0, 10);
