<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@include file="../include/header.jspf" %>

<link rel="stylesheet" href="../../../resources/Board/css/readPage.css">
<script src="../../../resources/Board/js/readPage.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script src="../../../resources/Board/js/upload.js"></script>

<link rel="stylesheet" href="../../../resources/assets/css/normalize.css">
<link rel="stylesheet" href="../../../resources/assets/css/font-awesome.min.css">
<link rel="stylesheet" href="../../../resources/assets/css/fontello.css">
<link href="../../../resources/assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
<link href="../../../resources/assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
<link href="../../../resources/assets/css/animate.css" rel="stylesheet" media="screen">
<link rel="stylesheet" href="../../../resources/assets/css/bootstrap-select.min.css">
<link rel="stylesheet" href="../../../resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../../../resources/assets/css/icheck.min_all.css">
<link rel="stylesheet" href="../../../resources/assets/css/price-range.css">
<link rel="stylesheet" href="../../../resources/assets/css/owl.carousel.css">
<link rel="stylesheet" href="../../../resources/assets/css/owl.theme.css">
<link rel="stylesheet" href="../../../resources/assets/css/owl.transitions.css">
<link rel="stylesheet" href="../../../resources/assets/css/lightslider.min.css">
<link rel="stylesheet" href="../../../resources/assets/css/style.css">
<link rel="stylesheet" href="../../../resources/assets/css/responsive.css">


<%
    // 줄바꿈
    pageContext.setAttribute("br", "<br/>");
    pageContext.setAttribute("cn", "\n");
%>

<style type="text/css">
    .popup {
        position: absolute;
    }

    .back {
        background-color: gray;
        opacity: 0.5;
        width: 100%;
        height: 300%;
        overflow: hidden;
        z-index: 1101;
    }

    .front {
        z-index: 1110;
        opacity: 1;
        boarder: 1px;
        margin: auto;
    }

    .show {
        position: relative;
        max-width: 1200px;
        max-height: 800px;
        overflow: auto;
    }

    .popup {
        position: absolute;
    }

    .back {
        background-color: gray;
        opacity: 0.5;
        width: 100%;
        height: 300%;
        overflow: hidden;
        z-index: 1101;
    }

    .front {
        z-index: 1110;
        opacity: 1;
        boarder: 1px;
        margin: auto;
    }

    .show {
        position: relative;
        max-width: 1200px;
        max-height: 800px;
        overflow: auto;
    }
</style>
<
<div class="page-head">
    <div class="container">
        <div class="row">
            <div class="page-head-content">
                <h1 class="page-title">인테리어 견적 </h1>
            </div>
        </div>
    </div>
</div>
<div class="content-area single-property" style="background-color: #FCFCFC;">&nbsp;
    <div class="container">
        <form role="form" action="modifyPage" method="post">

            <input type='hidden' name='boardNo' value="${boardVO.boardNo}">
            <input type='hidden' name='page' value="${cri.page}">
            <input type='hidden' name='perPageNum' value="${cri.perPageNum}">

        </form>
        <div class="clearfix padding-top-40">

            <div class="col-md-8 single-property-content prp-style-1 ">
                <%--                <div class="row">--%>
                <%--                    <div class="light-slide-item">--%>
                <%--                        <div class="clearfix">--%>
                <%--                            <div class="favorite-and-print">--%>
                <%--                                <a class="add-to-fav" href="#login-modal" data-toggle="modal">--%>
                <%--                                    <i class="fa fa-star-o"></i>--%>
                <%--                                </a>--%>
                <%--                                <a class="printer-icon " href="javascript:window.print()">--%>
                <%--                                    <i class="fa fa-print"></i>--%>
                <%--                                </a>--%>
                <%--                            </div>--%>

                <%--                            <ul id="image-gallery" class="gallery list-unstyled cS-hidden">--%>
                <%--                                <li data-thumb="../../../resources/assets/img/property-1/property1.jpg">--%>
                <%--                                    <img src="../../../resources/assets/img/property-1/property1.jpg" alt="property1"/>--%>
                <%--                                </li>--%>
                <%--                                <li data-thumb="../../../resources/assets/img/property-1/property2.jpg">--%>
                <%--                                    <img src="../../../resources/assets/img/property-1/property3.jpg" alt="property2"/>--%>
                <%--                                </li>--%>
                <%--                                <li data-thumb="../../../resources/assets/img/property-1/property3.jpg">--%>
                <%--                                    <img src="../../../resources/assets/img/property-1/property3.jpg" alt="property1"/>--%>
                <%--                                </li>--%>
                <%--                                <li data-thumb="../../../resources/assets/img/property-1/property4.jpg">--%>
                <%--                                    <img src="../../../resources/assets/img/property-1/property4.jpg"/>--%>
                <%--                                </li>--%>
                <%--                            </ul>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>

                <div class="single-property-wrapper">
                    <div class="single-property-header">
                        <h1 class="property-title pull-left">${boardVO.title}</h1>
                        <c:choose>
                            <c:when test="${boardVO.budget eq '-1'}">
                                <span class="property-price pull-right">업체 협의</span>
                            </c:when>
                            <c:otherwise>
                                <span class="property-price pull-right">${boardVO.budget} 만원</span>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="property-meta entry-meta clearfix ">

                        <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-tag">
                                        <img src="../../../resources/assets/img/icon/sale-orange.png">
                                    </span>
                            <span class="property-info-entry">
                                        <span class="property-info-label">Status</span>
                                        <span class="property-info-value">견적 대기 중</span>
                                    </span>
                        </div>

                        <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info icon-area">
                                        <img src="../../../resources/assets/img/icon/room-orange.png">
                                    </span>
                            <span class="property-info-entry">
                                        <span class="property-info-label">Area</span>
                                        <span class="property-info-value">${boardVO.area} 평</span>
                                    </span>
                        </div>

                        <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-bed">
                                        <img src="../../../resources/assets/img/icon/bed-orange.png">
                                    </span>
                            <span class="property-info-entry">
                                        <span class="property-info-label">Bedrooms</span>
                                        <span class="property-info-value">3</span>
                                    </span>
                        </div>

                        <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-bed">
                                        <img src="../../../resources/assets/img/icon/cars-orange.png">
                                    </span>
                            <span class="property-info-entry">
                                        <span class="property-info-label">Car garages</span>
                                        <span class="property-info-value">1</span>
                                    </span>
                        </div>

                        <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-bath">
                                        <img src="../../../resources/assets/img/icon/os-orange.png">
                                    </span>
                            <span class="property-info-entry">
                                        <span class="property-info-label">Bathrooms</span>
                                        <span class="property-info-value">3.5</span>
                                    </span>
                        </div>

                        <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-garage">
                                        <img src="../../../resources/assets/img/icon/room-orange.png">
                                    </span>
                            <span class="property-info-entry">
                                        <span class="property-info-label">Garages</span>
                                        <span class="property-info-value">2</span>
                                    </span>
                        </div>

                        <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-garage">
                                        <img src="../../../resources/assets/img/icon/shawer-orange.png">
                                    </span>
                            <span class="property-info-entry">
                                        <span class="property-info-label">Garages</span>
                                        <span class="property-info-value">2</span>
                                    </span>
                        </div>


                    </div>
                    <!-- .property-meta -->


                    <!-- End description area  -->

                    <div class="section additional-details">

                        <h4 class="s-property-title">견적 상세정보 </h4>

                        <ul class="additional-details-list clearfix">
                            <li>
                                <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">게시글 번호</span>
                                <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${boardVO.boardNo} 번</span>
                            </li>
                            <li>
                                <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">시공 분야</span>
                                <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${boardVO.category}</span>
                            </li>

                            <li>
                                <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">주거 유형</span>
                                <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${boardVO.part}</span>
                            </li>
                            <li>
                                <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">주소</span>
                                <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${boardVO.address}</span>
                            </li>

                            <li>
                                <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">면적</span>
                                <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${boardVO.area}평</span>
                            </li>

                            <li>
                                <fmt:parseDate var='startDate' pattern="yyyy-MM-dd"
                                               value="${boardVO.startDate}" scope="page"/>
                                <c:choose>
                                    <c:when test="${startDate eq 'Sat Jan 01 00:00:00 KST 1'}">
                                        <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">시공 시작일</span>
                                        <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">시작일 협의</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">시공 시작일</span>
                                        <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"><fmt:formatDate
                                                value="${startDate}"
                                                pattern="yyyy년 MM월 dd일"/></span>
                                    </c:otherwise>
                                </c:choose>
                            </li>

                            <li>
                                <fmt:parseDate var='endDate' pattern="yyyy-MM-dd"
                                               value="${boardVO.endDate}" scope="page"/>
                                <c:choose>
                                    <c:when test="${endDate eq 'Sat Jan 01 00:00:00 KST 1'}">
                                        <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">시공 마감일</span>
                                        <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">마감일 협의</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">시공 마감일</span>
                                        <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> <fmt:formatDate
                                                value="${endDate}"
                                                pattern="yyyy년 MM월 dd일"/></span>
                                    </c:otherwise>
                                </c:choose>
                            </li>
                            <li>
                                <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">조회수</span>
                                <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${boardVO.view_count}</span>
                            </li>
                        </ul>
                    </div>

                    <!-- End additional-details area  -->
                    <div class="section">
                        <h4 class="s-property-title">상세 요청사항</h4>
                        <div class="s-property-content">
                            <p>${boardVO.require} </p>
                        </div>
                    </div>

                    <div class="section property-features">

                        <h4 class="s-property-title">특이 사항</h4>
                        <ul>
                            <li><a href="properties.html">2017년 신축 건물</a></li>
                            <li><a href="properties.html">전세 임대</a></li>
                            <li><a href="properties.html">대학가</a></li>
                            <li><a href="properties.html">주차공간 협소</a></li>
                            <li><a href="properties.html">층고 낮음</a></li>
                            <li><a href="properties.html">앨리베이터 사용가능</a></li>
                        </ul>

                    </div>
                    <!-- End features area  -->

                    <div class="section property-video">
                        <h4 class="s-property-title">참고 자료</h4>
                        <div class="video-thumb">
                            <%--                                <img src="../../../resources/assets/img/property-video.jpg" class="img-responsive wp-post-image" alt="Exterior">--%>
                            <ul class="mailbox-attachments clearfix uploadedList"
                                style=" list-style: none; padding-left: 0px;"></ul>
                            <div class='popup back' style="display:none; width: 600px; height: 480px;"></div>
                            <%--                                <div id="popup_front" class='popup front' style="display:none;">--%>
                            <div id="popup_front" class='popup front'>
                                <img id="popup_img">
                            </div>
                        </div>
                    </div>
                    <!-- End video area  -->

                    <c:if test="${not empty login}">
                        <section id="comment-form" class="add-comments" style="padding-left: 0px; list-style: none; ">
                            <h4 class="s-property-title">댓글 </h4>
                            <h4 class="text-uppercase wow fadeInLeft animated">Leave comment</h4>
                            <form>
                                <div class="row wow fadeInLeft animated">
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label for="comment">Comment <span class="required">*</span>
                                            </label>
                                            <textarea class="form-control" id="comment" rows="4"></textarea>
                                            <input class="form-control" type="text" placeholder="USER ID"
                                                   id="newReplyWriter" value="${login.nickName}" style= "display: none;">

                                        </div>
                                    </div>
                                </div>

                                <div class="row wow fadeInLeft animated">
                                    <div class="col-sm-12 text-right">
                                        <button type="button" class="btn" id="replyAddBtn"
                                                style=" color: #FFF; background-color: #FDC600; border-color: #FDC600;
                                             border-radius: 1px; padding: 10px 20px; font-weight: 600;">
                                            <i class="fa fa-comment-o"></i> Post comment
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </section>
                    </c:if>
                    <c:if test="${empty login}">
                    <section id="comment-form" class="add-comments" style="padding-left: 0px; list-style: none; ">
                        <h4 class="s-property-title">댓글 </h4>
                        <h4 class="text-uppercase wow fadeInLeft animated" style="padding-bottom: 50px;">로그인 후 댓글을 작성하실
                            수 있습니다.</h4>
                        </c:if>

                        <ul style="padding-left: 0px; list-style: none;">
                            <li class="time-label" id="repliesDiv">
                                <h4 class="text-uppercase wow fadeInLeft animated">Comments</h4>
                            </li>
                        </ul>


                        <div class="section property-share">
                            <h4 class="s-property-title">공유 </h4>
                            <div class="roperty-social">
                                <ul>
                                    <li><a title="Share this on dribbble " href="#"><img
                                            src="../../../resources/assets/img/social_big/dribbble_grey.png"></a></li>
                                    <li><a title="Share this on facebok " href="#"><img
                                            src="../../../resources/assets/img/social_big/facebook_grey.png"></a></li>
                                    <li><a title="Share this on delicious " href="#"><img
                                            src="../../../resources/assets/img/social_big/delicious_grey.png"></a></li>
                                    <li><a title="Share this on tumblr " href="#"><img
                                            src="../../../resources/assets/img/social_big/tumblr_grey.png"></a></li>
                                    <li><a title="Share this on digg " href="#"><img
                                            src="../../../resources/assets/img/social_big/digg_grey.png"></a></li>
                                    <li><a title="Share this on twitter " href="#"><img
                                            src="../../../resources/assets/img/social_big/twitter_grey.png"></a></li>
                                    <li><a title="Share this on linkedin " href="#"><img
                                            src="../../../resources/assets/img/social_big/linkedin_grey.png"></a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="box-footer">

                            <c:if test="${login.nickName == boardVO.nickName}">
                                <button type="submit" class="btn btn-warning">Modify</button>
                                <button type="submit" class="btn btn-danger">REMOVE</button>
                            </c:if>
                            <button type="submit" class="btn btn-primary">LIST ALL</button>
                        </div>

                </div>
            </div>


            <div class="col-md-4 p0">
                <aside class="sidebar sidebar-property blog-asside-right">
                    <div class="dealer-widget">
                        <div class="dealer-content">
                            <div class="inner-wrapper">

                                <div class="clear">
                                    <div class="col-xs-4 col-sm-4 dealer-face">
                                        <a href="">
                                            <img src="../../../resources/assets/img/client-face1.png"
                                                 class="img-circle">
                                        </a>
                                    </div>
                                    <div class="col-xs-8 col-sm-8 ">
                                        <h3 class="dealer-name">
                                            <span>${boardVO.nickName}</span>
                                        </h3>
                                        <div class="dealer-social-media">
                                            <a class="twitter" target="_blank" href="">
                                                <i class="fa fa-twitter"></i>
                                            </a>
                                            <a class="facebook" target="_blank" href="">
                                                <i class="fa fa-facebook"></i>
                                            </a>
                                            <a class="gplus" target="_blank" href="">
                                                <i class="fa fa-google-plus"></i>
                                            </a>
                                            <a class="linkedin" target="_blank" href="">
                                                <i class="fa fa-linkedin"></i>
                                            </a>
                                            <a class="instagram" target="_blank" href="">
                                                <i class="fa fa-instagram"></i>
                                            </a>
                                        </div>

                                    </div>
                                </div>

                                <div class="clear">
                                    <ul class="dealer-contacts">
                                        <li><i class="pe-7s-map-marker strong"> </i> 서울특별시 강남구 테헤란로14길</li>
                                        <li><i class="pe-7s-mail strong"> </i>interiorfriend@gmail.com</li>
                                        <li><i class="pe-7s-call strong"> </i> 1577 - 1010</li>
                                    </ul>
                                    <p>안녕하세요 항상 최고의 서비스를 제공하겠습니다.</p>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default sidebar-menu similar-property-wdg wow fadeInRight animated">
                        <div class="panel-heading">
                            <h3 class="panel-title">추천 인테리어 신청목록</h3>
                        </div>
                        <div class="panel-body recent-property-widget">
                            <ul>
                                <li>
                                    <div class="col-md-3 col-sm-3 col-xs-3 blg-thumb p0">
                                        <a href="single.html"><img
                                                src="../../../resources/assets/img/demo/small-property-2.jpg"></a>
                                        <span class="property-seeker">
                                                    <b class="b-1">A</b>
                                                    <b class="b-2">S</b>
                                                </span>
                                    </div>
                                    <div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
                                        <h6><a href="single.html">신축 아파트 리모델링 </a></h6>
                                        <span class="property-price">7000 만원</span>
                                    </div>
                                </li>
                                <li>
                                    <div class="col-md-3 col-sm-3  col-xs-3 blg-thumb p0">
                                        <a href="single.html"><img
                                                src="../../../resources/assets/img/demo/small-property-1.jpg"></a>
                                        <span class="property-seeker">
                                                    <b class="b-1">A</b>
                                                    <b class="b-2">S</b>
                                                </span>
                                    </div>
                                    <div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
                                        <h6><a href="single.html">대학가 원룸 도배</a></h6>
                                        <span class="property-price">100 만원</span>
                                    </div>
                                </li>
                                <li>
                                    <div class="col-md-3 col-sm-3 col-xs-3 blg-thumb p0">
                                        <a href="single.html"><img
                                                src="../../../resources/assets/img/demo/small-property-3.jpg"></a>
                                        <span class="property-seeker">
                                                    <b class="b-1">A</b>
                                                    <b class="b-2">S</b>
                                                </span>
                                    </div>
                                    <div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
                                        <h6><a href="single.html">화장실 내부 수리</a></h6>
                                        <span class="property-price">500 만원</span>
                                    </div>
                                </li>

                                <li>
                                    <div class="col-md-3 col-sm-3 col-xs-3 blg-thumb p0">
                                        <a href="single.html"><img
                                                src="../../../resources/assets/img/demo/small-property-2.jpg"></a>
                                        <span class="property-seeker">
                                                    <b class="b-1">A</b>
                                                    <b class="b-2">S</b>
                                                </span>
                                    </div>
                                    <div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
                                        <h6><a href="single.html">복층 카페 인테리어 </a></h6>
                                        <span class="property-price">2500 만원</span>
                                    </div>
                                </li>

                            </ul>
                        </div>
                    </div>

                    <div class="panel panel-default sidebar-menu wow fadeInRight animated">
                        <div class="panel-heading">
                            <h3 class="panel-title">Smart search</h3>
                        </div>
                        <div class="panel-body search-widget">
                            <form action="" class=" form-inline">
                                <fieldset>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <input type="text" class="form-control" placeholder="Key word">
                                        </div>
                                    </div>
                                </fieldset>

                                <fieldset>
                                    <div class="row">
                                        <div class="col-xs-6">

                                            <select id="lunchBegins" class="selectpicker" data-live-search="true"
                                                    data-live-search-style="begins" title="Select Your City">

                                                <option>New york, CA</option>
                                                <option>Paris</option>
                                                <option>Casablanca</option>
                                                <option>Tokyo</option>
                                                <option>Marraekch</option>
                                                <option>kyoto , shibua</option>
                                            </select>
                                        </div>
                                        <div class="col-xs-6">

                                            <select id="basic" class="selectpicker show-tick form-control">
                                                <option> -Status-</option>
                                                <option>Rent</option>
                                                <option>Boy</option>
                                                <option>used</option>

                                            </select>
                                        </div>
                                    </div>
                                </fieldset>

                                <fieldset class="padding-5">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <label for="price-range">Price range ($):</label>
                                            <input type="text" class="span2" value="" data-slider-min="0"
                                                   data-slider-max="600" data-slider-step="5"
                                                   data-slider-value="[0,450]" id="price-range"><br/>
                                            <b class="pull-left color">2000$</b>
                                            <b class="pull-right color">100000$</b>
                                        </div>
                                        <div class="col-xs-6">
                                            <label for="property-geo">Property geo (m2) :</label>
                                            <input type="text" class="span2" value="" data-slider-min="0"
                                                   data-slider-max="600" data-slider-step="5"
                                                   data-slider-value="[50,450]" id="property-geo"><br/>
                                            <b class="pull-left color">40m</b>
                                            <b class="pull-right color">12000m</b>
                                        </div>
                                    </div>
                                </fieldset>

                                <fieldset class="padding-5">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <label for="price-range">Min baths :</label>
                                            <input type="text" class="span2" value="" data-slider-min="0"
                                                   data-slider-max="600" data-slider-step="5"
                                                   data-slider-value="[250,450]" id="min-baths"><br/>
                                            <b class="pull-left color">1</b>
                                            <b class="pull-right color">120</b>
                                        </div>

                                        <div class="col-xs-6">
                                            <label for="property-geo">Min bed :</label>
                                            <input type="text" class="span2" value="" data-slider-min="0"
                                                   data-slider-max="600" data-slider-step="5"
                                                   data-slider-value="[250,450]" id="min-bed"><br/>
                                            <b class="pull-left color">1</b>
                                            <b class="pull-right color">120</b>

                                        </div>
                                    </div>
                                </fieldset>

                                <fieldset class="padding-5">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <div class="checkbox">
                                                <label> <input type="checkbox" checked> Fire Place</label>
                                            </div>
                                        </div>

                                        <div class="col-xs-6">
                                            <div class="checkbox">
                                                <label> <input type="checkbox"> Dual Sinks</label>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>

                                <fieldset class="padding-5">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <div class="checkbox">
                                                <label> <input type="checkbox" checked> Swimming Pool</label>
                                            </div>
                                        </div>
                                        <div class="col-xs-6">
                                            <div class="checkbox">
                                                <label> <input type="checkbox" checked> 2 Stories </label>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>

                                <fieldset class="padding-5">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <div class="checkbox">
                                                <label><input type="checkbox"> Laundry Room </label>
                                            </div>
                                        </div>
                                        <div class="col-xs-6">
                                            <div class="checkbox">
                                                <label> <input type="checkbox"> Emergency Exit</label>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>

                                <fieldset class="padding-5">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <div class="checkbox">
                                                <label> <input type="checkbox" checked> Jog Path </label>
                                            </div>
                                        </div>
                                        <div class="col-xs-6">
                                            <div class="checkbox">
                                                <label> <input type="checkbox"> 26' Ceilings </label>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>

                                <fieldset class="padding-5">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="checkbox">
                                                <label> <input type="checkbox"> Hurricane Shutters </label>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>

                                <fieldset>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <input class="button btn largesearch-btn" value="검색" type="submit">
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>

                </aside>
            </div>
        </div>

    </div>
</div>

<!-- /.content -->


<!--////////////////////////////reply///////////////////////////////-->
<script id="template" type="text/x-handlebars-template">
    {{#each .}}
    <li class="replyLi" data-replyNo={{replyNo}}>
        <div class="row comment">
            <div class="col-sm-9 col-md-10">
                <h5 class="text-uppercase"> - {{nickName}}</h5>
                <p class="posted"><i class="fa fa-clock-o"></i> {{prettifyDate regDate}}</p>
                <p>{{replyContent}}</p>
            </div>
        </div>
    </li>
    {{/each}}
</script>

<script>
    Handlebars.registerHelper("prettifyDate", function (timeValue) {
        var dateObj = new Date(timeValue);
        var year = dateObj.getFullYear();
        var month = dateObj.getMonth() + 1;
        var date = dateObj.getDate();
        return year + "년 " + month + "월 " + date + "일    ";
    });

    var printData = function (replyArr, target, templateObject) {

        var template = Handlebars.compile(templateObject.html());

        var html = template(replyArr);
        $(".replyLi").remove();
        target.after(html);

    }

    var boardNo = ${boardVO.boardNo};

    var replyPage = 1;

    function getPage(pageInfo) {

        $.getJSON(pageInfo, function (data) {
            printData(data.list, $("#repliesDiv"), $('#template'));
            printPaging(data.pageMaker, $(".pagination"));

            $("#modifyModal").modal('hide');

        });
    }

    var printPaging = function (pageMaker, target) {

        var str = "";

        if (pageMaker.prev) {
            str += "<li><a href='" + (pageMaker.startPage - 1)
                + "'> << </a></li>";
        }

        for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
            var strClass = pageMaker.cri.page == i ? 'class=active' : '';
            str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
        }

        if (pageMaker.next) {
            str += "<li><a href='" + (pageMaker.endPage + 1)
                + "'> >> </a></li>";
        }

        target.html(str);
    };

    $("#repliesDiv").on("click", function () {

        if ($(".timeline li").size() > 1) {
            return;
        }
        getPage("/replies/" + boardNo + "/1");

    });

    $(document).ready(
        function () {
            if ($(".timeline li").size() > 1) {
                return;
            }
            getPage("/replies/" + boardNo + "/1");
        }
    )


    $(".pagination").on("click", "li a", function (event) {

        event.preventDefault();

        replyPage = $(this).attr("href");

        getPage("/replies/" + boardNo + "/" + replyPage);

    });

    $("#replyAddBtn").on("click", function () {

        var replyerObj = $("#newReplyWriter");
        var replytextObj = $("#comment");
        var nickName = replyerObj.val();
        var replyContent = replytextObj.val();
        $.ajax({
            type: 'post',
            url: '/replies/',
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "POST"
            },
            dataType: 'text',
            data: JSON.stringify({boardNo: boardNo, nickName: nickName, replyContent: replyContent}),
            success: function (result) {
                console.log("result: " + result);
                if (result == 'SUCCESS') {
                    alert("등록 되었습니다.");
                    replyPage = 1;
                    getPage("/replies/" + boardNo + "/" + replyPage);
                    replyerObj.val("");
                    replytextObj.val("");
                }
            }
        });
    });
</script>

<!--////////////////////////////modify,delete///////////////////////////////-->

<script>
    $(document).ready(function () {

        var formObj = $("form[role='form']");

        console.log(formObj);

        $("#modifyBtn").on("click", function () {
            formObj.attr("action", "/board/modifyPage");
            formObj.attr("method", "get");
            formObj.submit();
        });

        $("#removeBtn").on("click", function () {
            formObj.attr("action", "/board/removePage");
            formObj.submit();
        });

        $("#goListBtn ").on("click", function () {
            formObj.attr("method", "get");
            formObj.attr("action", "/board/list");
            formObj.submit();
        });

    });
</script>


<script id="templateAttach" type="text/x-handlebars-template">
    <li data-src='{{fullName}}'>
        <span class="mailbox-attachment-icon has-img"><img src="{{getLink}}"
                                                           onerror="this.onerror=null; this.src='../../../resources/assets/img/icon/document.png';"></span>
        <div class="mailbox-attachment-info">
            <a href="{{getLink}}" class="mailbox-attachment-name" download>{{fileName}}</a>
            </span>
        </div>
    </li>
</script>


<script>
    $(document).ready(function () {

        var formObj = $("form[role='form']");

        console.log(formObj);

        $("#modifyBtn").on("click", function () {
            formObj.attr("action", "/board/modifyPage");
            formObj.attr("method", "get");
            formObj.submit();
        });

        /* 	$("#removeBtn").on("click", function(){
                formObj.attr("action", "/sboard/removePage");
                formObj.submit();
            }); */


        $("#removeBtn").on("click", function () {

            var replyCnt = $("#replycntSmall").html();

            if (replyCnt > 0) {
                alert("댓글이 달린 게시물을 삭제할 수 없습니다.");
                return;
            }

            var arr = [];
            $(".uploadedList li").each(function (index) {
                arr.push($(this).attr("data-src"));
            });

            if (arr.length > 0) {
                $.post("/deleteAllFiles", {files: arr}, function () {

                });
            }

            formObj.attr("action", "/board/removePage");
            formObj.submit();
        });

        $("#goListBtn ").on("click", function () {
            formObj.attr("method", "get");
            formObj.attr("action", "/board/list");
            formObj.submit();
        });

        var boardNo = ${boardVO.boardNo};
        var template = Handlebars.compile($("#templateAttach").html());

        $.getJSON("/board/getAttach/" + boardNo, function (list) {
            $(list).each(function () {

                var fileInfo = getFileInfo(this);
                var html = template(fileInfo);
                $(".uploadedList").append(html);

            });
        });


        $("#popup_img").on("click", function () {

            $(".popup").hide('slow');

        });


    });
</script>


<%@include file="../include/footer.jspf" %>