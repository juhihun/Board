
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
 <!DOCTYPE html>
    <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">Start Bootstrap</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="main.do">글목록</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addForm.do">글등록</a>
                 	<C:choose>
                 	<C:when test="${empty logId }">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logForm.do">로그인</a>                    
                    </C:when>
                    <C:otherwise>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>
                    </C:otherwise>
                   </C:choose>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
                </div>
            </div>