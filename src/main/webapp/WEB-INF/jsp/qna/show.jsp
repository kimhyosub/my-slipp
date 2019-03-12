<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/jsp/layout/header.jsp" charEncoding="UTF-8" />

<div class="container" id="main">
    <div class="col-md-12 col-sm-12 col-lg-12">
        <div class="panel panel-default">
            <header class="qna-header">
                <h2 class="qna-title">${question.title}</h2>
            </header>
            <div class="content-main">
	            <article class="article">
	                <div class="article-header">
	                    <div class="article-header-thumb">
	                        <img src="https://graph.facebook.com/v2.3/100000059371774/picture" class="article-author-thumb" alt="">
	                    </div>
	                    <div class="article-header-text">
	                        <a href="/users/92/kimmunsu" class="article-author-name">${question.writer.memberId }</a>
	                        <a href="/questions/413" class="article-header-time" title="퍼머링크">
	                            ${question.formattedCreateDate }
	                            <i class="icon-link"></i>
	                        </a>
	                    </div>
	                </div>
	                <div class="article-doc">
	                    ${question.contents }
	                </div>
	                <div class="article-util">
	                    <ul class="article-util-list">
	                        <li>
	                            <a class="link-modify-article" href="/question/${question.id }/form">수정</a>
	                        </li>
	                        <li>
	                            <form class="form-delete" action="/question/${qeustion.id }" method="POST">
	                                <input type="hidden" name="_method" value="DELETE">
	                                <button class="link-delete-article" type="submit">삭제</button>
	                            </form>
	                        </li>
	                        <li>
	                            <a class="link-modify-article" href="/index.html">목록</a>
	                        </li>
	                    </ul>
	                </div>
	            </article>
                <div class="qna-comment">
	                <div class="qna-comment-slipp">
	                    <p class="qna-comment-count"><strong>2</strong>개의 의견</p>
	                    <div class="qna-comment-slipp-articles">
	                        <c:forEach var="answer" items="${question.answers}" varStatus="vs">
	                        <article class="article" id="answer-${answer.id }">
	                            <div class="article-header">
	                                <div class="article-header-thumb">
	                                    <img src="https://graph.facebook.com/v2.3/1324855987/picture" class="article-author-thumb" alt="">
	                                </div>
	                                <div class="article-header-text">
	                                    <a href="/member/1/자바지기" class="article-author-name">${answer.writer.memberName }</a>
	                                    <a href="#answer-1434" class="article-header-time" title="퍼머링크">
	                                        ${answer.formattedCreateDate }
	                                    </a>
	                                </div>
	                            </div>
	                            <div class="article-doc comment-doc">
	                                ${answer.contents }
	                            </div>
	                            <div class="article-util">
	                                <ul class="article-util-list">
	                                    <li>
	                                        <a class="link-modify-article" href="/question/${question.id }/answers/${answer.id }/form">수정</a>
	                                    </li>
	                                    <li>
	                                        <a class="link-delete-article" href="/question/${question.id }/answers/${answer.id }/form">삭제</a>
	                                    </li>
	                                </ul>
	                            </div>
	                        </article>
	                        </c:forEach>
	                        <form class="answer-write" method="post" action="/api/question/${question.id }/answers">
						        <div class="form-group" style="padding:14px;">
						            <textarea class="form-control" placeholder="update your status" name="contents"></textarea>
						        </div>
						        <input type="submit" class="btn btn-success pull-right" value="답변하기"/>
						    </form>
	                    </div>
	                </div>
                </div>
            </div>
        </div>
    </div>
</div>
    
<script type="text/template" id="answerTemplate">
    <article class="article">
        <div class="article-header">
            <div class="article-header-thumb">
                <img src="https://graph.facebook.com/v2.3/1324855987/picture" class="article-author-thumb" alt="">
            </div>
            <div class="article-header-text">
                <a href="#" class="article-author-name">{0}</a>
                <div class="article-header-time">{1}</div>
            </div>
        </div>
        <div class="article-doc comment-doc">
            {2}
        </div>
        <div class="article-util">
        <ul class="article-util-list">
            <li>
                <a class="link-modify-article" href="/api/question/updateAnswer/{3}">수정</a>
            </li>
            <li>
                <a class="link-delete-article" href="/api/qna/deleteAnswer/{4}">삭제</a>
            </li>
        </ul>
        </div>
    </article>
</script>

<c:import url="/WEB-INF/jsp/layout/footer.jsp" charEncoding="UTF-8" />