<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/jsp/layout/header.jsp" charEncoding="UTF-8" />

<div class="container">
	<h1>회원목록</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Id</th>
				<th scope="col">비밀번호</th>
				<th scope="col">이름</th>
				<th scope="col">수정</th>
			</tr>
		</thead>
		<tbody>
            <c:forEach var="member" items="${members}" varStatus="vs">
            <tr>
                <th scope="row">${vs.count }</th>
                <td>${member.memberId }</td>
                <td>${member.memberPassword }</td>
                <td>${member.memberName }</td>
                <td><a href="/member/${member.id }/form" class="btn btn-primary">수정</a></td>
            </tr>
            </c:forEach>					
		</tbody>
	</table>
</div>

<c:import url="/WEB-INF/jsp/layout/footer.jsp" charEncoding="UTF-8" />