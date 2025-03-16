<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.demo.model.User,jp.demo.model.Mutter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List" %>	



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chuitter</title>
<link rel="stylesheet" href="css/main.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400..700&display=swap" rel="stylesheet">
</head>
<body>

	<!-- ヘッダー -->
	<div class="header">
	    <h1>MURMUR</h1>
	    <a href="Logout" class="logout-button">ログアウト</a>
	</div>
	
	<div id="main-container" style="margin-top: 80px;"> <!-- ヘッダー分の余白 -->

	
	<p>
	<c:out value="${loginUser.name }" /> さん　MURMURへようこそ！
	</p>


	
	<form action = "Main" method="post">
		<input type="text" name="text">
		<input type="submit" value="投稿">
	</form>
	
	<br>
	<br>
	
	
	<!--エラーの場合 -->
	<c:if test="${not empty errorMsg}">
		<p　style="color:red;"><c:out value="${errorMsg}" /></p>
	</c:if>
	
	
	<!--投稿一覧 -->
	<div class="chat-box">
		<c:forEach var = "mutter" items="${mutterList}">
			<div class="chat ${mutter.userName eq loginUser.name ? 'right' : 'left'}">
		
				<!-- 長丸の名前表示 -->
				<div class="user-name">
					<c:out value="${mutter.userName}" />
				</div>
	
				<!-- 吹き出し -->
				<div class="bubble">
					<c:out value="${mutter.text}" escapeXml="false" />
				</div>
				
			</div>
		</c:forEach>
	</div>
		
	
	<br>
	<br>
	
	


</body>
</html>