$(function () {
    var id = getQueryString('post_id');
    if(id != '') {
        showPostDetail();
    }
    var fac_id = getQueryString('fac_id');

    if(fac_id != '') {
        showPostByFac();
    }
    function showPostByFac(){
        var url = '/post/api/fac_post/' + fac_id;
        $.getJSON(url, function (data) {
            if(data.success){
                var post = data.data[0];
                var html = '';
                var html2 = '';
                var postList = data.data;
                html += '<div style="margin-top: 20px; margin-bottom: 20px; text-align: center">\n' +
                    '            <img class="layui-circle" width="180px" height="180px" src="' + post.factoryImg + '"/>\n' +
                    '            <a href="post_fac?fac_id=' + post.factoryId + '"><h3><b>' + post.factoryName + '</b></h3></a>  \n' +
                    '        </div>\n' +
                    '\n' +
                    '        <hr style="margin: 20px" />\n' +
                    '\n' +
                    '        <div style="margin: 20px; color: grey">\n' +
                    '            <i class="layui-icon layui-icon-home"></i>\n' +
                    '            <span style="margin-left: 5px">' + post.factoryInfo + '</span>\n' +
                    '            <br/><br/>\n' +
                    '            <i class="layui-icon layui-icon-rmb"></i>\n' +
                    '            <span style="margin-left: 5px">' + post.beListed + '</span>\n' +
                    '            <br/><br/>\n' +
                    '        </div>';

                postList.map(function (item, index) {
                   html2 += '<div style="margin: 20px; border: 1px solid #ebebeb" >\n' +
                       '            <div style="margin: 20px">\n' +
                       '                <a href="post_detail?post_id=' + item.id + '"><h3><b>' + item.postName + '</b></h3></a>\n' +
                       '            </div>\n' +
                       '\n' +
                       '            <div style="margin-left:20px; margin-top: 5px; margin-bottom: 20px">\n' +
                       '                <i style="color: grey; font-size: 14px" class="layui-icon layui-icon-username">' + item.factoryInfo + '</i>\n' +
                       '                <i style="color: grey; font-size: 14px" class="layui-icon layui-icon-location">' + item.postCity + '</i>\n' +
                       '            </div>\n' +
                       '\n' +
                       '            <div style="margin-left: 20px; margin-top: 10px; margin-bottom: 20px">'+ post.postWelfare +'</div></div>'
                });
                $('#factory_detail').html(html);
                $('#post_list').html(html2);
                $('#title').html('岗位列表---' + post.factoryName);
            }
        })
    }

    function  showPostDetail() {
        var url = '/post/api/post_detail/' + id;
        $.getJSON(url, function (data) {
            if(data.success) {
                var post = data.data;
                var html = '';
                var html2 = '';
                html += '<div style="margin: 20px">\n' +
                    '                  <span class="layui-badge-dot"></span>\n' +
                    '                  <b><span style="font-size: 16px;">岗位详情</span></b>\n' +
                    '            </div>\n' +
                    '\n' +
                    '            <div style="margin: 20px; border: 1px solid #131801">\n' +
                    '                <div style="margin: 20px">\n' +
                    '                    <h3 style="font-family: Arial"><b>' + post.postName + '</b></h3>\n' +
                    '                </div>\n' +
                    '\n' +
                    '                <div style="margin-left:20px; margin-top: 5px; margin-bottom: 20px">\n' +
                    '                    <i style="color: grey; font-size: 12px" class="layui-icon layui-icon-username">' + post.factoryInfo + '</i>\n' +
                    '                    <i style="color: grey; font-size: 12px" class="layui-icon layui-icon-location">' + post.postCity + '</i>\n' +
                    '                </div>\n' +
                    '<div style="margin-left: 20px; margin-top: 10px; margin-bottom: 20px">' + post.postWelfare + '</div>' +
                    '\n' +
                    '                <hr class="layui-bg-gray" style="margin: 20px"/>\n' +
                    '\n' +
                    '                <div style="margin: 20px">\n' +
                    '                    <i class="layui-icon layui-icon-find-fill" style="color: #009f95; font-size: 26px"></i>\n' +
                    '                    <b style="font-size: 20px; margin-left: 10px">岗位职责</b><br/><br/>\n' +
                    post.postInfo +
                    '\n' +
                    '                </div>\n' +
                    '\n' +
                    '                <div style="margin: 20px">\n' +
                    '                    <i class="layui-icon layui-icon-template-1" style="font-size: 26px; color: #009f95"></i>\n' +
                    '                    <b style="margin-left: 10px; font-size: 20px">岗位要求</b><br/><br/>\n' +
                    post.postRequirement +
                    '                </div>\n' +
                    '\n' +
                    '                <div style="margin-left: 20px; margin-bottom: 20px">\n' +
                    '                    <button class="layui-btn" style="width: 80px; margin-left: 40%">申请</button>\n' +
                    '                </div>\n' +
                    '            </div>';

                html2 += '<div style="margin-top: 20px; margin-bottom: 20px; text-align: center">\n' +
                    '            <img class="layui-circle" width="180px" height="180px" src="' + post.factoryImg + '"/>\n' +
                    '            <a href="post_fac?fac_id=' + post.factoryId + '"><h3><b>' + post.factoryName + '</b></h3></a>  \n' +
                    '        </div>\n' +
                    '\n' +
                    '        <hr style="margin: 20px" />\n' +
                    '\n' +
                    '        <div style="margin: 20px; color: grey">\n' +
                    '            <i class="layui-icon layui-icon-home"></i>\n' +
                    '            <span style="margin-left: 5px">' + post.factoryInfo + '</span>\n' +
                    '            <br/><br/>\n' +
                    '            <i class="layui-icon layui-icon-rmb"></i>\n' +
                    '            <span style="margin-left: 5px">' + post.beListed + '</span>\n' +
                    '            <br/><br/>\n' +
                    '        </div>'
                $('#post_detail').html(html);
                $('#factory_detail').html(html2);
                $('#title').append(post.postName);
            }
        })
    }
})