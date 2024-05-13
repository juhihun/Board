<%@page import="com.yedam.VO.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form name="myFrm" action="deleteBoard.do">
	<%
	BoardVO vo = (BoardVO) request.getAttribute("bno");
	String logId = (String) session.getAttribute("logId");
	%>
	<h2>삭제할래?</h2>
	<table class="table">
	<tr>
		<th>글번호</th>
		<td>${bno.boardNo }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" value="${bno.title }"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="content" cols="30" rows="4">${bno.content }</textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${bno.writer }</td>

	</table>
	<button type="submit" class="btn btn-danger">확인</button>
	<input type="hidden" name="bno" value="${bno.boardNo }">
</form>
<script>
const logid = "${logId }";
const writer = "${bno.writer }";

document.forms.myFrm.addEventListener('submit',function(e){
	
	e.preventDefault();
	if(logid != writer){
		alert("권한이 없습니다");
		return;
	} this.submit();
	
});

</script>
