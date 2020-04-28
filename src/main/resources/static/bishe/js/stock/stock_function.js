function operation(stockId, id, type) {
    var html = '<div style="margin-left: 20px; margin-top: 60px; margin-right: 20px; width: 300px" class="layui-form">' +
        '<div class="layui-form-item">\n' +
        '    <label class="layui-form-label">操作数量:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '      <input id="number" type="text" name="title" value="0" required  lay-verify="number" autocomplete="off" class="layui-input">\n' +
        '    </div>\n' +
        '    <button id="btn" onclick="addNum()" style="margin-left: 200px; margin-top: 20px;" class="layui-btn layui-btn-sm"><i class="layui-icon layui-icon-addition"></i></button>' +
        '    <button id="btn1" onclick="subtract()" style="margin-top: 20px" class="layui-btn layui-btn-danger layui-btn-sm"><i class="layui-icon layui-icon-subtraction"></i></button>' +
        '  </div>' +
        '</div>';

    layer.open({
        offset: 'auto',
        area: ['400px', '300px'],
        type: 1,
        title: '出库/入库',
        content: html,
        id: 'add',
        btn: '立即提交',
        anim: 1,
        yes: function (index, layero) {
            var number = $('#number').val();
            var result = verifyNumber(number);
            var stockVO = {};
            if (result != '') {
                stockVO.num = result;
                stockVO.id = id;
                stockVO.type = type;
                stockVO.stockId = stockId;
                var data = JSON.stringify(stockVO);
                $.ajax({
                    type : "PUT",
                    data : data,
                    dataType : "json",
                    url : "/stock/operation",
                    contentType :"application/json;charset=utf-8",
                    success : function(data) {
                        if (data.code == 200){
                            window.location.href = '/system/index/stock';
                        } else {
                            layer.msg(data.msg, {
                                icon: 2,
                            })
                        }
                    }
                });
            }
        }
    });
}


function verifyNumber(number) {
    var reg=/^\d{1,}$/;
    var pattern=new RegExp(reg);
    if (pattern.test(number)) {
        return number;
    } else {
        layer.msg("只能输入正整数.", {icon: 2});
    }
    return '';
}

function search() {
    var str = $('#searchVal').val();
    var url = window.location.href;
    if (url.indexOf("?") > 0) {
        url = url.split("?")[0];
    }
    url += '?pageNum=1&str=' + str;
    window.location.href = url;
}

function addNum() {
    var num = $('#number').val();
    $('#number').val(parseInt(num) + 1);
}


function subtract() {
    var num = $('#number').val();
    if (num == 0) {
        layer.msg("不能输入负数.", {icon: 2});
    }else {
        $('#number').val(parseInt(num) - 1);
    }
}