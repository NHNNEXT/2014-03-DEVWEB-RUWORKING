<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="pageContainer">
<div id="ns-index">
	<div class = "card type1">
		<span>공약 이행률 순위</span>
		<span class = "more">더보기</span>
		<div class="politicianList">
			<ul>
				<li>
					<div class="photo">
					<span>1</span>
					<img src="img/mem1.jpg" alt="">
					</div>
					<div class="info">
					<span class = "name">홍길동</span>
					<span class = "party">밥맛있당</span>
					<span class = "line"></span>
					<span class = "district">제천시·단양군</span>
					<span class="now">이행률</span>
					<span class="percentage">82</span>
					<span class="percent">%</span>
					</div>
				</li>
				<li>
					<div class="photo">
					<span>2</span>
					<img src="img/mem2.jpg" alt="">
					</div>
					<div class="info">
					<span class = "name">기길동</span>
					<span class = "party">알겠당</span>
					<span class = "line"></span>
					<span class = "district">증평군·진천군·괴산군·음성군</span>
					<span class="now">이행률</span>
					<span class="percentage">78</span>
					<span class="percent">%</span>
				</li>
				<li>
					<div class="photo">
					<span>3</span>
					<img src="img/mem3.jpg" alt="">
					</div>
					<div class="info">
					<span class = "name">두길동</span>
					<span class = "party">포도당</span>
					<span class = "line"></span>
					<span class = "district">청주시 흥덕구 을</span>
					<span class="now">이행률</span>
					<span class="percentage">76</span>
					<span class="percent">%</span>
				</li>
				<li>
					<div class="photo">
					<span>4</span>
					<img src="img/mem4.jpg" alt="">
					</div>
					<div class="info">
					<span class = "name">박길동</span>
					<span class = "party">형이당</span>
					<span class = "line"></span>
					<span class = "district">논산시·계룡시·금산군</span>
					<span class="now">이행률</span>
					<span class="percentage">72</span>
					<span class="percent">%</span>
				</li>
				<li>
					<div class="photo">
					<span>5</span>
					<img src="img/mem5.jpg" alt="">
					</div>
					<div class="info">
					<span class = "name">나길동</span>
					<span class = "party">누나당</span>
					<span class = "line"></span>
					<span class = "district">동대문구 갑</span>
					<span class="now">이행률</span>
					<span class="percentage">67</span>
					<span class="percent">%</span>
				</li>
			</ul>
		</div>
	</div>

	<div class="secondfloor">
		<div class="boxTypeA">
		<span class = "title">18대<br>대통령 공약 이행률</span>
		<div class = "card type2">
		<div id="chart_d" class="Nwagon2"></div>
			<script>
			var options = {
				'dataset': {
					title: 'Web accessibility status',
					values:[18, 12, 3, 7],
					colorset: ['#2EB400', '#FF8C00', '#DC143C', '#666666'],
					fields: ['완료', '진행중', '미이행', '보류'] 
				},
				'donut_width' : 30, //70
				'core_circle_radius':40,
				'chartDiv': 'chart_d',
				'chartType': 'donut',
				'chartSize': {width:350, height:300}
			};

			Nwagon.chart(options);
			</script>
			<div class = "field_underbar"><span></span><span></span><span></span><span></span></div>
		</div>
		</div>
		<div class="boxTypeB">
		<span class = "title">19대<br>국회의원 평균 공약 이행률</span>
		<div class = "card type2_Big">
			<div id="Nwagon" class="Nwagon1"></div>
			<script>
			    var options = {
			        'legend':{
			            names: [['서울특별시'], ['대구광역시'], ['인천광역시'],['광주광역시'],['대전광역시'],['울산광역시'],['세종특별시'],['경기도'],['충청북도'],['충청남도'],['전라북도'],['전라남도'],['경상북도'],['경상남도'],['제주도']]
			        },
			        'dataset': {
			            title: '국회의원 공약 이행률',
			            values: [[70], [50.4], [21.3],[56.3],[63.4],[84.3],[57.3],[47.2],[91.1],[28.3],[65.7],[62.3],[84.3],[27.3],[33.4]],
			            colorset: ['#0083CA', '#CC3333', '#CC3333','#0083CA','#0083CA','#CC3333','#0083CA','#0083CA','#CC3333','#CC3333','#0083CA','#0083CA','#CC3333','#CC3333','#0083CA'],
			            // fields: ['A', 'B', 'C'],
			            fields: [],
			            opacity:[0.3, 0.5, 0.7, 0.9]
			        },
			        'core_circle_value' : ['72.7%'],
			        'core_circle_radius':30,
			        'maxValue' : 100,
			        'increment' : 20,
			        'chartDiv': 'Nwagon',
			        'chartType': 'polar',
			        'chartSize': {width:700, height:400}
			    };
			    Nwagon.chart(options);
			</script>
		</div>
		</div>
		<div class="boxTypeC">
		<span class = "title">우리지역<br>국회의원 평균 공약 이행률</span>
		<div class = "card type2">
			<div id="chart_d2" class="Nwagon2"></div>
			<script>
			var options = {
				'dataset': {
					title: 'Web accessibility status',
					values:[18, 12, 3, 7],
					colorset: ['#2EB400', '#FF8C00', '#DC143C', '#666666'],
					fields: ['완료', '진행중', '미이행', '보류'] 
				},
				'donut_width' : 30, //70
				'core_circle_radius':40,
				'chartDiv': 'chart_d2',
				'chartType': 'donut',
				'chartSize': {width:350, height:300}
			};
			Nwagon.chart(options);
			</script>
			<div class = "field_underbar"><span></span><span></span><span></span><span></span></div>
		</div>
		</div>

		<div class="notice">
			<div class="title">공지사항</div>
			<div class="content">- 19대 국회의원 정보가 업데이트 되었습니다.</div>
			<div class="date">14.03.04</div>
			<div class="content">- 서비스 개선을 위한 정기점검 안내드립니다.</div>
			<div class="date">14.03.04</div>
			<div class="content">- 서비스 개선을 위한 정기점검 안내드립니다.</div>
			<div class="date">14.03.04</div>
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
					<div class="name">개발자</div>
					<div class="party">개발중이당</div>
				</div>
				<div class="body">
					<div class="title">홍길동 의원 복지공략 실천 이행해 좋은 반응을 얻고 있다</div>
					<div class="content">최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다. 홍 대표는 앞으로도 더욱 열심히 시민들의 목소리에 귀를 귀울여 더욱 많은 시민들이 삶의 행복을 느끼며 살아갈 수 있도록 더욱 노력하겠다는 포부를 밝혔다. 리서치 전문 전문 기관인 OOO서치에서 설문을 실시한 결과 홍의원의 선거 공약 이행에 대한 만족도는 00%에 해당하였고 전문가 만족도는 00%에 해당하였다.</div>
				</div>
				<div class="footer">
					<div class="date">14.11.03 14:02</div>
					<div class="more">자세히</div>
				</div>
			</div>
			<div class="cardB">
				<div class="header">
					<div class="name">개발자</div>
					<div class="party">개발중이당</div>
				</div>
				<div class="body">
					<div class="title">홍길동 의원 복지공략 실천 이행해 좋은 반응을 얻고 있다 있다</div>
					<div class="content">최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다. 홍 대표는 앞으로도 더욱 열심히 시민들의 목소리에 귀를 귀울여 더욱 많은 시민들이 삶의 행복을 느끼며 살아갈 수 있도록 더욱 노력하겠다는 포부를 밝혔다</div>
					<div class="content">이런식으로 좌 우로 본문 내용을 나누게 된다면 Javascript의 subString을 쓰면 될 것 같다는 생각이 든다. 이를 활용하면 더욱 멋진 UI를 구성할 수 있을것으로 예상되는 바이다</div>
				</div>
				<div class="footer">
					<div class="date">14.11.03 14:02</div>
					<div class="validity">OOO의원 기사 평균 신뢰도 : 99%</div>
					<div class="more">자세히</div>
				</div>
			</div>
			<div class="cardB">
				<div class="header">
					<div class="name">개발자</div>
					<div class="party">개발중이당</div>
				</div>
				<div class="body">
					<div class="title">홍길동 의원 복지공략 실천 이행해 좋은 반응을 얻고 있다</div>
					<div class="content">최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다. 홍 대표는 앞으로도 더욱 열심히 시민들의 목소리에 귀를 귀울여 더욱 많은 시민들이 삶의 행복을 느끼며 살아갈 수 있도록 더욱 노력하겠다는 포부를 밝혔다</div>
					<div class="content">최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다.</div>
				</div>
				<div class="footer">
					<div class="date">14.11.03 14:02</div>
					<div class="validity">OOO의원 기사 평균 신뢰도 : 99%</div>
					<div class="more">자세히</div>
				</div>
			</div>
			<div class="cardA">
				<div class="header">
					<div class="name">개발자</div>
					<div class="party">개발중이당</div>
				</div>
				<div class="body">
					<div class="title">홍길동 의원 복지공략 실천 이행해 좋은 반응을 얻고 있다</div>
					<div class="content">최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다.</div>
				</div>
				<div class="footer">
					<div class="date">14.11.03 14:02</div>
					<div class="more">자세히</div>
				</div>
			</div>
			<div class="cardC">
				<div class="header">
					<div class="name">개발자</div>
					<div class="party">개발중이당</div>
				</div>
				<div class="body">
					<div class="title">홍길동 의원 복지공략 실천 이행해 좋은 반응을 얻고 있다</div>
					<div class="content">최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다. 홍 대표는 앞으로도 더욱 열심히 시민들의 목소리에 귀를 귀울여 더욱 많은 시민들이 삶의 행복을 느끼며 살아갈 수 있도록 더욱 노력하겠다는 포부를 밝혔다. 최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다.</div>
				</div>
				<div class="footer">
					<div class="date">14.11.03 14:02</div>
					<div class="validity">OOO의원 기사 평균 신뢰도 : 99%</div>
					<div class="more">자세히</div>
				</div>
			</div>
			<div class="cardC">
				<div class="header">
					<div class="name">개발자</div>
					<div class="party">개발중이당</div>
				</div>
				<div class="body">
					<div class="title">홍길동 의원 복지공략 실천 이행해 좋은 반응을 얻고 있다</div>
					<div class="content">최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다. 홍 대표는 앞으로도 더욱 열심히 시민들의 목소리에 귀를 귀울여 더욱 많은 시민들이 삶의 행복을 느끼며 살아갈 수 있도록 더욱 노력하겠다는 포부를 밝혔다. 최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다.</div>
				</div>
				<div class="footer">
					<div class="date">14.11.03 14:02</div>
					<div class="validity">OOO의원 기사 평균 신뢰도 : 99%</div>
					<div class="more">자세히</div>
				</div>
			</div>
			<div class="cardC">
				<div class="header">
					<div class="name">개발자</div>
					<div class="party">개발중이당</div>
				</div>
				<div class="body">
					<div class="title">홍길동 의원 복지공략 실천 이행해 좋은 반응을 얻고 있다</div>
					<div class="content">최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다. 홍 대표는 앞으로도 더욱 열심히 시민들의 목소리에 귀를 귀울여 더욱 많은 시민들이 삶의 행복을 느끼며 살아갈 수 있도록 더욱 노력하겠다는 포부를 밝혔다. 최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다.</div>
				</div>
				<div class="footer">
					<div class="date">14.11.03 14:02</div>
					<div class="validity">OOO의원 기사 평균 신뢰도 : 99%</div>
					<div class="more">자세히</div>
				</div>
			</div>
			<div class="cardC">
				<div class="header">
					<div class="name">개발자</div>
					<div class="party">개발중이당</div>
				</div>
				<div class="body">
					<div class="title">홍길동 의원 복지공략 실천 이행해 좋은 반응을 얻고 있다</div>
					<div class="content">최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다. 홍 대표는 앞으로도 더욱 열심히 시민들의 목소리에 귀를 귀울여 더욱 많은 시민들이 삶의 행복을 느끼며 살아갈 수 있도록 더욱 노력하겠다는 포부를 밝혔다. 최근 홍길동 의원은 선거 공약으로 내세웠던 내용중 하나인 복지공약을 이행해서 시민들로 부터 좋은 반응을 얻고 있다.</div>
				</div>
				<div class="footer">
					<div class="date">14.11.03 14:02</div>
					<div class="validity">OOO의원 기사 평균 신뢰도 : 99%</div>
					<div class="more">자세히</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
