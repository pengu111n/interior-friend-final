
var imgTarget = $('.upload-hidden');

    imgTarget.on("change", function () {
        var parent = $(".filebox");




        var file = $("#input_file")[0].files[0]; //선택한 파일리스트를 가져온다.
        var formData = new FormData();

        formData.append("file", file);



        //formData의 file key값을 files[0,1..].file 형식으로 지정한다.

        $.ajax({
            url: "/uploadImg",
            type: "POST",
            data: formData,
            dataType:'text',
            contentType: false,
            processData: false,
            success: function (data) {
                console.log(data);
                $("#fileName").val(data);
                $(".upload-name").val(data);
                var src = data;
                $('.filebox').prepend('<div class="upload-display"><div class="upload-thumb-wrap"><button type="button" data-file="' + src + '" id="x-mark">❌</button><img src=/displayImg?fileName='+src+' class="upload-thumb"></div></div>');


            },
            error : function(err){
                alert("failed!")
                console.log(err)
            }


        });

function checkExtension(fileName, fileSize){

               if(fileSize >= maxSize){
                   alert("파일 사이즈 초과");
                   return false;
               }


               return true;
           }

});

var xmark = $("#x-mark");

$(document).on("click", "#x-mark" ,function(){
        var targetFile = $("#x-mark").data("file");
        const imgbox = document.querySelector(".upload-display");
        imgbox.remove();

        $.ajax({
            url: '/removeImg',
            data: {fileName: targetFile},
            dataType:'text',
            type: 'POST',
            success: function(result){
                alert("삭제되었습니다");
                console.log(result);
                $(".upload-name").val("파일명");
            },
        }) //$.ajax

 })

 function changeFile(){
    var targetFile = $("#x-mark").data("file");

    $.ajax({
        url: '/removeImg',
        data: {fileName: targetFile},
        dataType:'text',
        type: 'POST',
        success: function(result){
            alert("삭제되었습니다");
            console.log(result);
            $(".upload-name").val("파일명");
        },
    }) //$.ajax
 }


