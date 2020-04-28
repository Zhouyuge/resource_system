function updateCate(id) {
    var html = '';
    var url = '/cate/cate/' + id;
    $.ajaxSettings.async = false;
    $.getJSON(url, function (data) {
       if(data.code == 200) {
           var data = data.data;
           html += '<form class="layui-form" action="" style="margin-top: 50px">\n' +
               '  <div class="layui-form-item" style="display: none">\n' +
               '    <label style="width: 100px" class="layui-form-label">ID:</label>\n' +
               '    <div class="layui-input-block">\n' +
               '      <input style="width: 300px" value="' + data.id + '" type="text" name="id" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
               '    </div>' +
               '  </div>' +

               '  <div class="layui-form-item">\n' +
               '    <label style="width: 100px" class="layui-form-label">资源分类名称:</label>\n' +
               '    <div class="layui-input-block">\n' +
               '      <input style="width: 300px" value="' + data.categoryName + '" type="text" name="categoryName" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
               '    </div>' +
               '  </div>' +
               '  <div class="layui-form-item">\n' +
               '    <label style="width: 100px" class="layui-form-label">资源分类备注:</label>\n' +
               '    <div class="layui-input-block">\n' +
               '          <textarea style="width: 300px" name="categoryContent" placeholder="请输入备注" class="layui-textarea">' + data.categoryContent + '</textarea>\n' +
               '    </div>' +
               '  </div>' +

               '  <div class="layui-form-item">\n' +
               '    <div class="layui-input-block">\n' +
               '      <button class="layui-btn" lay-submit lay-filter="form">修改</button>\n' +
               '    </div>\n' +
               '  </div>\n' +
               '</form>';
       }
    });
    layer.open({
        offset: 'auto',
        area: ['500px', '380px'],
        type: 1,
        title: '修改资源分类',
        content: html,
        btn: ['取消'],
        id: 'update',
        anim: 1,
        yes: function (index, layero) {
            layer.closeAll();
        }
    });
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(form)', function(data){
            var data = JSON.stringify(data.field);
            $.ajax({
                type : "PUT",
                data : data,
                dataType : "json",
                url : "/cate/cate",
                contentType :"application/json;charset=utf-8",
                success : function(data) {
                    if (data.code == 200){
                        window.location.href = '/system/index/category';
                    } else {
                        layer.msg(data.msg, {
                            icon: 2,
                        })
                    }
                }
            });
            return false;
        });
    });
}

function deleteCate(id) {
    layer.confirm('确定删除吗？', {
        btn: ['删除', '取消']
    }, function(index, layero){
        $.ajax({
            type : "delete",
            dataType : "json",
            url : "/cate/category/" + id,
            contentType :"application/json;charset=utf-8",
            success : function(data) {
                if (data.code == 200){
                    window.location.href = '/system/index/category';
                } else {
                    layer.msg(data.msg, {
                        icon: 2,
                    })
                }
            }
        });
        return false;
    }, function(index){
    });
}

function addOne() {
    var html = '' +
        '<form class="layui-form" action="" style="margin-top: 50px">\n' +
        '  <div class="layui-form-item">\n' +
        '    <label style="width: 100px" class="layui-form-label">资源分类名称:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '      <input style="width: 300px" type="text" name="categoryName" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
        '    </div>' +
        '  </div>' +
        ' <div class="layui-form-item">\n' +
        '    <label style="width: 100px" class="layui-form-label">是否可重复:</label>\n' +
        '    <div class="layui-input-block" style="width: 300px">\n' +
        '      <input type="radio" name="useStr" value="1" title="是"  checked>\n' +
        '      <input type="radio" name="useStr" value="0" title="否">\n' +
        '    </div>\n' +
        '  </div>' +
        '  <div class="layui-form-item">\n' +
        '    <label style="width: 100px" class="layui-form-label">资源分类备注:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '          <textarea style="width: 300px" name="categoryContent" placeholder="请输入备注" class="layui-textarea"></textarea>\n' +
        '    </div>' +
        '  </div>' +
        '  <div class="layui-form-item">\n' +
        '    <div class="layui-input-block">\n' +
        '      <button class="layui-btn" lay-submit lay-filter="form">添加</button>\n' +
        '    </div>\n' +
        '  </div>\n' +
        '</form>';

    layer.open({
        offset: 'auto',
        area: ['500px', '420px'],
        type: 1,
        title: '添加资源分类',
        content: html,
        btn: ['取消'],
        id: 'add',
        anim: 1,
        yes: function (index, layero) {
            layer.closeAll();
        }
    });
    layui.use('form', function(){
        var form = layui.form;
        form.render();
        //监听提交
        form.on('submit(form)', function(data){
            var data = JSON.stringify(data.field);
            $.ajax({
                type : "POST",
                data : data,
                dataType : "json",
                url : "/cate/cate",
                contentType :"application/json;charset=utf-8",
                success : function(data) {
                    if (data.code == 200){
                        window.location.href = '/system/index/category';
                    } else {
                        layer.msg(data.msg, {
                            icon: 2,
                        })
                    }
                }
            });
            return false;
        });
    });

}

function searchCate() {
    var str = $('#searchVal').val();
    var url = window.location.href;
    if (url.indexOf("?") > 0) {
        url = url.split("?")[0];
    }
    url += '?pageNum=1&str=' + str;
    window.location.href = url;
}