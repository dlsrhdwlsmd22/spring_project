<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>게시판 내용</h3>
	<table border="1">
		<tr>
			<th>글번호</th>
			<td>${map.BRD_NO}</td>
		</tr>
		<tr>	
			<th>제목</th>
			<td>${map.BRD_TITLE}</td>
		</tr>		
		<tr>	
			<th>내용</th>
			<td>${map.BRD_CONTENT}</td>
		</tr>
		<tr>	
			<th>작성자</th>
			<td>${map.BRD_WRITER}</td>
		</tr>
		<tr>	
			<th>조회수</th>
			<td>${map.BRD_HIT}</td>
		</tr>
		<tr>	
			<th>날짜</th>
			<td>${map.BRD_DATE}</td>
		</tr>	
	</table>
	<a href="board.do">글목록</a>
	<c:if test="${prev != 0 }">
		<a href="boardc.do?no=${prev}">이전글</a>
	</c:if>
	<c:if test="${next != 0 }">
		<a href="boardc.do?no=${next}">다음글</a>
	</c:if>
	<a href="boarde.do?no=${map.BRD_NO}">글수정</a>
</body>
</html>