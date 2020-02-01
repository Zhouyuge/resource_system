function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {//获取地址不为空的情况下返回 需要的信息
        return decodeURIComponent(r[2]);
    }
    return '';
}

function co(obj) {
    var p = obj.parentNode;
    if (p.classList.contains("layui-nav-itemed")) {
        p.classList.remove("layui-nav-itemed");     //删除展开
    } else {
        p.classList.add("layui-nav-itemed");                //添加展开

    }
}

function skip(tId) {
    window.location.href = '/bs/index/topics/etiles?category=' + tId + '&page=1';
}

function change_state(obj) {
    var child = obj.firstChild;
    if (getComputedStyle(child).color.toString() == 'rgb(49, 176, 213)' && child.className.toString() == 'layui-icon layui-icon-praise') {
        child.style.color = "rgb(119, 119, 119)";
        var agree_num = child.firstChild;
        agree_num.innerHTML = parseInt(agree_num.innerHTML) - 1;        //点赞数-1
    } else if (getComputedStyle(child).color.toString() == 'rgb(119, 119, 119)' && child.className.toString() == 'layui-icon layui-icon-praise') {
        child.style.color = "rgb(49, 176, 213)";
        var agree_num = child.firstChild;
        agree_num.innerHTML = parseInt(agree_num.innerHTML) + 1;    //点赞数+1
    } else if (getComputedStyle(child).color.toString() == 'rgb(255, 255, 0)') {
        child.className = "layui-icon layui-icon-star";
        child.style.color = "rgb(119, 119, 119)";
        var agree_num = child.firstChild;
        agree_num.innerHTML = parseInt(agree_num.innerHTML) - 1;        //收藏数-1
    } else {
        child.className = "layui-icon layui-icon-star-fill";
        child.style.color = "yellow";
        var agree_num = child.firstChild;
        agree_num.innerHTML = parseInt(agree_num.innerHTML) + 1;        //收藏数+1
    }

}

/**
 * 获取商品详情----coin_ware
 */
function getDetail(obj) {
    var id = obj.id.toString().split("btn")[1];
    var url = '/cw/api/ware/' + id;
    var othis = $(this);
    layui.use('layer', function () { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        //触发事件
        var active = {
            offset: function (obj) {
                $.getJSON(url, function (data) {
                    layer.open({
                        type: 1
                        ,
                        title: data.ware.coinWareName
                        ,
                        offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                        ,
                        id: 'layerDemo' + obj.id //防止重复弹出
                        ,
                        content: '<div style="width: 500px; height: 450px;"><img style="position: relative; left: 30%" width="400px" height="400px" src="' + data.ware.coinWareBigPic + '"><br/><br/><br/><div><button style="position: absolute; left: 43%" type="button" onclick="tips_msg()" class="layui-btn layui-btn-radius layui-btn-primary">点击购买</button></div>'
                        ,
                        area: ['700px', '600px']
                        ,
                        shade: 0 //不显示遮罩
                        ,
                        close: function () {
                            layer.closeAll();
                        }
                        ,
                        time: 4000
                    });
                });
            }
        };
        active['offset'].call(obj, othis);
    });
}

function tips_msg() {
    alert("请去牛客网官方购买哟！");
}
