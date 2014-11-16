/* NHNNEXT Development Practice Project RUWORKING HTH 141110 */ 
;
(function() {
    document.addEventListener("DOMContentLoaded", function() {

        // 로그인 클릭시 로그인 레이어 표시
        var login = document.querySelector("nav .login");
        var cancellogin = document.querySelector("nav .cancel");
        login.addEventListener("click", loginLayerToggle, false);
        cancellogin.addEventListener("click", loginLayerToggle, false);

        resizeNavBar();
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
})();