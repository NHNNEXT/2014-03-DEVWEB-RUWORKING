;
(function(){
	
	document.addEventListener("DOMContentLoaded", function(){
		var formEle = document.querySelectorAll("[data-type='vote-form']");
		var self = this;
		
		for(var fidx = 0; fidx < formEle.length; fidx++){
			var submitBtn = formEle[fidx].querySelector(".submit");
			var scoreEle = formEle[fidx].querySelectorAll("[data-type='score-range']");
			var scoreVerified = false;
			var targetForm = formEle[fidx];
			
			for (var idx = 0; idx < scoreEle.length; idx++) {
				scoreEle[idx].addEventListener("change", function(){
					console.log("나 동작함");
					scoreVerified = true;
				}, false);
			}

			submitBtn.addEventListener("click", function(targetForm){
				
				var url = "/Vote.ruw";
				var params = "score=" + targetForm[0].value+"&politician-id="+targetForm[1].value+"&promise-num="+targetForm[2].value;
				var request = new XMLHttpRequest();
				 request.open("POST", url, true);
				 request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				 
				 if(scoreVerified===true){
					 request.onreadystatechange=function(){
						 if(request.readyState == 4 && request.status == 200){
							 var result = request.responseText;
			                 result = JSON.parse(result);
			                 
			                 var totalPercentEle = document.getElementById("ns-politician").querySelector(".percentage");
			                 totalPercentEle.innerHTML=result.totalPercent;

			                 var eachPercentEle = targetForm.parentElement.parentElement.parentElement.querySelector(".percentage");
			                 eachPercentEle.innerHTML=result.eachPercent;

			                 if(result.alreayVoted){
			                	 alert("이미 투표하셨습니다.");
			                 }else{
			                	 alert("투표 성공하셨습니다.");
			                 }
						 }
					 }
					request.send(params);
				 }else{
					var scoreEle = targetForm.querySelector("[data-type='score-range']");
					if(confirm("회원님께서 평가해주신 의원님의 이행률 척도 " + scoreEle.value + "% 가\r"
						+ "처음 투표 화면에 보여지는 기본값과 같아 확인하고자 합니다\r" 
						+ "========================================\r\r"
						+ "확인버튼을 누르면 회원님의 평가 정보가 즉시 반영됩니다.\r"
						+ "실수로 투표하기 버튼을 누르셨다면 취소버튼을 눌러\r"
						+ "평가를 중단하실 수 있습니다.")) {
						 request.onreadystatechange=function(){
							 if(request.readyState == 4 && request.status == 200){
								 var result = request.responseText;
				                 result = JSON.parse(result);
				                 
				                 var totalPercentEle = document.getElementById("ns-politician").querySelector(".percentage");
				                 totalPercentEle.innerHTML=result.totalPercent;

				                 var eachPercentEle = targetForm.parentElement.parentElement.parentElement.querySelector(".percentage");
				                 eachPercentEle.innerHTML=result.eachPercent;
				                 
				                 if(result){
				                	 alert("이미 투표하셨습니다.");
				                 }else{
				                	 alert("투표 성공하셨습니다.");
				                 }
							 }
						 }
						request.send(params);
		
					}
				 }
			
			}.bind(this, targetForm), false);
			
		}
	},false);
	
})();
	
	
