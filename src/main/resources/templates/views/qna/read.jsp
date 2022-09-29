<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %> 

이게 무슨 태그지 ? 

--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/infoBoard.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/FAQ.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/QNAForm.css">
<div class="page-head">
    <div class="container">
        <div class="row">
            <div class="page-head-content">
                <h1 class="page-title">1:1문의</h1>
            </div>
        </div>
    </div>
</div>
<!-- End page header -->


<div class="ArticleContentBox">
    <div class="container read__container">
        <div class="header">
            <div class="header__title">

                <!-- 추가 -->
                <c:if test="${login.nickName == QNAVO.nickName || login.rank == 3}">

                <td>${QNAVO.qnaTitle}</td>
                <span>처리상태
    <c:if test="${QNAVO.status == 0}">
        <span>답변 대기</span>
    </c:if>
    <c:if test="${QNAVO.status == 1}">
        <span class="status"><strong>답변 완료</strong></span>
    </c:if>

    </span>
            </div>
            <div class="header__nickname">
                <span>${QNAVO.nickName}</span>
            </div>
            <div class="header__date">
                <span><h6><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${QNAVO.qnaDate}"/></h6></span>
                <span>

    <c:if test="${login.rank == 3}">
        <a href="/qna/remove?qnaNo=${QNAVO.qnaNo}" onclick="confirm('삭제하시겠습니까?')">삭제</a>
        <a href="/qna/modify?qnaNo=${QNAVO.qnaNo}">수정</a>
    </c:if>

    <input id="minus" type="button" value="-">
    <input id="plus" type="button" value="+">
    </span>
            </div>
        </div>
        <div class="content">
            <div>

                <pre>${QNAVO.qnaContent}</pre>

            </div>

            <!-- 답변 등록되는 곳-->


            <c:if test="${QNAVO.answerContent != null}">
                <hr>
                <div class="answerContent">
                    <span class="answerContent__title">${QNAVO.category}</span>
                    <span class="answerContent__Content"><br><pre>${QNAVO.answerContent}</pre></span>
                </div>
            </c:if>


        </div>
        <c class=center>
            </c:if>


            <button onclick="location.href='/qna/list'" class="navbar-btn nav-button wow fadeInRight"
                    data-wow-delay="0.48s" type="submit">
                목록으로
            </button>
    </div>
</div>
</div>


<script>
    const minus = document.getElementById("minus");
    const plus = document.getElementById("plus");


    let fontsize = 16;


    function onMinusClick() {
        if (fontsize > 4) {
            fontsize -= 2;
            document.querySelector(".content").style.fontSize = fontsize + "px";
            document.querySelector("pre").style.fontSize = fontsize + "px";
        }
    }

    function onPlusClick() {
        if (fontsize < 50) {
            fontsize += 2;
            document.querySelector(".content").style.fontSize = fontsize + "px";
            document.querySelector("pre").style.fontSize = fontsize + "px";
        }
    }

    minus.addEventListener("click", onMinusClick);
    plus.addEventListener("click", onPlusClick);


    function deleteConfirm() {
        var confirmDelete = confirm("삭제하시겠습니까?");
        if (confirmDelete) {
            location.href = "/qna/remove?qnaNo=${QNAVO.qnaNo}";
        } else {
            return false;
        }
    }

    function modifyConfirm() {

        location.href = "/qna/modify?qnaNo=${QNAVO.qnaNo}";

    }


</script>


<!-- -->


<%@ include file="../include/footer.jspf" %>
        