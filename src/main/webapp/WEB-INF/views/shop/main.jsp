<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>홈화면</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/shop/login.do">로그인</a><br />
	<a href="${pageContext.request.contextPath}/shop/join.do">회원가입</a><br />
	
	<a href="${pageContext.request.contextPath}/shop/logout.do">로그아웃</a><br />
	<a href="${pageContext.request.contextPath}/shop/edit.do">정보수정</a><br />
	<a href="${pageContext.request.contextPath}/shop/delete.do">회원탈퇴</a><br />
	
</body>
</html>