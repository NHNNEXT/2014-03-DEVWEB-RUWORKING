document.addEventListener("DOMContentLoaded", function(e) {
	var stringList = document.getElementsByClassName("content");
	for(var i=3; i<stringList.length; i++) {
		var string = stringList[i].innerHTML;
		var insertString = string.substring(0, 160) + "...";
		stringList[i].innerHTML = insertString;
	}
});