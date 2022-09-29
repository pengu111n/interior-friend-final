<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jspf" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>

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


<!-- board search area -->
<%--
<div id="board-search">
    <div class="container">
        <div class="search-window">
            <form action="">
                <div class="search-wrap">
                    <label for="search" class="blind">공지사항 내용 검색</label> <input
                        id="search" type="search" name="" placeholder="검색어를 입력해주세요."
                        value="">
                    <button type="submit" class="btn btn-dark">검색</button>
                </div>
            </form>
        </div>
    </div>
</div>
--%>

<!-- board list area -->
<div id="board-list">
    <div class="container">
        <table class="board-table">
            <thead>
            <tr>
                <th scope="col" class="th-num">번호</th>
                <th scope="col" class="th-title">제목</th>
                <th scope="col" class="th-date">등록일</th>


                <!-- 관지자 아니면 공지 작성 버튼 안뜨게 해야하는데 memberVO.rank == 3으로 하면 되려나? -->
                <c:if test="${login.rank == 3}">
                    <div class="collapse navbar-collapse yamm" id="navigation">
                        <div class="button navbar-right">
                            <a href="/notice/register"
                               class="navbar-btn nav-button wow fadeInRight"
                               data-wow-delay="0.48s">공지사항 작성</a>
                        </div>
                    </div>
                </c:if>


            </tr>
            </thead>


            <tbody>


            <c:forEach items="${list}" var="item">

                <tr>

                    <td>${item.noticeNo}</td>

                    <td><a href='/notice/read?noticeNo=${item.noticeNo}'>${item.noticeTitle}</td>

                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.regDate}"></fmt:formatDate></td>

                </tr>
            </c:forEach>


            </tbody>


        </table>
    </div>
</div>

<!-- /.box-body -->


<div class="text-center">
    <div class="pagination">
        <ul>

            <c:if test="${pageMaker.prev}">
                <li><a href="list${pageMaker.makeQuery(pageMaker.startPage - 1) }">&laquo;</a></li>
            </c:if>

            <c:forEach begin="${pageMaker.startPage }"
                       end="${pageMaker.endPage }" var="idx">
                <li
                        <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
                    <a href="list${pageMaker.makeQuery(idx)}">${idx}</a>
                </li>
            </c:forEach>

            <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                <li><a href="list${pageMaker.makeQuery(pageMaker.endPage +1) }">&raquo;</a></li>
            </c:if>

        </ul>
    </div>

</div>


<%@ include file="../include/footer.jspf" %>
