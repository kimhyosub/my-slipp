<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/jsp/layout/header.jsp" charEncoding="UTF-8" />

<div class="container">
	<h1>로그인</h1>
	<c:if test="${!empty errorMessage}">
	   <div class="alert alert-danger" role="alert">${errorMessage}</div>
	</c:if>
	<form action="/login" method="post">
		<div class="form-group">
			<label for="memberId">사용자 아이디</label> 
			<input type="text" class="form-control" name="memberId" id="memberId" placeholder="memberId"> 
		</div>
		<div class="form-group">
			<label for="memberPassword">Password</label> 
			<input type="password" class="form-control" name="memberPassword" id="memberPassword" placeholder="memberPassword">
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>

<c:import url="/WEB-INF/jsp/layout/footer.jsp" charEncoding="UTF-8" />
	