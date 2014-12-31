;
(function() {
    document.addEventListener("DOMContentLoaded", function() {
    	var downIcon = document.querySelectorAll(" .promise .down-icon");
        
        for(var i=0; i<5; i++){
        		downIcon[i].addEventListener("click", boardLayerToggle, false);
        }
   
        function boardLayerToggle(e) {
            var promiseEle = e.target.parentNode.parentNode.childNodes;
            if (promiseEle[3].style.display === "block") {
                promiseEle[3].style.display = "none";   
            } else {
                promiseEle[3].style.display = "block";    
            }
        }

        (function (){
            var targetEle = document.querySelectorAll(".promise-detail");
            var i, length = targetEle.length;
            for(i = 0; i < length; i++){
                    targetEle[i].innerHTML = targetEle[i].innerHTML.replace(new RegExp("ㅇ","gim"), "<br>ㅇ");
                }
        })();

        document.addEventListener("input", outputUpdate, false);

        function outputUpdate(e) {
            document.querySelectorAll('#range-value')[e.target.id-1].innerHTML = e.target.value + " <small>%</small>";
        }

    }, false);
})();


