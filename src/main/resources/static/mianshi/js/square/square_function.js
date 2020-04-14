function showNoteEdit(){
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

        //触发事件
        layer.open({
                    type: 1
                    ,area: ['600px', '430px']
                    ,title: '添加笔记'
                    ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                    ,id: 'layerDemo1' //防止重复弹出
                    ,content: '<textarea id="demo1" style="display: none;"></textarea>'
                    ,btn: ['添加笔记','关闭']
                    ,btnAlign: 'c' //按钮居中
                    ,shade: 0 //不显示遮罩
                    ,yes: function(){
                        var content = layedit.getContent(index);
                $.ajax({
                    type: "POST",
                    data: JSON.stringify({
                        "noteContent": content,
                        "userId": "6aca7cbe-dff0-4342-a4f4-c7ad86699c4b",
                        "titleId" : getQueryString("id")
                    }),
                    dataType: "json",
                    contentType: "application/json;charset=utf-8",
                    url: "/square/api/note",
                    success: function (res) {
                        if (res.code == 200) {
                            layer.msg("添加成功!");
                            window.location.reload();
                        }
                    }
                });
                layer.closeAll()
              }
        });
    });
    var layedit;
    var index;
    layui.use('layedit', function(){
        layedit = layui.layedit;
        index = layedit.build('demo1', {

        }); //建立编辑器

        var $ = layui.jquery;
        layedit.set({
            uploadImage: {
                url: '/square/api/upload' //接口url
                ,type: '' //默认post
                ,success: function (data) {
                    alert(data.data.src);
                }
            }
        });
    });
}

// 添加题解
function addComment(val) {
    var userId = $('#user').attr("data-self");
    var objId = getQueryString('id');
    $.ajax({
        type: "POST",
        data: JSON.stringify({
            "parentId": 0, "userId": "6aca7cbe-dff0-4342-a4f4-c7ad86699c4b", "commentType": 2, "functionType": 3,
            "commentContent": val, "agreeNum": 0, "commentNum": 0, "objectId": objId
        }),
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        url: "/comment/api/comment",
        success: function (res) {
            if (res.code == 200) {
                window.location.reload();
            }
        }
    });
}

function  changeHtml() {
    document.location.href = "/bs/index/square_edit";
}

function deleteNote(val){
    var url = '/square/api/note';
}