<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />
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
		<h1>회원목록</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Id</th>
					<th scope="col">비밀번호</th>
					<th scope="col">이름</th>
				</tr>
			</thead>
			<tbody>
                <c:forEach var="member" items="${members}" varStatus="vs">
                <tr>
                    <th scope="row">${vs.count }</th>
                    <td>${member.memberId }</td>
                    <td>${member.memberPassword }</td>
                    <td>${member.memberName }</td>
                </tr>
                </c:forEach>					
			</tbody>
		</table>
	</div>

	<!-- footer -->
	<script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>