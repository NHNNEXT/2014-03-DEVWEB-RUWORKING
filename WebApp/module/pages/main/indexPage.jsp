<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src = "/module/pages/main/js/getlocal.js"></script>
<script src = "/module/pages/main/js/contentShorting.js"></script>

<div id="pageContainer">
<div id="ns-index">
	<div class = "card type1">
		 ${request.politicianName[0]}
		<span>공약 이행률 순위</span>
		<a href="/ranking.ruw"><span class = "more">더보기</span></a>
		<div class="politicianList">
			<ul>
			<c:forEach var="each" items="${Top5List}" varStatus="status">
				<li><a href="/viewDetail.ruw?pid=${each.politicianId}">
					<div class="photo">
					<span>${status.count}</span>
					<img src="${each.imgUrl}" alt="${each.name} 의원 사진">
					</div>
					<div class="info">
					<span class = "name">${each.name}</span>
					<span class = "party">${each.party}</span>
					<span class = "line"></span>
					<span class = "district">${each.local}</span>
					<span class="now">이행률</span>
					<span class="percentage">${each.promiseFulfillment}</span>
					<span class="percent">%</span>
					</div></a>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
	<div id="localinfo"></div>
	<div class="secondfloor">
		<div class="boxTypeA">
		<span class = "title"><span>서울특별시</span><br>국회의원 평균 공약 이행률</span>
		<div class = "card type2">
			<div id="chart_d2" class="Nwagon2"></div>
			<div class="loading">로딩중<br>위치 정보 사용에<br>동의해 주세요</div>
		</div>
			
		</div>
		<div class="boxTypeB">
		<span class = "title">19대<br>국회의원 평균 공약 이행률</span>
		<div class = "card type2_Big">
			<div id="Nwagon" class="Nwagon1"></div>
		</div>
		</div>
		<div class="boxTypeC">
		<span class = "title">19대<br>국회의원 임기일 D-DAY</span>
		<div class = "card type2 dday">
			<div class="number">
				${DDay}
			</div>
		</div>
		</div>

		<div class="notice">
			<div class="title">공지사항</div>
			<div class="content">- 19대 국회의원 정보가 업데이트 되었습니다.</div>
			<div class="date">15.01.04</div>
			<div class="content">- 서비스 개선을 위한 정기점검 안내드립니다.</div>
			<div class="date">15.01.03</div>
			<div class="content">- 서비스 개선을 위한 정기점검 안내드립니다.</div>
			<div class="date">14.12.29</div>
		</div>
		<div class="graph-tip">
			[Tip] 그래프의 각 항목 위에 마우스를 올리시면 자세한 정보를 확인할 수 있습니다
		</div>
	</div>

	<div class = "card type3">
		<span>최근 올라온 소식</span>
		<div>
			<div class="cardA">
				<div class="header">
					<div class="name">${mainArticleNotImage[0].name}</div>
					<div class="party">${mainArticleNotImage[0].partyName}</div>
				</div>
				<div class="body">
					<div class="title">${mainArticleNotImage[0].title}</div>
					<div class="content">${mainArticleNotImage[0].content}</div>
				</div>
				<div class="footer">
					<div class="date"> ${mainArticleNotImage[0].date} </div>
					<div class="more"><a href="/GetArticle.ruw?article-id=${mainArticleNotImage[0].article_id}&ancestor-id=${mainArticleNotImage[0].ancestor_id}">자세히</a></div>
				</div>
			</div>
		
		<c:forEach var="article" items="${mainArticleImage }">
				<div class="cardB">
				<div class="header">
					<div class="name">${article.name }</div>
					<div class="party">${article.partyName }</div>
				</div>
				<div class="body">
					<div class="title">${article.title}</div>
					<div class="content">${article.content}</div>
					<img src="${article.img_url}">
				</div>
				<div class="footer">
					<div class="date">${article.date}</div>
					<div class="more"><a href="/GetArticle.ruw?article-id=${article.article_id}&ancestor-id=${article.ancestor_id}">자세히</a></div>
				</div>
			</div>
		</c:forEach>
		
			<c:forEach var="article" items="${mainArticleNotImage}" begin="1" varStatus="status">
				<c:choose>
					<c:when test = "${ status.index == 1}"> <div class="cardA">
					</c:when>
					<c:otherwise>
						<div class="cardC">
					</c:otherwise>	
				</c:choose>
					<div class="header">
						<div class="name">${article.name }</div>
						<div class="party">${article.partyName }</div>
					</div>
					<div class="body">
						<div class="title">${article.title}</div>
						<div class="content">${article.content}</div>
					</div>
					<div class="footer">
						<div class="date">${article.date} </div>
						<div class="more"><a href="/GetArticle.ruw?article-id=${article.article_id}&ancestor-id=${article.ancestor_id}">자세히</a></div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
</div>
<script src="/module/pages/main/js/localChart.js"></script>