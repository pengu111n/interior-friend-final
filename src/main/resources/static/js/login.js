function modal(id) {
    var name = $("#name").val();
    var phoneNum = $("#phoneNum").val();
    $.ajax({
        type:"post",
        url: "/member/findID",

        data: {
            name: name,
            phoneNum: phoneNum,
        },
        success: function(data){
            $("#usernameval").text(data);
        },
        error: function(){
            alert("일치하는 이름이나 전화번호가 없습니다.");
        }
    });
    var zIndex = 9999;
    var modal = $('#' + id);

    var bg = $('<div>')
        .css({
            position: 'fixed',
            zIndex: zIndex,
            left: '0px',
            top: '0px',
            width: '100%',
            height: '100%',
            overflow: 'auto',
            backgroundColor: 'rgba(0,0,0,0.4)'
        })
        .appendTo('body');

    modal
        .css({
            position: 'fixed',
            boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',
            zIndex: zIndex + 1,
            top: '50%',
            left: '50%',
            transform: 'translate(-50%, -50%)',
            msTransform: 'translate(-50%, -50%)',
            webkitTransform: 'translate(-50%, -50%)'
        })
        .show()
        .find('.modal_close_btn')
        .on('click', function() {
            bg.remove();
            modal.hide();
        });
}

$('#popup_open_btn').on('click', function() {
    // 모달창 띄우기
    modal('my_modal');
});