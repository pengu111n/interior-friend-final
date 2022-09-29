<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../include/header.jspf"%>

 <style>
.btn-primary {
	color: #fff;
	background-color: #fdc600;
	border-color: #fdc600;
	border-radius: 1px;
	padding: 10px 20px;
	font-weight: 600;
}
.fileDrop {
  width: 80%;
  height: 150px;
  border: 1px dotted gray;
  background-color: lightgrey;
  margin: auto;

}
.small {
	margin-left: 3px;
	font-weight: bold;
	color: gray;
}
.mailbox-attachments {
  list-style: none;
  margin: 0;
  padding: 0;
}
.mailbox-attachment-icon.has-img>img {
    max-width: 100%;
    height: auto;
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
.fa-remove:before, .fa-close:before, .fa-times:before {
    content: "\f00d";
}
.mailbox-attachment-name {
    font-weight: bold;
    color: #666;
}
.fa-fw {
    width: 1.28571429em;
    text-align: center;
}
.fa {
    display: inline-block;
    font: normal normal normal 14px/1 FontAwesome;
    font-size: inherit;
    text-rendering: auto;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#space').val('${cboard.space}').prop("selected", true);
		$('#cnstType').val('${cboard.cnstType}').prop("selected", true);
	});
</script>

                <div class="page-head">
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title">시공사례 수정</h1>
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->

        <!-- property area -->
        <div class="content-area submit-property" style="background-color: #FCFCFC;">&nbsp;
            <div class="container">
                <div class="clearfix" >
                    <div class="wizard-container">

                        <div class="wizard-card ct-wizard-orange" id="wizardProperty">
                            <form action="modify" method="post" >
                            <input type="hidden" name="cbno" value="${cboard.cbno}">
                                <ul>
                                    <li><a href="#step1" data-toggle="tab">Step 1 </a></li>
                                    <li><a href="#step2" data-toggle="tab">Step 2 </a></li>
                                    <!-- <li><a href="#step3" data-toggle="tab">Step 3 </a></li> -->
                                    <li><a href="#step3" data-toggle="tab">Finished </a></li>
                                </ul>

                                <div class="tab-content">
                                    <div class="tab-pane" id="step1">
                                         <h4 class="info-text">  </h4>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="col-sm-12">
                                                    <div class="form-group">
                                                        <label>제목 :</label>
                                                        <textarea class="form-control" name="ctitle" onkeypress="TextCount(this,'ctitle');"
                                                        placeholder="제목을 간략하게 작성해주세요 (20자이내)">${cboard.ctitle} </textarea>
                                                        <span id="ctitle"></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12">
                                                <div class="col-sm-12">
                                                    <div class="form-group">
                                                        <label>평수 :</label>
                                                        <textarea id="area" name="area" class="form-control" placeholder="평수는 숫자만 입력 가능합니다.">${cboard.area} </textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12">
                                                <div class="col-sm-12">
                                                    <div class="form-group">
                                                        <label>시공 비용 :</label>
                                                        <textarea id="cost" name="cost"  class="form-control" >${cboard.cost} </textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12">
                                                <div class="col-sm-12">
                                                    <div class="form-group">
                                                        <label>시공 기간 :</label>
                                                        <textarea id="period" name="period"  class="form-control" >${cboard.period} </textarea>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-sm-12">
                                                <div class="col-sm-6">
                                                    <div class="form-group">
                                                        <label>시공 공간  :</label>
                                                        <select id="space" name="space" class="selectpicker show-tick form-control">
   														<option value="" disabled selected> - 선택 - </option>
														<option value="아파트">아파트</option>
														<option value="빌라">빌라</option>
														<option value="카페/식당">카페/식당</option>
														<option value="사무/오피스">사무/오피스</option>
														<option value="매장/상업">매장/상업</option>
														<option value="병원/의료">병원/의료</option>
														<option value="기타">기타</option>

                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <div class="form-group">
                                                        <label>시공 분야  :</label>
                                                        <select id="cnstType" name="cnstType" class="selectpicker show-tick form-control">
															<option value="" disabled selected> - 선택 - </option>
															<option value="종합">종합</option>
															<option value="도배">도배</option>
															<option value="마루">마루</option>
															<option value="욕실">욕실</option>
															<option value="필름">필름</option>
															<option value="타일">타일</option>
															<option value="도어">도어</option>
															<option value="주방">주방</option>
															<option value="기타">기타</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12">
	                                            <div class="col-sm-12">
	                                             	<div class="form-group">
	                                                 	<label for="property-video">내용 :</label>
	                                                 	<textarea class="form-control" name="content"
														id="content" rows="10">${cboard.content} </textarea>
			                                         </div>
			                                     </div>
		                                     </div>
                                            <br>
                                        </div>
                                    </div>
                                    <!-- End step 1 -->

                                    <div class="tab-pane" id="step2">
                                        <div style="margin-bottom: 20px;">>
                                            <p align="center"><span class="info-text" style="font-size: 20px;">시공사진 이미지 등록</span>
                                            <span style="font-size: 16px;">(글 수정시 이미지를 다시 등록해주세요)</span></p>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6" align="center">
												<label for="property-images">이미지를 드래그 하세요</label>
												<div class="fileDrop"></div>
                                            </div>
	                                        <hr>
                                            <div class="col-sm-6">
                                                <div class="form-group">
												<ul class="mailbox-attachments clearfix uploadedList">
												</ul>
                                            	</div>
                                        	</div>
                                    	</div>
                                    </div>
                                    <!--  End step 2 -->


                                    <div class="tab-pane" id="step3">
                                        <h4 class="info-text"> 이용 약관 </h4>
                                        <div class="row" align="center">
                                            <div class="col-sm-12">
                                                <div class="">
                                                    <p>당사 웹사이트에 귀하의 개인 정보가 포함된 업체 광고를 게시하는 등 INTERIOR FRIEND 서비스에 액세스하거나</p>
                                                    <p>사용함으로써 귀하는 법적 적절한 방식으로 귀하의 개인 정보를 수집, 사용 및 공개하는 데 동의하는 것입니다.</p>
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="agree"/> <strong>동의합니다.</strong>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--  End step 3 -->

                                </div>

                                <div class="wizard-footer">
                                    <div class="pull-right">
                                        <input type='button' class='btn-next btn-primary' name='next' value='다음' />
                                        <input type='submit' class='btn-finish btn-primary ' name='finish' value='등록하기' />
                                    </div>

                                    <div class="pull-left">
                                        <input type='button' class='btn-previous btn-default' name='previous' value='이전' />
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </form>
                        </div>
                        <!-- End submit form -->
                    </div>
                </div>
            </div>
        </div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

 $(document).ready(
			function() {
				$("form")
						.submit(
								function() {
									if ($("textarea[Name='ctitle']").val() == "") {
                                        alert("제목을 간략히 작성해주세요");
                                        return false;
                                    }
									if (!$.isNumeric($("#area").val())) {
										alert("평수를 입력해주세요(숫자만 입력 가능합니다)");
										return false;
									}
									if ($("#cost").val() == "") {
										alert("시공 비용을 입력해주세요");
										return false;
									}
									if ($("#period").val() == "") {
										alert("시공 기간을 입력해주세요");
										return false;
									}
									if ($("#space").val() == null) {
										alert("시공 공간을 선택해주세요");
										return false;
									}
									if ($("#cnstType").val() == null) {
										alert("시공 분야를 선택해주세요");
										return false;
									}
									if ($("#content").val() == "") {
										alert("내용을 입력해주세요");
										return false;
									}
									if (!$("input:checked[Name='agree']").is(":checked")){
										alert("이용약관에 동의해주세요");
										return false;
									}

									event.preventDefault();

									var that = $(this);

									var str ="";
									$(".uploadedList .delbtn").each(function(index){
										 str += "<input type='hidden' name='files["+index+"]' value='"+$(this).attr("href") +"'> ";
									});

									that.append(str);

									that.get(0).submit();
								}); // submit() end
			}); // ready() end
</script>

<script type="text/javascript" src="/resources/js/upload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<script id="template" type="text/x-handlebars-template">
<li>
  <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
  <div class="mailbox-attachment-info">
	<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	<a href="{{fullName}}"
     class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
	</span>
  </div>
</li>
</script>

<script>

var template = Handlebars.compile($("#template").html());

$(".fileDrop").on("dragenter dragover", function(event){
	event.preventDefault();
});


$(".fileDrop").on("drop", function(event){
	event.preventDefault();

	var files = event.originalEvent.dataTransfer.files;

	var file = files[0];

	var formData = new FormData();

	formData.append("file", file);


	$.ajax({
		  url: '/uploadAjax',
		  data: formData,
		  dataType:'text',
		  processData: false,
		  contentType: false,
		  type: 'POST',
		  success: function(data){

			  var fileInfo = getFileInfo(data);

			  var html = template(fileInfo);

			  $(".uploadedList").append(html);
		  }
		});
});


// 첨부파일 삭제
$(".uploadedList").on("click", ".delbtn", function (event) {
    event.preventDefault();
    var that = $(this);
    $.ajax({
        url: "/deleteFile",
        type: "post",
        data: {fileName:$(this).attr("href")},
        dataType: "text",
        success: function (result) {
            if (result == "deleted") {
                alert("삭제되었습니다.");
                that.parents("li").remove();
            }
        }
    });
});

//제목 글자수 제한
function TextCount(obj,id){
	var strValue = obj.value;
	var strLen = strValue.length+1;
	var str = "";
	str += '[' + strLen + '자 / 21]';
	if(strLen > 20){
		alert("제목을 간략하게 작성해주세요 (20자이내)");
		$(obj).val(strValue.substring(0, 19));
	}
	$("#"+id).html(str);
}


</script>


<%@ include file="../include/footer.jspf"%>