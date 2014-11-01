// document.addEventListener("DOMcontentLoaded", function(){

(function(){
    var donut = document.getElementById("chart_d");
    var field = document.querySelectorAll('.field_underbar');
    var length = field.length;
    for(var i = 0; i < length; i++)
    {
        [].forEach.call(field, function(field){
            var field_element = field.querySelectorAll('span');
            var length = field_element.length;
            for(var j = 0; j < length; j++)
            {
                field_element[j].innerHTML = document.getElementById("chart_d").querySelectorAll('.fields text')[j].innerHTML;
                field_element[j].style.backgroundColor = document.getElementById("chart_d").querySelectorAll('.fields rect')[j].getAttribute('fill');
            }
        }, false);
    }
    console.log("asdasasd");
})();

(function(){
    var height = document.getElementById("main").offsetHeight;
    var targetEle = document.getElementById("left");

    targetEle.style.height = height-3 + "px";
})();

(function(){
    var login = document.getElementById("left").querySelector(".login");
    login.addEventListener("click", loginLayerToggle, false);

    function loginLayerToggle(){
        var loginLayer = document.getElementById("left").querySelector(".login-wrap");
        var meunLayer = document.getElementById("left").querySelector(".list-wrap");
        if (loginLayer.style.display==="block"){
            loginLayer.style.display="none";
            meunLayer.style.display="block";
        } else {
            loginLayer.style.display="block";
            meunLayer.style.display="none";
        }
    }

    var cancellogin = document.getElementById("left").querySelector(".cancel");
    cancellogin.addEventListener("click", loginLayerToggle, false);
})();