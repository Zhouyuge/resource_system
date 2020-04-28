$(function () {
    stock();

    function stock() {
        var pageNum = getQueryString('pageNum');
        if (pageNum == '') {
            pageNum = 1;
        }

        var str = getQueryString('str');
        var url = '/stock/stocks/' + pageNum;
        if (str != null || str != '') {
            $('#searchVal').val(str);
            var url = '/stock/stocks/' + pageNum + '/' + str;
        }

        var count;
        $.ajaxSettings.async = false;
        $.getJSON(url, function (data) {
            if (data.code == 200) {
                var html = '';
                count = data.page;
                var list = data.data;
                list.map(function (item, index) {
                    html += html += '     <tr>\n' +
                        '                      <th>' + item.materialName + '</th>\n' +
                        '                      <th>' + item.number + '</th>\n' +
                        '                      <th>' +
                        '                        <button onclick="operation(' + item.stockId + ', ' + item.id + ', 1)" class="layui-btn ">入库</button>\n' +
                        '                        <button onclick="operation(' + item.stockId + ', ' + item.id + ', 2)" class="layui-btn layui-btn-danger">出库</button>\n' +
                        '</th>\n' +
                        ' </tr>'
                });
                $('#body').html(html);
                $('#tipCount').append("共 "+ count + " 条数据")
            }
        })

        // 分页代码
        layui.use('laypage', function () {
            var laypage = layui.laypage;
            //执行一个laypage实例
            laypage.render({
                elem: 'page'
                , count: count
                , limit: 10
                , curr: pageNum
                , jump: function (obj, first) {
                    if (!first) {
                        var url = window.location.href;
                        if (url.indexOf("?") > 0) {
                            url = url.split("?")[0];
                            if(str != null) {
                                url += '?pageNum=' + obj.curr + "&" + str;
                            } else {
                                url += '?pageNum=' + obj.curr;
                            }
                        } else {
                            if (str == null) {
                                url += '?pageNum=' + obj.curr;
                            } else {
                                url += '?pageNum=' + obj.curr + "&" + str;
                            }
                        }
                        window.location.href = url;
                    }
                }
            });
        });
    }
})