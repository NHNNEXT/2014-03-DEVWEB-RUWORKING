function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(getCityName);
    } else {
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
}

function getCityName(position) {
    var localEle = document.querySelector(".secondfloor .boxTypeC .title span");
    
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
}

