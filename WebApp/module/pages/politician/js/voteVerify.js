;
(function(){
	
	document.addEventListener("DOMContentLoaded", function(){
		var formEle = document.querySelectorAll("[data-type='vote-form']");
		
		[].forEach.call(formEle, function(form){
			var submitBtn = form.querySelector(".submit");
			var scoreEle = form.querySelectorAll("[data-type='score']");
			var scoreVerified = false;

			for (var idx = 0; idx < scoreEle.length; idx++) {
				scoreEle[idx].addEventListener("click", function(){
					scoreVerified = true;
				}, false);
			}

			submitBtn.addEventListener("click", function(){
				if(scoreVerified===true){
					form.submit();
				}else{
					console.log("not verified");
				}
			},false);	
		},false);
	},false);
})();