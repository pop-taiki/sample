<?xml version="1.0" encoding="UTF-8" ?>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			</div>
		</nav>
		
		<div class="container-fluid bg-info">
			<h1>ログイン画面</h1>
			<!-- ログインが失敗した場合に出力 -->
			<span class="label label-danger">${message}</span>

			<!-- ログインIDとパスワードを入力 -->
			<form action="./Login" method="post">
				<input class="input-small" type="text" name="loginId" id="exampleInputName2" size="20" maxlength="10" placeholder="ID" />
				<input class="input-small" type="password" name="loginPassword" id="exampleInputName2" size="20" maxlength="20" placeholder="Password" />
				<input class="btn btn-primary btn-large" type="submit" value="Sign in" />
			</form>
		</div>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="./js/bootstrap.min.js"></script>
	</body>
</html>