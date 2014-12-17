;
(function() {
    document.addEventListener("DOMContentLoaded", function() {
    	var downIcon = document.querySelectorAll(" .promise .down-icon");
        
        for(var i=0; i<5; i++){
        downIcon[i].addEventListener("click", boardLayerToggle, false);
        }
        
    
    }, false);
    
    function boardLayerToggle(e) {
        
        var promiseEle = e.target.parentNode.parentNode.parentNode.childNodes;

        if (promiseEle[3].style.display === "block") {
            promiseEle[3].style.display = "none";   
        } else {
            promiseEle[3].style.display = "block";    
        }
        resizeNavBar();
    }

    function resizeNavBar(){
        var height = document.getElementById("main").offsetHeight;
        var targetEle = document.querySelector("nav");

        targetEle.style.height = height + "px";
    }

    (function (){
        var targetEle = document.querySelectorAll(".promise-detail");
        var i, length = targetEle.length;
        for(i = 0; i < length; i++){
                targetEle[i].innerHTML = targetEle[i].innerHTML.replace(new RegExp("ㅇ","gim"), "<br>ㅇ");
            }
        // document.querySelector(".promise-detail").innerHTML = document.querySelector(".promise-detail").innerHTML.replace(new RegExp("ㅇ","gim"), "<br>ㅇ");
    })();
})();

