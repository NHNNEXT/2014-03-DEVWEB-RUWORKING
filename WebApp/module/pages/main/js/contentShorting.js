function shortTitle(e) {
	var titleList = document.getElementsByClassName("title");
	for(var i=4; i<titleList.length; i++) {
		var title = titleList[i].innerHTML;
		if(title.length > 19) {
			var insertString = title.substring(0, 19) + "...";
			titleList[i].innerHTML = insertString;
		}
	}
} 

function shortContent(e) {
	var stringList = document.getElementsByClassName("content");
	for(var i=3; i<stringList.length; i++) {
		var string = stringList[i].innerHTML;
		if(string.length > 160) {
			var insertString = string.substring(0, 130) + "...";
			stringList[i].innerHTML = insertString;
		}
	}
}

function init() {
	shortTitle();
	shortContent();
}

document.addEventListener("DOMContentLoaded", init);