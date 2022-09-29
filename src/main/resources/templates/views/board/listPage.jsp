<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="../include/header.jspf" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script src="../../../resources/Board/js/upload.js"></script>
<style>
    .margin-space {
        margin-top: 40px;
        margin-left: 15px;
        margin-bottom: 40px;
    }

    .text-center {
        text-align: center;
    }

    .btn-primary {
        color: #fff;
        background-color: #fdc600;
        border-color: #fdc600;
        border-radius: 1px;
        padding: 10px 20px;
        font-weight: 600;
    }
</style>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="page-head">
        <div class="container">
            <div class="row">
                <div class="page-head-content">
                    <h1 class="page-title">인테리어 견적 신청 목록</h1>
                </div>
            </div>
        </div>
    </div>


    <!-- Main content -->
    <section class="content">

        <!-- Default box -->
        <div class="properties-area recent-property" style="background-color: #FFF;">
            <div class="container">
                <div class="row">

                    <div class="col-md-3 p0 padding-top-40">
                        <div class="blog-asside-right pr0">
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

                                                    <select id="lunchBegins" class="selectpicker"
                                                            data-live-search="true" data-live-search-style="begins"
                                                            title="-지역-">

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
                                                        <option> -상태-</option>
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
                                                    <label for="price-range">가격 범위 설정</label>
                                                    <input type="text" class="span2" value="" data-slider-min="0"
                                                           data-slider-max="600" data-slider-step="5"
                                                           data-slider-value="[0,450]" id="price-range"><br/>
                                                    <b class="pull-left color">2000$</b>
                                                    <b class="pull-right color">100000$</b>
                                                </div>
                                                <div class="col-xs-6">
                                                    <label for="property-geo">시공 면적 설정</label>
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
                                                    <input class="button btn largesearch-btn" value="Search"
                                                           type="submit">
                                                </div>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>
                            </div>

                            <div class="panel panel-default sidebar-menu wow fadeInRight animated">
                                <div class="panel-heading">
                                    <h3 class="panel-title">실시간 인기 견적</h3>
                                </div>
                                <div class="panel-body recent-property-widget">
                                    <ul>
                                        <li>
                                            <div class="col-md-3 col-sm-3 col-xs-3 blg-thumb p0">
                                                <a href="${pageContext.request.contextPath}/resources/single.html"><img
                                                        src="${pageContext.request.contextPath}/resources/assets/img/demo/small-property-2.jpg"></a>
                                                <span class="property-seeker">
                                                    <b class="b-1">A</b>
                                                    <b class="b-2">S</b>
                                                </span>
                                            </div>
                                            <div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
                                                <h6>
                                                    <a href="${pageContext.request.contextPath}/resources/single.html">신축
                                                        아파트 리모델링</a></h6>
                                                <span class="property-price">7000 만원</span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="col-md-3 col-sm-3  col-xs-3 blg-thumb p0">
                                                <a href="${pageContext.request.contextPath}/resources/single.html"><img
                                                        src="${pageContext.request.contextPath}/resources/assets/img/demo/small-property-1.jpg"></a>
                                                <span class="property-seeker">
                                                    <b class="b-1">A</b>
                                                    <b class="b-2">S</b>
                                                </span>
                                            </div>
                                            <div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
                                                <h6>
                                                    <a href="${pageContext.request.contextPath}/resources/single.html">대학가
                                                        원룸 도배</a></h6>
                                                <span class="property-price">100 만원</span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="col-md-3 col-sm-3 col-xs-3 blg-thumb p0">
                                                <a href="${pageContext.request.contextPath}/resources/single.html"><img
                                                        src="${pageContext.request.contextPath}/resources/assets/img/demo/small-property-3.jpg"></a>
                                                <span class="property-seeker">
                                                    <b class="b-1">A</b>
                                                    <b class="b-2">S</b>
                                                </span>
                                            </div>
                                            <div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
                                                <h6>
                                                    <a href="${pageContext.request.contextPath}/resources/single.html">화장실
                                                        내부 수리</a></h6>
                                                <span class="property-price">500 만원</span>
                                            </div>
                                        </li>

                                        <li>
                                            <div class="col-md-3 col-sm-3 col-xs-3 blg-thumb p0">
                                                <a href="${pageContext.request.contextPath}/resources/single.html"><img
                                                        src="${pageContext.request.contextPath}/resources/assets/img/demo/small-property-2.jpg"></a>
                                                <span class="property-seeker">
                                                    <b class="b-1">A</b>
                                                    <b class="b-2">S</b>
                                                </span>
                                            </div>
                                            <div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
                                                <h6>
                                                    <a href="${pageContext.request.contextPath}/resources/single.html">복층
                                                        카페 인테리어 </a></h6>
                                                <span class="property-price">2500 만원</span>
                                            </div>
                                        </li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div> <!-- left side -->

                    <div class="col-md-9  pr0 padding-top-40 properties-page">
                        <div class="col-md-12 clear">
                            <div class="col-xs-10 page-subheader sorting pl0">
                                <ul class="sort-by-list">
                                    <li class="active">
                                        <a href="javascript:void(0);" class="order_by_date" data-orderby="property_date"
                                           data-order="ASC">
                                            Property Date <i class="fa fa-sort-amount-asc"></i>
                                        </a>
                                    </li>
                                    <li class="">
                                        <a href="javascript:void(0);" class="order_by_price"
                                           data-orderby="property_price" data-order="DESC">
                                            Property Price <i class="fa fa-sort-numeric-desc"></i>
                                        </a>
                                    </li>
                                </ul><!--/ .sort-by-list-->

                                <div class="items-per-page">
                                    <label for="items_per_page"><b>Property per page :</b></label>
                                    <div class="sel">
                                        <select id="items_per_page" name="per_page">
                                            <option value="3">3</option>
                                            <option value="6">6</option>
                                            <option value="9">9</option>
                                            <option selected="selected" value="12">12</option>
                                            <option value="15">15</option>
                                            <option value="30">30</option>
                                            <option value="45">45</option>
                                            <option value="60">60</option>
                                        </select>
                                    </div><!--/ .sel-->
                                </div><!--/ .items-per-page-->
                            </div>

                            <div class="col-xs-2 layout-switcher">
                                <a class="layout-list" href="javascript:void(0);"> <i class="fa fa-th-list"></i> </a>
                                <a class="layout-grid active" href="javascript:void(0);"> <i class="fa fa-th"></i> </a>
                            </div><!--/ .layout-switcher-->
                        </div>

                        <div class="col-md-12 clear">
                            <div id="list-type" class="proerty-th">

                                <c:forEach items="${list}" var="item">

                                    <div class="col-sm-6 col-md-4 p0">
                                        <div class="box-two proerty-item">
                                            <div class="item-thumb">
                                                <a href='/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}&boardNo=${item.boardNo}'>
                                                        <c:set var="data" value="${item.image[0]}" />                                                        <a href='/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}&boardNo=${item.boardNo}'>
                                                        <img src="/displayFile?fileName=${data}" onerror="this.onerror=null; this.src='../../../resources/assets/img/logo-2.png';"/>
                                                </a>
                                            </div>

                                            <div class="item-entry overflow">
                                                <h5>
                                                    <a href='/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}&boardNo=${item.boardNo}'> ${item.title} </a>
                                                    <fmt:parseDate var='modifiedDate' pattern="yyyy-MM-dd"
                                                                   value="${item.modifiedDate}" scope="page"/>
                                                    <span class="pull-right"
                                                          style=" position: relative;top: 5px; font-size: x-small;"> <fmt:formatDate
                                                            value="${modifiedDate}" pattern="yyyy년 MM월 dd일 "/> </span>
                                                </h5>

                                                <div class="dot-hr"></div>
                                                <span class="pull-left"><b> Area :</b> ${item.area} 평 </span>
                                                <c:choose>
                                                    <c:when test="${item.budget eq -1}">
                                                        <span class="proerty-price pull-right"> 업체 협의 </span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="proerty-price pull-right">예산: ${item.budget} 만원</span>
                                                    </c:otherwise>
                                                </c:choose>

                                                <p style="display: none;"> ${item.require} </p>
                                                <div class="property-icon" style="color: #777777; opacity: 0.5;">
                                                    <span style="color: black;">
                                                    <c:choose>
                                                        <c:when test="${item.category eq '아파트'}">
                                                            <b>Category</b>: <img
                                                                src="${pageContext.request.contextPath}/resources/assets/img/icon/apartment.png">&emsp;&emsp;
                                                        </c:when>
                                                        <c:when test="${item.category eq '빌라'}">
                                                            <b>Category</b>: <img
                                                                src="${pageContext.request.contextPath}/resources/assets/img/icon/villa.png">&emsp;&emsp;
                                                        </c:when>
                                                        <c:when test="${item.category eq '카페/식당'}">
                                                            <b>Category</b>: <img
                                                                src="${pageContext.request.contextPath}/resources/assets/img/icon/restaurant.png">&emsp;&emsp;
                                                        </c:when>
                                                        <c:when test="${item.category eq '사무/오피스'}">
                                                            <b>Category</b>: <img
                                                                src="${pageContext.request.contextPath}/resources/assets/img/icon/workplace.png">&emsp;&emsp;
                                                        </c:when>
                                                        <c:when test="${item.category eq '매장/상업'}">
                                                            <b>Category</b>: <img
                                                                src="${pageContext.request.contextPath}/resources/assets/img/icon/market.png">&emsp;&emsp;
                                                        </c:when>
                                                        <c:when test="${item.category eq '병원/의료'}">
                                                            <b>Category</b>: <img
                                                                src="${pageContext.request.contextPath}/resources/assets/img/icon/hospital.png">&emsp;&emsp;
                                                        </c:when>
                                                        <c:otherwise>
                                                            <b>Category</b>: <img
                                                                src="${pageContext.request.contextPath}/resources/assets/img/icon/etc.png">&emsp;&emsp;
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <c:choose>
                                                        <c:when test="${item.part eq '종합'}">
                                                            <b>Part</b>: <img
                                                            src="${pageContext.request.contextPath}/resources/assets/img/icon/all.png"> </span>
                                                    </c:when>
                                                    <c:when test="${item.part eq '도배'}">
                                                        <b>Part</b>: <img
                                                            src="${pageContext.request.contextPath}/resources/assets/img/icon/wallpaper.png"> </span>
                                                    </c:when>
                                                    <c:when test="${item.part eq '마루'}">
                                                        <b>Part</b>: <img
                                                            src="${pageContext.request.contextPath}/resources/assets/img/icon/floor.png"> </span>
                                                    </c:when>
                                                    <c:when test="${item.part eq '욕실'}">
                                                        <b>Part</b>: <img
                                                            src="${pageContext.request.contextPath}/resources/assets/img/icon/bathroom.png"> </span>
                                                    </c:when>
                                                    <c:when test="${item.part eq '타일'}">
                                                        <b>Part</b>: <img
                                                            src="${pageContext.request.contextPath}/resources/assets/img/icon/tile.png"> </span>
                                                    </c:when>
                                                    <c:when test="${item.part eq '도어'}">
                                                        <b>Part</b>: <img
                                                            src="${pageContext.request.contextPath}/resources/assets/img/icon/door.png"> </span>
                                                    </c:when>
                                                    <c:when test="${item.part eq '주방'}">
                                                        <b>Part</b>: <img
                                                            src="${pageContext.request.contextPath}/resources/assets/img/icon/kitchen.png"> </span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <b>Part</b>: <img
                                                            src="${pageContext.request.contextPath}/resources/assets/img/icon/etc.png"> </span>
                                                    </c:otherwise>
                                                    </c:choose>
                                                    </span>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </c:forEach>
                            </div>
                        </div>

                        <div class="text-center">
                            <div class="pagination">
                                <ul>

                                    <c:if test="${pageMaker.prev}">
                                        <li><a href="${pageMaker.startPage - 1}">&laquo;</a></li>
                                    </c:if>

                                    <c:forEach begin="${pageMaker.startPage }"
                                               end="${pageMaker.endPage }" var="idx">
                                        <li
                                                <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
                                            <a href="${idx}">${idx}</a>
                                        </li>
                                    </c:forEach>

                                    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                                        <li><a
                                                href="${pageMaker.endPage +1}">&raquo;</a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    <!-- /.content -->
</div>
<!-- /.content-wrapper -->


<form id="jobForm">
    <input type='hidden' name="page" value=${pageMaker.cri.perPageNum}>
    <input type='hidden' name="perPageNum" value=${pageMaker.cri.perPageNum}>
</form>


<script>
    var result = '${msg}';

    if (result == 'SUCCESS') {
        alert("처리가 완료되었습니다.");
    }

    $(".pagination li a").on("click", function (event) {

        event.preventDefault();

        var targetPage = $(this).attr("href");

        var jobForm = $("#jobForm");
        jobForm.find("[name='page']").val(targetPage);
        jobForm.attr("action", "/board/listPage").attr("method", "get");
        jobForm.submit();
    });
</script>


<%@include file="../include/footer.jspf" %>