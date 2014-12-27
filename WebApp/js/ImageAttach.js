(function() {
	var inputElement = document.getElementById("ns-evidence").querySelector(".imageInput");
	inputElement.addEventListener("change", handleFiles, false);
})();

function handleFiles(files) {
	var preview = document.getElementById("ns-evidence").querySelector(".preview");
	if(files.length === 0) {
		preview.innerHTML = "";
		return;
	}
	
	for (var i = 0; i < files.length; i++) {
		var file = files[i];
		var imageType = /image.*/;

		if (!file.type.match(imageType)) {
			continue;
		}

		var img = document.createElement("img");
		img.classList.add("attachedImg");
	    img.height = 80;
		img.file = file;
		preview.innerHTML="";
		preview.appendChild(img); // Assuming that "preview" is the div output where the content will be displayed.
		
		var reader = new FileReader();
		reader.onload = (function(aImg) {
			return function(e) {
				aImg.src = e.target.result;
			};
		})(img);
		reader.readAsDataURL(file);
	}
}