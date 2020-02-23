$(function () {
    var action_id = getQueryString("action_id");

    showProject();

    function showProject() {
        var url = "/pa/api/project/" + action_id;
        $.getJSON(url, function (data) {
            if(data.code == 200) {
                var action = data.data;
                var html = '';
                html += '<div style="margin: 20px">\n' +
                    '                        <span class="layui-badge-dot"></span>\n' +
                    '                        <b><span style="font-size: 16px;">项目介绍</span></b>\n' +
                    '                        <br/><br/>\n' +
                    '                        <span>' + action.actionName.split(" ")[0] + '</span>\n' +
                    '                    </div>\n' +
                    '\n' +
                    '                    <hr style="margin: 20px"/>\n' +
                    '\n' +
                    '                    <div style="margin: 20px">\n' +
                    '                        <span class="layui-badge-dot"></span>\n' +
                    '                        <b><span style="font-size: 16px;">项目概括</span></b>\n' +
                    '                        <div style="margin-top: 20px;">\n' +
                    '                            <div style="margin: 20px">\n' +
                    '                                <img width="20px" height="20px" src="http://localhost:10086/img/action/1.png">\n' +
                    '                                <span style="margin-left: 20px; font-size: 16px">技术栈</span>\n' +
                    '                                <span style="position: absolute; left: 500px">' + action.actionProposeTime.split(" ")[0] + '</span>\n' +
                    '                            </div>\n' +
                    '                            <div style="margin: 20px">\n' +
                    '                                <img width="20px" height="20px" src="http://localhost:10086/img/action/2.png">\n' +
                    '                                <span style="margin-left: 20px; font-size: 16px"> 建议用时</span>\n' +
                    '                                <span style="position: absolute; left: 500px">' + action.actionProposeTime.split(" ")[1] + '</span>\n' +
                    '                            </div>\n' +
                    '                            <div style="margin: 20px">\n' +
                    '                                <img width="20px" height="20px" src="http://localhost:10086/img/action/3.png">\n' +
                    '                                <span style="margin-left: 20px; font-size: 16px">竞争力</span>\n' +
                    '                                <span style="position: absolute; left: 500px">' + action.actionProposeTime.split(" ")[2] + '</span>\n' +
                    '                            </div>\n' +
                    '                            <div style="margin: 20px">\n' +
                    '                                <img width="20px" height="20px" src="http://localhost:10086/img/action/4.png">\n' +
                    '                                <span style="margin-left: 20px; font-size: 16px">难度</span>\n' +
                    '                                <span style="position: absolute; left: 500px">' + action.actionProposeTime.split(" ")[3] + '</span>\n' +
                    '                            </div>\n' +
                    '                            <div style="margin: 20px">\n' +
                    '                                <img width="20px" height="20px" src="http://localhost:10086/img/action/5.png">\n' +
                    '                                <span style="margin-left: 20px; font-size: 16px">职位</span>\n' +
                    '                                <span style="position: absolute; left: 500px">' + action.actionProposeTime.split(" ")[4] + '</span>\n' +
                    '                            </div>\n' +
                    '\n' +
                    '                        </div>';

                $('#action').html(html);
                $('#project_name').append(action.actionName.split(" ")[0]);
                $('#title').append(action.actionName.split(" ")[0]);
            }
        })
    }

    showMyDemos();

    function showMyDemos() {
        var url = '/pa/api/mine_demo/' + action_id;
        $.getJSON(url, function(data) {
           if(data.code == 200) {
               var html = '';
               var demos = data.data;
               demos.map(function (item, index) {
                  html += '<tr>\n' +
                      '        <td>' + item.demoName + '</td>\n' +
                      '        <td>' + item.uploadTime + '</td>\n' +
                      '        <td><a href="javascript:void(0)" self-data="' + item.demoName + '" self-data1="' + item.demoDownUrl +'" self-data2 = "' + item.demoUrl + '" onclick="downloadFile(this)"><span style="color: #009f95">下载</span></a>   |   <a id="' + item.id + '" onclick="deleteItem(this)"><span style="color: #FD482C">删除</span></a></td>\n' +
                      '   </tr>'
               });
               $('#myDemo').html(html);
           }
        });
    }

    showNotMyDemos();

    function showNotMyDemos() {
        var url = '/pa/api/no_mine_demo/' + action_id;
        $.getJSON(url, function (data) {
            if(data.code == 200){
                var demoList = data.data;
                var html = '';
                demoList.map(function (item, index) {
                    html += '                            <div class="layui-col-md5" style="border: 1px solid #ebebeb; height: 100px; margin: 15px">\n' +
                        '                                <img style="margin: 10px" class="layui-circle" src="' + item.userHeadPic + '" height="30px" width="30px">\n' +
                        '                                <span style="color: grey;">' + item.userVisualName + '</span>&nbsp; /\n' +
                        '                                <span>' + item.demoName + '</span>\n' +
                        '                                <div>\n' +
                        '                                    <i class="layui-icon layui-icon-star-fill" style="color: #009f95; margin-left: 10px"></i> 0\n' +
                        '                                    <i class="layui-icon layui-icon-share" style="color: #009f95; margin-left: 50px"></i>0\n' +
                        '                                    <i class="layui-icon layui-icon-edit" style="color: #009f95; margin-left: 50px"></i>0\n' +
                        '                                </div>\n' +
                        '                            </div>\n'
                });
                $('#not_my_demo').html(html);
            }
        })
    }
})