<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${suggest.name}</title>

<style>

.simbol {
	display: flex;
    justify-content: center;
}

</style>

</head>
<body>
	<div class="simbol">
		<a href="/"><img src="/resources/image/addbutton.gif" width="300" alt="My Image"></a>
	</div>
	<form action="add" method="post" id=show>
		<h3>${suggest.name}</h3>
		<div><b>등록일 </b>${suggest.time}</div>
		<hr style="border: solid 1px gray;">
		<div>${suggest.story}</div>
		<hr style="border: solid 1px gray;">
	</form>
	<div>
		<a href="/suggest" style="text-decoration:none">나가기</a>
	</div>
</body>
</html>