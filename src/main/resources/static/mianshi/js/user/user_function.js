$(function () {
    layui.use('layedit', function(){
        var layedit = layui.layedit;
        var $ = layui.jquery;
        layedit.set({
            uploadImage: {
                url: '/user/api/upload' //接口url
                ,type: '' //默认post
                ,success: function (data) {
                    alert(data.data.src);
                }
            }
        });
        var index = layedit.build('demo',{
            height: 120,
            tool: [
                'link',
                'face',
                'image'
            ]
        }); //建立编辑器
        var daka = $('#dailyPoint');
        daka.click(function () {
           var content = layedit.getContent(index);
            $.ajax({
                type : "post",
                url : "/user/api/daily_point",
                contentType:"application/json;charset=utf-8",
                data : JSON.stringify({"dailyContent" : content}),
                dataType : "json",
                success: function () {
                    window.location.reload();
                }
            });
        });
    });

    showDailyPointList();

    function showDailyPointList() {
        layui.use('flow', function(){
            var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
            var flow = layui.flow;
            flow.load({
                elem: '#daily_list' //指定列表容器
                ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
                    var lis = [];
                    //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                    $.get('/user/api/daily_points/' + page, function(res){
                        //假设你的列表返回在data集合中
                        layui.each(res.data, function(index, item){
                            var html = '<li><div class="layui-row" style="background: #ffffff; margin-left: 20px; margin-right: 20px; margin-bottom: 10px">\n' +
                                '                <div class="layui-col-md1">\n' +
                                '                    <img style="margin: 10px" class="layui-circle" src="' + item.user.userHeadPic + '" height="40px" width="40px" />\n' +
                                '                </div>\n' +
                                '\n' +
                                '                <div style="margin-left: 10px; margin-top: 20px" class="layui-col-md10">\n' +
                                '                    <span style="color: #009f95">' + item.user.userVisualName + '</span>\n' +
                                '                    <span>说</span>\n' +
                                '                    <span style="color: grey" class="layui-col-md-offset8">\n' +
                                '                    ' + item.prettyTime + '\n' +
                                '                    </span>\n' +
                                '                </div>\n' +
                                '\n' +
                                '                <div class="layui-col-md10" style="margin: 20px">\n' +
                                '                    <p>' + item.dailyContent + '</p>\n' +
                                '                </div>\n' +
                                '                <hr/>\n' +
                                '                <div class="layui-row">\n' +
                                '                    <div class="layui-col-md4" style="text-align: center; margin-top: 10px; margin-bottom:10px">\n' +
                                '                        <a id="ag_' + item.id + '" flag="false" onclick="doAgree(' +item.id + ')"><i class="layui-icon layui-icon-praise"></i>\n' +
                                '                        <span id="agv_'+ item.id +'">' + item.agreeNum + '</span></a>\n' +
                                '                    </div>\n' +
                                '                    <div class="layui-col-md4" style="text-align: center; margin-top: 10px; margin-bottom:10px">\n' +
                                '                         <a  id="c_' + item.id + '" flag = "false" onclick="doComment(' + item.id + ')"><i class="layui-icon layui-icon-dialogue"></i>\n' +
                                '                         <span id="cv_'+ item.id +'">' + item.commentNum + '</span></a>\n' +
                                '                    </div>\n' +
                                '                    <div class="layui-col-md4" style="text-align: center; margin-top: 10px; margin-bottom:10px">\n' +
                                '                         <i class="layui-icon layui-icon-share"></i>\n' +
                                '                         <span>' + item.shareNum + '</span>\n' +
                                '                    </div>\n' +
                                '\n' +
                                '\n' +
                                '            </div>\n' +
                                '<div data-show="false" id="s_' + item.id + '" style="display: none;">' +
                                '<div style="background: #f5f5f5" class="layui-row">\n' +
                                '                 <input id="input_p_' + item.id + '" type="text" name="title"  placeholder="请输入您的观点" style="width: 500px; margin-top: 20px" class="layui-input layui-col-md-offset1 layui-col-md7">\n' +
                                '                 <button onclick="addComment2(' + item.id + ')" class="layui-btn layui-col-md-offset10" style="margin-bottom: 20px">回复</button>\n' +
                                '                </div>' +
                                '       </div> </div></li>';
                            lis.push(html);
                        });

                        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                        next(lis.join(''), page < res.page);
                    });
                }
            });
        });

    }
})
var obj_id;
var comment_id = 0;
var re_html = '';

// 评论按钮功能（显示或隐藏评论）
function doComment(val) {
    var comment = $('#c_' + val);
    var commentDiv = $('#s_' + val);
    var cv = $('#cv_' + val);
    var flag = comment.attr("flag");
    // 初始化日签到id
    obj_id = val;
    if(flag == 'false') {
        commentDiv.css("display", "inline")
        comment.css("color", "#009f95");
        comment.attr("flag", "true");
        var url = "/comment/api/comments_func/2/" + val;
        $.ajaxSettings.async = false;
        $.getJSON(url, function (data) {
            var coms = data.data;
            var html = '';
            if(commentDiv.attr("data-show") == "false") {
                coms.map(function (item, index) {
                    html += '                <div class="layui-row" style="background: #f5f5f5">\n' +
                        '                    <div class="layui-col-md1">\n' +
                        '                        <img style="margin: 10px" class="layui-circle" src="' + item.user.userHeadPic + '" height="40px" width="40px" />\n' +
                        '                    </div>\n' +
                        '\n' +
                        '                    <div style="margin-left: 10px; margin-top: 20px" class="layui-col-md10">\n' +
                        '                        <span style="color: #009f95">' + item.user.userVisualName + '</span>\n' +
                        '                        <span style="margin-left: 10px">\n' +
                        '                          ' + item.commentContent + '\n' +
                        '                        </span>\n' +
                        '                        <div style="text-align: right; margin-top: 20px;font-size: 6px">\n' +
                        '                            <span style="color: grey; margin-right: 65%">发表于' + item.prettyTime + '</span>\n' +
                        '                            <span style="margin-right: 20px; color: #269abc">赞(' + item.agreeNum + ')</span>\n' +
                        '                            <a onclick="initCommentId2(' + item.id + ')"><span style="margin-right: 20px; color: #269abc">回复(' + item.commentNum + ')</span></a>\n' +
                        '                            <div id="com_' + item.id + '" class="layui-row" style="background: #efefef; margin: 20px; text-align: left"></div>\n' +
                        '                        <div flag="false" id="second_comment_' + item.id + '" style="display: none">\n' +
                        '                            <input id="input_' + item.id + '"  type="text" name="title"  placeholder="请输入您的观点" style="width: 450px" class="layui-input layui-col-md-offset1 layui-col-md7">\n' +
                        '                            <button onclick="addComment(' + item.id + ')" class="layui-btn" style="margin-bottom: 20px; margin-left: 4px">回复</button>\n' +
                        '                        </div>' +
                        '                        <hr/>\n' +
                        '                    </div>\n' +
                        '                    </div>\n' +
                        '                </div>\n';
                });
                commentDiv.prepend(html);
                commentDiv.attr("data-show", "true");
                coms.map(function (item, index) {
                    showReComment(item);
                    $('#com_' + item.id).html(re_html);
                    re_html = '';
                })
            }
        });
    } else
        if(flag == 'true'){
            commentDiv.css("display", "none")
            comment.css("color", "#000000");
            comment.attr("flag", "false");
        }
}

// 隐藏或显示评论
function initCommentId(val) {
    var replay = $('#replay_' + val);
    if(replay.attr("flag") == 'false') {
        replay.css("display", "inile");
        replay.attr("flag", "true");
    } else {
        replay.attr("flag", "false");
        replay.css("display", "none");
    }
}
// 隐藏或显示回复
function initCommentId2(val) {
    var sc = $('#second_comment_' + val);
    if(sc.attr("flag") == 'false') {
        sc.css("display", "inile");
        sc.attr("flag", "true");
    } else {
        sc.attr("flag", "false");
        sc.css("display", "none");
    }
}
// 添加点赞
function doAgree(val){
    var agree = $('#ag_' + val);
    var agv = $('#agv_' + val);
    var agv_val = agv.text();
    var flag = agree.attr("flag");
    if(flag == "false") {
        agree.css("color", "#009f95");
        agree.attr("flag", "true");
        agv.text(parseInt(agv_val) + 1);
    } else {
        agree.attr("flag", "false");
        agv.text(parseInt(agv_val) - 1);
        agree.css("color", "#000000");
    }
}

// 递归展示回复树
function showReComment(val){
    if(val.parentId != 0) {
        re_html += '           <div class="layui-col-md10"style="margin: 10px">\n' +
            '                                <span style="color: #2aabd2">' + val.parentName + '</span>\n' +
            '                                <span>回复</span>\n' +
            '                                <span style="color: #2aabd2">' + val.user.userVisualName + '</span>\n' +
            '                                <span>:</span>\n' +
            '                                <span>' + val.commentContent + '</span>\n' +
            '                                <br/>\n' +
            '                                <br/>\n' +
            '                                <span style="color: grey">' + val.prettyTime + '</span>\n' +
            '                                <a onclick="initCommentId(' + val.id + ')"><span style="margin-left: 80%; color: #269abc">回复</span></a>' +
            '                                <div flag="false" style="margin: 20px; display: none" id="replay_' + val.id + '">\n' +
            '                                    <input id="input_' + val.id + '"  type="text" name="title"  placeholder="请输入您的观点" style="width: 400px" class="layui-input">\n' +
            '                                    <button onclick="addComment('+ val.id +')" class="layui-btn" style="margin-left: 430px;">回复</button>\n' +
            '                                </div>' +
            '                            </div>\n' +
            '                            <hr style="margin-left: 20px; margin-right: 20px"/>';
    }
    if(val.children.length == 0) {
        return ;
    }
    for(var i = 0; i < val.children.length; i++) {
        showReComment(val.children[i]);
    }
    return ;
}

// 添加含父节点的评论
function addComment(val) {
    comment_id = val;
    var content = $('#input_' + val).val();
    var userId = $('#user').attr("data-self");
    $.ajax({
        type : "POST",
        data : JSON.stringify({"parentId" : comment_id, "userId" : userId, "commentType" : 2, "functionType" : 2,
        "commentContent" : content, "agreeNum" : 0, "commentNum" : 0, "objectId" : obj_id }),
        dataType : "json",
        contentType:"application/json;charset=utf-8",
        url : "/comment/api/comment",
        success : function (res) {
            if(res.code == 200) {
                window.location.reload();
            }
        }
    });
}

// 添加不含父节点的评论
function addComment2(val) {
    var content = $('#input_p_' + val).val();
    var userId = $('#user').attr("data-self");
    $.ajax({
        type : "POST",
        data : JSON.stringify({"parentId" : 0, "userId" : userId, "commentType" : 2, "functionType" : 2,
        "commentContent" : content, "agreeNum" : 0, "commentNum" : 0, "objectId" : obj_id }),
        dataType : "json",
        contentType:"application/json;charset=utf-8",
        url : "/comment/api/comment",
        success : function (res) {
            if(res.code == 200) {
                window.location.reload();
            }
        }
    });
}