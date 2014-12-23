<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="/module/pages/ranking/js/ranking.js"></script>
<div id="pageContainer">
<div id="ns-rankingPage">
	<span class="title">국회의원 공약 이행률 순위</span>
	<div class="line"></div>
		<c:forEach var="each" items="${Politician}" varStatus="status">
			<div class="card">
				<div class="img"><img src="${each.imgUrl}" alt="${each.name} 의원 사진"></div>
				<div class="rank">${status.count} 위</div>
				<span class="name">${each.name} 의원</span>
				<span class="party">${each.party}</span>
				<span class="local">${each.local}</span>
				<span class="rate">${each.promiseFulfillment}</span>
				<span class="percent">%</span>
				<div class="line"></div>
				<span class="more"><a href="/viewDetail.ruw?pid=${each.politicianId}">자세히 보기</a></span>
			</div>
		</c:forEach>
	<div id="loader">
		<img src="img/ajax-loader.gif" alt="로딩중">
	</div>	
	
</div>
</div>