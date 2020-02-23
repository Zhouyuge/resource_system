$(function () {
    showProjectActionList();

    function showProjectActionList() {
        var url = '/pa/api/projects';
        $.ajaxSettings.async=false;
        $.getJSON(url, function (data) {
            if(data.code == 200) {
                var list = data.data;
                var html = '';
                list.map(function (item, index) {
                    if(item.id % 4 == 1) {
                        html += '               <a href="project_detail?action_id=' + item.id + '"><div class="layui-col-md3" style="margin-left: 40px; margin-top: 10px; margin-bottom: 10px; margin-right: 20px; width: 218px;">\n' +
                            '                    <img width="218px" height="146px" src="' + item.actionImg + '" />\n' +
                            '                    <div style="border-left: 1px solid #ebebeb; border-right: 1px solid #ebebeb; border-bottom: 1px solid #ebebeb">\n' +
                            '                        <br/>\n' +
                            '                        <b style="font-family: \'Microsoft YaHei UI\'; margin-left: 10px;">' + item.actionName + '</b>\n' +
                            '                        <span style="margin-left: 20px" class="layui-badge layui-bg-blue">' + item.actionType + '</span>\n' +
                            '                        <div style="margin-top: 30px;">\n' +
                            '                            <span style="color: #5f5f5f; margin-left: 10px;">' + item.actionProposeTime.split(" ")[3] + '</span>\n' +
                            '                            <span class="level' + item.actionHard + '" style="margin-left: 20%"></span>\n' +
                            '                        </div>\n' +
                            '                    </div>\n' +
                            '                </div></a>\n';
                    } else {
                        html += '               <a href="project_detail?action_id=' + item.id + '"><div class="layui-col-md3" style="margin: 10px; margin-right: 20px; width: 218px; ">\n' +
                            '                    <img width="218px" height="146px" src="' + item.actionImg + '" />\n' +
                            '                    <div style="border-left: 1px solid #ebebeb; border-right: 1px solid #ebebeb; border-bottom: 1px solid #ebebeb">\n' +
                            '                        <br/>\n' +
                            '                        <b style="font-family: \'Microsoft YaHei UI\'; margin-left: 10px;">' + item.actionName + '</b>\n' +
                            '                        <span style="margin-left: 20px" class="layui-badge layui-bg-blue">' + item.actionType + '</span>\n' +
                            '                        <div style="margin-top: 30px;">\n' +
                            '                            <span style="color: #5f5f5f; margin-left: 10px;">' + item.actionProposeTime.split(" ")[3] + '</span>\n' +
                            '                            <span class="level' + item.actionHard + '" style="margin-left: 20%"></span>\n' +
                            '                        </div>\n' +
                            '                    </div>\n' +
                            '                </div></a>\n'
                    }
                });
                $('#action_list').html(html);
                layui.use('rate', function(){
                    var rate = layui.rate;

                    //渲染
                    var ins1 = rate.render({
                        elem: '.level1',  //绑定元素
                        value: 1
                    });
                    //渲染
                    var ins2 = rate.render({
                        elem: '.level2',  //绑定元素
                        value: 2
                    });
                    //渲染
                    var ins3 = rate.render({
                        elem: '.level3',  //绑定元素
                        value: 3
                    });
                    //渲染
                    var ins4 = rate.render({
                        elem: '.level4',  //绑定元素
                        value: 4
                    });

                    //渲染
                    var ins5 = rate.render({
                        elem: '.level5',  //绑定元素
                        value: 5
                    });
                });
            }
        })
    }
})