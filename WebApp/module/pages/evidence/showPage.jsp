<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:scriptlet>
pageContext.setAttribute("space", " ");
pageContext.setAttribute("lf", "\n");
</jsp:scriptlet>
<div id="pageContainer">
	<div id="ns-evidenceDetail">
		<div class="evidence-wrapper">
			<div class="article-header">
				<div class="title">${article.title}</div>
				<div class="date">${article.date}</div>
				<div class="basic-info">
					글쓴이
					<div class="userId">${article.userId}</div>
					조회
					<div>0</div>
					댓글
					<div>0</div>
				</div>
			</div>
			<div class="line"></div>
			<div class="content">${fn:replace( fn:replace(article.content, space, "&nbsp;"), lf, "<br/>")}</div>
		</div>
		<a class="show-list">목록보기</a>
		<form class="comment-input">
			<input type="hidden" class="hidden-box" name="article-id"  value="${article.id}">			
			<input class="comment-box" name="comment" type="text"> 
			<div class="comment-submit">댓글 등록</div>
		</form>
		<ul class="comment-list">
			<c:forEach var="each" items="${commentList}">
				<li class="show-comment">
					<span class="user-id">${each.userId}</span> 
					<span class="comment">${each.comment}</span> 
					<span class="date">${each.time}</span>
				</li>
				<div class="line"></div>
			</c:forEach>
		</ul>
	</div>
</div>
<script src="/module/pages/evidence/js/comment.js"></script>