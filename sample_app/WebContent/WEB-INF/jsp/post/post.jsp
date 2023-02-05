<?xml version="1.0" encoding="UTF-8" ?>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="./css/bootstrap.min.css" rel="stylesheet">
		<link href="./css/style.css" rel="stylesheet" />
		<title>サンプルアプリ</title>
	</head>

	<body>
		<nav class="navbar navbar-static-top navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbarEexample1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<strong><span class="navbar-brand">サンプルアプリ</span></strong>
				</div>
	
				<div class="collapse navbar-collapse" id="navbarEexample1">
					<ul class="nav navbar-nav">
						<li><a href="./List">一覧に戻る</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		<div class="container-fluid bg-info">
			<h1>投稿画面</h1>
			<!-- コメントを入力 -->
			<!-- 投稿ボタン押下で確認ダイアログを表示しOKボタン押下でメッセージ情報へ登録 -->
			<form action="./Post" method="post">
				<input type="text" name="message" size="50" maxlength="55" />
				<input type="submit" value="投稿" class="btn btn-primary btn-large" onclick="return confirm('投稿しますか？')" />
			</form>
		</div>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="./js/bootstrap.min.js"></script>
	</body>
</html>