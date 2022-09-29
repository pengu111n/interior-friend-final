<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../include/header.jspf" %>
<%@ include file="../../include/myPageHeader.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>회원정보 수정</title>
</head>
<body>

<div class="register-area" style="background-color: rgb(249, 249, 249);">
    <div class="container">
        <div class="col-md-6">
            <div class="box-for overflow">
                <div class="col-md-12 col-xs-12 register-blocks">
                    <form role="form" method="post">
                        <input type=hidden name="auth" id="auth" value="${login.auth}"/>
                        <h2>회원정보 수정 :</h2>
                        <div class="form-group">
                            <label for="rank">회원분류</label>
                            <input type="text" class="form-control" id="rank" name="rank" value="${login.rank}"
                                   readonly="readonly">
                        </div>
                        <c:if test="${login.rank == 2}">
                            <div class="form-group">
                                <label for="companyNo">사업자번호</label>
                                <input type="text" class="form-control" id="companyNo" name="companyNo"
                                       value="${login.companyNo}">
                            </div>
                        </c:if>
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" id="id" name="id"
                                   value="${login.id}" readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label for="nickname">닉네임</label>
                            <input type="text" class="form-control" id="nickName" name="nickName"
                                   value="${login.nickName}">
                        </div>
                        <div class="form-group">
                            <label for="pw">비밀번호</label>
                            <input type="password" class="form-control" id="pw" name="pw"
                                   value="${login.pw}">
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" id="name" name="name"
                                   value="${login.name}" readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label for="birth">생년월일</label>
                            <input type="text" class="form-control" id="birth" name="birth"
                                   value="${login.birth}" readonly="readonly"
                                   onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
                        </div>
                        <div class="form-group">
                            <label for="address">주소</label>
                            <input type="text" class="form-control" id="address" name="address"
                                   value="${login.address}">
                        </div>
                        <div class="form-group">
                            <label for="phoneNum">전화번호</label>
                            <input type="text" class="form-control" id="phoneNum" name="phoneNum"
                                   value="${login.phoneNum}"
                                   onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
                        </div>
                        <div class="form-group">
                            <label for="email">이메일</label>
                            <input type="text" class="form-control" id="email" name="email"
                                   value="${login.email}">
                        </div>
                        <div class="form-group">
                            <label>회원이미지</label>
                            <div class="fileDrop">
                                <br/>
                                <br/>
                                <br/>
                                <p class="text-center"><i class="fa fa-paperclip"></i> 첨부파일을 드래그해주세요.</p>
                                <br/>
                            </div>
                            <ul class="mailbox-attachments clearfix uploadedList">
                            </ul>
                        </div>
                    </form>
                    <div class="text-center">
                        <button type="submit" class="btn btn-warning" style="float: left;">저장</button>
                        <button type="submit" class="btn btn-danger" style="float: right;">취소</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
    .fileDrop {
        width: 100%;
        height: 200px;
        border: 2px dotted #0b58a2;
    }
</style>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/address.js"></script>

<script type="text/javascript" src="/resources/js/mpMemberUpload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<script id="template" type="text/x-handlebars-template">
    <li>
        <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
        <div class="mailbox-attachment-info">
            <a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
            <a href="{{fullName}}"
               class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
            <input type=hidden name="fullName" id="fullName" value="{{fullName}}"/>
        </div>
    </li>
</script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="/resources/js/mpMember.js"></script>
<script>
    $(document).ready(function () {
        var formObj = $("form[role='form']");
        console.log(formObj);
        $(".btn-danger").on("click", function () {
            self.location = "/mypage/member/get?memNo="+${login.memNo};
        });
        $(".btn-warning").on("click", function () {
            formObj.submit();
        });
    });
</script>

</body>
</html>

<%@ include file="../../include/footer.jspf" %>