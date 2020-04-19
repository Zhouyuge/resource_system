function getEdit() {
    layer.open({
        type: 1
        ,offset: 'auto'
        ,id: 'layerDemo1'
        ,title: '在线编程'
        ,content: '<form class="layui-form" action="">\n' +
            '<div class="layui-form-item layui-form-text">\n' +
            '    <h1 style="margin-left: 500px; margin-top: 20px; margin-bottom: 20px" class="layui-form-label">JAVA</h1><br/>\n' +
            '    <textarea style="width: 1160px; height: 500px; margin: 20px" name="desc" placeholder="请输入内容" id="code_area" class="layui-textarea"></textarea>\n' +
            '  </div>' +
            '  </form>'

        ,area: ['1200px', '700px']
        ,btn: '保存代码'
        ,btnAlign: 'c' //按钮居中
        ,shade: 0 //不显示遮罩
        ,yes: function(){
            var content = $('#code_area').val();
            $('#code_content').html(content);
            layer.closeAll();
        }
    });
}

function submitCode() {
    var s = $('#code_content').text();
    var id = getQueryString("oj_id");
    $.ajax(
        {
            type : "POST",
            data : JSON.stringify({"codeLanguage" : "java", "code" : s, "submitProblemId" : id}),
            dataType : "json",
            contentType:"application/json;charset=utf-8",
            url : "/problem/api/submit_oj",
            success : function (res) {
                if(res.code == 200) {
                    var html = '\n' +
                        '                <tr>\n' +
                        '                  <td>' + res.data.score + '</td>\n' +
                        '                  <td>' + res.data.isAccepted + '</td>\n' +
                        '                  <td>' + res.data.details + '</td>\n' +
                        '                </tr>';
                    $('#result').html(html);
                }
            }
        }
    );
}