<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="pageContainer">
	<div id = "ns-party">
	<div class="cards-container">
		<span>정당별 공약 이행률</span>
		<div class="party-cards">
			<ul>
			<c:forEach var="party" items="${partyList}" varStatus="status">
				<li class="card-list">
					<div class="party-card">
						<span class="party">${party.name}</span>
						<div class="chart-container">
							<div id="chart_d${status.count}" class="chart"></div>
							<script>
							var options = {
								'dataset': {
									title: 'Web accessibility status',
									values:[${party.averageRatio}, ${100-party.averageRatio}],
									colorset: ['#2EB400', '#DC143C'],
									fields: ['완료', '미이행'] 
								},
								'donut_width' : 30, //70
								'core_circle_radius':40,
								'chartDiv': 'chart_d${status.count}',
								'chartType': 'donut',
								'chartSize': {width:350, height:300}
							};
							Nwagon.chart(options);
							</script>
							<div class = "field_underbar"><span></span><span></span></div>
						</div>
						<div class="party-info">
							<ul>
								<li class="num-of-politicians"><span class="title">의원수</span>
									<span class="real-num-of-politicians">${party.politicianNumber}</span> 
									<span class="total-num-of-politicians">/${totalPoliticianNumber}</span>
								</li>
								<li class="ratio"><span class="title">이행률</span> 
									<span class="percentage">${party.averageRatio}</span> 
									<span class="percent">%</span>
								</li>
							</ul>
						</div>

					</div>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	</div>
</div>
<script src="module/pages/party/js/layout.js"></script>
