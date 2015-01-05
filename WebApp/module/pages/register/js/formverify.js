/* NHNNEXT Development Practice Project RUWORKING HTH 141116 */ 
;
(function() {
    // 변수선언
    var IDVerified = false;
    var PWVerified = false;
    var EmailVerified = false;
    var GenderVerified = false;
    var termsVerified = false;

    // 이벤트 등록
    document.addEventListener("DOMContentLoaded", function() {
        var formEle = document.getElementById("test");
        var idEle = formEle.querySelector("[data-type='id']");
        var pwEle1 = formEle.querySelector("[data-type='pw1']");
        var pwEle2 = formEle.querySelector("[data-type='pw2']");
        var emailEle = formEle.querySelector("[data-type='email']");
        var submitEle = formEle.querySelector("[data-type='submit']");
        var genderEle = formEle.querySelectorAll("[data-type='gender']");
        var termsEle = document.querySelector("[data-type='agree']");
        
        var pwVerifyCount = 0;

        idEle.addEventListener("focusout", function(e) {
            IDVerified = checkID(e.target.value);
            showValidResult(IDVerified, 0);
        }, false);
        pwEle1.addEventListener("focusout", function(e) {
        		if(pwVerifyCount++ != 0) {
        			PWVerified = checkPW(pwEle1.value, pwEle2.value);
        			showValidResult(PWVerified, 1);
        			showValidResult(PWVerified, 2);
        		}
        }, false);
        pwEle2.addEventListener("focusout", function(e) {
            PWVerified = checkPW(pwEle1.value, pwEle2.value);
            showValidResult(PWVerified, 1);
            showValidResult(PWVerified, 2);
        }, false);
        emailEle.addEventListener("focusout", function(e) {
            EmailVerified = checkEMAIL(e.target.value);
            showValidResult(EmailVerified, 3);
        }, false);

        // 성별 체크 여부 확인
        [].forEach.call(genderEle, function(radioBtn){
          radioBtn.addEventListener("click", function(){ GenderVerified = true;}, false);
        }, false);

        // 약관 동의 여부 확인
        termsEle.addEventListener("click", function(){
            if(termsVerified === false){
                termsVerified = true;
            } else {
                termsVerified = false;
            }
        }, false);

        // submit 최종 점검
        submitEle.addEventListener("click", function(e) {
            if (checkSubmit(IDVerified, PWVerified, EmailVerified, GenderVerified, termsVerified)) {
                validateEncryptedForm();
            	formEle.submit();
            } else {
                showNotValid();
            }
        }, false);

    }, false);

    /**
     * 아이디 생성 규칙
     * 1. 반드시 영문자가 하나 포함되어야 함 -> Primary Key(UserID) 와의 혼선 방지
     * 2. 아이디는 4자 ~ 12자 길이
     * 3. 아이디는 숫자와 영어로만 구성 가능
     * 
     * @param str : 아이디(String)
     * @return true : 아이디 생성 규칙을 만족 / false : 아이디 생성 규칙에 부합하지 않음 
     * @exception 없음
     */
    function checkID(str) {
        // 아이디에 영문자가 한자라도 포함되어 있지 않으면 false - a-z, A-Z가 검출되지 않으면 true니까 false return
        if (!/[a-zA-Z]/.test(str)) {
            return false;
        }

        // 영문자, 숫자 조합인 문자열을 검증한다 - a-z, A-Z, 0-9로 구성된 4~12자리 문자열인가?
        if (/^[a-zA-Z0-9]{4,12}$/.test(str)) {
            return true;
        }

        return false;
    }

    /**
     * 비밀번호 검증
     * 비밀번호 Input 항목에서 입력한 비밀번호와
     * 비밀번호 확인 Input 항목에서 입력한 비밀번호는 반드시 같아야 한다.
     * 
     * @param pw1 : 비밀번호 Input 항목에서 입력된 값(String) / pw2 : 비밀번호 확인 Input 항목에서 입력된 값(String)
     * @return true : 두 비밀번호가 일치함 / false : 두 비밀번호가 일치하지 않음
     * @exception 없음
     */
    function checkPW(pw1, pw2) {
        if (pw1 === "" || pw2 === "")
            return false;

        if (pw1 !== pw2) {
            return false;
        }

        return true;
    }

    /**
     * 이메일 검증
     * ABC@ABC.com 형태의 String이 입력되었는지 검증
     * 
     * @param str : email Input 항목에서 입력된 값(String)
     * @return true : 이메일 형식에 부합함 / false : 이메일 형식에 부합하지 않음
     * @exception 없음
     */
    function checkEMAIL(str) {
        var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

        if (regex.test(str) === false) {
            return false;
        }
        return true;
    }

    /**
     * Submit 직전 최종 점검
     * 인자로 입력된 모든 flag 들에 대한 검증을 시행함
     * 
     * @param args : 인자의 갯수 제한없이 입력을 받을 수 있다
     *               각 인자들은 check군 함수들의 return값을 저장해둔 flag 형태의 변수이어야 한다.
     *               
     * @return true : 입력된 모든 인자의 값이 true임 / false : 입력된 인자들 중 하나 이상의 값이 false임
     * @exception 없음
     */
    function checkSubmit(args) {
        var argCount = arguments.length;

        for (var i = 0; i < argCount; i++) {
            if (!arguments[i])
                return false;
        }
        return true;
    }

    /**
     * 각 항목별 입력값이 유효한지 판별하여 사용자에게 알려준다
     * 각 항목별 input Element 바로 하단부에 입력값이 유효하지 않을경우 유효하지 않음을 알린다
     * 
     * @param args : flag : 각 항목별 검증함수에 의해 return된 값 (boolean)이 인자로 넘어온다
     *               num : querySelector상의 Element원소 위치
     *               
     * @return 없음
     * @exception 없음
     */
    function showValidResult(flag, num){
        var validinfoEle = document.getElementById("test").querySelectorAll(".validate-info");
        if(flag){
            validinfoEle[num].style.display="none";
        } else {
            validinfoEle[num].style.display="block";
        }
    }

    /**
     * Submit 직전 최종 점검에서 실패할 경우 사용자에게 점검해야할 요소들을 알리는 Layer를 보여줌
     * 
     * @param args : 없음
     * @return 없음
     * @exception 없음
     */
    function showNotValid(){
        var validinfoEle = document.querySelector(".showregistererror");
        validinfoEle.style.display="block"
        setTimeout(function(){validinfoEle.style.display="none"}, 8500);
    }
    
    function validateEncryptedForm(){
        var formEle = document.getElementById("test");
    	var pwEle1 = formEle.querySelector("[data-type='pw1']");
        var pwEncryption = formEle.querySelector("[data-type='pwEncryption']");
    	var securedPassword = sha256_digest(pwEle1.value);
    	pwEncryption.value = securedPassword;
    }
})();