$(function () {
    showAll();
    function showAll() {
        var type_id = getQueryString('type_id');
        var url ='';
        if(type_id != '') {
            url = '/post/api/post_type/' + type_id + '/1';
        }else {
            url = '/post/api/post/1';
        }

        $.getJSON(url, function (data) {
            var html = '';
            var post = data.data;
            if(data.success) {
                post.map(function (item, index) {
                    html += '                <a href="post_detail?post_id=' + item.id + '"><div class="layui-col-md3" style="border: 1px solid #ebebeb;margin-left: 40px; margin-top: 10px">\n' +
                        '                   <div style="margin-left: 10px; margin-top: 20px; margin-bottom: 20px" class="layui-row">\n' +
                        '                        <img class="layui-circle layui-col-md3" width="50px" height="60px" src="' + item.factoryImg + '"/>\n' +
                        '                        <div style="margin-left: 10px" class="layui-col-md7">\n' +
                        '                            <b style="font-size: 16px" title="' + item.postName + '">' + item.simpleName + '</b>\n' +
                        '                            <br/>\n' +
                        '                            <br/>\n' +
                        '                            <span style="color: grey" title="' + item.factoryName + '">' + item.simpleFactoryName + '</span>\n' +
                        '                        </div>\n' +
                        '                    </div>\n' +
                        '                </div></a>\n'
                });
                $('#content').html(html);
            }
        })
    }
})