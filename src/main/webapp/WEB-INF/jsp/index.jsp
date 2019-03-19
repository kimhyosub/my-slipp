<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/jsp/layout/header.jsp" charEncoding="UTF-8" />

<div class="container">
    <h1>메인페이지</h1>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">제목</th>
                <th scope="col">글쓴이</th>
                <th scope="col">날짜</th>
                <th scope="col">댓글개수</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="question" items="${questions}" varStatus="vs">
            <tr>
                <th scope="row">${vs.count }</th>
                <td><a href="/question/${question.id}">${question.title }</a></td>
                <td>${question.writer.memberId }</td>
                <td>${question.formattedCreateDate}</td>
                <td>${question.countOfAnswer}</td>
            </tr>
            </c:forEach>                    
        </tbody>
    </table>
    <div>
        <a class="btn btn-primary" href="/question/form">글쓰기1</a>
    </div>
</div>

<c:import url="/WEB-INF/jsp/layout/footer.jsp" charEncoding="UTF-8" />
    