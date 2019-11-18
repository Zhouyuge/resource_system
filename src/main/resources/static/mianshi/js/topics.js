$(function () {
    var url = '/zt/api/categorys';
    getCategorys();

    function getCategorys() {
        var html = '';
        var fHtml = '';
        $.getJSON(url, function (data) {
            if (data.success) {   //成功条件判断
                var types = data.etileTypes;    //定义数据变量
                var i = 1;
                types.map(function (item, index) {
                    if (i < 12) {
                        html += '<div class="layui-col-md3" style="margin-bottom:23px">'
                            + '<a class="topic-info" href = "/bs/index/topics/etiles?category=' + item.etileCategoryId + '">'
                            + '<img src = "' + item.etileCategoryPhoto + '"></a>'
                            + '<div>'
                            + '<strong>' + item.etileCategoryName + '</strong>'
                            + '<div class="clearfix">'
                            + '<div><i class="layui-icon layui-icon-release"/>'
                            + '共有<span>' + item.etileCategoryNum + '</span>题'
                            + '<button onclick="skip(' + item.etileCategoryId + ')" class="layui-btn layui-btn-radius layui-btn-sm" style="position: absolute; left: 60%; top: 90%">马上练习</button>'
                            + '</div></div></div></div>';
                        i++;
                    } else {
                        fHtml += '<div class="layui-col-md2" style="margin:18px">'
                            + '<a class="topic-info" href = "/bs/index/topics/etiles?category=' + item.etileCategoryId + '">'
                            + '<img src = "' + item.etileCategoryPhoto + '"></a>'
                            + '<div>'
                            + '<strong>' + item.etileCategoryName + '</strong>'
                            + '<div class="clearfix">'
                            + '<div><i class="layui-icon layui-icon-release"/>'
                            + '共有<span>' + item.etileCategoryNum + '</span>题'
                            + '<button onclick="skip(' + item.etileCategoryId + ')" class="layui-btn layui-btn-radius layui-btn-sm" style="position: absolute; left: 60%; top: 90%">马上练习</button>'
                            + '</div></div></div></div>';
                    }
                });
                $('#type').html(html);
                $('#f_type').html(fHtml);
            }
        });
    }

});