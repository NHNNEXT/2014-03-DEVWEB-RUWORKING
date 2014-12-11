/* NHNNEXT Development Practice Project RUWORKING HTH 141110 */ 
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
    }

})();


