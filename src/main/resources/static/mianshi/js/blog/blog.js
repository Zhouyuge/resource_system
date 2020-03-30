$(function () {
    $(document).ready(function () {
        var limit = 10;
        layui.use('flow', function () {
            var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
            var flow = layui.flow;
            flow.load({
                elem: '#LAY_demo1' //指定列表容器
                , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
                    //页数
                    //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                    $.getJSON('/bc/api/blog/' + page, function (res) {
                        if (res.success) {
                            var lis = [];
                            //假设你的列表返回在data集合中
                            layui.each(res.blogDtos, function (index, value) {
                                var html = '<li><div style="margin: 15px">'
                                    + '<img style="width: 40px; height: 40px" class="layui-circle" src="' + value.user.userHeadPic + '">'
                                    + '<span style="color: #31b0d5; margin-left: 5px">' + value.user.userVisualName + '</span>'
                                    + '</div>'
                                    + '<div style="width: 700px;margin-left: 15px">'
                                    + '<h3><a href="/bs/index/study/detail_blog?id=' + value.blogCenterId + '">' + value.blogCenterName + '</a></h3><br/>'
                                    + '<span style="color: #5f5f5f;">' + value.blogCenterVlog + '</span>'
                                    + '</div><br/>'
                                    + '<div style="margin-left: 15px;">'
                                    + '<span>来自          </span>'
                                    + '<span style="color: #d5d5d5">' + value.user.userName + '的博客</span>'
                                    + '<div align="right" style="margin-right: 60px">'
                                    + '<a onclick="change_state(this)"><i class="layui-icon layui-icon-praise" style=" width: 25px; height: 25px"><span>' + value.blogCenterAgree + '</span></i></a>'
                                    + '<a onclick="change_state(this)"><i class="layui-icon layui-icon-star" style="margin-left: 30px; width: 25px; height: 25px"><span>' + value.blogCenterCollect + '</span></i></a>'
                                    + '</div>'
                                    + '</div>'
                                    + '<div style="margin: 10px" align="right"><span style="color: #C2BE9E">' + value.blogCenterEditTime + '</span></div>'
                                    + '<li><hr class="layui-bg-grey" />';

                                lis.push(html);
                            });
                            //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                            //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                            next(lis.join(''), page < res.pages);
                        }
                    });
                }
            });
        });
    });
});