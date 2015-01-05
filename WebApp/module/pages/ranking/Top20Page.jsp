<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="pageContainer">
<div id="ns-rankingPage">
	<span class="title">국회의원 공약 이행률 Top 20</span>
	<div class="line"></div>
		<c:forEach var="each" items="${Politician}" varStatus="status">
			<a href="/viewDetail.ruw?pid=${each.politicianId}">
			<div class="card">
				<div class="img"><img src="${each.imgUrl}" alt="${each.name} 의원 사진"></div>
				<div class="rank">${status.count} 위</div>
				<span class="name">${each.name} 의원</span>
				<span class="party">${each.party}</span>
				<span class="local">${each.local}</span>
				<span class="rate">${each.promiseFulfillment}</span>
				<span class="percent">%</span>
				<div class="line"></div>
				<span class="more">자세히 보기</span>
			</div></a>
		</c:forEach>
</div>
</div>

<style>

#ns-rankingPage .card {
  -webkit-animation: first 3s  alternate;
  -moz-animation: first 3s  alternate;
  animation: first 3s  alternate;
  -o-animation: first 3s  alternate;
}

@-webkit-keyframes first {
  0% {
    opacity: 0;
    margin-top: 300px;
  }
  75% {
    margin-top: -5px;
    -ms-transform: rotate(0deg);
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  90% {
    -ms-transform: rotate(3deg);
    -webkit-transform: rotate(3deg);
    transform: rotate(3deg);
  }
  100% {
    opacity: 1.0;
    margin-top: 10px;
  }
}
@-moz-keyframes first {
   0% {
    opacity: 0;
    margin-top: 300px;
  }
  75% {
    margin-top: -5px;
    -ms-transform: rotate(0deg);
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  90% {
    -ms-transform: rotate(3deg);
    -webkit-transform: rotate(3deg);
    transform: rotate(3deg);
  }
  100% {
    opacity: 1.0;
    margin-top: 10px;
  }
}
@keyframes first {
    0% {
    opacity: 0;
    margin-top: 300px;
  }
  75% {
    margin-top: -5px;
    -ms-transform: rotate(0deg);
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  90% {
    -ms-transform: rotate(3deg);
    -webkit-transform: rotate(3deg);
    transform: rotate(3deg);
  }
  100% {
    opacity: 1.0;
    margin-top: 10px;
  }
}
</style>