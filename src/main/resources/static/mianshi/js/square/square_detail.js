$(function () {
    var id = getQueryString('id');
    var url = '/square/api/square/' + id;
    showSquareTitle();
    function showSquareTitle(){
        var hard = 0;
        $.ajaxSettings.async = false;   //关闭异步
        $.getJSON(url, function (data) {
            $('#title').html(data.data.titleName);
            $('#title_name').html(data.data.titleName);
            $('#title_content').html(data.data.titleContent);
            hard = data.data.titleHard;
        })

        layui.use('rate', function(){
            var rate = layui.rate;
            //渲染
            var ins1 = rate.render({
                elem: '#hard'  //绑定元素
                ,value: hard
                ,theme: "#8df6a0"
            });
        });
    }

    showComments();

    function showComments(){
        var commentUrl = '/comment/api/comments_func/3/' + id;
        $.getJSON(commentUrl, function (data) {
            if(data.code == 200) {
                var noComment = document.getElementById("no_content");
                noComment.style.display = 'none';
                var html = '';
                var list = data.data;
                list.map(function (item, index) {
                    html += '\n' +
                        '          <div style="margin: 20px">\n' +
                        '               <img class="layui-circle" style="border: #444444 solid 1px" src="' + item.user.userHeadPic + '" width="30px" height="30px">\n' +
                        '               <span style="color: #2EA0FF; margin-left: 20px;">' + item.user.userVisualName + '</span>\n' +
                        '               <div  style="margin: 20px">\n' +
                        '                    <span>\n' +
                        '                       ' + item.commentContent + '\n' +
                        '                    </span>\n' +
                        '               </div>\n' +
                        '\n' +
                        '               <div style="color: #9F9F9F; font-size: 12px; margin-left: 20px;">\n' +
                        '                    发表于 '+ item.prettyTime +'\n' +
                        '               </div>\n' +
                        '          </div>';
                })
                $('#comment_list').append(html);
            }
        })
    }

    showNotes();

    function  showNotes() {
        var noteUrl = '/square/api/note/6aca7cbe-dff0-4342-a4f4-c7ad86699c4b/' + getQueryString('id');
        $.getJSON(noteUrl, function (data) {
            if(data.code == 200){
                var html = '';
                var item = data.data;
                if(item != null) {
                    var btn = document.getElementById("addNote");
                    btn.style.display = 'none';

                    var list = document.getElementById("talk_content");
                    list.style.display = 'inline';

                    html += '<div style="margin: 20px">\n' +
                        '            <span>' + item.noteContent + '</span>\n' +
                        '        </div>\n' +
                        '\n' +
                        '        <div style="margin-top: 20px; margin-bottom: 20px; margin-left: 60% ">\n' +
                        '            <span style="color: #9F9F9F">发表于 ' + item.createTime + '</span>\n' +
                        '            <a onclick="deleteNote(' + item.id + ')" style="margin-left: 20px; color: #5FB878">删除</a>\n' +
                        '        </div>';

                    $('#talk_content').append(html);
                }
            }
        })

    }
})