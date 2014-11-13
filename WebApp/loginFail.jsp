<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
<div class="login-form">
<p>아이디 또는 비밀번호를 다시 확인하세요.</p>
<p>RUWORKING에 등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.</p>
	<form method="POST" action="Login.ruw">
		<input type="text" name="userId" placeholder="아이디"> <input
			type="password" name="userPw" placeholder="비밀번호"> <input
			type="submit" class="submit" value="로그인  ">
		<div class="cancel"><a href="index.jsp">로그인 취소</a></div>
	</form>
</div>
</body>
</html>