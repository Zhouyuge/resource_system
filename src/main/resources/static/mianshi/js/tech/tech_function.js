function fileUpload(obj) {
    layui.use('layer', function () { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer, upload = layui.upload; //独立版的layer无需执行这一句
        var othis = $(this);
        var active = {
            offset: function () {
                layer.open({
                    type: 1
                    ,
                    title: '文件上传'
                    ,
                    offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                    ,
                    id: 'layerDemo' + obj.id //防止重复弹出
                    ,
                    content: '<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">\n' +
                        '  <ul class="layui-tab-title">\n' +
                        '    <li class="layui-this">文件上传</li>\n' +
                        '    <li>网站资料</li>\n' +
                        '  </ul>\n' +
                        '  <div class="layui-tab-content">\n' +
                        '    <div class="layui-tab-item layui-show">' +
                        ' <div class="layui-upload">\n' +
                        '  <button type="button" class="layui-btn layui-btn-normal" id="testList">选择文件</button> \n' +
                        '  <div class="layui-upload-list">\n' +
                        '    <table class="layui-table">\n' +
                        '      <thead>\n' +
                        '        <tr><th>文件名</th>\n' +
                        '        <th>大小</th>\n' +
                        '        <th>状态</th>\n' +
                        '        <th>操作</th>\n' +
                        '      </tr></thead>\n' +
                        '      <tbody id="demoList"></tbody>\n' +
                        '    </table>\n' +
                        '  </div>\n' +
                        '  <button type="button" class="layui-btn" id="testListAction">开始上传</button>\n' +
                        '</div>  ' +
                        '</div>\n' +
                        '    <div class="layui-tab-item">内容2</div>\n' +
                        '  </div>\n' +
                        '</div>'
                    ,
                    area: ['700px', '600px']
                    ,
                    shade: 0 //不显示遮罩
                    ,
                    close: function () {
                        parent.location.reload();
                        layer.closeAll();
                    }
                });
            }
        };
        active['offset'].call(obj, othis);

        //多文件列表示例
        var demoListView = $('#demoList')
            ,uploadListIns = upload.render({
            elem: '#testList'
            ,url: '/tech/api/fileUpload'
            ,data: {id : obj.id}
            ,accept: 'file'
            ,multiple: true
            ,auto: false
            ,bindAction: '#testListAction'
            ,choose: function(obj){
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function(index, file, result){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td>'+ file.name +'</td>'
                        ,'<td>'+ (file.size/1024).toFixed(1) +'kb</td>'
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function(){
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function(){
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    demoListView.append(tr);
                });
            }
            ,done: function(res, index, upload){
                if(res.success){ //上传成功
                    var tr = demoListView.find('tr#upload-'+ index)
                        ,tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                }
                this.error(index, upload);
            }
            ,error: function(index, upload){
                var tr = demoListView.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });
    });
}

function toPdfDetail(obj) {
    window.open(obj.id);
}