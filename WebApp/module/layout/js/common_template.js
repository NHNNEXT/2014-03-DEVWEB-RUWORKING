/* NHNNEXT Development Practice Project RUWORKING HTH 141110 */ 
;
(function() {
    document.addEventListener("DOMContentLoaded", function() {

        // 로그인 클릭시 로그인 레이어 표시
        var login = document.querySelector("nav .login_out");
        var cancellogin = document.querySelector("nav .cancel");
        login.addEventListener("click", loginLayerToggle, false);
        cancellogin.addEventListener("click", loginLayerToggle, false);

        var searchWindow = document.getElementById('body-container').querySelector("header .searchBox form input[name='userQuery']");
    
        searchWindow.addEventListener("keyup", function(e){
            if(!(e.keyIdentifier === "U+0009")){
                setTimeout(function(){searchAutoComplete(e)}, 100);
            }
        }, false);

        var searchinfoEle = document.getElementById("main").querySelector(".searchinfo");
        searchinfoEle.addEventListener("click", function(e){
            searchForm.elements[0].focus();
            searchinfoEle.style.display="none";
            setNavOff();
        }, false);

        var politicianEleOnNav = document.getElementById("body-container").querySelector(".list-wrap span[data-listtype='poli']");
        politicianEleOnNav.addEventListener("click", function(e){
            searchinfoEle.style.display="block";
            setNavOn(e);
            gotop();
        }, false);
        
        var imgEle = document.querySelectorAll(".cardB .body img");
        [].forEach.call(imgEle, function(imgEle) {
            imgEle.addEventListener("click", function(e){
                var Ele = document.querySelector(".dim");
                var zoomimgEle = Ele.querySelector(".realImg");
                Ele.style.display = "block";
                if(window.innerHeight < e.target.naturalHeight || window.innerWidth <  e.target.naturalWidth){
                    window.open(e.currentTarget.src, "확대 이미지 보기", "width="+screen.width+", height="+screen.height+", toolbar=no, menubar=no, scrollbars=no, resizable=no" );
                    Ele.style.display = "none";
                    return;
                }
                zoomimgEle.innerHTML = e.currentTarget.outerHTML;
                zoomimgEle.style.width = e.target.naturalWidth +"px";
                zoomimgEle.style.height = e.target.naturalHeight +"px";
                zoomimgEle.style.top = "calc(50% - " + e.target.naturalHeight/2 +"px)";
                zoomimgEle.style.left = "calc(50% - " + e.target.naturalWidth/2 +"px)";
                Ele.addEventListener("click", function(){
                    Ele.style.display = "none";
                }, false);
            }, false);
        }, false);

        setNavMenu();
    }, false);

    function gotop(orix,oriy,desx,desy) {
        var Timer;
        if (document.body.scrollTop == 0) {
            var winHeight = document.documentElement.scrollTop;
        } else {
            var winHeight = document.body.scrollTop;
        }
        if(Timer) clearTimeout(Timer);
        startx = 0;
        starty = winHeight;
        if(!orix || orix < 0) orix = 0;
        if(!oriy || oriy < 0) oriy = 0;
        var speed = 7;

        if(!desx) desx = 0 + startx;
        if(!desy) desy = 0 + starty;
        desx += (orix - startx) / speed;
        if (desx < 0) desx = 0;
        desy += (oriy - starty) / speed;
        if (desy < 0) desy = 0;
        var posX = Math.ceil(desx);
        var posY = Math.ceil(desy);
        window.scrollTo(posX, posY);
        if((Math.floor(Math.abs(startx - orix)) < 1) && (Math.floor(Math.abs(starty - oriy)) < 1)){
            clearTimeout(Timer);
            window.scroll(orix,oriy);
        }else if(posX != orix || posY != oriy){
            Timer = setTimeout(function(){gotop(orix,oriy,desx,desy);},15);
        }else{
            clearTimeout(Timer);
        }
    }
    
    var originText;
    function setNavOn(e) {
        var originEle = e.target.parentElement.querySelector(".on");
        originText = originEle.innerText;
        originEle.classList.remove("on");
        e.target.classList.add("on");
    }

    function setNavOff() {
        var lo = location.href;
        var serviceName = lo.split("/")[3].split("?")[0];
        var navEle = document.querySelector("nav .list-wrap");
        var target = navEle.children;
        
        for(var i = 0; i < target.length; i++ ) {
            if(target[i].innerText === originText){
                if(target[i].tagName === "A") {
                    target[i].children[0].classList.add("on");
                } else {
                    target[i].classList.add("on");
                }
            }
        }
        if(serviceName != "ranking.ruw")
            navEle.children[3].classList.remove("on");
    }

    function loginLayerToggle() {
        var loginLayer = document.querySelector("nav .login-wrap");
        var meunLayer = document.querySelector("nav .list-wrap");
        if (loginLayer.style.display === "block") {
            loginLayer.style.display = "none";
            meunLayer.style.display = "block";
        } else {
            loginLayer.style.display = "block";
            meunLayer.style.display = "none";
        }
    }

    function searchAutoComplete(e){
        var searchResultEle = document.getElementById('body-container').querySelector("header .searchBox .search-result .main");
		var request = new XMLHttpRequest();
		var url = "/search.ruw";
		var params = "userQuery=" + e.target.value;
	
		request.open("POST", url, true);
		request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		request.send(params);

        request.onreadystatechange = function() {
            if (request.readyState === 4 && request.status === 200) {
                var result = request.responseText;
                result = JSON.parse(result);
                renderSearchResult(e.target.value, result, searchResultEle);
            }
        }
    }

    function renderSearchResult(key, result, targetEle) {
        if(result==null) {
          clearEle(targetEle);
          closeEle(targetEle.parentNode);
          return;  
        } 
        var length = result.length;
        clearEle(targetEle);

        showEle(targetEle.parentNode);
        for(var i = 0; i < length; i++){
            targetEle.insertAdjacentHTML('beforeend', makeResultElement(key, result[i], i));
        }
    }

    function makeResultElement(key, result, count){
        return "<li><a href='/viewDetail.ruw?pid=" + result.politicianId + "' tabindex=0>"
        + "<img src='" + result.imgUrl + "'/>"
        + "<span class='name'>" + result.name.replace(key, "<span class='highlight'>" + key + "</span>") + " 의원</span>"
        + "<span class='party'>" + result.party + "</span>"
        + "<span class='line'></span>"
        + "<span class='local'>" + result.local + "</span>"
        + "</a></li>";
    }

    function clearEle(targetElement) {
        targetElement.innerHTML = "";
    }

    function closeEle(targetElement) {
        targetElement.style.visibility = "hidden";
    }

    function showEle(targetElement) {
        targetElement.style.visibility = 'visible';
    }
    
    function setNavMenu(){
        var lo = location.href;
        var serviceName = lo.split("/")[3].split("?")[0];

        var navEle = document.querySelectorAll(".list-wrap span");

        if(serviceName !== ""){
            navEle[0].classList.remove("on");
        }
        
        if(serviceName === "Top20.ruw") {
            navEle[1].classList.add("on");
        }

        if(serviceName === "Parties.ruw") {
            navEle[2].classList.add("on");
        }
        
        if(serviceName === "viewDetail.ruw" || serviceName === "ranking.ruw") {
            navEle[3].classList.add("on");
        }
    }
})();