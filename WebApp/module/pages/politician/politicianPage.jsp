<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:scriptlet>
pageContext.setAttribute("space", " ");
pageContext.setAttribute("lf", "\n");
</jsp:scriptlet>

<div id = "pageContainer">
	<div id = "ns-politician">
		<div class = "politician-card">
			<div class="photo">
				<img src="${politician.imgUrl}" alt="${politician.name} 의원 사진">
			</div>
			<div class="info">
				<span class="name">${politician.name}</span>
				<span class="party">${politician.party}</span>
				<span class="district">${politician.local}</span>
				<span class="line"></span>
				<span class="now">공약 이행률</span>
				<span class="percent">%</span>
				<span class="percentage">${percent}</span>
			</div>
				<div class = "graph-wrap">
				<div id="chart_d" class="Nwagon2"></div>
					<script>
					var options = {
						'dataset': {
							title: 'Web accessibility status',
							values:[${percent}, 100-${percent}],
							colorset: ['#2EB400', '#DC143C'],
							fields: ['완료', '미이행'] 
						},
						'donut_width' : 30, //70
						'core_circle_radius':40,
						'chartDiv': 'chart_d',
						'chartType': 'donut',
						'chartSize': {width:300, height:285}
					};

					Nwagon.chart(options);
					</script>
					<div class = "field_underbar"><span></span><span></span></div>
				</div>
		</div>
		<div class="board">
			<ul>
			<c:forEach var="each" items="${promises}" varStatus="status">
				<c:set var="mapper" value= "${relatePostMap[status.count]}"/>
				<li class="promise">
					<div class="promise-title">
						<div class="title-number">약속 ${status.count}</div>	
						<div class="percentage">&nbsp;${each.percent} %</div>
						<span class="title-ct">${each.title}</span>
						<div class="down-icon"></div>
					</div>
					<div class="promise-board">
						<ul>
							<li>
								<div class="promise-detail">
								${fn:replace( fn:replace(each.content, space, "&nbsp;"), lf, "<br/>")}
								</div>
							</li>
							<li>관련 기사 목록</li>
       						<c:choose>
       						<c:when test="${fn:length(mapper) == 0}">
       							<li>해당 약속과 관련된 기사가 없습니다</li>
       						</c:when>
       						<c:otherwise>
       							<c:forEach items="${mapper}" var="item" varStatus="loop">
       								<li>
       									<a href="GetArticle.ruw?article-id=${item.id}">${item.title}</a>	
       								</li>
   								</c:forEach>
       						</c:otherwise>
       						</c:choose>
						</ul>
						<c:if test="${!empty sessionScope.userId}">
						<div class="vote-wrap">
							<form action="/Vote.ruw" method="post" class="vote" data-type="vote-form">
								<span class="induce">회원님! ${politician.name} 의원의 ${status.count} 번째 약속 이행률을 평가해 주세요!</span>
								<div class="rangewrap">
									<input type="range" min="0" value="50" max="100" id="${status.count}" step="10" name="score" data-type="score-range">
								</div>
								<input type="hidden" name="politician-id" value="${politician.politicianId}"/>
								<input type="hidden" name="promise-num" value="${status.count}"/>
								<div id="range-value">50 <small>%</small></div>
								<div data-type="submit" class="submit">평가하기</div>
							</form>
						</div>
						</c:if>
					</div>	
				</li>
				</c:forEach>
			</ul>
			<form method="get" action="/WriteArticle.ruw">
				<input type="hidden" name="pid" value="${politician.politicianId}"/>
				<input class="upload" type="submit" value="올리기"></div>
			</form>	
		</div>
</div>
<script src="/module/pages/politician/js/politician.js"></script>
<script src="/module/pages/politician/js/voteVerify.js"></script>