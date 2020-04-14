$(function () {
    showSquares();

    function showSquares() {
        var pageNum = getQueryString('pageNum');
        if(pageNum == ''){
            pageNum = 1;
        }
        var url = "/square/api/squares/" + pageNum;

        $.getJSON(url, function (data) {
            var list = data.data;
            var html = '';
            list.map(function (item, index) {
                html += '\n' +
                    '            <li>\n' +
                    '                <div style="margin-left: 20px; margin-bottom: 20px">\n' +
                    '                    <a target="_blank" href="/bs/index/sqaure_title_detail?id=' + item.id + '"><span>' + item.titleName + '</span>\n' +
                    '                </div>\n' +
                    '\n' +
                    '                <div style="margin: 20px;" class="layui-row"><div class="layui-col-md10">\n';
                    var labels = item.titleLabels;
                    if(labels.indexOf(" ") != -1 ) {
                        var labels1 = labels.split(" ");
                        for (var i = 0; i < labels1.length; i++) {
                            html += '<span class="layui-badge layui-bg-blue">' + labels1[i] + '</span>\n'
                        }
                    }else
                        if(labels != ''){
                        html += '<span class="layui-badge layui-bg-blue">' + labels + '</span>\n'
                    }
                    html += '<span style="color: #ffffff">123</span></div>\n' +
                    '                    <div class="layui-col-md2"><img class="layui-circle" style="border: #444444 solid 1px; " src="http://39.106.218.135:10086/img/h_img/default.jpg" width="30px" height="30px">\n' +
                    '                    <span style="color: #FD482C">Eureka</span></div>\n' +
                    '                </div >\n' +
                    '\n' +
                    '                <hr style="margin: 20px">\n' +
                    '            </li>';
            });
            $('#ul_info').html(html);
        });

        layui.use('laypage', function () {
            var laypage = layui.laypage;
            //执行一个laypage实例
            laypage.render({
                elem: 'btn' //注意，这里的 btn 是 ID，不用加 # 号
                , count: 400
                , limit: 20
                , curr: pageNum
                , jump: function (obj, first) {
                    if (!first) {
                        var url = window.location.href;
                            if (url.indexOf("?") > 0) {
                                url = url.split("?")[0];
                                url += '?pageNum=' + obj.curr;
                            } else {
                                url += '?pageNum=' + obj.curr;
                            }
                        window.location.href = url;
                    }
                }
            });
        });
    }
});