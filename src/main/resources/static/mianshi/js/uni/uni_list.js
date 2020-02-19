$(function () {
    var uni_id = getQueryString('uni_id');

    showUni();

    function showUni(){
        var url = '/uni/api/uni/' + uni_id;
        $.getJSON(url, function (data) {
           if(data.success) {
               var uni = data.data;
               var html = '';
               html += '<div class="layui-col-md3">\n' +
                   '            <div style="margin-top: 40px; margin-left: 40px">\n' +
                   '                <span style="font-size: 36px"><b>' + uni.univerName + '</b></span>\n' +
                   '            </div>\n' +
                   '\n' +
                   '            <div style="margin-left: 40px; margin-top: 10px">\n' +
                   '                <a href="' + uni.univerUrl + '">' + uni.univerUrl + '</a>\n' +
                   '            </div>\n' +
                   '        </div>\n' +
                   '\n' +
                   '        <div class="layui-col-md-offset6 layui-col-md3" style="margin-top: 20px">\n' +
                   '            <img width="150px" height="150px" src="' + uni.univerImg + '">\n' +
                   '        </div>'
           }
           $('#uni_info').html(html);
        });
    }

    showPapers();

    function showPapers() {
        var url = "/uni/api/paper/" + uni_id;
        $.getJSON(url, function (data) {
            var html = '';
            var paperList = data.data;
            paperList.map(function (item, index) {
                html += '<tr>\n' +
                    '     <td>' + item.paperYear + '</td>\n' +
                    '     <td>' + item.uniName + '</td>\n' +
                    '     <td><a href="paper_list?paper_id=' + item.id + '&uni_id=' + uni_id + '">' + item.paperCode + '</td>\n' +
                    '     <td>' + item.paperHot + '</td>\n' +
                    '    </tr>\n';
            });
            $('#papers').html(html);
        })
    }

})