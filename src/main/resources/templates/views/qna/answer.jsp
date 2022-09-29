<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <div class="container">
        <div class="header">
            <div class="header__title">

                <span><h2><c:out value="${qna.qnaTitle}"/></h2></span>
            </div>
            <div class="header__nickname"> <!-- 닉네임 필요한가 ? 답변할 때?-->
                <span><c:out value="${qna.qnaContent}"/></span>
            </div>
            <div class="header__date">
                <span><h6>${qna.qnaDate}</h6></span>
                <span>
          	<input id="minus" type="button" value="-">
          	<input id="plus" type="button" value="+">
          	</span>
            </div>
        </div>

        <!-- 폼 롤로 바꾸고 -->
        <form role="form" method="post">
            <%-- 임시 주석
              <input type="hidden" name="no" value="${ansQNAReq.qnaNo}">  --%>
            <div class="content">
                <hr>
                <%--  <span>#${ansQNAReq.category}</span>  --%>
                <textarea class="answer__Textarea"
                          name="answerContent">안녕하세요 ${qna.nickName}님 당신의 인테리어에 대한 고민을 보다 쉽게! 인테리어 프렌드 인프! 입니다.</textarea>
            </div>
            <div class="center">
                <button class="navbar-btn nav-button wow fadeInRight" data-wow-delay="0.48s" type="submit">
                    제출
                </button>
            </div>
        </form>
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
        }
    }

    function onPlusClick() {
        if (fontsize < 50) {
            fontsize += 2;
            document.querySelector(".content").style.fontSize = fontsize + "px";
        }
    }

    minus.addEventListener("click", onMinusClick);
    plus.addEventListener("click", onPlusClick);


</script>

<%@ include file="../include/footer.jspf" %>        