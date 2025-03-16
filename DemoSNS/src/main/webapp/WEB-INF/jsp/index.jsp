<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="chuitter" content="つぶやきサイトだよ">
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
		<p>MURMURへようこそ！</p>
		
	<br>
	<br>
	
	<div id="login-container">
	
	    <form action="Login" method="post">
	
	        <div class="form-group">
	            <label for="name">ユーザー名：</label>
	            <input type="text" id="name" name="name" placeholder="名前を入れてね">
	        </div>
	
	        <div class="form-group">
	            <label for="pass">パスワード：</label>
	            <input type="password" id="pass" name="pass" placeholder="半角英数字">
	        </div>
	
	        <input type="submit" class="button" value="ログイン">
	
	    </form>
	
</div>

</body>
</html>