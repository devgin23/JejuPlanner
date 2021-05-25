<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="staticBackdropLabel">일정 짜기</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<!--private int planNo;
				private String userId;
				private String descript;
				private String addr;
				private int planDay;
				private int startTime;
				private int rowNo; --> 
			<div class="modal-body">
				<form id="frm">
					내용 		: <input type="text" name="descript"><br> 
					장소 		: <input type="text" name="addr"><br> 
					시작시간 	: <input type="text" name="startTime"><br>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
					<input type="submit" id="frmSubmit" class="btn btn-primary" data-bs-dismiss="modal">
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal"
	data-bs-target="#staticBackdrop">Launch static backdrop modal</button>
<div id="disp">일정 div</div>
<div id="place">장소 div</div>

 <!-- method="post" action="/plan/write/add" -->
<script>
$('#frmSubmit').on('click', function(){
    $.ajax({
        url: "/plan/write/schAdd",
        data: $('#frm').serialize(),
        dataType:"json",
        type: "POST",
        success: function(data){
        	var output='';
        	$.each(data,function(){
				output+= '<div>';
				output+= '<h3>'+ this.descript + '</h3>';
				output+= '<p>' + this.addr +'</p>';
				output+= '<p>' + this.startTime +'</p>';
				output+= '</div>';
			});
        	document.getElementById('disp').innerHTML = output;
        },
        error: function(){
            alert("일정 추가 실패!");
        }
    });
});
</script>
