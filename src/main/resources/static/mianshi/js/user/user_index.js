$(function(){
    var url = '/user/api/user';

    getUser();

    function getUser(){
        $.getJSON(url, function (data) {
            var html = '';


            html += '<img  class="layui-circle" style="width: 60px; height: 60px" src="' + data.userHeadPic + '" />'
                +'<span style="margin-left: 14px; color: #A2C69A">&nbsp;'
                + (data.userVisualName == '' ? data.userName : data.userVisualName) + '</span>';
                if (data.userSex == 1) {
                    html += '<i class="layui-icon layui-icon-male" style="margin-left 5px;color: #2aabd2;"></i>';
                } else {
                    html += '<i class="layui-icon layui-icon-female" style="margin-left: 5px; color: #FD482C;"></i>';
                }
            $('#imgAndName').html(html);
            $('#self_title').append((data.userVisualName == '' ? data.userName : data.userVisualName) + '的个人主页');
            $('#user_name').append((data.userVisualName == '' ? data.userName : data.userVisualName));
            $('#user_tel').append(data.userTel);
            $('#user_email').append(data.userEmal);
            $('#user_detail').append(data.userDetail);
            $('#user_create_data').append(data.userCreateTime);
            if (data.userSex == 1) {
               $('#user_sex').append('<span class="layui-icon layui-icon-male" style="margin-left: 50px;color: #2aabd2;">男</span>');
               document.getElementsByName("sex")[0].checked = 1;
            } else {
                $('#user_sex').append('<span class="layui-icon layui-icon-female" style="margin-left: 50px; color: #FD482C;">女</span>');
                document.getElementsByName("sex")[0].checked = 1;
            }

            var u = document.getElementsByName("username")[0];
            u.value = data.userVisualName;

            document.getElementsByName("usertel")[0].value = data.userTel;

            document.getElementsByName("useremail")[0].value = data.userEmal;

            document.getElementsByName("desc")[0].value = data.userDetail;
        });
    }
});

function showEdit() {
    var l = document.getElementById("ul_list_info");
    l.style.display = "none";

    var e = document.getElementById("edit_form");
    e.style.display = "inline";
}