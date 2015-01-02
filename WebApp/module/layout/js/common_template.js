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
            setNavMenu("searchInfoDpOFF");
        }, false);

        var politicianEleOnNav = document.getElementById("body-container").querySelector(".list-wrap span:nth-of-type(2)");
        politicianEleOnNav.addEventListener("click", function(e){
            searchinfoEle.style.display="block";
            setNavMenu("searchInfoDpON");
        }, false);
        setNavMenu();
    }, false);

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
    
    function setNavMenu(type){
        var lo = location.href;
        var serviceName = lo.split("/")[3].split("?")[0];

        var navEle = document.querySelectorAll(".list-wrap span");

        if(serviceName !== ""){
            navEle[0].classList.remove("on");
        }
        
        if(serviceName === "Parties.ruw") {
            navEle[2].classList.add("on");
        }
        
        if(serviceName === "viewDetail.ruw") {
            navEle[3].classList.add("on");
        }

        if(type === "searchInfoDpON") {
            navEle[0].classList.remove("on");
            navEle[3].classList.add("on");
        }

        if(type === "searchInfoDpOFF") {
            navEle[3].classList.remove("on");
            navEle[0].classList.add("on");
        }
    }
})();