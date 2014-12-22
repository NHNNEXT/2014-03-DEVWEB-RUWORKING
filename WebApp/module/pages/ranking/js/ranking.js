/* NHNNEXT Development Practice Project RUWORKING HTH 141223 */ 
;
(function() {
    document.addEventListener("DOMContentLoaded", function() {
        addMouseEvent();  
    }, false);

    function addMouseEvent() {
        var count = 1;
        var selfwindow = window;
        window.addEventListener("scroll", function(e) {
            
            var scrollHeight = document.documentElement.scrollHeight;
            var viewableRatio = window.innerHeight / scrollHeight;
            var scrollthumbHeight = window.innerHeight * viewableRatio;

            if(innerHeight - (scrollY* viewableRatio + scrollthumbHeight) < 50){
                setTimeout(function(){getElement(count++);}, 650);
            }
        }, false);
    }

    function getElement(count) {
        var rankingWrapperEle = document.getElementById('ns-rankingPage');
        
        var request = new XMLHttpRequest();
        var url = "/ranking.ruw";
        var params = "start=" + count;
    
        request.open("POST", url, true);
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        request.send(params);

        request.onreadystatechange = function() {
            if (request.readyState === 4 && request.status === 200) {
                var result = request.responseText;
                result = JSON.parse(result);
                hideLoadingBar();
                renderSearchResult(result, rankingWrapperEle, count);
            }
            resizeNavBar();
        }
    }

    function renderSearchResult(result, targetEle, count) {
        if(result==null) {
          return;  
        } 
        var length = result.length;
        for(var i = 0; i < length; i++){
            targetEle.insertAdjacentHTML('beforeend', makeResultElement(result[i], i, count));
        }
        targetEle.insertAdjacentHTML('beforeend', "<div id='loader'><img src='img/ajax-loader.gif' alt='로딩중'></div>");
    }

    function makeResultElement(result, index, count){
        return "<div class='card'>"
        + "<div class='img'><img src='" + result.imgUrl + "' alt='" + result.name + "의원 사진'></div>"
        + "<div class='rank'>"+ (count*10 + index*1 + 1) + " 위</div>"
        + "<span class='name'>" + result.name + "</span>"
        + "<span class='party'>" + result.party + "</span>"
        + "<span class='local'>" + result.local + "</span>"
        + "<span class='rate'>" + result.promiseFulfillment + "</span>"
        + "<span class='percent'>%</span>"
        + "<div class='line'></div>"
        + "<span class='more'><a href='/viewDetail.ruw?pid=" + result.politicianId +"'>자세히 보기</a></span>"
        + "</div>";
    }

    function resizeNavBar(){
        var height = document.getElementById("main").offsetHeight;
        var targetEle = document.querySelector("nav");

        targetEle.style.height = height + "px";
    }

    function hideLoadingBar() {
        var loadingEle = document.getElementById("loader");
        loadingEle.parentNode.removeChild(loadingEle);
    }
})();