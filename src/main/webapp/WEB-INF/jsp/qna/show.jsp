<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/jsp/layout/header.jsp" charEncoding="UTF-8" />

<div class="container">
    
    <h1>${question.title}</h1>
    
    <div class="form-group">
        <label for="title">제목</label> 
        ${question.title }" 
    </div>
    <div class="form-group">
        <label for="contents">내용</label> 
        ${question.contents }
    </div>
    <a class="btn btn-primary" href="/question/${question.id }/form">수정</a>
    <a class="btn btn-primary" href="/question/${question.id }/form">삭제</a>
    <a class="btn btn-primary" href="/">목록</a>
    
</div>

<c:import url="/WEB-INF/jsp/layout/footer.jsp" charEncoding="UTF-8" />