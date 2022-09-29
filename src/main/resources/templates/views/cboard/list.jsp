<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../include/header.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

        <div class="page-head">
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title">시공사례 목록</h1>
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->

        <!-- property area -->
        <div class="properties-area recent-property" style="background-color: #FFF;">
                    <div class="container">
                        <div class="row  pr0 padding-top-20 properties-page">
                           	<div class="col-md-12 padding-bottom-40 large-search">
        	                    <div class="col-lg-12 col-lg-offset-0 col-md-10 col-md-offset-1 col-sm-12" align="center">
        	                        <div class="search-form" data-wow-delay="0.8s">
        	                            <!-- <form action="" class=" form-inline"> -->
        	                            <form role="form" method="get" class=" form-inline">
        	                                <!-- <div class="form-group"> -->
        	                                <div class="search form-group">
        	                                    <select id="lunchBegins" name="searchType" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="선택">
        	                                        <!-- <option>제목</option>
        	                                        <option>내용</option>
        	                                        <option>작성자</option> -->
                                                    <%-- <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option> --%>
        										    <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
        										    <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
        										    <option value="n"<c:out value="${scri.searchType eq 'n' ? 'selected' : ''}"/>>업체명</option>
        									        <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
        	                                    </select>
        	                                </div>
        	                                <div class="form-group">
        	                                    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" class="form-control" placeholder="Key word" />
        	                                </div>
        	<!--                                 <div class="form-group">
        	                                    <select id="basic" class="selectpicker show-tick form-control">
        	                                        <option> -Status- </option>
        	                                        <option>Rent </option>
        	                                        <option>Boy</option>
        	                                        <option>used</option>

        	                                    </select>
        	                                </div> -->
        	                                <button class="search-btn" type="button"><i class="fa fa-search"></i></button>
        	                                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        								    <script>
        								      $(function(){
        								        $('.search-btn').click(function() {
        								          self.location = "list" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        								        });
        								      });
        								    </script>
        	                            </form>
        	                        </div>
        	                    </div>
        	                </div>
        		            <!-- </div> -->
                            <!-- 검색기능 end -->

                            <div class="col-md-12  clear">
                                <div class="col-xs-10 page-subheader sorting pl0">
                                    <ul class="sort-by-list">
                                        <li class="">
                                            <a href="javascript:void(0);" class="order_by_date" data-orderby="property_date" data-order="ASC">
                                                최신순 <i class="fa fa-sort-amount-asc"></i>
                                            </a>
                                        </li>
        <!--                                 <li class="active">
                                            <a href="javascript:void(0);" class="order_by_price" data-orderby="property_price" data-order="DESC">
                                                좋아요순 <i class="fa fa-sort-amount-asc"></i>
                                            </a>			fa fa-sort-numeric-desc
                                        </li> -->
                                    </ul>
                                </div>

                                <div class="col-xs-2 layout-switcher">
                                    <a class="layout-list" href="javascript:void(0);"> <i class="fa fa-th-list"></i>  </a>
                                    <a class="layout-grid active" href="javascript:void(0);"> <i class="fa fa-th"></i> </a>
                                </div><!--/ .layout-switcher-->
                            </div>

                            <div class="col-md-12 clear ">
                                <div id="list-type" class="proerty-th">
                                	<c:forEach var="cboard" items="${list}">
                                    <div class="col-sm-6 col-md-4 p0">
                                        <div class="box-two proerty-item">
                                            <div class="item-thumb">
                                                <a href="read?cbno=${cboard.cbno}">
                                                 <c:set var="data" value="${cboard.files[0]}" />
                                               <img style="height: 240px;" src="/displayFile?fileName=${fn:substring(data, 0, 12)}${fn:substring(data, 14, 100)}"
                                               <%-- <img style="height: 240px;" src="/upload${fn:substring(data, 0, 12)}${fn:substring(data, 14, 100)}" --%>
                                                onerror="this.src='/resources/assets/img/demo/default.jpg'"/></a>
                                            </div>

                                            <div class="item-entry overflow">
                                                <h5 style="font-size: 14px;"><a href="read?cbno=${cboard.cbno}"> ${cboard.ctitle} </a></h5>
                                                <div class="dot-hr"></div>
                                                <span class="pull-left"><b> ${cboard.companyName} </b></span>
                                                <span class="proerty-price pull-right"> ￦ ${cboard.cost} </span>
                                                <p style="display: none;">${fn:replace(cboard.content, cn, br)}</p>
                                                <div class="property-icon">
                                                    ${cboard.cnstType} |
                                                    ${cboard.space} |
                                                    ${cboard.area}평
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>

                            <div class="col-md-12 clear padding-bottom-40">
                                <div class="pull-right">
                                    <div class="pagination">
        	                             <ul>
        		  							<c:if test="${pageMaker.prev}">
        										<li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
        									</c:if>

        									<c:forEach begin="${pageMaker.startPage }"
        										end="${pageMaker.endPage }" var="idx">
        										<li
        											<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
        											<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
        										</li>
        									</c:forEach>

        									<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
        										<li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
        									</c:if>
        								</ul>
                                    </div>
                                </div>
                            </div>
                            <!-- 페이징 end -->
                        </div>
                    </div>
                 </div>

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("등록이 완료되었습니다.");
		location.replace(self.location);
	}
</script>


<%@ include file="../include/footer.jspf"%>