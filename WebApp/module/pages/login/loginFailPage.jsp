<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src = "library/js/sha256.js"></script>
<script src = "module/pages/login/js/encryptPassword.js"></script>

<div id="pageContainer">
<div id="ns-LoginFail">
	<span class="title">로그인 실패</span>
	<div class="box">
		<span class="noti">${errorMessage}</span>
		<div class="login-form">
			<form method="POST" action="Login.ruw" id="login-form">
				<div class="input-wrap"><input type="text" name="userId" placeholder="아이디"></div>
				<div class="input-wrap"><input type="password" name="userPw" class="password" placeholder="비밀번호">
				<input type="hidden" name="PwEncryption" class="PwEncryption"></div>
				<div class="submit"><div class="submit">로그인</div>
			</form>
		</div>
	</div> 
</div>
</div>