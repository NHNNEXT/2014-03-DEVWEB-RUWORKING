/* NHNNEXT Development Practice Project RUWORKING HTH 141110 */ 
;
(function() {
    document.addEventListener("DOMContentLoaded", function() {

        // 로그인 클릭시 로그인 레이어 표시
        var downIcon = document.querySelectorAll(" .promise .down-icon");
        
        for(var i=0; i<5; i++){
        downIcon[i].addEventListener("click", boardLayerToggle, false);
        }
    }, false);

    function boardLayerToggle(e) {
        
        var promiseEle = e.target.parentNode.parentNode.childNodes;

        if (promiseEle[5].style.display === "block") {
            promiseEle[5].style.display = "none";   
        } else {
            promiseEle[5].style.display = "block";    
        }
    }

})();