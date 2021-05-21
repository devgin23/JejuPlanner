<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>회원가입</title>
        <!-- Bootstrap -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화 -->
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <!-- custom js -->
        <script type="text/javascript" src="/resources/js/register.js"/></script>
        <style>
            .custom-align{
                text-align: center;
            }
            .custom-align-content{
                display: center;
                vertical-align: middle;
            }

        </style>
    </head>
    <body>
        <div class="container"><!-- 좌우측 공간 확보 -->
            <!-- header -->
            <header>
                <div class="m1 custom-align"><img src="/resources/images/Goodee_logo-remove.png"></div>
                <div class="row">
                    <p></p>
                    <div class="col-md-12 custom-align">
                        <small>
                        <a href="/">로그인</a> | <a href="/member/register">회원가입</a>
                        </small>
                    </div>
                </div>
            </header>
            <!-- modal -->
            <div class="modal fade" id="defaultModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">알림</h4>
                        </div>
                        <div class="modal-body">
                            <p class="modal-contents"></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <hr/>



            <!-- content -->
            <div class="custom-align-content">
                <form class="form-horizontal" role="form" method="post" accept-charset="UTF-8" id="regForm">
                    <div class="form-group" id="divId">
                        <label for="inputId" class="col-lg-2 control-label">아이디</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control onlyAlphabetAndNumber" id="userId" name="userId" data-rule-required="true" placeholder="30자이내의 알파벳, 언더스코어(_), 숫자만 입력 가능합니다." maxlength="30">
                            <button class="idCheck" type="button" id="idCheck" name="idCheck" onclick="fn_idCheck();" value="N">중복확인</button>
                        </div>
                    </div>
                    
                    <div class="form-group" id="divPassword">
                        <label for="inputPassword" class="col-lg-2 control-label">비밀번호</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="userPw" name="userPw" data-rule-required="true" placeholder="비밀번호" maxlength="30">
                        </div>
                    </div>
                    <div class="form-group" id="divPasswordCheck">
                        <label for="inputPasswordCheck" class="col-lg-2 control-label">비밀번호 확인</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="userPwCheck" data-rule-required="true" placeholder="비밀번호 확인" maxlength="30">
                        </div>
                    </div>
                    <div class="form-group" id="divNickname">
                        <label for="inputNickname" class="col-lg-2 control-label">닉네임</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="userNickname" name="userNickname" data-rule-required="true" placeholder="닉네임" maxlength="15">

                        </div>
                    </div>
                    
                    <div class="form-group" id="divMail">
                        <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
                        <div class="col-lg-10">
                            <input type="email" class="form-control" id="userMail" name="userMail" data-rule-required="true" placeholder="이메일" maxlength="40">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="inputgender" class="col-lg-2 control-label">성별</label>
                        <div class="col-lg-10">
                            <select class="form-control" id="userGender" name="userGender">
                                <option value="M">남</option>
                                <option value="F">여</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" id="divAge">
                        <label for="inputAge" class="col-lg-2 control-label">나이</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control onlyNumber" id="userAge" name="userAge" data-rule-required="true" placeholder="나이" maxlength="2">
                        </div>
                    </div>
                    
                    <div class="form-group custom-align">
                        <div class="col-lg-offset-2 col-lg-12">
                            <button type="submit" class="btn btn-primary">제출</button>
                        </div>
                    </div>
                </form>
            </div>     
        

            <!--// 본문 들어가는 부분 -->
            <hr/>
            <!-- footer -->
            <footer>
                <div>
                    <p class="text-center">
                        <small>Copyrightⓒ GDJ32 G team All rights reserved.</small>
                    </p>
                </div>
            </footer>
        </div>
    </body>
</html>