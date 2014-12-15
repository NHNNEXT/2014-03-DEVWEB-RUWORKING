<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="pageContainer">
<div id="ns-searchResult">
	<span class="title">"${Query}" 검색결과</span>
	<div class="line"></div>
	
	<c:choose>
		<c:when test="${empty Politician}">
		<div class="noResult">검색 결과 없음</div>
		</c:when>
		<c:otherwise>
		<c:forEach var="each" items="${Politician}">
			<div class="card">
				<div class="img"><img src="${each.imgUrl}" alt="${each.name} 의원 사진"></div>
				<span class="name">${each.name} 의원</span>
				<span class="party">${each.partyId}</span>
				<span class="local">${each.local}</span>
				<div class="line"></div>
				<span class="more"><a href="/viewDetail.ruw?pid=${each.politicianId}">자세히 보기</a></span>
			</div>
		</c:forEach>
		</c:otherwise>
	</c:choose>
</div>
</div>