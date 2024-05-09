<%@page import="com.yedam.VO.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h2>상세화면</h2>

<%
 BoardVO vo = (BoardVO) request.getAttribute("result");
%>

<%if (vo == null){ %>
<p>조회된 결과가 없습니다</p>
<%} else {  %>
<form name="myFrm">
<input type="hidden" name ="bno" value="<%=vo.getBoardNo() %>">
</form>
<table class = "table">
  <tr>
    <th>게시글 번호</th><th><%=vo.getBoardNo() %></th>
    <th>작성일자</th><td><%=vo.getCreateDate() %></td>
    <th>조회수</th><th><%=vo.getViewCnt() %></th>
  </tr>
  <tr>
  <th>제목</th><th><%=vo.getTitle() %></th>
    <th>작성자</th><th><%=vo.getWriter() %></th>
  </tr>
  <tr>
   <th>내용</th> <td colspan="4"><%=vo.getContent() %></td>
  </tr>
	<tr align = "center">
	<td colspan="4"><button class ="btn btn-primary" id="modBtn">수정</button>
	<button class ="btn btn-danger">삭제</button></td>
	</tr>
</table>
<%} %>
<script src = "js/board.js"></script>

<jsp:include page="../includes/footer.jsp"></jsp:include>