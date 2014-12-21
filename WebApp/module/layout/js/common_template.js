/* NHNNEXT Development Practice Project RUWORKING HTH 141110 */ 
;
(function() {
    document.addEventListener("DOMContentLoaded", function() {

        // 로그인 클릭시 로그인 레이어 표시
        var login = document.querySelector("nav .login_out");
        var cancellogin = document.querySelector("nav .cancel");
        login.addEventListener("click", loginLayerToggle, false);
        cancellogin.addEventListener("click", loginLayerToggle, false);

        resizeNavBar();

        var searchWindow = document.getElementById('body-container').querySelector("header .searchBox form input[name='userQuery']");
    
        searchWindow.addEventListener("keyup", function(e){
          setTimeout(function(){searchAutoComplete(e)}, 300);
        }, false);

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

    function resizeNavBar(){
        var height = document.getElementById("main").offsetHeight;
        var targetEle = document.querySelector("nav");

        targetEle.style.height = height + "px";
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
                renderSearchResult(result, searchResultEle);
            }
        }
    }

    function renderSearchResult(result, targetEle) {
        if(result==null) {
          clearEle(targetEle);
          closeEle(targetEle.parentNode);
          return;  
        } 
        var length = result.length;
        clearEle(targetEle);

        showEle(targetEle.parentNode);
        // console.log(targetEle.parentNode.style);
        for(var i = 0; i < length; i++){
            targetEle.insertAdjacentHTML('beforeend', makeResultElement(result[i]));
        }
    }

    function makeResultElement(result){
        return "<li><img src='" + result.imgUrl + "'/>"
        + "<span class='name'>" + result.name + " 의원</span>"
        + "<span class='party'>" + result.party + "</span>"
        + "<span class='line'></span>"
        + "<span class='local'>" + result.local + "</span>"
        + "</li>";
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
    
})();