<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/jsp/layout/header.jsp" charEncoding="UTF-8" />

<div class="container">
	<h1><c:choose ><c:when test="${isUpdate}">회원수정</c:when><c:otherwise>회원가입</c:otherwise></c:choose></h1>
	<form action="/member/form" method="post">
	    <c:if test="${isUpdate}"><input type="hidden" id="id" name="id" value="${member.id }"/></c:if>
		<div class="form-group">
			<label for="memberId">사용자 아이디</label> 
			<input type="text" class="form-control" name="memberId" id="memberId" placeholder="memberId" value="${member.memberId }"> 
			<small id="idHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
		</div>
		<div class="form-group">
			<label for="memberPassword">Password</label> 
			<input type="password" class="form-control" name="memberPassword" id="memberPassword" placeholder="memberPassword" value="${member.memberPassword }">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">이름</label> 
			<input type="text" class="form-control" name="memberName" id="memberName" placeholder="memberName" value="${member.memberName }">
		</div>
		<button type="submit" class="btn btn-primary">
			<c:choose >
                <c:when test="${isUpdate}">수정</c:when>
                <c:otherwise>회원가입</c:otherwise>
            </c:choose>
		</button>
	</form>
</div>

<c:import url="/WEB-INF/jsp/layout/footer.jsp" charEncoding="UTF-8" />