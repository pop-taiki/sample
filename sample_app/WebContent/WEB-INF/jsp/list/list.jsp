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
				
				<div class="collapse navbar-collapse" id="navbarEexample1">
					<ul class="nav navbar-nav">
						<li><a href="./Logout">ログアウト</a></li>
						<li><a href="./Post">投稿</a></li>
					</ul>
					<p class="navbar-text navbar-right">ようこそ${user.userName}さん</p>
				</div>
			</div>
		</nav>
		
		<div class="container-fluid bg-info">
			<h1>一覧画面</h1>
			<table class="table table-striped">
				<!-- メッセージ情報を出力 -->
				<c:forEach var="message" items="${messages}" varStatus="status">
					<tr>
						<td>
							<div class="media">
								<div class="media-body">
									<h4 class="media-heading">
										<c:out value="${message.userName}" />
										<small><c:out value="${message.posted}" /></small>
									</h4>
									<br><c:out value="${message.message}" /><br>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="./js/bootstrap.min.js"></script>
	</body>
</html>