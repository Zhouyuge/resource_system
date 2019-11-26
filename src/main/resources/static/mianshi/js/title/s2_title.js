function getStype(url, typeId) {
    $.getJSON(url, function (data) {
        var html = '';
        if (data.success) {
            var i = data.data;
            html += '<div class="layui-input-block" style="margin: 0px">';
            i.map(function (item, index) {
                html += '<div class="rand"><input style="margin-left: 50px" type="checkbox" name="s_type" lay_filter="s_type" value="' + item.typeName + '" title="' + item.typeName + '" lay-skin="primary" />' +
                    '       \n' + '<span style="position:absolute; left: 75%">30/100</span>' +
                    '<div style="width: 600px; margin-top: 15px; margin-bottom: 15px" class="layui-progress" lay-showPercent="yes">\n' +
                    '  <div class="layui-progress-bar layui-bg-red" lay-percent="30%"></div>\n'
                    +'</div>'
                    +'</div>';
            });
            html += '</div>';
            $('#f_id' + typeId).html(html);
        }
        layui.form.render();
        layui.use('element', function(){
            var element = layui.element;
            element.init();
        });
    });
}

function toDo(){
    window.open("s_title_detail");
}