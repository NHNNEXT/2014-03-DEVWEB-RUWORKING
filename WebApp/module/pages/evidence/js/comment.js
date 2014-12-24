;
(function(){
	var commentSubmit = document.querySelector(".comment-submit")
		commentSubmit.addEventListener("click", writeComment, false)
	
	function writeComment(e){		
		var commentForm = e.currentTarget.form;
		 var url = "/WriteComment.ruw";
		 var params = "articleId=" + commentForm[0].value + "&comment=" + commentForm[1].value;
		
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
			+ "</li>";
	}
})();
