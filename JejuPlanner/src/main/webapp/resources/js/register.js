function emulAcceptCharset(form) {
    if (form.canHaveHTML) { // detect IE
        document.charset = form.acceptCharset;
    }
    return true;
}

//아이디 중복검증
function fn_idCheck(){
	var userId = $("#userId").val();
	if(userId==''){
		$("#idCheck").attr("value", "B");
		alert('아이디를 입력해 주세요.');
	}else{
		$.ajax({
			url : "/member/register/idCheck",	//클라이언트가 요청보내는 주소
			type : "post",						//HTTP 요청방식 (GET, POST)
			data : {userId}, //HTTP 요청과 함께 보내는 데이터
			success : function(data){			//서버단으로 요청 전송이 성공하면 success 실행	
				if(data==1){
					//id Overlap
					$("#idCheck").attr("value", "D");
					alert("중복된 아이디입니다.");
				}else if(data==0){
					$("#idCheck").attr("value", "Y");
					alert("사용가능한 아이디입니다.");
				}
			}
		});
	}
}

$(function(){
    //모달을 전역변수로 선언
    var modalContents = $(".modal-contents");
    var modal = $("#defaultModal");
    
    
    
    $('.onlyAlphabetAndNumber').keyup(function(event){
        if (!(event.keyCode >=37 && event.keyCode<=40)) {
            var inputVal = $(this).val();
            $(this).val($(this).val().replace(/[^_a-z0-9]/gi,'')); //_(underscore), 영어, 숫자만 가능
        }
    });
    
    $(".onlyHangul").keyup(function(event){
        if (!(event.keyCode >=37 && event.keyCode<=40)) {
            var inputVal = $(this).val();
            $(this).val(inputVal.replace(/[a-z0-9]/gi,''));
        }
    });

    $(".onlyNumber").keyup(function(event){
        if (!(event.keyCode >=37 && event.keyCode<=40)) {
            var inputVal = $(this).val();
            $(this).val(inputVal.replace(/[^0-9]/gi,''));
        }
    });
    
    //------- validation 검사
    $( "form" ).submit(function( event ) {
        
        var divId = $('#userId');
        var idCheckVal = $('#idCheck');
        var divPassword = $('#divPassword');
        var divPasswordCheck = $('#divPasswordCheck');
        var divName = $('#divName');
        var divMail = $('#divMail');
        
        //아이디 검사
        if($('#userId').val()==""){
            modalContents.text("아이디를 입력하여 주시기 바랍니다.");
            modal.modal('show');
            
            $('#userId').focus();
            return false;
        }
        //아이디 중복 검사
        var idCheckVal = $("#idCheck").val();
        //아이디 중복검사 미실행 시
    	if(idCheckVal == "N"){
    		modalContents.text("아이디를 중복 확인을 주시기 바랍니다.");
            modal.modal('show');
            return false;
    	}
    	//아이디 중복 시
    	else if(idCheckVal == "D"){
    		modalContents.text("중복된 아이디 입니다.");
    		modal.modal('show');
    		return false;
    	}
    	else if(idCheckVal == "B"){
    		modalContents.text("아이디를 입력해 주세요.")
    		modal.modal('show');
    		return false;
    	}
        
        //패스워드 검사
        if($('#userPw').val()==""){
            modalContents.text("패스워드를 입력하여 주시기 바랍니다.");
            modal.modal('show');
            
            $('#userPw').focus();
            return false;
        }
        
        //패스워드 확인
        if($('#userPwCheck').val()==""){
            modalContents.text("패스워드 확인을 입력하여 주시기 바랍니다.");
            modal.modal('show');
            
            $('#userPwCheck').focus();
            return false;
        }
        
        //패스워드 비교
        if($('#userPw').val()!=$('#userPwCheck').val() || $('#userPwCheck').val()==""){
            modalContents.text("패스워드가 일치하지 않습니다.");
            modal.modal('show');
            
            $('#userPwCheck').focus();
            return false;
        }
        
        //이메일
        if($('#userMail').val()==""){
            modalContents.text("이메일을 입력하여 주시기 바랍니다.");
            modal.modal('show');
            
            $('#userMail').focus();
            return false;
        }
    });
});