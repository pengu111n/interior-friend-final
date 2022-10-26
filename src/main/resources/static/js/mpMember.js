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
    //url: "/member/register/uploadAjax",
    url: "/mypage/member/modify/uploadAjax",
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
    //url: "/member/register/deleteFile",
    url: "/mypage/member/modify/deleteFile",
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

function changeRank(){
  var r = document.getElementById("rank");
  var innerR = r.options[r.selectedIndex].value;

  if (innerR == 2) {
    document.getElementById("compInput").innerHTML =
      '<label for="companyNo">사업자번호</label><input type="text" class="form-control" id="companyNo" name="companyNo" placeholder="사업자번호" onblur="emptyCompanyNo()"><span class="empty emptyCN">필수 정보입니다.</span>';

    document.getElementById("label_name").innerHTML = "기업명";
    $("#name").attr("placeholder", "기업명");

  } else {
    document.getElementById("compInput").innerHTML = "";

    document.getElementById("label_name").innerHTML = "이름"
    $("#name").attr("placeholder", "이름");
  }
}

function selectEmail() {
  var email = document.getElementById("email2");
  var innerE = email.options[email.selectedIndex].value;

  if (innerE == "other") {
    document.getElementById("otherEmail").removeAttribute("disabled");
    email.options[email.selectedIndex].value = "";
  } else {
    document.getElementById("otherEmail").setAttribute("disabled", "true");
    document.getElementById("otherEmail").value = "";
    if (email.options[5]) {
      email.options[5].value = "other";
    }
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
var idRegex = /^[a-z]+[a-z0-9]{5,19}$/;

function usernameCheck() {
  var username = $("#username").val();
  $.ajax({
    url: "/member/usernameCheck",
    type: "post",
    dataType: "json",
    data: { username: username },
    success: function (data) {
      if (data == 1) {
        $("#dupId").show();
        $(".regexId").hide();
        $(".emptyID").hide();
        $(".successId").hide();
        return false;
      } else if (id == "") {
        $(".successId").hide();
        $("#dupId").hide();
        $(".regexId").hide();
        $(".emptyID").show();
      } else if (!idRegex.test($("#id").val())) {
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
  if ($("#id").val() == null || $("#id").val() == "") {
    alert("아이디를 입력해주세요.");
    $("#id").focus();
    return false;
  }

  if ($("#nickName").val() == null || $("#nickName").val() == "") {
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

function SUMaddress() {
  var realAddress = document.getElementById("address");
  var fakeAddress =
    $("#sample4_roadAddress").val() + " " + $("#sample4_detailAddress").val();
  realAddress.setAttribute("value", fakeAddress);
}

function regexPW() {
  var regExp =
    /^(?!((?:[A-Za-z]+)|(?:[~!@#$%^&*()_+=]+)|(?=[0-9]+))$)[A-Za-z\d~!@#$%^&*()_+=]{8,}$/;
  var pw = $("#pw").val();

  if (pw == "") {
    $(".emptyPW").show();
    $(".regexPW").hide();
  } else if (!regExp.test($("#pw").val())) {
    $(".regexPW").show();
    $(".emptyPW").hide();
  } else {
    $(".emptyPW").hide();
    $(".regexPW").hide();
  }
}

function regexPhone(){
    var regExp = /^[0-9]{2,3}[0-9]{3,4}[0-9]{4}/;
    var phoneNum = $("#phoneNum").val();


      if (phoneNum == "") {
        $(".emptyPhone").show();
        $(".regPhone").hide();
      }else if(!regExp.test(phoneNum)){
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
  } else if (confirmPw == "") {
    $(".emptyPW1").show();
    $(".samePW").hide();
  } else {
    $(".samePW").hide();
    $(".emptyPW1").hide();
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
  let birth = $("#yy").val();

  if (birth == "") {
    $(".lengthCK").css("display", "block");
  }else if(birth.length != 4){
    $(".lengthCK").css("display", "block");
  } else {
    $(".lengthCK").hide();
  }

}

function emptyDay(){
    let dd = $("#dd").val();

    if(dd == ""){
        $(".emptyBirth").css("display", "block");
    }else{
        $(".emptyBirth").hide();
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


for (var i = 1; i <= 12; i++) {
  var mm = i > 9 ? i : "0" + i;
  $(".month").append('<option value="' + mm + '">' + mm + "월</option>");
}

$(document).ready(function() {
        var formObj = $("form[role='form']");
        console.log(formObj);
        $(".btn-modify").on("click", function() {
            formObj.attr("action", "/mypage/member/modify");
            formObj.attr("method", "get");
            formObj.submit();
        });
        $(".btn-leave").on("click", function() {
            formObj.attr("action", "/mypage/member/remove");
            formObj.submit();
        });
    });