$(function () {
    var url = '/cw/api/coin_wares';

    getWares();

    function getWares() {
        var n_html = '<ul>';     //牛客定制
        var hz_html = '<ul>';     //热门周边
        var hw_html = '<ul>';    //热门商品
        var b_html = '<ul>';     //专业书籍
        $.getJSON(url, function (data) {
            if (data.success) {
                var wares = data.ware;
                wares.map(function (item, index) {
                    if (item.coinWareTypeName == '牛客定制') {
                        n_html += '<div class="layui-col-md3" style="text-align:center ; border: 1px solid grey; margin: 25px; height: 200px">'
                            + '<img align="center" style="width: 160px; height: 120px" src="' +  item.coinWareBigPic + '"/>'
                            + '<br>'
                            + '<span style="text-align:center ; color: #737373">' + item.coinWareName + '</span><br/>'
                            + '<button  id="btn' + item.coinWareId + '" onclick="getDetail(this)" data-method="notice" data-type="auto" type="button" style="position: absolute; left: 0%; top:80%; width: 100%; height: 20%" class="layui-btn layui-btn-danger"><span style="font-size: 16px">兑 &nbsp;&nbsp;&nbsp; 换</button>'
                            + '<span style="position: absolute; left: 3%; top: 5%" class="layui-badge"><i class="layui-icon layui-icon-rmb">' + item.coinWarePrice + '</i></span>'
                            + '</div>';
                    }
                    if (item.coinWareTypeName == '热门商品') {
                        hw_html += '<div class="layui-col-md3" style="text-align:center ;border: 1px solid grey; margin: 25px; height: 200px">'
                            + '<img align="center" style="width: 160px; height: 120px" src="' +  item.coinWareBigPic + '"/>'
                            + '<br>'
                            + '<span style="text-align:center ;color: #737373">' + item.coinWareName + '</span><br/>'
                            + '<button  id="btn' + item.coinWareId + '" onclick="getDetail(this)" data-method="notice" data-type="auto" type="button" style="position: absolute; left: 0%; top:80%; width: 100%; height: 20%" class="layui-btn layui-btn-danger"><span style="font-size: 16px">兑 &nbsp;&nbsp;&nbsp; 换</button>'
                            + '<span style="position: absolute; left: 3%; top: 5%" class="layui-badge"><i class="layui-icon layui-icon-rmb">' + item.coinWarePrice + '</i></span>'
                            + '</div>';
                    }

                    if (item.coinWareTypeName == '名企周边') {
                        hz_html += '<div class="layui-col-md3" style="text-align:center ; border: 1px solid grey; margin: 25px; height: 200px">'
                            + '<img align="center" style="width: 160px; height: 120px" src="' +  item.coinWareBigPic + '"/>'
                            + '<br>'
                            + '<span style="text-align:center ;color: #737373">' + item.coinWareName + '</span><br/>'
                            + '<button  id="btn' + item.coinWareId + '" onclick="getDetail(this)" data-method="notice" data-type="auto" type="button" style="position: absolute; left: 0%; top:80%; width: 100%; height: 20%" class="layui-btn layui-btn-danger"><span style="font-size: 16px">兑 &nbsp;&nbsp;&nbsp; 换</button>'
                            + '<span style="position: absolute; left: 3%; top: 5%" class="layui-badge"><i class="layui-icon layui-icon-rmb">' + item.coinWarePrice + '</i></span>'
                            + '</div>';
                    }

                    if (item.coinWareTypeName == '专业书籍') {
                        b_html += '<div class="layui-col-md3" style="text-align:center ; border: 1px solid grey; margin: 25px; height: 200px ">'
                            + '<img align="center" style="width: 160px; height: 120px" src="' +  item.coinWareBigPic + '"/>'
                            + '<br>'
                            + '<span style="color: #737373">' + item.coinWareName + '</span><br/>'
                            + '<button  id="btn' + item.coinWareId + '" onclick="getDetail(this)" data-method="notice" data-type="auto" type="button" style="position: absolute; left: 0%; top:80%; width: 100%; height: 20%" class="layui-btn layui-btn-danger"><span style="font-size: 16px">兑 &nbsp;&nbsp;&nbsp; 换</button>'
                            + '<span style="position: absolute; left: 3%; top: 5%" class="layui-badge"><i class="layui-icon layui-icon-rmb">' + item.coinWarePrice + '</i></span>'
                            + '</div>';
                    }
                });

                $('#n_ware').append(n_html + '</ul>');
                $('#hw_ware').append(hw_html + '</ul>');
                $('#hz_ware').append(hz_html + '</ul>');
                $('#b_ware').append(b_html + '</ul>');
            }
        });

    }
});

layui.use('layer', function () { //独立版的layer无需执行这一句
    var $ = layui.jquery;
    var layer = layui.layer;  //独立版的layer无需执行这一句
    var active = {
        notice: function () {
            //示范一个公告层
            layer.open({
                type: 1
                ,
                title: false //不显示标题栏
                ,
                closeBtn: false
                ,
                area: '300px;'
                ,
                shade: 0.8
                ,
                id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,
                btn: ['我知道了']
                ,
                btnAlign: 'c'
                ,
                moveType: 1 //拖拽模式，0或者1
                ,
                content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">牛币是牛客网推出的一种虚拟货币，仅限在牛客网使用，用于牛币商城兑换各类商品，不支持提现。<br/><br/>' +
                    '牛币的有效期截至当年的12月31日，跨年即清零，请大家注意及时使用。<br/><br/><span style="color: #d43f3a">特别注意:这是个人作品，所以无法购买哟~</span></div>'
            });
        }
    };

    $('#layerDemo .layui-btn').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
});