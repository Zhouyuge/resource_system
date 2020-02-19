$(function () {
    showUnis();

    function showUnis(){
        var type = getQueryString('city_name');
        if(type == '') {
            type = '北京';
        }
        var url = '/uni/api/unis/' + type;
        $.getJSON(url, function (data) {
           var unis = data.data;
           var html = '';
           unis.map(function (item, index) {
               html += '<div class="layui-col-md2" style="margin-right: 5px; margin-bottom: 20px">\n' +
                   '                    <a href="uni_list?uni_id=' + item.id + '"><h3 style="font-size: 20px"><b>' + item.univerName + '</b></h3></a>\n' +
                   '                    <br/>\n' +
                   '                    <span style="color: grey">共有' + item.titleNum + '道真题</span>\n' +
                   '                </div>';
           });
           $("#unis").html(html);
        });

        var city = $('#' + type)
        city.addClass("layui-btn layui-btn-radius layui-btn-sm");
    }
})