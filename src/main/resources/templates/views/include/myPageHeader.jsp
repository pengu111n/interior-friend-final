<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="page-head">
    <div class="container">
        <div class="row">
            <div class="page-head-content">
                <h1 class="page-title">마이페이지</h1>
            </div>
        </div>
    </div>
</div>
<!-- End page header -->


<nav class="navbar navbar-default">
    <div class="container">
        <ul class="main-nav nav navbar-nav" style="text-align: center;">
            <li class="wow fadeInDown animated" data-wow-delay="0.2s"
                style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInDown; display: inline-block;">
                <a href="../member/get?memNo=${login.memNo}">회원정보 관리</a></li>
            <li class="wow fadeInDown animated" data-wow-delay="0.2s"
                style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInDown; display: inline-block;">
                <a  href="../board/list?memNo=${login.memNo}">작성글 관리</a></li>
            <%--
            <li class="wow fadeInDown animated" data-wow-delay="0.2s"
                style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInDown; display: inline-block;">
                <a href="">나의 문의</a></li>
            <li class="wow fadeInDown animated" data-wow-delay="0.2s"
                style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInDown; display: inline-block;">
                <a href="">찜한 기업</a></li>
            --%>
        </ul>
    </div>
</nav>