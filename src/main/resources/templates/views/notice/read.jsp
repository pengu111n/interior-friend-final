<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/infoBoard.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/FAQ.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/QNAForm.css">
<div class="page-head">
    <div class="container">
        <div class="row">
            <div class="page-head-content">
                <h1 class="page-title">공지사항</h1>
            </div>
        </div>
    </div>
</div>
<!-- End page header -->

<div class="ArticleContentBox">
    <div class="container read__container">
        <div class="header">
            <div class="header__title">

                <span><h2><c:out value="${notice.noticeTitle}"/></h2></span>
            </div>

            <div class="header__date">
                <span><h6><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${notice.regDate}"/></h6></span>
                <span>
          	<%--        <c:if test="${noticeData.notice.writer.memNo == authUser.memno || authUser.rank == 3}">     --%>


                    <!-- 관지자 아니면 공지 수정 삭제 버튼 안뜨게 해야하는데 memberVO.rank == 3으로 하면 되려나? -->


<c:if test="${login.rank == 3}">


    <a href="/notice/remove?noticeNo=${notice.noticeNo}"
       onclick="confirm('삭제하시겠습니까?')">삭제</a>


    <a href="/notice/modify?noticeNo=${notice.noticeNo}">수정</a>

</c:if>




          	<input id="minus" type="button" value="-">
          	<input id="plus" type="button" value="+"></span>
            </div>
        </div>
        <% pageContext.setAttribute("newLine", "\n"); %>
        <div class="content">
            ${fn:replace(notice.noticeContent, newLine, "<br/>")}

            <%--${notice.noticeContent}--%>
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
        