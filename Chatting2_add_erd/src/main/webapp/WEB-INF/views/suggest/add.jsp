<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<script>
$(function() {
	$("#story").summernote({
        placeholder: '여기에 입력하세요',
        tabsize: 2,
        height: 120,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture', 'video']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ]
      });	
	
	
});

$(function() {
	$("#new").submit(function(e) {
		if($("#name").val() == "") {
			alert("제목이 비었습니다")
			return false;
		}
		
		if($("#story").val() == "") {
			alert("내용이 비었습니다")
			return false;
		}
	})
})
</script>

<style>

.simbol {
	display: flex;
    justify-content: center;
}

.button {
	background-color: #2660d6;
    color: yellow;
    width: 300px;
}

.add {
	display: flex;
    justify-content: space-between;
    margin: 20px;
}

</style>

<title>건의사항</title>
</head>
<body>
	<div class="simbol">
		<a href="/"><img src="/resources/image/addbutton.gif" width="300" alt="My Image"></a>
	</div>
	
	<form action="add" method="post" id="new">
		<div>
			<span>제목 : </span>
			<input type="text" id="name" name="name">
			
			<br>
			
			<textarea type="text" id="story" name="story"></textarea>
		</div>
		
		<div class="add">
			<div style=visibility:hidden>
				가상의 공간
			</div>
			
			<div>
				<button class="button">등록</button>
			</div>
			
			<div>
				<a href="/suggest" style="text-decoration:none">나가기</a>
			</div>
		</div>
	</form>
</body>
</html>