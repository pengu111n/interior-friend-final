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


<!-- board search area -->

<%--검색은 추후에 시간 남으면 추가--%>
<div id="board-search">
    <div class="container">
        <div class="search-window">
            <%-- <form action="">--%>
            <%--    <div class="search-wrap">
                    <label for="search" class="blind">공지사항 내용 검색</label>
                    <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
                    <button type="submit" class="btn btn-dark">검색</button>
                </div>--%>

            <c:if test="${login.rank != null}">
                <button type="button" class="btn btn-dark writeform"
                        onclick="location.href = '/qna/register'">1:1 문의 하기
                </button>
            </c:if>

            </form>
        </div>
    </div>
</div>


<!-- board list area -->
<div id="board-list">
    <div class="container">
        <table class="board-table">
            <thead>
            <tr>
                <th scope="col" class="th-num">번호</th>
                <th scope="col" class="th-100">카테고리</th>
                <!--
                1. 쿼리에서 카테고리를 넣고, 폼에서 보내는식으로 하면 넘어오나?
                2. oracle에서 카테고리 만들고, vo에 넣고, mapper.xml에 추가?
                -->
                <th scope="col" class="th-title">제목</th>
                <th scope="col" class="th-100">닉네임</th>
                <th scope="col" class="th-100">등록일</th>
                <th scope="col" class="th-100">상태</th>
            </tr>
            </thead>
            <tbody>

            <%--
            <c:if test="${qnaPage.hasNoArticles()}">
                <tr>
                    <td colspan="6">게시글이 없습니다.</td>
                </tr>
            </c:if>
            --%>


            <c:forEach items="${list}" var="item">
                <c:if test="${login.nickname == item.nickname || login.rank == 3}">

                    <tr>
                        <td>${item.qnaNo}</td>
                        <td>${item.category}</td>
                        <th class="title">
                            <a href='/qna/read?qnaNo=${item.qnaNo}'>${item.qnaTitle}
                        </th>
                        <td class="nickname">
                            <c:out value="${item.nickname}"/>
                        </td>
                        <td class="date td-100">
                            <fmt:formatDate pattern="yy-MM-dd" value="${item.qnaDate}"/>
                        </td>

                        <!-- 스테이터스가 문의글이 등록 될 때 0으로 등록되고, 답변 후에 1로 변경되어야 함. -->

                        <c:if test="${item.status == 0}">

                            <td class="wating td-100">
                                <c:if test="${login.rank == 3}">
                                    <a href="answer?qnaNo=${item.qnaNo}<%--&pageNo=${qnaPage.currentPage}--%>">답변대기</a>

                                    <!-- 링크에 qnaNo=까지만 나오고 숫자가 안들어가네 ? -->

                                </c:if>

                                <!-- authUser.rank  => memberVO.rank != 3 같이 변경  -->
                                <c:if test="${login.rank != 3}">
                                    답변대기

                                </c:if>

                            </td>
                        </c:if>
                        <c:if test="${item.status == 1}">
                            <td class="complete td-100">답변완료</td>
                        </c:if>
                    </tr>
                </c:if>
            </c:forEach>


            </tbody>
        </table>
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
    </div>
</div>


<%@ include file="../include/footer.jspf" %>