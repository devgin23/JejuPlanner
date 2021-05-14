<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal"
	data-bs-target="#staticBackdrop">Launch static backdrop modal
</button>

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
			<!-- private int bno;
				private String userId;
				private Date regDate;
				private String title;
				private String content; --> 
			<div class="modal-body">
				<form method="post" action="/plan/schedulePlan/add">
					UserId : <input type="text" name="userId"><br> 
					Title : <input type="text" name="title"><br> 
					Content : <input type="text" name="content"><br>
					<input id="modalButton" type="submit" value="제출"/>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Understood</button>
			</div>
		</div>
	</div>
</div>

<c:forEach var="vo" items="${cart}">
	<br/>
UserId : ${vo.userId}, Title : ${vo.title }, Content : ${vo.content }  
	
</c:forEach>