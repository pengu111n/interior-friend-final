<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../include/header.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="/resources/js/upload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
 
<%
// 줄바꿈     
pageContext.setAttribute("br", "<br/>");
pageContext.setAttribute("cn", "\n");
%> 

<style type="text/css">
.margin-space {
	margin-top: 40px;
	margin-left: 15px;
	margin-bottom: 40px;
}
.btn-primary {
	color: #fff;
	background-color: #fdc600;
	border-color: #fdc600;
	border-radius: 1px;
	padding: 10px 20px;
	font-weight: 600;
}
.mailbox-attachments {
  list-style: none;
  margin: 0;
  padding: 0;
}
.mailbox-attachment-icon.has-img>img {
   position:relative;
   width: 800px;
   height: 500px;
   left : 120px;
}
img {
    vertical-align: middle;
}
img {
    border: 0;
}
.mailbox-attachment-info {
    padding: 10px;
    background: #f4f4f4;
}
.mailbox-attachment-icon, .mailbox-attachment-info, .mailbox-attachment-size {
    display: block;
}
.mailbox-attachment-name {
    font-weight: bold;
    color: #666;
}
 </style>


<!-- Content Wrapper. Contains page content -->
<!-- Content Header (Page header) -->


 <div class="page-head">
    <div class="container">
        <div class="row">
            <div class="page-head-content">
                <h1 class="page-title">시공사례 </h1>
            </div>
        </div>
    </div>
</div>
<!-- End page header -->

        <!-- property area -->
 <div class="content-area single-property" style="background-color: #FCFCFC;">&nbsp;
	<div class="container">

		<div class="clearfix padding-top-10">

			<div class="col-md-12 single-property-content prp-style-2">
				<div class="">
					<div class="row">
						<div class="light-slide-item">
							<div class="clearfix">
								<div class="favorite-and-print">
									<a class="add-to-fav" href="#login-modal" data-toggle="modal">
										<i class="fa fa-star-o"></i>
									</a> <a class="printer-icon " href="javascript:window.print()">
										<i class="fa fa-print"></i>
									</a>
								</div>
							<!--<ul id="image-gallery" class="gallery list-unstyled cS-hidden">
									<li data-thumb="/resources/assets/img/property-1/property1.jpg">
										<img src="/resources/assets/img/property-1/property1.jpg" />
									</li>
									<li data-thumb="/resources/assets/img/property-1/property2.jpg">
										<img src="/resources/assets/img/property-1/property2.jpg" />
									</li>
									<li data-thumb="/resources/assets/img/property-1/property3.jpg">
										<img src="/resources/assets/img/property-1/property3.jpg" />
									</li>
									<li data-thumb="/resources/assets/img/property-1/property4.jpg">
										<img src="/resources/assets/img/property-1/property4.jpg" />
									</li>
								</ul>   -->

							</div>
						</div>
					</div>
					<div class="single-property-wrapper">

						<div class="section property-share">
                            <h4 class="s-property-title"></h4>
                            <ul class="mailbox-attachments clearfix uploadedList"></ul>
                        </div>
                        <div class="section">
                            <h2 class="property-title">${cboard.ctitle}</h2>
                            &nbsp;
                        </div>
                        <div class="section">
                            <div class="s-property-content">
                                <p>${fn:replace(cboard.content, cn, br)}</p>
                            </div>
                        </div>
						<!-- End description area  -->

						<div class="section additional-details">

							<h4 class="s-property-title" >시공 정보</h4>

							<ul class="additional-details-list clearfix">
								<li><span class="col-xs-6 col-sm-2 col-md-2 add-d-title">유형</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${cboard.cnstType}</span>
								</li>

								<li><span class="col-xs-6 col-sm-2 col-md-2 add-d-title">공간</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${cboard.space}</span>
								</li>
								<li><span class="col-xs-6 col-sm-2 col-md-2 add-d-title">면적(평수)</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${cboard.area}</span>
								</li>

								<li><span class="col-xs-6 col-sm-2 col-md-2 add-d-title">기간</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${cboard.period}</span>
								</li>

								<li><span class="col-xs-6 col-sm-2 col-md-2 add-d-title">금액</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">${cboard.cost}</span>
								</li>
							</ul>
						</div>
						<!-- End additional-details area  -->

						<div class="section property-share">
							<h4 class="s-property-title">업체 정보</h4>
						</div>
						<div class="clear">
							<div class="col-xs-6 col-sm-2 col-md-2 add-d-title">
								<a href=""> <img
									src="/resources/assets/img/client-face1.png" class="img-circle">
								</a>
							</div>
							<div class="col-xs-8 col-sm-8 ">
								<h3 class="dealer-name">
									<a href="">${cboard.companyName}</a>
								</h3>
								<div class="dealer-social-media">
									<a class="twitter" target="_blank" href=""> <i
										class="fa fa-twitter"></i>
									</a> <a class="facebook" target="_blank" href=""> <i
										class="fa fa-facebook"></i>
									</a> <a class="gplus" target="_blank" href=""> <i
										class="fa fa-google-plus"></i>
									</a> <a class="linkedin" target="_blank" href=""> <i
										class="fa fa-linkedin"></i>
									</a> <a class="instagram" target="_blank" href=""> <i
										class="fa fa-instagram"></i>
									</a>
								</div>

							</div>
						</div>


						<div class="section property-features">
                             <!-- <h4 class="s-property-title">Features</h4>    -->
							 <ul class="dealer-contacts">
								<li><i class="pe-7s-map-marker strong"> </i> ${cboard.address}</li>
								<li><i class="pe-7s-mail strong"> </i> ${cboard.email} </li>
								<li><i class="pe-7s-call strong"> </i> ${cboard.phoneNum} </li>
							 </ul>
                             <ul>
                                 <li><a>제공 서비스</a></li>
                                 <li>직영시공, 설계도면, 3D 디자인, 전문감리, 공정표, 세금계산서, 현금영수증, 하자이행증권, 계약이행증권, 마감청소</li>
                             </ul>
                             <ul>
                                 <li><a>경력</a></li>
                                 <li>5~10년</li>
                             </ul>
                             <ul>
                                 <li><a>AS</a></li>
                                 <li>1년</li>
                             </ul>
                        </div>
					</div>
				</div>

				<div class="section property-share">
					<h4 class="s-property-title">Share width your friends</h4>
					<div class="roperty-social">
						<ul>
							<li><a title="Share this on dribbble " href="#"><img
									src="/resources/assets/img/social_big/dribbble_grey.png"></a></li>
							<li><a title="Share this on facebok " href="#"><img
									src="/resources/assets/img/social_big/facebook_grey.png"></a></li>
							<li><a title="Share this on delicious " href="#"><img
									src="/resources/assets/img/social_big/delicious_grey.png"></a></li>
							<li><a title="Share this on tumblr " href="#"><img
									src="/resources/assets/img/social_big/tumblr_grey.png"></a></li>
							<li><a title="Share this on digg " href="#"><img
									src="/resources/assets/img/social_big/digg_grey.png"></a></li>
							<li><a title="Share this on twitter " href="#"><img
									src="/resources/assets/img/social_big/twitter_grey.png"></a></li>
							<li><a title="Share this on linkedin " href="#"><img
									src="/resources/assets/img/social_big/linkedin_grey.png"></a></li>
						</ul>
					</div>
				</div>
				<h5 style="text-align: right">등록일 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${cboard.regDate}" /></h5>
			</div>
		</div>
		<div class="margin-space" style="text-align: right">
			<c:set var="pageNo"
				value="${empty param.pageNo ? '1' : param.pageNo}" />

			<a href="list?pageNo=${pageNo}" class="btn btn-primary ">목록</a>
			<c:if test="${login.memNo == cboard.memNo}">
			<a href="modify?cbno=${cboard.cbno}" class="btn btn-primary">수정</a>
			<a onclick="return confirm('정말로 삭제하시겠습니까?')"	href="delete?cbno=${cboard.cbno}" class="btn btn-primary">삭제</a>
			</c:if>
		</div>
	</div>
</div>


<!--                         <div class="similar-post-section padding-top-40">
                            <div id="prop-smlr-slide_0">
                                <div class="box-two proerty-item">
                                    <div class="item-thumb">
                                        <a href="property-1.html" ><img src="/resources/assets/img/similar/property-1.jpg"></a>
                                    </div>
                                    <div class="item-entry overflow">
                                        <h5><a href="property-1.html"> Super nice villa </a></h5>
                                        <div class="dot-hr"></div>
                                        <span class="pull-left"><b> Area :</b> 120m </span>
                                        <span class="proerty-price pull-right"> $ 300,000</span>
                                    </div>
                                </div>
                                <div class="box-two proerty-item">
                                    <div class="item-thumb">
                                        <a href="property-1.html" ><img src="/resources/assets/img/similar/property-2.jpg"></a>
                                    </div>
                                    <div class="item-entry overflow">
                                        <h5><a href="property-1.html"> Super nice villa </a></h5>
                                        <div class="dot-hr"></div>
                                        <span class="pull-left"><b> Area :</b> 120m </span>
                                        <span class="proerty-price pull-right"> $ 300,000</span>
                                    </div>
                                </div>
                                <div class="box-two proerty-item">
                                    <div class="item-thumb">
                                        <a href="property-1.html" ><img src="/resources/assets/img/similar/property-3.jpg"></a>
                                    </div>
                                    <div class="item-entry overflow">
                                        <h5><a href="property-1.html"> Super nice villa </a></h5>
                                        <div class="dot-hr"></div>
                                        <span class="pull-left"><b> Area :</b> 120m </span>
                                        <span class="proerty-price pull-right"> $ 300,000</span>
                                    </div>
                                </div>
                                <div class="box-two proerty-item">
                                    <div class="item-thumb">
                                        <a href="property-1.html" ><img src="/resources/assets/img/similar/property-1.jpg"></a>
                                    </div>
                                    <div class="item-entry overflow">
                                        <h5><a href="property-1.html"> Super nice villa </a></h5>
                                        <div class="dot-hr"></div>
                                        <span class="pull-left"><b> Area :</b> 120m </span>
                                        <span class="proerty-price pull-right"> $ 300,000</span>
                                    </div>
                                </div>
                            </div>
                        </div>                                                                    하단에 게시글 목록-->





<!-- JavaScript의 템플릿을 적용하여 '만들어진 HTML 코드에 데이터(객체)를 넣어 찍어내는 틀'로 사용한다.
	 handlebars 사용 -->
<script id="templateAttach" type="text/x-handlebars-template">
<li data-src='{{fullName}}'>
   <span class="mailbox-attachment-icon has-img"><img src="{{getLink}}" alt="."></span>
	</span>
  </div>
</li>
</script>




<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	var cbno = ${cboard.cbno};
	var template = Handlebars.compile($("#templateAttach").html());

	$.getJSON("/cboard/getAttach/"+cbno,function(list){
		$(list).each(function(){

			var fileInfo = getFileInfo(this);

			var html = template(fileInfo);

			 $(".uploadedList").append(html);

		});
	});
});
</script>



<%@ include file="../include/footer.jspf"%>
