
;
(function() {
	document.addEventListener("DOMContentLoaded", function(){
		var formEle = document.getElementById("form");
		var pwEle = formEle.querySelector(".password");
		var pwEncryptEle = formEle.querySelector(".PwEncryption");
		var submitEle = formEle.querySelector(".submit");
		submitEle.addEventListener("click", function() {

			validateEncryptedForm();
	        formEle.submit();
	    }, false);
	    
	    function validateEncryptedForm(){
	    	var securedPassword = sha256_digest(pwEle.value);
	    	pwEle.value = "";
	    	pwEncryptEle.value = securedPassword;
	    }
	},false);
})();