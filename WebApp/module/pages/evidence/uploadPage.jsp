<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="hiddenInfo" style="display: none">
	<c:forEach var="promiseTitle" items="${requestScope.promiseList}" varStatus="promiseCount">
			<p class ="promiseContent${promiseCount.count}">${promiseTitle}</p>
	</c:forEach>
</div>

<div id="pageContainer">
	<div id="ns-evidence">
		<form class="uploadBoard" action="/Upload.ruw" method="post">
			<div class="pid" style="display:none">${requestScope.pid}</div>
			<div class="promise wrap">
				<select name="promiseNumber">
					<option value ="1">공약1</option>
					<option value ="2">공약2</option>
					<option value ="3">공약3</option>
					<option value ="4">공약4</option>
					<option value ="5">공약5</option>
				</select> 
				<span>
					<!--promiseContent-->
				</span>
			</div>
			<div class="title wrap">
				<span>제목</span> <input type="text" name="articleTitle">
			</div>
			<div class="content wrap">
				<textarea name="articleContent" cols="107" rows="20"></textarea>
			</div>
			<div class="submit">
				<input type="submit" value="올리기">
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="/js/SelectPromise.js"></script>

