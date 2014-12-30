(function(){
	document.addEventListener("DOMContentLoaded", function(){
	    getLocation();
	}, false);
	var Constants = {
		error : {
			10: "사용중이신 브라우저 또는 단말기가 위치정보 기능을 제공하지 않아 서울특별시 데이터를 표시합니다"
		}
	};

	function getLocation() {
	    if (navigator.geolocation) {
	        navigator.geolocation.getCurrentPosition(getCityName, showError);
	    } else {
	    	showError(new Error(10));
	    }
	}

	function showError(error) {
		drawGraph("서울특별시");
		if (error.code === undefined) {
			var code = error.message;
			setLocalInfoMessage(Constants.error[code]);
		} else {
			switch(error.code) {
		        case error.PERMISSION_DENIED:
		        	setLocalInfoMessage("사용자가 위치정보 서비스 이용을 거부하여 현재 접속중이신 위치를 파악할 수 없어 서울특별시 데이터를 표시합니다");
		            break;
		        case error.POSITION_UNAVAILABLE:
		        case error.TIMEOUT:
		        case error.UNKNOWN_ERROR:
		            setLocalInfoMessage("위치정보 서비스 불가능 지역에 계시거나 기술적 문제로 인해 현재 접속중이신 위치를 파악할 수 없어 서울특별시 데이터를 표시합니다");
		            break;
		    }
		}

	    
	}

	function getCityName(position) {
	    var localEle = document.querySelector(".secondfloor .boxTypeA .title span");
	    
	    var request = new XMLHttpRequest();
	    var absoluteUrl = "https://maps.googleapis.com/maps/api/geocode/json";
	    var params = "?latlng=" + position.coords.latitude + "," + position.coords.longitude + "&language=ko"; // 현 접속 위치
	    
	    // test data
	    // var params = "?latlng=" + 37.53455 + "," + 127.0005 + "&language=ko";	// 서울 용산구 한남동
	    // var params = "?latlng=" + 35.16915 + "," + 129.182588 + "&language=ko";	// 부산 해운대구 좌동
	    // var params = "?latlng=" + 35.867932 + "," + 128.6091 + "&language=ko";	// 대구 중구 동인동 (대구시청)
	    
	    var url = absoluteUrl + params;
	    request.open("GET", url, true);
	    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    request.send(null);

	    request.onreadystatechange = function() {
	        if (request.readyState === 4 && request.status === 200) {
	            var result = request.responseText;
	            result = JSON.parse(result);

	            var location = result.results[0].formatted_address.split(" ")[1];//.address_components[0].short_name;
	            changeCityName(location, localEle);
	            drawGraph(location);
	        }
	    }
	}

	function changeCityName(location, localEle) {
		localEle.innerText = location;
	}

	function drawGraph(location){
		var request = new XMLHttpRequest();
	   	console.log(location);
	   	var url = "/GetLocalList.ruw";
	    request.open("GET", url, true);
	    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    request.send(null);

	    request.onreadystatechange = function() {
	        if (request.readyState === 4 && request.status === 200) {
	            var result = request.responseText;
	            result = JSON.parse(result);

	            var city = null;
	            for(var itr in result[1]) {
	            	city = result[1][itr];
	            	if(city.local == location) {
	            		renderGraphUsingPercent(city.percent);
	            	}
	            }
	        }
	    }
	}

	function renderGraphUsingPercent(percent){
		var options = {
			'dataset': {
				title: 'Web accessibility status',
				values:[percent, 100-percent],
				colorset: ['#2EB400', '#DC143C'],
				fields: ['완료', '미이행'] 
			},
			'donut_width' : 30, //70
			'core_circle_radius':40,
			'chartDiv': 'chart_d2',
			'chartType': 'donut',
			'chartSize': {width:350, height:300}
		};
		Nwagon.chart(options);
		appendUnderbarInfo();
		drawDonutGraphColorInfo();
		deleteLoadingEle();
	}

	function appendUnderbarInfo(){
		var ele = document.getElementById("chart_d2");
		ele.insertAdjacentHTML('afterbegin', "<div class='field_underbar'><span></span><span></span></div>");
	}

	function drawDonutGraphColorInfo() {
	    var donut = document.getElementById("chart_d2");
	    var field = document.querySelectorAll('.field_underbar');
	    var length = field.length;

	    for(var i = 0; i < length; i++)
	    {
	        [].forEach.call(field, function(field){
	            var field_element = field.querySelectorAll('span');
	            var length = field_element.length;
	            for(var j = 0; j < length; j++)
	            {
	                field_element[j].innerHTML = document.getElementById("chart_d2").querySelectorAll('.fields text')[j].innerHTML;
	                field_element[j].style.backgroundColor = document.getElementById("chart_d2").querySelectorAll('.fields rect')[j].getAttribute('fill');
	            }
	        }, false);
	    }
	}

	function deleteLoadingEle() {
		var Ele = document.getElementById("ns-index").querySelector(".secondfloor .boxTypeA .card.type2 div.loading");
		Ele.parentNode.removeChild(Ele);
	}

	function setLocalInfoMessage(message){
		var Ele = document.getElementById("localinfo");
		Ele.style.display = "block";
		Ele.classList.add("localinfo");
		Ele.innerText = message;
		setTimeout(function(){Ele.style.display="none"},8400);
	}
})();