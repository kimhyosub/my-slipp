<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" />
<title>CMS</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">SLIPP</a>
		<div class="collapse navbar-collapse " id="navbarSupportedContent">
			<ul class="navbar-nav mr-0 my-2 my-lg-0">
				<li class="btn btn-outline-success"><a href="/member/join">회원가입</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h1>회원가입</h1>
		<form action="/member/join" method="post">
			<div class="form-group">
				<label for="memberId">사용자 아이디</label> 
				<input type="text" class="form-control" name="memberId" id="memberId" placeholder="memberId"> 
				<small id="idHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="memberPassword">Password</label> 
				<input type="password" class="form-control" name="memberPassword" id="memberPassword" placeholder="memberPassword">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">이름</label> 
				<input type="text" class="form-control" name="memberName" id="memberName" placeholder="memberName">
			</div>
			<button type="submit" class="btn btn-primary">회원가입</button>
		</form>
	</div>

	<!-- footer -->
	<script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>