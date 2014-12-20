<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div id="pageContainer">
    <div id="ns-evidenceDetail">
        <div class ="evidence-wrapper">
            <div class="title">${article.title}</div>
            <div class="userId">글쓴이 ${article.userId}</div>
            <div class="date">${article.date}</div>
            <div class="line"></div>
            <div class="content">${article.content}</div>
        </div>
        <a class="show-list">목록보기</a>
        <form class="comment-input">
            <input class="comment-box" type="text">
            <input class="comment-submit" type="submit" value="댓글 등록">
        </form>
        <ul class="comment-list">
            
            <li class="show-comment">
                <span class="member">아이디</span>
                <span class="comment">안녕하십니다. 참 재미있네요</span>
            </li>
            <div class="line"></div>

        </ul>

    </div>
</div>
