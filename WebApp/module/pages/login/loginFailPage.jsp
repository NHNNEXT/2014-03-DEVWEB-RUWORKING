<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="pageContainer">
<div id="ns-LoginFail">
	<span class="title">로그인 실패</span>
	<div class="box">
		<span class="noti">${errorMessage}</span>
		<div class="login-form">
			<form method="POST" action="Login.ruw">
				<div class="input-wrap"><input type="text" name="userId" placeholder="아이디"></div>
				<div class="input-wrap"><input type="password" name="userPw" placeholder="비밀번호"></div>

				<div class="submit"><input type="submit" class="submit" value="로그인"></div>
			</form>
		</div>
	</div> 
</div>
</div>