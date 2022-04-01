<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function() {
	if(location.search.match("wrong=true")) {
		alert("아이디 혹은 비밀번호가 잘못되었습니다.");
		location.href = location.pathname;
	}
})
</script>

<style>
.body {
    position: relative;
    background: #f5f6f7;
}

.simbol {
	display: flex;
    justify-content: center;
}

.text {
	display: flex;
    justify-content: center;
}

.login {
	background-color: #2660d6;
    color: yellow;
    width: 300px;
}

.login_login {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}
</style>

</head>
<body class="body">
	<div class="simbol">
		<a href="/"><img src="/resources/image/addbutton.gif" width="300" alt="My Image"></a>
	</div>
	
	<div class="text">
		<form action="login" method="post">
			<div>아이디</div>
			<input type="text" name="id" size=40>
			<div>비밀번호</div>
			<input type="password" name="pw" size=40>
			
		<div class="login_login">
			<button class="login">로그인</button>		
		</div>

		</form>
	</div>
</body>
</html>