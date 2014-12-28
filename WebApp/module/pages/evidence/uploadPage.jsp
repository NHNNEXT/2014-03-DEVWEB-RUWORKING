<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="hiddenInfo" style="display: none">
	<c:forEach var="promiseTitle" items="${requestScope.promiseList}" varStatus="promiseCount">
			<p class ="promiseTitle${promiseCount.count}">${promiseTitle}</p>
	</c:forEach>
</div>

<div id="pageContainer">
	<div id="ns-evidence">
		<form class="uploadBoard" action="/Upload.ruw" method="post" enctype="multipart/form-data">
			<c:choose>
			<c:when test="${!empty requestScope.promiseList}">
				<!--증거자료 처음 올릴 때-->
				<div class="promise wrap">
					<select name="promiseNumber">
						<option value ="1">공약1</option>
						<option value ="2">공약2</option>
						<option value ="3">공약3</option>
						<option value ="4">공약4</option>
						<option value ="5">공약5</option>
					</select> 
					<span class="promiseTitle">
						${requestScope.promiseList[0]}
					</span>
				</div>
				<input type="text" name="politicianId" value="${requestScope.politicianId}" style="display:none"/>
				<input type="text" name="version" value="0" style="display:none"/>
			</c:when>
			<c:otherwise>
				<!--증거자료 수정할 때-->
				<div class="promise wrap">
					<input type="text" name="promiseNumber" value="${article.promiseNum}" style="display:none"/>
					<span  class="promiseNumber" name="promiseNumber">공약${article.promiseNum}</span> 
					<span class="promiseTitle">${promiseTitle}</span>
				</div>
				<input type="text" name="politicianId" value="${article.politicianId}" style="display:none"/>
				<input type="text" name="version" value="${article.version+1}" style="display:none"/>
				
			</c:otherwise>
			</c:choose>
			
			<div class="title wrap">
				<span>제목</span> <input type="text" name="articleTitle" value="${article.title}">
			</div>
			<div class="content wrap">
				<textarea name="articleContent" cols="107" rows="20">${article.content}</textarea>
			</div>
			<div class="imageAttach wrap" >
				<span>이미지 첨부</span>
				<input class="imageInput" type="file" name="attachedFile" accept="image/*" onchange="handleFiles(this.files)">
				<div class="preview"></div>
			</div>
			
			<c:choose>
			<c:when test="${!empty requestScope.promiseList}">	
			<div class="submit">
				<input type="submit" value="올리기">
			</div>
			</c:when>
			<c:otherwise>
			<div class="submit">
				<input type="submit" value="수정하기">
			</div>
			</c:otherwise>
			</c:choose>
		</form>
	</div>
</div>


<script type="text/javascript" src="/js/SelectPromise.js"></script>
<script type="text/javascript" src="/js/ImageAttach.js"></script>

