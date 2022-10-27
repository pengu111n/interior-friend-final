//var template = Handlebars.compile($("#template").html());

$(".fileDrop").on("dragenter dragover", function (event) {
  event.preventDefault(); // 기본효과를 막음
});
$(".fileDrop").on("drop", function (event) {
  event.preventDefault(); // 기본효과를 막음
  // 드래그된 파일의 정보
  var files = event.originalEvent.dataTransfer.files;
  // 첫번째 파일
  var file = files[0];
  // 콘솔에서 파일정보 확인
  console.log(file);

  var formData = new FormData();
  formData.append("file", file);

  $.ajax({
    type: "post",
    url: "/member/register/uploadAjax",
    data: formData,
    processData: false,
    dataType: "text",
    contentType: false,
    success: function (data) {
      console.log(data);
      var fileInfo = getFileInfo(data);

      var html = template(fileInfo);

      $(".uploadedList").append(html);
    },
    error: function (result) {
      alert("이미지 파일이 아닙니다");
      return false;
    },
  });
});

$(".uploadedList").on("click", ".delbtn", function (event) {
  event.preventDefault();
  var that = $(this);
  $.ajax({
    url: "/member/register/deleteFile",
    type: "post",
    data: { fileName: $(this).attr("href") },
    dataType: "text",
    success: function (result) {
      if (result == "deleted") {
        alert("삭제되었습니다.");
        that.parents("li").remove();
      }
    },
  });
});
var auth;
$("#confirmEmailBtn").click(function (event) {
  event.preventDefault();
  $.ajax({
    type: "POST",
    url: "/member/confirmMail",
    data: { email : $("#email").val() },
    success: function (data) {
      $(".invalidEmail").hide()
      $(".sendMail").show();
      console.log(data);
      auth = data;
      $("#confirmEmailBtn").attr("disabled", true);
      return false;
    },
    error: function(){
        $(".invalidEmail").show()
    }
  });
});




function onKeyMailConfirm(){
    if(auth != $("#confirmMailText").val()){
        $(".notMatchAuth").show()
        $(".success").hide()
    }else{
        $(".notMatchAuth").hide()
        $(".success").show()
    }
}

function changeRank() {
  var r = document.getElementById("rank");
  var innerR = r.options[r.selectedIndex].value;

  if (innerR == 2) {
    document.getElementById("compInput").innerHTML =
      '<label for="companyNo">사업자번호</label><input type="text" class="form-control" id="companyNo" name="companyNo" placeholder="사업자번호" onblur="emptyCompanyNo()"><span class="empty emptyCN">필수 정보입니다.</span>';

    document.getElementById("nickname__label").innerHTML = "기업명";
    $("#name").attr("placeholder", "기업명");
  } else {
    document.getElementById("compInput").innerHTML = "";

    document.getElementById("nickname__label").innerHTML = "닉네임";
    $("#name").attr("placeholder", "닉네임");
  }
}

function enterkey() {
  if (window.event.keyCode == 13) {
    fn_reg();
  }
}

function checkNumber(event) {
  if (event.key >= 0 && event.key <= 9) {
    return true;
  }

  return false;
}

var idPass;

function idCheck() {
  var usernameRegex = /^[a-z]+[a-z0-9]{5,19}$/;
  var username = $("#username").val();
  $.ajax({
    url: "/member/usernameCheck",
    type: "post",
    dataType: "json",
    data: { username: username },
    success: function (data) {
      console.log(data);
      if (data == 1) {
        $("#dupId").show();
        $(".regexId").hide();
        $(".emptyID").hide();
        $(".successId").hide();
      } else if (username == "") {
        $(".successId").hide();
        $("#dupId").hide();
        $(".regexId").hide();
        $(".emptyID").show();
      } else if (!usernameRegex.test($("#username").val())) {
        $(".successId").hide();
        $("#dupId").hide();
        $(".regexId").show();
        $(".emptyID").hide();
      } else {
        $(".successId").show();
        $("#dupId").hide();
        $(".regexId").hide();
        $(".emptyID").hide();
      }
    },
  });
}

function nicknameCheck() {
  var nickname = $("#nickname").val();
  $.ajax({
    url: "/member/nicknameCheck",
    type: "post",
    dataType: "json",
    data: { nickname: nickname },
    success: function (data) {
      console.log(data);
      if (data == 1) {
        $(".nicknameCK").show();
        $(".emptynickname").hide();
        return false;
      } else if (nickname == "") {
        $(".emptynickname").show();
        $(".nicknameCK").hide();
      } else {
        $(".nicknameCK").hide();
        $(".emptynickname").hide();
      }
    },
  });
}

function fnSubmit() {
  if ($("#username").val() == null || $("#username").val() == "") {
    alert("아이디를 입력해주세요.");
    $("#username").focus();
    return false;
  }

  if ($("#nickname").val() == null || $("#nickName").val() == "") {
    alert("닉네임을 입력해주세요.");
    $("#nickName").focus();
    return false;
  }

  if ($("#pw").val() == null || $("#pw").val() == "") {
    alert("비밀번호를 입력해주세요.");
    $("#pw").focus();

    return false;
  }

  if ($("#confirmPw").val() == null || $("#confirmPw").val() == "") {
    alert("비밀번호 확인을 입력해주세요.");
    $("#confirmPw").focus();

    return false;
  }

  if ($("#pw").val() != $("#confirmPw").val()) {
    alert("비밀번호가 일치하지 않습니다.");
    $("#memberPw2").focus();

    return false;
  }

  if ($("#name").val() == null || $("#name").val() == "") {
    alert("이름을 입력해주세요.");
    $("#name").focus();
    return false;
  }

  if ($("#phoneNum").val() == null || $("#phoneNum").val() == "") {
    alert("전화번호을 입력해주세요.");
    $("#phoneNum").focus();

    return false;
  }
  if ($("#phoneNum").val() == null || $("#phoneNum").val() == "") {
    alert("전화번호을 입력해주세요.");
    $("#phoneNum").focus();

    return false;
  }
  if ($("#email").val() == null || $("#email").val() == "") {
    alert("이메일을 입력해주세요.");
    $("#email").focus();

    return false;
  }

  if (confirm("회원가입하시겠습니까?")) {
    $("#join").submit();
  } else {
    return false;
  }
}

function regexPW() {
  var regExp =
    /^(?!((?:[A-Za-z]+)|(?:[~!@#$%^&*()_+=]+)|(?=[0-9]+))$)[A-Za-z\d~!@#$%^&*()_+=]{8,}$/;
  var pw = $("#pw").val();
  if (pw == "") {
    $(".emptyPW").show();
    $(".regexPW").hide();
    $(".successPW").hide();
  } else if (!regExp.test($("#pw").val())) {
    $(".regexPW").show();
    $(".emptyPW").hide();
    $(".successPW").hide();
  } else {
    $(".emptyPW").hide();
    $(".regexPW").hide();
    $(".successPW").show();
  }
}

function regexPhone() {
  var regExp = /^[0-9]{2,3}[0-9]{3,4}[0-9]{4}/;
  var phoneNum = $("#phoneNum").val();

  if (phoneNum == "") {
    $(".emptyPhone").show();
    $(".regPhone").hide();
  } else if (!regExp.test(phoneNum)) {
    $(".emptyPhone").hide();
    $(".regPhone").show();
  } else {
    $(".emptyPhone").hide();
    $(".regPhone").hide();
  }
}

function confirmPW() {
  var pw = $("#pw").val();
  var confirmPw = $("#confirmPw").val();

  if (pw != confirmPw) {
    $(".samePW").show();
    $(".emptyPW1").hide();
    $(".successPW1").hide();
  } else if (confirmPw == "") {
    $(".emptyPW1").show();
    $(".samePW").hide();
    $(".successPW1").hide();
  } else {
    $(".samePW").hide();
    $(".emptyPW1").hide();
    $(".successPW1").show();
  }
}

function emptyName() {
  let name = $("#name").val();

  if (name == "") {
    $(".emptyName").show();
  } else {
    $(".emptyName").hide();
  }
}
function emptyBirth() {
  let yy = $("#yy").val();

  if (yy == "") {
    $(".lengthCK").css("display", "block");
  } else if (yy.length != 4) {
    $(".lengthCK").css("display", "block");
  } else {
    $(".lengthCK").hide();
  }
}

function fourinput(object){
    if (object.value.length > object.maxLength){
            object.value = object.value.slice(0, object.maxLength);
          }
}
function emptyDay(object) {
  let dd = $("#dd").val();

  if (dd == "") {
    $(".emptyBirth").css("display", "block");
  } else {
    $(".emptyBirth").hide();
  }
if (object.value.length > object.maxLength){
        object.value = object.value.slice(0, object.maxLength);
      }

}

function emptyMail() {
  let email = $("#email").val();

  if (email == "") {
    $(".emptyMail").show();
  } else {
    $(".emptyMail").hide();
  }
}

function emptyCompanyNo() {
  let companyNo = $("#companyNo").val();

  if (companyNo == "") {
    $(".emptyCN").show();
  } else {
    $(".emptyCN").hide();
  }
}

let index = {
	init: function(){
		$(".btn-save").on("click",()=>{	//function(){} 대신 ()=>{} : this를 바인딩하기 위해서
		this.update();
		});
	},

        update : function(){
		//alert('user의 save함수 호출됨');
		let data = {
			id: $("#id").val(),
			username: $("#username").val(),
			pw: $("#pw").val(),
			email: $("#email").val(),
			rank: $("#rank").val(),
			companyNo: $("#companyNo").val(),
			nickname: $("#nickname").val(),
			name: $("#name").val(),
			birth: $("#birth").val(),
			roadAddress: $("#sample4_roadAddress").val(),
			detailAddress: $("#sample4_detailAddress").val(),
			phoneNum: $("#phoneNum").val(),
			fileName: $("#fileName").val()
		};
		$.ajax({
			//회원정보 수정 요청
			type: "PUT",
			url: "/api/modify",
			data: JSON.stringify(data),		//http body 데이터
			contentType: "application/json; charset=utf-8",	//body 데이터가 어떤 타입인지(MIME)

			//응답 결과가 정상일 때
		}).done(function(resp){
			alert("회원수정이 완료되었습니다.");
			//console.log(resp);
			location.href="/mypage/member/get";
			//실패일 때
		}).fail(function(error){
		    console.log(error);
			alert(JSON.stringify(error));
		});

	}

}
index.init();
$(document).ready(function(){
for (var i = 1; i <= 12; i++) {
  var mm = i > 9 ? i : "0" + i;
  $(".month").append('<option value="' + mm + '">' + mm + "</option>");
}

for (var j = 2021; j >= 1922; j--) {
  var yy = j > 9 ? j : "0" + j;
  $(".year").append('<option value="' + yy + '">' + yy + "</option>");
}

for (var k = 1; k <= 31; k++) {
  var dd = k > 9 ? k : "0" + k;
  $(".day").append('<option value="' + dd + '">' + dd + "</option>");
}
var formObj = $("form[role='form']");
        console.log(formObj);
        $(".btn-cancle").on("click", function () {
            self.location = "/mypage/member/get";
        });
});






