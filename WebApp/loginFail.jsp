<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
<div class="login-form">
	<form method="POST" action="Login.ruw">
		<input type="text" name="userId" placeholder="아이디"> <input
			type="password" name="userPw" placeholder="비밀번호"> <input
			type="submit" class="submit" value="로그인  ">
		<div class="cancel">로그인 취소</div>
	</form>
</div>
<jsp:include page="module/bottom.jsp" />
</body>
</html>