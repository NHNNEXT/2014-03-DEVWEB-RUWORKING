(function() {
	var selectBtn = document.querySelector(".promise select");
	var contentSpan = document.querySelector(".promise span");
	var promiseContentList = document.querySelectorAll("#hiddenInfo p");

	selectBtn.addEventListener('change', function(e){	    
		contentSpan.innerHTML = promiseContentList[selectBtn.value-1].innerHTML;
	}, false);
})();

 
