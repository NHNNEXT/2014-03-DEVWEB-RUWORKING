;
(function(){
	var commentSubmit = document.querySelector(".comment-submit")
		commentSubmit.addEventListener("click", writeComment, false)
	
	function writeComment(){		
		var articleIdEle = document.getElementById("ns-evidenceDetail").querySelector(".hidden-box");
		var commentInputEle = document.getElementById("ns-evidenceDetail").querySelector(".comment-box");
			
		 var url = "/WriteComment.ruw";
		 var params = "articleId=" + articleIdEle.value + "&comment=" + commentInputEle.value;
		
		 var request = new XMLHttpRequest();
		 request.open("POST", url, true);
		 request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		 
		 request.onreadystatechange = function() {
			 if(request.readyState == 4 && request.status == 200) {
				 var result = request.responseText;
                 result = JSON.parse(result);
                 
                 var listEle = document.getElementById("ns-evidenceDetail").querySelector(".comment-list");
                 listEle.insertAdjacentHTML('beforeend', makeElement(result));
                 
                 var commentBox = document.querySelector(".comment-box");
                 commentBox.value = "";
			 }
		 }
	request.send(params);

	}
	
	function makeElement(result){
		return "<li class='show-comment'>" 
			+ "<span class='user-id'>" + result.userId + "</span>"
			+ "<span class='comment'>" + result.comment + "</span>"
			+ "<span class='date'>" + result.time + "</span>"
			+ "</li>"+"<div class='line'></div>";

	}
})();
