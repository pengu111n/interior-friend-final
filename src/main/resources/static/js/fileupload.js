



$(document).ready(function () {
var imgTarget = $('.preview-image .upload-hidden');

    imgTarget.on("change", function () {
        var parent = $(this).parent();
        parent.children('.upload-display').remove();


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
                $('.preview-image').prepend('<div class="upload-display"><div class="upload-thumb-wrap"><i id="x-mark" class="fa fa-remove"></i><img src=/displayImg?fileName='+src+' class="upload-thumb"></div></div>');


            },
            error : function(err){
                alert("failed!")
                console.log(err)
            }
        });
    });
});
function checkExtension(fileName, fileSize){

               if(fileSize >= maxSize){
                   alert("파일 사이즈 초과");
                   return false;
               }


               return true;
           }


