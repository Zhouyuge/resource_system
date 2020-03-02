$(function(){
    var invi_id = getQueryString('invi_id');

    showInviDetail();

    function showInviDetail() {
        var url = '/invi/api/invitation/' + invi_id;
        $.getJSON(url, function (data) {
            if(data.code == 200) {
                var invi = data.data;
                var html = '';
                html += '<i class="layui-icon layui-icon-reply-fill" style="color: #009f95; font-size: 22px"></i>\n' +
                    '            <span style="font-size: 15px">' + invi.invitationName + '</span>\n' +
                    '            <span class="layui-badge layui-bg-green">置顶</span>\n' +
                    '            <span class="layui-badge">\n' +
                    '                <i style="font-size: 10px;" class="layui-icon layui-icon-fire"></i>\n' +
                    '                <span>烫</span>\n' +
                    '            </span>\n' +
                    '\n' +
                    '            <div style="margin-top: 20px" class="layui-row">\n' +
                    '                <div class="layui-col-md1">\n' +
                    '                    <img width="50px" height="50px" class="layui-circle" src="' + invi.userImg + '" />\n' +
                    '                </div>\n' +
                    '\n' +
                    '                <div class="layui-col-md10" style="margin-left: 10px">\n' +
                    '                    <span style="color: #009f95;">' + invi.userVisualName + '</span>\n' +
                    '                    <div style="margin-top: 20px">\n' +
                    '                        <span style="color: grey; font-size: 12px;">编辑于'+ invi.createTime +'</span>\n' +
                    '                        <span style="color: grey; font-size: 12px; margin-left: 100px">回复' + invi.commentNum + '&nbsp; | </span>\n' +
                    '                        <span style="color: grey; font-size: 12px; margin-left: 10px">赞' + invi.agreeNum + '&nbsp; | </span>\n' +
                    '                        <span style="color: grey; font-size: 12px; margin-left: 10px">浏览' + invi.viewNum + '&nbsp;</span>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </div>';
                $('#header').html(html);
                $('#content').append(invi.invitationContent);
            }
        })
    }

    showAllTopics();

    function showAllTopics(){
        var url = '/invi/api/hot';
        $.getJSON(url, function (data) {
            var hots = data.data;
            var html = '';
            hots.map(function (item, index) {
                html+='<div style="margin: 20px; line-height: 30px">\n' +
                    '            <p>' + item.hotName + '</p>\n' +
                    '            <span style="color: grey;">' + item.viewNum + '人预览</span>\n' +
                    '            <span style="color: grey; margin-left: 10px">' + item.userNum + '人参与</span>\n' +
                    '            <hr style="height: 0px" />\n' +
                    '        </div>';
            });
            $('#hot_list').append(html);
        })
    }

})