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
        <a class="navbar-brand" href="#">CMS</a>
        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="navbar-nav mr-0 my-2 my-lg-0 navbar-right">
                <li class="btn btn-outline-success"><a href="/">Posts</a></li>
                <c:choose>
                    <c:when test="${empty sessionedMember}">
	                    <li class="btn btn-outline-success"><a href="/login/form">로그인</a></li>
	                    <li class="btn btn-outline-success"><a href="/member/form">회원가입</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="btn btn-outline-success"><a href="/logout">로그아웃</a></li>
                        <li class="btn btn-outline-success"><a href="/member/${id}/form">개인정보수정</a></li>
                    </c:otherwise>
                </c:choose>
                
            </ul>
        </div>
    </nav>