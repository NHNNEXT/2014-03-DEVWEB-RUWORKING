<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src = "module/pages/register/js/formverify.js"></script>
<script src = "module/pages/register/js/fail_Layout.js"></script>
<div id="pageContainer">
<div id="ns-register">	
	<div id="body-container">
	<div class = "header">&nbsp;회원가입</div>
	<span class="fail">죄송합니다. 회원가입에 실패하였습니다. 다시 시도해 주세요</span>
	<section>
		<span class="title">회원가입 약관</span>
		<div class = "terms">
		이 사이트는 학습을 위해 개발중인 사이트 입니다.<br><br>
		비밀번호 암호화 작업등은 진행하였으나 학습 목적을 벗어나는 수준의 회원정보를 보호활동은 진행하지 않습니다.<br><br>
		본 사이트에 가입함으로 인해 발생할 수 있는 <u>개인정보 보안과 관련된 모든 문제에 대해 본 사이트는 책임지지 않으며 모든 책임은 귀하에게 귀속됨에 동의하신다면</u> 좌측 하단에 위치한 동의 버튼을 누르시고 가입을 계속 진행하세요
		</div>
		<div class="agree">
		<input type="checkbox" name="agree" data-type="agree"> 위 약관에 동의합니다
		</div>
		<div class="showregistererror">
			올바르지 않은 입력값이 있습니다<br>
			<span>
				체크해 보세요!<br>
				1. 약관에 동의하셨나요?<br>
				2. 아이디/비밀번호/이메일 등이 올바른가요?<br>
				3. 성별 체크를 하셨나요?
			</span>
		</div>
	</section>
	<section>
		<span class="title">정보 입력</span>
		<form action="/Register.ruw" id ="test" method="post">
		<div class="input-wrap"><input type="text" name="id" data-type="id" placeholder = "아이디">
		<span class="validate-info validate-big">알파벳, 숫자를 활용하여 4자 ~ 12자의 ID를 구성하세요<br>단, 아이디에 영문자가 반드시 1개이상 포함되어야 합니다</span></div>
		<div class="input-wrap"><input type="password" name="pw1" data-type="pw1" placeholder = "비밀번호">
		<span class="validate-info">비밀번호가 일치하지 않습니다.</span></div>
		<div class="input-wrap"><input type="password" name="pw2" data-type="pw2" placeholder = "비밀번호 확인">
		<span class="validate-info">비밀번호가 일치하지 않습니다.</span></div>
		<div class="input-wrap"><input type="email" name="email" data-type="email" placeholder = "비상연락용 이메일 (example@example.com)"><span class="validate-info">이메일 주소를 다시 확인해주세요.</span></div>

		<div class="gender-wrap">
			<div class="male">
				<input type="radio" name="gender" id = "Male" data-type="gender" value="남"><label for="Male">남성</label>
			</div>
			
			<div class="female">
				<input type="radio" name="gender" id = "Female" data-type="gender" value="여"><label for="Female">여성</label>
			</div>
		</div>
		<div id = "submit" data-type="submit">회원가입</div>
		</form>
	</section>
	</div>
</div>
</div>