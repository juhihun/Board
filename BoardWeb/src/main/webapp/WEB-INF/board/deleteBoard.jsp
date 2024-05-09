<%@page import="com.yedam.VO.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<form action = "deleteBoard.do">
<%
BoardVO vo = (BoardVO) request.getAttribute("bno");
%>
<h2>삭제할래?</h2>
<button type="submit" class= "btn btn-danger">확인</button>
	<input type="hidden" name="bno" value="<%=vo.getBoardNo()%>">
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>