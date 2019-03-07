<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/jsp/layout/header.jsp" charEncoding="UTF-8" />

<div class="container">
	<h1>질문하기</h1>
	<form action="/question" method="post">
		<div class="form-group">
			<label for="title">제목</label> 
			<input type="text" class="form-control" name="title" id="title" placeholder="제목" value="">
		</div>
		<div class="form-group">
			<label for="contents">내용</label> 
			<textarea class="form-control" name="contents" id="contents" placeholder="내용" ></textarea>
		</div>
		<button type="submit" class="btn btn-primary">질문하기</button>
	</form>
</div>

<c:import url="/WEB-INF/jsp/layout/footer.jsp" charEncoding="UTF-8" />