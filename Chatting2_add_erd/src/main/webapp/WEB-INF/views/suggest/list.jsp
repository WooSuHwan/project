<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>건희사항 목록</title>

<style>

.simbol {
	display: flex;
    justify-content: center;
}

.list {
	display: flex;
    justify-content: center;
}

.add_out {
	display: flex;
    justify-content: flex-end;
}

.suggestlist {
	display: flex;
    justify-content: center;
}

</style>

</head>
<body>
	<div class="simbol">
		<a href="/"><img src="/resources/image/addbutton.gif" width="300" alt="My Image"></a>
	</div>
	
	<div class="suggestlist">
		<h1>건의사항 목록</h1>
	</div>
	
	<div class = "list">		
		<div>
			<table>
				<thead>
					<c:choose>
						<c:when test="${list.size() > 0}">
							<tr>
								<th>번호</th>
								<th><span>제목</span></th>
								<th>입장</th>
								<th>삭제</th>
							</tr>
				</thead>
				
				<tbody>					
					<c:forEach var="item" items="${list}" varStatus="status">
					<tr>
						<td>${list.size() - status.index}</td>
						<td>${item.name}</td>
						<td><a href="/suggest/${item.code}" style="text-decoration:none">입장</a></td>
						<td>
							<c:if test="${code eq item.user_code}">
								<a href="/suggest/delete/${item.code}" style="text-decoration:none">삭제</a>
							</c:if>
						</td>
					</tr>
						</c:forEach>
							</c:when>
								<c:otherwise>
									<div>등록된 건의사항이 없습니다</div>
								</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			
			<div class="add_out">
				<c:if test="${code ne null}">
					<a href="/suggest/add" style="text-decoration:none">추가</a>
				</c:if>
				
				<a href="/" style="text-decoration:none; margin-left: 5px;">나가기</a>
			</div>
		</div>
<!--
	<div>
		<div>
			<span>번호</span>
			<span>제목</span>
			<span>수정</span>
			<span>삭제</span>
		</div>
		<c:choose>
			<c:when test="${list.size() > 0}">
				<c:forEach var="item" items="${list}" varStatus="status">
					<div>
						<span>${list.size() - status.index}</span>
						<span>${item.name}</span>
						<span><a href="/suggest/${item.code}">입장</a></span>
						<span>
							<c:if test="${code eq item.user_code}">
								<a href="/suggest/delete/${item.code}">삭제</a>
							</c:if>
						</span>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>등록된 건의사항이 없습니다</div>
			</c:otherwise>
		</c:choose>
-->
	</div>
</body>
</html>