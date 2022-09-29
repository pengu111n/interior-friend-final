$(document).ready(function(){

    var formObj = $("form[role='form']");

    console.log(formObj);

    $(".btn-warning").on("click", function(){
        formObj.attr("action", "/board/modifyPage");
        formObj.attr("method", "get");
        formObj.submit();
    });

    $(".btn-danger").on("click", function(){
        formObj.attr("action", "/board/deletePage");
        formObj.submit();
    });

    $(".btn-primary").on("click", function(){
        formObj.attr("method", "get");
        formObj.attr("action", "/board/listPage");
        formObj.submit();
    });

});