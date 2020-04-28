function updateCate(id) {
    var html = '';
    var url = '/mate/mate/' + id;

    // 分类地址
    var cate_url = "/cate/cates";
    var list = '';
    $.ajaxSettings.async = false;
    $.getJSON(cate_url, function (data) {
        list = data.data;
    })

    var obj;
    $.ajaxSettings.async = false;
    $.getJSON(url, function (data) {
        if (data.code == 200) {
            obj = data.data;
        }
    });

    html += '<form class="layui-form layui-form-pane" action="" style="margin-top: 50px">\n' +
        '  <div class="layui-form-item" style="display: none">\n' +
        '    <label style="width: 100px" class="layui-form-label">ID:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '      <input style="width: 300px" value="' + obj.id + '" type="text" name="id" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
        '    </div>' +
        '  </div>' +
        '  <div class="layui-form-item" style="display: none">\n' +
        '    <label style="width: 100px" class="layui-form-label">ID:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '      <input style="width: 300px" value="' + obj.categoryId + '" type="text" name="oldCategoryId" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
        '    </div>' +
        '  </div>' +

        '  <div class="layui-form-item" style="margin-left: 50px">\n' +
        '    <label style="width: 100px" class="layui-form-label">资源名称:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '      <input style="width: 500px" value="' + obj.materialName + '" type="text" name="materialName" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
        '    </div>' +
        '  </div>' +
        '  <div class="layui-form-item" style="margin-left: 50px">\n' +
        '    <label style="width: 100px" class="layui-form-label">计量单位:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '      <input style="width: 500px" type="text" name="materialSpeci" value="' + obj.materialSpeci + '" required  lay-verify="required" placeholder="请输入计量单位" autocomplete="off" class="layui-input">\n' +
        '    </div>' +
        '  </div>' +
        '  <div class="layui-form-item" style="margin-left: 50px">\n' +
        '    <label style="width: 100px" class="layui-form-label">选择类别:</label>\n' +
        '    <div style="width: 500px" class="layui-input-block">\n' +
        '      <select style="width: 500px;" name="categoryId" lay-verify="required" lay-search>\n'
    '           <option></option>\n';
    if (list != null) {
        list.map(function (item, index) {
            html += '<option value="' + item.id + '">' + item.categoryName + '</option>\n';
        });
    }
    html += '      </select>\n' +
        '    </div>\n' +
        '  </div> \n' +
        '  <div class="layui-form-item" style="margin-left: 50px">\n' +
        '    <label style="width: 100px" class="layui-form-label">资源信息:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '          <textarea style="width: 500px" name="materialInfo" placeholder="请输入信息" class="layui-textarea">' + obj.materialInfo + '</textarea>\n' +
        '    </div>' +
        '  </div>' +
        '  <div class="layui-form-item">\n' +
        '    <div class="layui-input-block">\n' +
        '      <button class="layui-btn" lay-submit lay-filter="form">修改</button>\n' +
    '    </div>\n' +
    '  </div>\n' +
    '</form>';

    layer.open({
               offset: 'auto',
               area: ['800px', '600px'],
               type: 1,
               title: '修改资源',
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
               // 更新全部
               form.render();
               //监听提交
               form.on('submit(form)', function(data){
                   var data = JSON.stringify(data.field);
                   $.ajax({
                       type : "PUT",
                       data : data,
                       dataType : "json",
                       url : "/mate/mate",
                       contentType :"application/json;charset=utf-8",
                       success : function(data) {
                           if (data.code == 200){
                               window.location.href = '/system/index/material';
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
            url : "/mate/mate/" + id,
            contentType :"application/json;charset=utf-8",
            success : function(data) {
                if (data.code == 200){
                    window.location.href = '/system/index/material';
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
    // 分类地址
    var cate_url = "/cate/cates";
    var list = '';
    $.ajaxSettings.async = false;
    $.getJSON(cate_url, function (data) {
        list = data.data;
    })

    var html = '' +
        '<form class="layui-form layui-form-pane" style="margin-top: 50px">\n' +
        '  <div class="layui-form-item" style="margin-left: 50px">\n' +
        '    <label style="width: 100px" class="layui-form-label">资源名称:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '      <input style="width: 500px" type="text" name="materialName" required  lay-verify="required" placeholder="请输入资源名称" autocomplete="off" class="layui-input">\n' +
        '    </div>' +
        '  </div>' +
        '  <div class="layui-form-item" style="margin-left: 50px">\n' +
        '    <label style="width: 100px" class="layui-form-label">计量单位:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '      <input style="width: 500px" type="text" name="materialSpeci" required  lay-verify="required" placeholder="请输入计量单位" autocomplete="off" class="layui-input">\n' +
        '    </div>' +
        '  </div>' +
        '  <div class="layui-form-item" style="margin-left: 50px">\n' +
        '    <label style="width: 100px" class="layui-form-label">选择类别:</label>\n' +
        '    <div style="width: 500px" class="layui-input-block">\n' +
        '      <select style="width: 500px;" name="categoryId" lay-verify="required" lay-search>\n'
        '           <option></option>\n';
        if(list != null) {
            list.map(function (item, index) {
                html += '<option value="' + item.id + '">' + item.categoryName + '</option>\n';
            });
        }
        html += '      </select>\n' +
        '    </div>\n' +
        '  </div> \n' +
        '  <div class="layui-form-item" style="margin-left: 50px">\n' +
        '    <label style="width: 100px" class="layui-form-label">资源信息:</label>\n' +
        '    <div class="layui-input-block">\n' +
        '          <textarea style="width: 500px" name="materialInfo" placeholder="请输入信息" class="layui-textarea"></textarea>\n' +
        '    </div>' +
        '  </div>' +
        '  <div class="layui-form-item">\n' +
        '    <div class="layui-input-block">\n' +
        '      <button class="layui-btn" lay-submit lay-filter="form">添加</button>\n' +
        '      <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>\n'
        '    </div>\n' +
        '  </div>\n' +
        '</form>';

    layer.open({
        offset: 'auto',
        area: ['800px', '600px'],
        type: 1,
        title: '添加资源',
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
        // 更新全部
        form.render();
        //监听提交
        form.on('submit(form)', function(data){
            var data = JSON.stringify(data.field);
            $.ajax({
                type : "POST",
                data : data,
                dataType : "json",
                url : "/mate/mate",
                contentType :"application/json;charset=utf-8",
                success : function(data) {
                    if (data.code == 200){
                        window.location.href = '/system/index/material';
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