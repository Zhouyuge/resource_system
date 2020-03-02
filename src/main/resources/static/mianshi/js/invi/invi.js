$(function () {
    $(document).ready(function () {
        var limit = 10;
        var typeId = getQueryString('type_id');
        if (typeId == '') {
            typeId = 0;
        }
        layui.use('flow', function () {
            var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
            var flow = layui.flow;
            flow.load({
                elem: '#talk_list' //指定列表容器
                , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
                    //页数
                    //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                    $.getJSON('/invi/api/invis/' + page + '/' + typeId, function (res) {
                        if (res.code == 200) {
                            var lis = [];
                            //假设你的列表返回在data集合中
                            layui.each(res.data, function (index, value) {
                                var html = '<li>\n' +
                                    '    <div style="margin-left: 20px;margin-top: 20px; margin-bottom: 20px " class="layui-row">\n' +
                                    '        <div class="layui-col-md1">\n' +
                                    '            <img width="50px" height="50px" class="layui-circle" src="' + value.userImg + '" />\n' +
                                    '        </div>\n' +
                                    '\n' +
                                    '        <div class="layui-col-md10" style="margin-left: 5px">\n' +
                                    '            <a href="talk_detail?invi_id=' + value.id + '"><span>' + value.invitationName + '</span></a>\n' +
                                    '            <span class="layui-badge layui-bg-green">置顶</span>\n' +
                                    '            <span class="layui-badge">\n' +
                                    '                <i class="layui-icon layui-icon-fire"></i>\n' +
                                    '                <span>烫</span>\n' +
                                    '            </span>\n' +
                                    '            <div style="margin-top: 20px" class="layui-row">\n' +
                                    '                <span style="color: #009f95; font-size: 12px" class="layui-col-md2" title="' + value.userVisualName + '">' + value.simpleName + '</span>\n' +
                                    '                <span style="color: grey; font-size: 12px;" class="layui-col-md2">' + value.createTime + '</span>\n' +
                                    '                <span style="color: grey; font-size: 12px;" class="layui-col-md3"> 发表在 [招聘信息]</span>\n' +
                                    '                <div class="layui-col-md-offset1 layui-col-md4">\n' +
                                    '                    <span style="color: grey; font-size: 12px;">回复' + value.commentNum + ' | </span>\n' +
                                    '                    <span style="color: grey; font-size: 12px;">赞' + value.agreeNum + ' | </span>\n' +
                                    '                    <span style="color: grey; font-size: 12px;">浏览' + value.viewNum + '</span>\n' +
                                    '                </div>\n' +
                                    '            </div>\n' +
                                    '        </div>\n' +
                                    '    </div>\n' +
                                    '    <hr style="margin: 20px"/>\n' +
                                    '            </li>'
                                lis.push(html);
                            });
                            //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                            //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                            next(lis.join(''), page < res.page);
                        }
                    });
                }
            });
        });
        var type_hrefs = [];
        type_hrefs = $(".type_href");
        type_hrefs[typeId].classList.add("layui-btn");
        type_hrefs[typeId].classList.add("layui-btn-sm");
    });

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
                    '            <hr/>\n' +
                    '        </div>';
            });
            $('#hot_list').append(html);
        })
    }
})