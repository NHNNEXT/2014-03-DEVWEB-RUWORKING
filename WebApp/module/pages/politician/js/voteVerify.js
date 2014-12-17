/* NHNNEXT Development Practice Project RUWORKING HTH 141110 */ 

(function(){
	
	document.addEventListener("DOMContentLoaded", function(){
		var formEle = document.querySelectorAll("[data-type='vote-form']");
		var self = this;
		for(var fidx = 0; fidx < formEle.length; fidx++){
			var submitBtn = formEle[fidx].querySelector(".submit");
			var scoreEle = formEle[fidx].querySelectorAll("[data-type='score']");
			var scoreVerified = false;
			var targetForm = formEle[fidx];
			
			for (var idx = 0; idx < scoreEle.length; idx++) {
				scoreEle[idx].addEventListener("click", function(){
					scoreVerified = true;
				}, false);
			}
			
			submitBtn.addEventListener("click", function(targetForm){
				if(scoreVerified===true){
					targetForm.submit();
				}else{
					console.log("not verified");
				}
			}.bind(this, targetForm), false);
			
		}
	},false);
	
})();
	
	
