<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${chatting.name} 채팅방</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
#chatting {
	height:400px;
	background-color:#bfff00;
	padding-bottom: 300px;
}

.title {
	background-color: #a1e5a1;
}

.text {
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.textarea {
	resize: none;
}

.bubbleme {
	display: flex;
    justify-content: flex-end;
    align-items: center;
    margin-top: 3px;
    margin-right: 5px;
}

.another {
	display: flex;
    align-items: center;
    margin-top: 3px;
    margin-left: 10px;
    margin-bottom: 3px;
}

.name {
    background: #ffe529;
    text-align: center;
    border-radius: 20%;
    padding: 3px;
    line-height: 2;
}

.text {
	border-radius: 20%;
    background: #ffffff;
}

.title {
	display: flex;
    justify-content: space-between;
}
</style>

<script>
var chatroomlist_code = ${chatting.code}

// 스크롤 맨 밑으로 가는 코드
function addElement(text) {
   // create a new element
   const element = document.createElement('chatting');
   element.innerText = text;

   // get the list where you want to add the element 
   const list = document.getElementById("");
   list.appendChild(element);

   // scroll to it
   element.scrollIntoView();
}

// 채팅 내용을 가져오는 코드
function loadChat() {
	console.log("loadChat()");
	$.ajax({
		url : "/chatroom/" + chatroomlist_code + "/list",
		method : "GET",
		dataType : "JSON",
		success : function(server_data) {
			makeChat(server_data);
		}
	})
}
// 가져온 채팅 내용을 배치를 하는 코드
function makeChat(server_data) {
	var html = "";
	
	for(var i=0; server_data.length > i; i++) {
		var chat_item = server_data[i];
		var isMe = chat_item.user_code == ${code};
		var who = "another";
		
		if(isMe) {
			who = "me";
		}
		/**
		html += "<div class = 'bubble" + who + "'>";
		// 기본 <div class = 'bubble another>
		if(isMe) {
			html += "<small class = 'time'>" + (new Date(chat_item.time)).format("Y-m-d H:M:S") + " </small>";
		}
		// 자신일 경우 <div class = 'bubble me'><small class = 'time'>시간</small>
		if(!isMe) {
			html += "<small class='name'>" + chat_item.chat_user_name + "</small>";
		}
		// 상대일 경우 <div class = 'bubble another'><small class = 'name'>이름</small>
		html += "<span class = 'text " + who + "'>" + chat_item.story + "</span>";
		// 자신일 경우 <div class = 'bubble me'><small class = 'time'>시간</small><span class = 'text' me>내용</span>
		// 상대일 경우 <div class = 'bubble another'><small class = 'name'>이름</small><span class = 'text' me>내용</span>
		if(!isMe) {
			html += "<small class = 'time'>" + (new Date(chat_item.time)).format("Y-m-d H:M:S") + "</small>";
		}
		// 상대일 경우 <div class = 'bubble another'><small class = 'name'>이름</small><span class = 'text' me>내용</span><small class = 'time'>시간</small>
		html += "</div>";
		// 자신일 경우 <div class = 'bubble me'><small class = 'time'>시간</small><span class = 'text' me>내용</span></div>
		// 상대일 경우 <div class = 'bubble another'><small class = 'name'>이름</small><span class = 'text' me>내용</span><small class = 'time'>시간</small></div>
		*/
		
		html += "<div class = 'bubble" + who + "'>";
		// <div class = 'bubble me'>
		if(isMe) {
			html += "<small class = 'time'>" + (new Date(chat_item.time)).format("Y-m-d H:m") + "</small>";
		}
		// <div class = 'bubble me'>시간
		if(isMe) {
			html += "<span class = 'text " + who + "'>" + chat_item.story + "</span>";
		}
		// <div class = 'bubble me'>시간<span class ='text me'>내용</span>
		if(!isMe) {
			html += "<div><small class='name'>" + chat_item.chat_user_name + "</small></div>";
		}
		// <div class = 'bubble me'><div><small class='name'>이름</small></div>
		if(!isMe) {
			html += "<div class = 'another'><span class = 'text " + who + "'>" + chat_item.story + "</span>";
		}
		// <div class = 'bubble me'><div><small class='name'>이름</small></div class = 'another'><div><span class = 'text another'>내용</span>
		if(!isMe) {
			html += "<small class = 'time'>" + (new Date(chat_item.time)).format("Y-m-d H:m") + " </small></div>";
		}
		// <div class = 'bubble me'><div><small class='name'>이름</small></div><div class = 'another'><span class = 'text another'>내용</span><small class = 'time'>시간</samll></div>
		html += "</div>";
		// 자신일 경우 <div class = 'bubble me'>시간<span class ='text me'>내용</span></div>
		// 상대일 경우 <div class = 'bubble me'><div><small class='name'>이름</small></div class = 'another'><div><span class = 'text another'>내용</span><small class = 'time'>시간</samll></div>
	}
	
	$("#chatting").html(html);
}
// 자바스크립트에서 지정한 날짜 형식에 따라 날짜 출력해주는 함수.
Date.prototype.format = function (format) { 
   format = format.replace(/Y/g, this.getFullYear());
   format = format.replace(/y/g, (this.getFullYear().toString()).substring(3 - 1));
   format = format.replace(/m/g, ((this.getMonth()+1)<10) ? '0'+(this.getMonth()+1):(this.getMonth()+1));
   format = format.replace(/d/g, (this.getDate()<10) ? '0'+this.getDate():this.getDate());
   format = format.replace(/H/g, (this.getHours()<10) ? '0'+this.getHours():this.getHours());
   format = format.replace(/m/g, (this.getMinutes()<10) ? '0'+this.getMinutes():this.getMinutes());
   format = format.replace(/s/g, (this.getSeconds()<10) ? '0'+this.getSeconds():this.getSeconds());
   format = format.replace(/U/g, (this.getMilliseconds()<10) ? '0'+this.getMilliseconds():this.getMilliseconds());
   return format;
}
Date.prototype.addDays = function(days) {
  // 날짜 더해주는 함수.
  //var date = new Date(this.valueOf());
  //date.setDate(date.getDate() + days);
  //return date;
  // 객체 재활용하도록 코드 수정 2019-10-26 21:09 Hawon Kim
  this.setDate(this.getDate() + days);
  return this;
}
//입장과 동시에 작동
$(function() {
	// 채팅 내용을 보여주는 코드
	loadChat();
	interval = setInterval(loadChat, 1 * 1000);
	// 보내기를 눌렀을 때 작동하는 코드
	$("#button").on("click", function() {
		
		var textarea = $("#textarea").val();
		
		if(textarea == "") {
			return false;
		} 
		
		$.ajax({
			url : "/chatroom/new",
			method : "POST",
			data : {
				"chatroomlist_code" : chatroomlist_code,
				"story" : textarea,
			},
			success : function(data) {
				loadChat();
				$("#textarea").val("");
				console.log("성공")
			},
			error : function() {
				console.log("실패")	
			}
		})
	})
})
</script>

</head>
<body>
	<!-- 제목 -->
	<div class="title">
		<div>
			<a href="/chatroomlist" style="text-decoration:none">나가기</a>
		</div>
		
		<div>
			<span>${chatting.name}</span>
		</div>
		
		<div>
			<button id="change">수정</button>
			<button id="confirm">완료</button>
			<button id="cancel">취소</button>
		</div>
	</div>
	<!-- 채팅을 보는 곳 -->
	<div id="chatting" style="overflow:auto;"></div>
	<!-- 채팅치는 곳 -->
	<div id="text" class="text">
		<textarea id="textarea" class="textarea" style = "width:90%" rows="" cols=""></textarea>
		
		<button id="button" class = "button">보내기</button>
	</div>
</body>
</html>