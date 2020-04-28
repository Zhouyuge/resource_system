$(function () {
    showMate();

    function showMate() {
        // 获取页码
        var pageNum = getQueryString("pageNum");
        // 默认为第一页
        if (pageNum == '') {
            pageNum = 1;
        }
        var str = getQueryString("str");
        if(str == ''){
            str = null;
        }
        // 后台接口,是否模糊查询
        var url = '/mate/mates/' + pageNum + '/' + str;
        $('#searchVal').val(str);
        var count;
        // 关闭异步，设置同步
        $.ajaxSettings.async = false;
        $.getJSON(url, function (data) {
            if (data.code == 200) {
                var list = data.data;
                var html = '';
                list.map(function (item, index) {
                    // 动态拼接html
                    html += '     <tr>\n' +
                        '                      <th>' + item.materialName + '</th>\n' +
                        '                      <th>' + item.materialInfo + '</th>\n' +
                        '                      <th>' + item.categoryName + '</th>\n' +
                        '                      <th>' + item.materialSpeci + '</th>\n';
                        if (item.materialImg != null && item.materialImg != '') {
                           html +=  '                      <th>' + item.materialImg + '</th>\n';
                        } else {
                            html += '        <th><button class="layui-btn layui-btn-sm layui-btn-warm">上传图片</button></th>';
                        }
                        html +=  '                      <th>\n' +
                        '                        <button onclick="updateCate(' + item.id + ')" class="layui-btn layui-btn-sm">修改</button>\n' +
                        '                        <button onclick="deleteCate(' + item.id + ')" class="layui-btn layui-btn-danger layui-btn-sm">删除</button>\n' +
                        '                      </th>\n' +
                        '                    </tr>\n';
                });
                count = data.page;
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