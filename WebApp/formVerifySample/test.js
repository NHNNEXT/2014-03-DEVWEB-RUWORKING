/* NHNNEXT Development Practice Project RUWORKING HTH 141109 */ 
;
(function() {
    // 변수선언
    var IDVerified = false;
    var PWVerified = false;
    var EmailVerified = false;
    var GenderVerified = false;

    // 이벤트 등록
    document.addEventListener("DOMContentLoaded", function() {
        var formEle = document.getElementById("test");
        var idEle = formEle.querySelector("[data-type='id']");
        var pwEle1 = formEle.querySelector("[data-type='pw1']");
        var pwEle2 = formEle.querySelector("[data-type='pw2']");
        var emailEle = formEle.querySelector("[data-type='email']");
        var submitEle = formEle.querySelector("[data-type='submit']");
        var genderEle = formEle.querySelectorAll("[data-type='gender']");

        idEle.addEventListener("change", function(e) {
            IDVerified = checkID(e.target.value);
        }, false);
        pwEle1.addEventListener("change", function(e) {
            PWVerified = checkPW(pwEle1.value, pwEle2.value);
        }, false);
        pwEle2.addEventListener("change", function(e) {
            PWVerified = checkPW(pwEle1.value, pwEle2.value);
        }, false);
        emailEle.addEventListener("change", function(e) {
            EmailVerified = checkEMAIL(e.target.value);
        }, false);

        // 성별 체크 여부 확인
        [].forEach.call(genderEle, function(radioBtn){
          radioBtn.addEventListener("click", function(){ GenderVerified = true;}, false);
        }, false);

        // submit 최종 점검
        submitEle.addEventListener("click", function(e) {
            if (checkSubmit(IDVerified, PWVerified, EmailVerified, GenderVerified)) {
                formEle.submit();
            } else {
                console.log("필수항목중 채워지지 않은 항목이 있거나 올바르지 않은 항목이 있습니다");
            }
        }, false);

    }, false);

    /**
     * 아이디 생성 규칙
     * 1. 반드시 영문자가 하나 포함되어야 함 -> Primary Key(UserID) 와의 혼선 방지
     * 2. 아이디는 4자 ~ 15자 길이
     * 3. 아이디는 숫자와 영어로만 구성 가능
     * 
     * @param str : 아이디(String)
     * @return true : 아이디 생성 규칙을 만족 / false : 아이디 생성 규칙에 부합하지 않음 
     * @exception 없음
     */
    function checkID(str) {
        if (/^[a-zA-Z0-9]{4,15}$/.test(str)) {
            if (!/[a-zA-Z]/.test(str)) {
                alert("아이디에 영문자가 반드시 한자 이상 포함되어야 합니다.");
                return false;
            }
            return true;
        }
        if (str.length < 4 || str.length > 15) {
            alert("아이디는 4자 에서 15자 까지만 허용합니다.");
        } else {
            alert("아이디에 숫자나 영문자가 아닌 문자가 포함되어 있습니다.");
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
            alert("비밀번호가 일치하지 않습니다!");
            return false;
        }

        alert("비밀번호 일치");
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
            alert("잘못된 이메일 형식입니다.");
            return false;
        }
        alert("유효한 이메일 형식입니다");
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
})();