<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="pageContainer">
	<div id = "ns-party">
	<div class="cards-container">
		<span>정당별 공약 이행률</span>
		<div class="party-cards">
			<ul>
			<c:forEach var="party" items="${partyList}">
				<li class="card-list">
					<div class="party-card">
						<span class="party">${party.name}</span>
						<div id="chart_party" class="Nwagon2">차트</div>
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
				<li class="card-list">
					<div class="party-card">
						<span class="party">새정치민주연합</span>
						<div id="chart_party" class="Nwagon2">차트</div>
						<div class="party-info">
							<ul>
								<li class="num-of-politicians"><span class="title">의원수</span>
									<span class="real-num-of-politicians">130</span> <span
									class="total-num-of-politicians">/300</span></li>
								<li class="ratio"><span class="title">이행률</span> <span
									class="percentage">35</span> <span class="percent">%</span></li>
							</ul>
						</div>

					</div>
				</li>
				<li class="card-list">
					<div class="party-card">
						<span class="party">통합진보당</span>
						<div id="chart_party" class="Nwagon2">차트</div>
						<div class="party-info">
							<ul>
								<li class="num-of-politicians"><span class="title">의원수</span>
									<span class="real-num-of-politicians">5</span> <span
									class="total-num-of-politicians">/300</span></li>
								<li class="ratio"><span class="title">이행률</span> <span
									class="percentage">35</span> <span class="percent">%</span></li>
							</ul>
						</div>

					</div>
				</li>
				<li class="card-list">
					<div class="party-card">
						<span class="party">정의당</span>
						<div id="chart_party" class="Nwagon2">차트</div>
						<div class="party-info">
							<ul>
								<li class="num-of-politicians"><span class="title">의원수</span>
									<span class="real-num-of-politicians">5</span> <span
									class="total-num-of-politicians">/300</span></li>
								<li class="ratio"><span class="title">이행률</span> <span
									class="percentage">35</span> <span class="percent">%</span></li>
							</ul>
						</div>

					</div>
				</li>
				<li class="card-list">
					<div class="party-card">
						<span class="party">무소속</span>
						<div id="chart_party" class="Nwagon2">차트</div>
						<div class="party-info">
							<ul>
								<li class="num-of-politicians"><span class="title">의원수</span>
									<span class="real-num-of-politicians">2</span> <span
									class="total-num-of-politicians">/300</span></li>
								<li class="ratio"><span class="title">이행률</span> <span
									class="percentage">35</span> <span class="percent">%</span></li>
							</ul>
						</div>

					</div>
				</li>
			</ul>
		</div>
	</div>
	</div>
</div>
