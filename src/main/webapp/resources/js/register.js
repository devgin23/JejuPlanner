function emulAcceptCharset(form) {
    if (form.canHaveHTML) { // detect IE
        document.charset = form.acceptCharset;
    }
    return true;
}
//아이디 중복검증 결과값 전역변수 선언
var idCheckResult = 1;
//아이디 중복검증
function fn_idCheck(){
	$.ajax({
		url : "/member/register/idCheck",	//클라이언트가 요청보내는 주소
		type : "post",						//HTTP 요청방식 (GET, POST)
		data : {"userId" : $("#userId").val()}, //HTTP 요청과 함께 보내는 데이터
		success : function(data){			//서버단으로 요청 전송이 성공하면 success 실행	
			if(data==1){
				idCheckResult = data;
				//id Overlap
				$("#idCheck").attr("value", "O");
				alert("중복된 아이디입니다.");
			}else if(data==0){
				idCheckResult = data;
				$("#idCheck").attr("value", "Y");
				alert("사용가능한 아이디입니다.");
			}
		}
	})
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
    
    //------- 검사하여 상태를 class에 적용
    $('#userId').keyup(function(event){
        
        var divId = $('#divId');
        
        if($('#userId').val()==""){
            divId.removeClass("has-success");
            divId.addClass("has-error");
        }else{
            divId.removeClass("has-error");
            divId.addClass("has-success");
        }
    });
    
    $('#userPw').keyup(function(event){
        
        var divPassword = $('#divPassword');
        
        if($('#userPw').val()==""){
            divPassword.removeClass("has-success");
            divPassword.addClass("has-error");
        }else{
            divPassword.removeClass("has-error");
            divPassword.addClass("has-success");
        }
    });
    
    $('#userPwCheck').keyup(function(event){
        
        var passwordCheck = $('#userPwCheck').val();
        var password = $('#userPw').val();
        var divPasswordCheck = $('#divPasswordCheck');
        
        if((passwordCheck=="") || (password!=passwordCheck)){
            divPasswordCheck.removeClass("has-success");
            divPasswordCheck.addClass("has-error");
        }else{
            divPasswordCheck.removeClass("has-error");
            divPasswordCheck.addClass("has-success");
        }
    });
    
    
    $('#userNickname').keyup(function(event){
        
        var divNickname = $('#divNickname');
        
        if($.trim($('#userNickname').val())==""){
            divNickname.removeClass("has-success");
            divNickname.addClass("has-error");
        }else{
            divNickname.removeClass("has-error");
            divNickname.addClass("has-success");
        }
    });
    
    $('#userMail').keyup(function(event){
        
        var divMail = $('#divMail');
        
        if($.trim($('#userMail').val())==""){
            divMail.removeClass("has-success");
            divMail.addClass("has-error");
        }else{
            divMail.removeClass("has-error");
            divMail.addClass("has-success");
        }
    });

    
    
    //------- validation 검사
    $( "form" ).submit(function( event ) {
        
        var divId = $('#userId');
        var idCheckVal = $('#idCheck');
        var divPassword = $('#divPassword');
        var divPasswordCheck = $('#divPasswordCheck');
        var divName = $('#divName');
        var divNickname = $('#divNickname');
        var divMail = $('#divMail');
        
        
        //아이디 검사
        if($('#userId').val()==""){
            modalContents.text("아이디를 입력하여 주시기 바랍니다.");
            modal.modal('show');
            
            divId.removeClass("has-success");
            divId.addClass("has-error");
            $('#userId').focus();
            return false;
        }else{
            divId.removeClass("has-error");
            divId.addClass("has-success");
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
    	else if(idCheckVal == "O"){
    		modalContents.text("중복된 아이디 입니다.");
    		modal.modal('show');
    		return false;
    	}
    	//아이디 중복검사 통과 시
    	else if(idCheckVal == "Y"){
    		divId.removeClass("has-error");
            divId.addClass("has-success");
    	}
        
        
        //패스워드 검사
        if($('#userPw').val()==""){
            modalContents.text("패스워드를 입력하여 주시기 바랍니다.");
            modal.modal('show');
            
            divPassword.removeClass("has-success");
            divPassword.addClass("has-error");
            $('#userPw').focus();
            return false;
        }else{
            divPassword.removeClass("has-error");
            divPassword.addClass("has-success");
        }
        
        //패스워드 확인
        if($('#userPwCheck').val()==""){
            modalContents.text("패스워드 확인을 입력하여 주시기 바랍니다.");
            modal.modal('show');
            
            divPasswordCheck.removeClass("has-success");
            divPasswordCheck.addClass("has-error");
            $('#userPwCheck').focus();
            return false;
        }else{
            divPasswordCheck.removeClass("has-error");
            divPasswordCheck.addClass("has-success");
        }
        
        //패스워드 비교
        if($('#userPw').val()!=$('#userPwCheck').val() || $('#userPwCheck').val()==""){
            modalContents.text("패스워드가 일치하지 않습니다.");
            modal.modal('show');
            
            divPasswordCheck.removeClass("has-success");
            divPasswordCheck.addClass("has-error");
            $('#userPwCheck').focus();
            return false;
        }else{
            divPasswordCheck.removeClass("has-error");
            divPasswordCheck.addClass("has-success");
        }  
        
        //별명
        if($('#userNickname').val()==""){
            modalContents.text("별명을 입력하여 주시기 바랍니다.");
            modal.modal('show');
            
            divNickname.removeClass("has-success");
            divNickname.addClass("has-error");
            $('#userNickname').focus();
            return false;
        }else{
            divNickname.removeClass("has-error");
            divNickname.addClass("has-success");
        }
        
        //이메일
        if($('#userMail').val()==""){
            modalContents.text("이메일을 입력하여 주시기 바랍니다.");
            modal.modal('show');
            
            divMail.removeClass("has-success");
            divMail.addClass("has-error");
            $('#userMail').focus();
            return false;
        }else{
            divMail.removeClass("has-error");
            divMail.addClass("has-success");
        }
        

    
    });
    
});