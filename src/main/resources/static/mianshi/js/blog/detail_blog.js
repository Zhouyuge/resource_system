$(function () {
    var id = getQueryString('id');
    if (id == '' || id <= 0) {
        id = 1;
    }

    var url = "/bc/api/blog_detail/" + id;

    getBlog();

    function getBlog() {
        var html = '';
        $.getJSON(url, function (data) {
            var res = data.blog;

            html += '<h2>' + res.blogCenterName + '</h2>'
                + '<br/>'
                + '<span style="color: grey">' + res.blogCenterEditTime + '</span>'
                + '<br/><div style="margin-top: 20px; margin-bottom: 20px">'
                + '<img style="width: 40px; height: 40px" class="layui-circle" src="' + res.blogCenterPic + '">'
                + '<span style="color: #31b0d5; margin-left: 5px">' + res.blogCenterAuthor + '</span>'
                + '</div>'
                + '<div style="border: 1px solid #c8e5bc">'
                + res.blogCenterContent
                + '</div>'
                + '<div align="center">'
                + '<a onclick="change_state(this)"><i class="layui-icon layui-icon-praise" style="font-size: 30px;"><span>' + res.blogCenterAgree + '</span></i></a>'
                + '<a onclick="change_state(this)"><i class="layui-icon layui-icon-star" style="margin-left: 90px;  font-size: 30px;"><span>' + res.blogCenterCollect + '</span></i></a>'
                + '</div>';
            $('#circle').html(html);
            $('#title').append(res.blogCenterName);
        });
    }
});