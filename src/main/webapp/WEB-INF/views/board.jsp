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
	<h3>게시판 목록</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>날짜</th>	
		</tr>
		
		<c:forEach var="map" items="${list}">
		<tr>
			<td>${map.BRD_NO}</td>
			<td><a href="boardc.do?no=${map.BRD_NO}">${map.BRD_TITLE}</a></td>
			<td>${map.BRD_WRITER}</td>
			<td>${map.BRD_HIT}</td>
			<td>${map.BRD_DATE}</td>	
		</tr>
		</c:forEach>
	</table>
	
	<a href="boardw.do">게시판글쓰기</a>
</body>
</html>