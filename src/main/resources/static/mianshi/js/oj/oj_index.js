$(function () {

    showOJTitles();

    function showOJTitles(){
        var page = getQueryString("page");
        if(page == ''){
            page = 1;
        }

        var count;

        var url = '/problem/api/pros/' + page;
        $.ajaxSettings.async = false;
        $.getJSON(url, function (data) {
            var list = data.data;
            var html = '';
            count = data.page;
            list.map(function (item, index) {
                html += ' <tr>\n' +
                    '        <td><span style="color: #333333; font-size: 16px; margin: 5px">' + item.problemLabel + '</span></td>\n' +
                    '        <td><a href="/bs/index/oj_detail?oj_id=' + item.problemId + '" target="_blank"><span style="color: #333333; font-size: 16px; margin: 5px">' + item.problemName + '</span></a></td>\n' +
                    '        <td><span style="color: #333333; font-size: 16px; margin: 5px">' + item.problemDifficulty + '</span></td>\n';
                    if(item.totalSubmitCount == 0){
                        html += '    <td><span style="color: #333333; font-size: 16px; margin: 5px">0.0%</span></td>\n' +
                        ' </tr>';

                    }else {
                        html += '    <td><span style="color: #333333; font-size: 16px; margin: 5px">' + ((item.totalRightCount / item.totalSubmitCount) * 100).toFixed(2) + '%</span></td>\n' +
                        ' </tr>';
                    }
            })
            $('#tbody').html(html);
        });


        layui.use('laypage', function () {
            var laypage = layui.laypage;
            //执行一个laypage实例
            laypage.render({
                elem: 'demo0' //注意，这里的 demo0 是 ID，不用加 # 号
                , count: count
                , limit: 20
                , curr: page
                , jump: function (obj, first) {
                    if (!first) {
                        var url = window.location.href;
                        if (url.indexOf("?") > 0) {
                            url = url.split("?")[0];
                            url += '?page=' + obj.curr;
                        } else {
                            url += '?page=' + obj.curr;
                        }
                        window.location.href = url;
                    }
                }
            });
        });
    }

})