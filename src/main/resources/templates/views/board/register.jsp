<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<%@ include file="../include/header.jspf" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Board/css/register.css">--%>
<script src="${pageContext.request.contextPath}/resources/Board/js/register.js"></script>
<script src="${pageContext.request.contextPath}/resources/Board/js/upload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>


<style>
    .fileDrop {
        width: 80%;
        height: 150px;
        border: 1px dotted gray;
        background-color: #a2a098;
        margin: auto;
    }

    .tab-content {
        margin: auto;
        width: 80%;
    }

</style>


<div class="page-head">
    <div class="container">
        <div class="row">
            <div class="page-head-content">
                <h1 class="page-title">인테리어 견적 신청</h1>
            </div>
        </div>
    </div>
</div>
<!-- property area -->
<div class="content-area submit-property" style="background-color: #FCFCFC;">&nbsp;
    <div class="container">
        <div class="clearfix">
            <div class="wizard-container">

                <div class="wizard-card ct-wizard-orange" id="wizardProperty">
                    <form id='registerForm' role="form" method="post">
                        <div class="wizard-header">
                            <h3>
                                인테리어 견적 간편 신청 <br/>
                            </h3>
                        </div>

                        <ul>
                            <li><a href="#step1" data-toggle="tab">Step 1 </a></li>
                            <li><a href="#step2" data-toggle="tab">Step 2 </a></li>
                            <li><a href="#step3" data-toggle="tab">Step 3 </a></li>
                            <li><a href="#step4" data-toggle="tab">Finished </a></li>
                        </ul>

                        <div class="tab-content">

                            <div class="tab-pane" id="step1">
                                <div class="row p-b-15  ">
                                    <input type="hidden" id="memNo" name="memNo" value="${login.memNo}">
                                    <input type="hidden" id="id" name="id" value="${login.id}">
                                    <input type="hidden" id="nickName" name="nickName" value="${login.nickName}">

                                <%--                                    <h4 class="info-text"> 인테리어 견적 신청</h4>--%>
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label>제목 : </label>
                                            <input type="text" class="form-control" name="title" id="title"
                                                   placeholder="시공내용을 간략하게 적어주세요 (20자이내)">
                                        </div>
                                    </div>

                                    <div class="form-group" style="width: 800px;">

                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label>주소 :</label><br/>
                                                <select
                                                        class="form-control" name="address_1" id="address_1"
                                                        style="width: 160px; display: inline-block;"></select>
                                                <select
                                                        class="form-control" name="address_2" id="address_2"
                                                        style="width: 160px; display: inline-block;"></select>
                                                <input type="hidden" id="address" name="address" value="">
                                            </div>
                                        </div>
                                    </div>


                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label>시공 시작일</label><br/>
                                            <input type="date"
                                                   class="form-control" name="startDate" id="startDate"
                                                   style="width: 200px; margin-right: 50px; display: inline-block;"></input>
                                            <label>시공 시작일 미정</label>
                                            <input type="checkbox" id="undefined_start" name="undefined_start"
                                                   style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;">
                                        </div>

                                        <div class="form-group">
                                            <label>시공 종료일</label><br/>
                                            <input type="date"
                                                   class="form-control" name="endDate" id="endDate"
                                                   style="width: 200px; margin-right: 50px; display: inline-block;"/>
                                            <label>시공 종료일 미정</label>
                                            <input type="checkbox" id="undefined_end"
                                                   name="undefined_end"
                                                   style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;">
                                        </div>

                                    </div>

                                </div>
                            </div>
                            <!--  End step 1 -->

                            <div class="tab-pane" id="step2">
                                <div class="row">

                                    <div class="col-sm-12">
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label>면적 :</label><br/>
                                                <div class="input-group"
                                                     style="width: 320px; margin: 0px;">
                                                    <div class="input-group-addon">평수</div>
                                                    <input type="number" class="form-control" name="area"/>
                                                    <div class="input-group-addon">평</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="col-sm-12">
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <label>희망 예산 :</label><br/>
                                                    <div class="input-group"
                                                         style="width: 320px; margin-top: 0px; margin-bottom: 0px;">
                                                        <div class="input-group-addon">예산</div>
                                                        <input type="number" class="form-control"
                                                               name="budget_defined"/>
                                                        <div class="input-group-addon">만원</div>
                                                    </div>
                                                    업체 협의
                                                    <input type="checkbox" id="budget_undefined"
                                                           name="budget_undefined">
                                                    <input type="hidden" id="budget" name="budget" value="">
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="col-sm-12">

                                        <div class="col-sm-3" style="width : 250px;">
                                            <div class="form-group">
                                                <label>주거유형</label> <select class="selectpicker show-tick form-control"
                                                                            name="category" id="category">
                                                <option value="" disabled selected>주거유형</option>
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

                                        <div class="col-sm-3" style="width : 250px;">
                                            <div class="form-group">
                                                <label>인테리어 분야</label>
                                                <select class="selectpicker show-tick form-control" name="part"
                                                        id="part">
                                                    <option value="" disabled selected>인테리어 분야</option>
                                                    <option value="종합">종합</option>
                                                    <option value="도배">도배</option>
                                                    <option value="마루">마루</option>
                                                    <option value="욕실">욕실</option>
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
                                                <label>상세 요청 사항 :</label>
                                                <textarea class="form-control" name="require"
                                                          id="exampleFormControlTextarea1" rows="10" placeholder=" <프로젝트의 현재 상황>&#13;&#10;      예시) 디자인 준비 상황, 진행 계획 등&#13;&#10;&#13;&#10; <상세한 업무 내용>&#13;&#10;     예시) 시공내용, 일정 &#13;&#10;&#13;&#10; <참고자료 / 유의사항>&#13;&#10;     예시) 참고사이트, 기타 유의사항 등
                                                            "></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>
                            <!-- End step 2 -->

                            <div class="tab-pane" id="step3">
                                <h4 class="info-text">첨부파일 등록</h4>
                                <div class="row">
                                    <div class="col-sm-6" align="center">
                                        <label>이미지를 드래그 하세요</label>
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
                            <!--  End step 3 -->


                            <div class="tab-pane" id="step4">
                                <h4 class="info-text"> 이용약관 </h4>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="">
                                            <p>
                                                <label><strong>개인정보의 수집 및 이용목적</strong></label><br/>
                                                개인정보의 수집은 아래와 같은 목적을 위하여 수집 합니다 이외의 목적으로는 사용되지 않습니다.<br/>
                                                - 중개플랫폼 서비스를 위한 프로젝트 관리<br/>
                                                - 인테리어 서비스 거래를 위한 계약서 작성<br/>
                                                - 지속적인 서비스 제공을 위한 고객관리<br/><br/>
                                                <label><strong>수집하는 개인정보의 항목</strong></label><br/>
                                                가 본. 공인중개사무소는 고객관리 계약서 , 작성 등 서비스의 제공을 위해 최소한의 개인정보를 수집하고 있습니다.<br/>
                                                나 시스템 . 이용과정이나 사업처리과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.<br/><br/>
                                                <label><strong>개인정보의 보유 및 이용기간</strong></label><br/>
                                                저장된 개인정보는 원칙적으로 개인정보의 수집 및 이용목적이 달성되면 지체 없이 파기합니다.<br/>
                                                단 다음의 , 정보에 대해서는 아래의 이유로 명시한 기간 동안 보존합니다.<br/>
                                            </p>

                                            <div class="checkbox">
                                                <input type="checkbox" id="agree_policy" name="agree_policy"/> <strong> 동의함</strong>
                                            </div>
                                            <div class="checkbox">
                                                <input type="checkbox" id="disagree_policy"  name="disagree_policy" style="margin-left: 50px;"/> <strong> 동의하지 않음           </strong>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--  End step 4 -->

                        </div>

                        <div class="wizard-footer">
                            <div class="pull-right">
                                <input type='button' class='btn btn-next btn-primary' name='next' value='Next'/>
                                <input type='submit' class='btn btn-finish btn-primary ' name='finish' id='finish' value='Finish'/>
                            </div>

                            <div class="pull-left">
                                <input type='button' class='btn btn-previous btn-default' name='previous'
                                       value='Previous'/>
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


<script id="template" type="text/x-handlebars-template">
    <li>
        <div class="mailbox-attachment-info">
            <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
            <a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
            <a href="{{fullName}}"
               class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
            </span>
        </div>
    </li>
</script>

<script>

    var template = Handlebars.compile($("#template").html());

    $(".fileDrop").on("dragenter dragover", function (event) {
        event.preventDefault();
    });


    $(".fileDrop").on("drop", function (event) {
        event.preventDefault();

        var image = event.originalEvent.dataTransfer.files;

        var file = image[0];

        var formData = new FormData();

        formData.append("file", file);


        $.ajax({
            url: '/uploadAjax',
            data: formData,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {

                var fileInfo = getFileInfo(data);

                var html = template(fileInfo);

                $(".uploadedList").append(html);
            }
        });
    });


  /*  $("#registerForm").submit(function (event) {
        event.preventDefault();

        var that = $(this);

        var str = "";
        $(".uploadedList .delbtn").each(function (index) {
            str += "<input type='hidden' name='image[" + index + "]' value='" + $(this).attr("href") + "'> ";
        });

        that.append(str);

        budget_check();
        startDate_check();
        endDate_check();

        if (input_check()) {
            that.get(0).submit();
        }

    });*/

    $(".uploadedList").on("click", ".delbtn", function (event) {
        var that = $(this);
        $.ajax({
            url: "/deleteFile",
            type: "post",
            data: {fileName: $(this).attr("href") },
            dataType:"text",
            success: function (result) {
                if (result == 'deleted') {
                    that.parent("div").remove();
                }
            }
        });
        return false;
    });

    $(document).ready(
        function() {
            $("form")
                .submit(
                    function () {
                        var rv = true;
                        if ($("#title").val() == "") {
                            alert("시공내용을 간략히 입력해주세요");
                            $("#title").focus();
                            return rv = false;
                        } else if ($("#category").val() == null) {
                            alert("주거유형을 선택해주세요");
                            $("#category").focus();
                            return rv = false;
                        } else if ($("#sido1").val() == "") {
                            alert("주소를 선택해주세요");
                            $("#title").focus();
                            return rv = false;
                        } else if ($("#gugun1").val() == "") {
                            alert("주소를 선택해주세요");
                            $("#gugun1").focus();
                            return rv = false;
                        } else if (!$.isNumeric($(
                            'input[type=number][name=area]')
                            .val())) {
                            alert("면적을 입력해주세요(면적은 숫자만 입력 가능합니다)");
                            $("#area").focus();
                            return rv = false;
                        } else if ($("#startDate").val() == ""
                            && $("#undefined_start").is(
                                ":checked") == false) {
                            alert("시공 시작일을 입력해주세요");
                            $("#startDate").focus();
                            return rv = false;
                        } else if ($("#endDate").val() == ""
                            && $("#undefined_end").is(
                                ":checked") == false) {
                            alert("시공 종료일을 입력해주세요");
                            $("#endDate").focus();
                            return rv = false;
                        } else if (!$.isNumeric($(
                                'input[type=number][name=budget_defined]').val())
                            && $("#budget_undefined").is(
                                ":checked") == false) {
                            alert("예산을 입력해주세요");
                            $("#budget").focus();
                            return rv = false;
                        } else if ($("#part").val() == null) {
                            alert("인테리어 분야를 선택해주세요");
                            $("#part").focus();
                            return rv = false;
                        } else if ($("#require").val() == "undefined") {
                            alert("상세 요청사항을 입력해주세요");
                            $("#require").focus();
                            return rv = false;
                        } else if ($("#agree_policy").is(":checked") == false) {
                            alert("이용약관에 동의하지 않으면 본 서비스를 이용하실 수 없습니다.");
                            return rv = false;
                        } else if ($("#disagree_policy").is(":checked") == true) {
                            alert("이용약관에 동의하지 않으면 본 서비스를 이용하실 수 없습니다.");
                            return rv = false;
                        }
                        event.preventDefault();

                        var that = $(this);

                        var str = "";
                        $(".uploadedList .delbtn").each(function (index) {
                            str += "<input type='hidden' name='image[" + index + "]' value='" + $(this).attr("href") + "'> ";
                        });

                        that.append(str);

                        budget_check();
                        startDate_check();
                        endDate_check();

                        that.get(0).submit();
                        alert("게시글이 성공적으로 등록되었습니다")

                    }) // submit() end
        }); // ready() end

</script>


<%@ include file="../include/footer.jspf" %>
<%--<%@ include file="../include/footer1.jspf" %>--%>