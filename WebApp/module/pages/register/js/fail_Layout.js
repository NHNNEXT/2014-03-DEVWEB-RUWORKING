/* NHNNEXT Development Practice Project RUWORKING HTH 141116 */ 
;
(function() {
	// 회원가입 실패시 표시되는 안내 레이어가 10초후 사라지도록 조치
    document.addEventListener("DOMContentLoaded", function() {
    		var registerFailEle = document.querySelector("span.fail");
        setTimeout(function(){registerFailEle.style.display="none"}, 10000);
    }, false);
})();