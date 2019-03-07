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
                <th scope="col">답변의수</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="question" items="${questions}" varStatus="vs">
            <tr>
                <th scope="row">${vs.count }</th>
                <td>${question.title }</td>
                <td>${question.writer }</td>
                <td></td>
                <td></td>
            </tr>
            </c:forEach>                    
        </tbody>
    </table>
</div>

<c:import url="/WEB-INF/jsp/layout/footer.jsp" charEncoding="UTF-8" />
    