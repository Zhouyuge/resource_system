$(function () {
   var paper_id = getQueryString('paper_id');
   var page_num = getQueryString('paper_num')
   var uni_id = getQueryString('uni_id')

    if(page_num == '') {
        page_num = 0;
    }

    showPaperTitles();

    showUni();

    function showUni(){
        var url = '/uni/api/uni/' + uni_id;
        $.getJSON(url, function (data) {
            if(data.success) {
                var uni = data.data;
                var html = '';
                var html2 ='';
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
                    '        </div>';

                html2 += '<a href="uni_list?uni_id=' + uni_id + '">返回试卷列表</a>';
            }
            $('#uni_info').html(html);
            $('#paper_name').html(html2);
        });
    }


    function showPaperTitles() {
       var url = '/uni/api/paper_titles/' + paper_id + "/" + page_num;
       $.getJSON(url, function (data) {
           var paperTitleList = data.data;
           var html = '';
           paperTitleList.map(function (item, index) {
               html += '<tr>\n' +
                   '     <td><a href="paper_detail?title_id=' + item.id + '">' + item.paperTitleName + '</td>\n' +
                   '     <td>单选题</td>\n' +
                   '    </tr>\n';
           });
           $("#papers").html(html);
       })
   }
});