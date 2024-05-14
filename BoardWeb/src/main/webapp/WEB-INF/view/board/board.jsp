<%@page import="com.yedam.VO.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
div.reply div {
	margin: auto;
}

div.reply ul {
	list-style-type: none;
	margin: 5px;
}

div.reply li {
	padding-top: 1px;
	padding-bottom: 1px;
}

div.reply span {
	display: inline-block;
}

.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>


<h2>상세화면</h2>


<c:choose>
	<c:when test="${empty result }">
		<p>조회된 결과가 없습니다</p>
	</c:when>
	<c:otherwise>
		<form name="myFrm">
			<input type="hidden" name="bno" value="${result.boardNo }">
			<input type="hidden" name="page" value="${page }">
			<input type="hidden" name="searchCondition" value="${searchCondition }">
			<input type="hidden" name="keyword" value="${keyword }">
			
		</form>
		<table class="table">
			<tr>
				<th>게시글 번호</th>
				<th>${result.boardNo }</th>
				<th>작성일자</th>
				<td>${result.createDate }</td>
				<th>조회수</th>
				<th>${result.viewCnt }</th>
			</tr>
			<tr>
				<th>제목</th>
				<th>${result.title }</th>
				<th>작성자</th>
				<th>${result.writer }</th>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="4">${result.content }</td>
			</tr>
			<tr align="center">
				<td colspan="4"><button class="btn btn-primary" id="modBtn">수정</button>
					<button class="btn btn-danger">삭제</button></td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>

<!-- 댓글목록 -->
<div class = "container reply">
<div class = "header">
	<input class = "col-sm-8" id="reply">
	<button class = "col-sm-3" id = "addReply">댓글등록</button>
</div>
	<div class = "content">
		<ul>
			<li>
				<span class = "col-sm-2">글번호</span>
				<span class = "col-sm-5">댓글내용</span>
				<span class = "col-sm-2">작성자</span>
				<span class = "col-sm-2">삭제</span>
			</li>
			<li>
				<hr/>
			</li>
			<li style ="display : none;">
				<span class = "col-sm-2">2</span>
				<span class = "col-sm-5">3</span>
				<span class = "col-sm-2">user02</span>
				<span class = "col-sm-2"><button onclick="deleteRow(event)" class = "btn btn-warning">삭제</button></span>
			</li>
		
			
		</ul>
	
	</div> <!-- content -->
	<div class = "footer">
		<div class="center">
  			<div class="pagination">
  			<a href = "#">1</a>
  			<a href = "#" class = "active">2</a>
  			<a href = "#">3</a>
  			</div>
  		</div>
	</div>
</div> <!-- container -->



<script>
	const bno = '${result.boardNo }';
	const writer = '${logId }';
</script>
<script src = "js/replyService.js"></script>
<script src = "js/board.js"></script>
