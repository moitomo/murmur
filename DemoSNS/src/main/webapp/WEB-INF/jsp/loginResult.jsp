<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="jp.demo.model.User" %>
<%
//セッションスコープからユーザー情報を取得
User loginUser =(User)session.getAttribute("loginUser");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MURMUR</title>
<link rel="stylesheet" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400..700&display=swap" rel="stylesheet">
</head>
<body>

	<!-- ヘッダー -->
	<div class="header">
	    <h1>MURMUR</h1>
	</div>
	
	<br>
	<br>
	
	<!-- ログイン結果 -->	
		
	<!-- ログイン成功時 -->
	<div class="login-message">
	<c:if test="${not empty loginUser}">
	    <p>ログインに成功しました</p>
	    <p>ようこそ ${loginUser.name} さん</p>
	    <a href="Main"class="button">投稿ページへ</a>
	</c:if>
	
	<!-- ログイン失敗時 -->
	<c:if test="${empty loginUser}">
	    <p>ログインに失敗しました</p>
	    <a href="index"class="button">TOPへ</a>
	</c:if>



</body>
</html>