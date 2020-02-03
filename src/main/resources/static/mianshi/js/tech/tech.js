$(function () {
    getTechLang();

    function getTechLang(){
        var url = '/tech/api/technology/1';
        
        $.getJSON(url, function(data){
           if (data.success) {
               var techs = data.data;
               var html = '';
               techs.map(function (item, index) {
                   html += '                <a href="tech_detail?tech_id=' + item.id + '">\n' +
                       '                <div style="margin: 18px; text-align: center; border: 1px solid #e0e0e0;" class="layui-col-md2">\n' +
                       '                    <img style="margin-top: 10px;" src="' + item.technologyPic + '">\n' +
                       '                    <div style="margin: 10px">\n' +
                       '                        <span>' + item.technologyName + '</span>\n' +
                       '                    </div>\n' +
                       '                    <div style="margin: 10px">\n' +
                       '                        <button type="button" class="layui-btn layui-btn-xs layui-btn-primary layui-btn-radius">' + item.technologyTypeName + '</button>\n' +
                       '                    </div>\n' +
                       '                    <div class="layui-row" style="margin-top: 10px; background: #e0e0e0; height: 50px">\n' +
                       '                        <div class="layui-col-md6" style="margin-top: 15px">\n' +
                       '                            <span style="font-size: 16px">' + item.technologyNum + '</span>\n' +
                       '                        </div>\n' +
                       '                        <div class="layui-col-md6" style="margin-top: 15px">\n' +
                       '                            <span style="font-size: 16px">0评价</span>\n' +
                       '                        </div>\n' +
                       '                    </div>\n' +
                       '                </div>\n' +
                       '                </a>\n';
               })
           }
           $('#tech_lang').html(html);
        });
    }

    getTechMath();

    function getTechMath(){
        var url = '/tech/api/technology/2';

        $.getJSON(url, function(data){
            if (data.success) {
                var techs = data.data;
                var html = '';
                techs.map(function (item, index) {
                    html += '         <a href="tech_detail?tech_id=' + item.id + '">\n' +
                        '                <div style="margin: 18px; text-align: center; border: 1px solid #e0e0e0;" class="layui-col-md2">\n' +
                        '                    <img style="margin-top: 10px;" src="' + item.technologyPic + '">\n' +
                        '                    <div style="margin: 10px">\n' +
                        '                        <span>' + item.technologyName + '</span>\n' +
                        '                    </div>\n' +
                        '                    <div style="margin: 10px">\n' +
                        '                        <button type="button" class="layui-btn layui-btn-xs layui-btn-primary layui-btn-radius">' + item.technologyTypeName + '</button>\n' +
                        '                    </div>\n' +
                        '                    <div class="layui-row" style="margin-top: 10px; background: #e0e0e0; height: 50px">\n' +
                        '                        <div class="layui-col-md6" style="margin-top: 15px">\n' +
                        '                            <span style="font-size: 16px">' + item.technologyNum + '</span>\n' +
                        '                        </div>\n' +
                        '                        <div class="layui-col-md6" style="margin-top: 15px">\n' +
                        '                            <span style="font-size: 16px">0评价</span>\n' +
                        '                        </div>\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '                </a>\n';
                })
            }
            $('#tech_math').html(html);
        });
    }


})