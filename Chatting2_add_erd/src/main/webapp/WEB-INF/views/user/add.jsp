<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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

.add {
	display: flex;
    justify-content: center;
    margin-top: 20px;
}

.add_add {
	background-color: #2660d6;
    color: yellow;
    width: 300px;
}

</style>

<script>
// 아이디 중복 확인
function confirm(event) {
	var id = $("#id").val();

	if(id == "") {
		return false;
	}
	// 아이디 중복 확인
	$.ajax({
		url:"same",
		data:{"user_id" : id},
		method:"POST",
		dataType:"TEXT",
		success:function(data) {
			console.log(data);
			
			if(data == "overlap") {
				$("#id_message").text("아이디가 중복이 되었습니다")
				$("#confirm").attr("disabled", true);
			} else {
				$("#id_message").text("멋있는 아이디 입니다.")
				$("#confirm").attr("disabled", false);
			}
		},
		error:function(){
			console.err("에러")
		}
	})
}
// 비밀번호 확인
function pw_confirm() {
	var pw = $("#pw").val();
	var pw_confirm = $("#pw_confirm").val()
	
	if(pw == "") {
		$("#pw_message").text("비밀번호가 비었습니다")
		return true;
	}
	
	if(pw == pw_confirm) {
		$("#pw_confirm_message").text("비밀번호가 일치합니다")
		return false;
	} else {
		$("#pw_confirm_message").text("비밀번호가 일치하지 않습니다")
		return true;
	}
	
}
// 페이지 로딩 후
$(function() {
	$("#id").blur(function() {
		confirm();
	})
	
	$("#pw, #pw_confirm").blur(function() {
		pw_confirm();
	})
	// 등록을 눌렀을 때
	$("#add").submit(function(event) {
		
		if($("#pw").val()=="") {
			alert("비밀번호가 비었습니다")
			event.preventDefault()
			return false;
		}
		// 등록 방지 용도
		var value = $("#pw_confirm").val();
		var result = value.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,16}/);
		if(result == null) {
			alert("비밀번호가 비었거나 일치하지 않습니다")
			event.preventDefault()
			return false;
		}
		
		if($("#name").val()=="") {
			alert("이름이 비었습니다")
			event.preventDefault()
			return false;
		}
		
		if($("#birth").val()=="") {
			alert("생년월일이 비었습니다")
			event.preventDefault()
			return false;
		}
		
		if($("#tell").val()=="") {
			alert("전화번호가 비었습니다")
			event.preventDefault()
			return false;
		}
			
	})
	// 보여주는 용도
	$("#pw").on("keyup", function() {
		var value = $("#pw").val();
		var result = value.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,16}/);
		
		if(result == null) {
			$("#pw_message").text("8~16자 영문 및 대소문자 숫자 특수문자");
		} else {
			$("#pw_message").text("비밀번호가 조건에 맞습니다");
		}	
	})
})


</script>
</head>
<body class="body">
	<div class="simbol">
		<a href="/"><img src="/resources/image/addbutton.gif" width="300" alt="My Image"></a>
	</div>
	
	<div class="text">
		<form action="add" method="post" id="add">			
			<div class="text_text">
				<div style="font-weight: 600">아이디:</div>
				<input type="text" name="id" id="id" required maxlength="16" size=40>
				<div id="id_message"></div>
				
				<div style="font-weight: 600">비밀번호:</div>
				<input type="password" name="pw" id="pw" size=40>
				<div id="pw_message"></div>
				
				<div style="font-weight: 600">비밀번호 확인:</div>
				<input type="password" name="pw_confirm" id="pw_confirm" size=40>
				<div id="pw_confirm_message"></div>
				
				<div style="font-weight: 600">이름</div>
				<input type="text" name="name" id="name" size=40>
				<div id="name_message"></div>
				
				<div style="font-weight: 600">전화번호</div>
				<input type="tel" name="tell" id="tell" size=40>
				<div id="tell_message"></div>
				
				<div style="font-weight: 600">생년월일</div>
				<input type="date" name="birth" id="birth" size=40>
				<div id="birth_message"></div>
				
				<div style="font-weight: 600">성별</div>	
				<select name="sex" id="sex">
					<option value="0">남자</option>
					<option value="1">여자</option>
				</select>
				
				<br>
				
				<div class="add">
					<button id="confirm" disabled="disabled" class="add_add">등록</button>
				</div>	
			</div>			
		</form>
	</div>
</body>
</html>