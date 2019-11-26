$(function(){
    var url = '/user/api/user';

    getUserInfo();

    function getUserInfo(){
        $.getJSON(url, function (data) {
            var html = '';
            html += '<img class="layui-circle" style="width: 35px; height: 35px" src="' + data.userHeadPic + '" />'
                +'<span style="color: #ffffff">'
                + (data.userVisualName == '' ? data.userName : data.userVisualName) + '</span>';
            $('#user_info').html(html);
            $('#self_blog_author')
                .append((data.userVisualName == '' ? data.userName : data.userVisualName) + '的博客');
            $('#blog_title')
                .append((data.userVisualName == '' ? data.userName : data.userVisualName) + '的博客');

        });
    }
})