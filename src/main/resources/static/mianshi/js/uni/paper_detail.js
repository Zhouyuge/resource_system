$(function () {
    var title_id = getQueryString('title_id');

    showTitleDetail();

    function showTitleDetail() {
        var url = '/uni/api/paper_title/' + title_id;
        $.getJSON(url, function (data) {
            if(data.success) {
                var detail = data.data;
                var html = '';
                html += detail.paperTitleName + '\n' +
                    '                <ul style="margin-top: 20px">\n' +
                   detail.paperTitleBody +
                    '                </ul>';
                $('#title_detail').html(html);

                var lis = document.getElementsByTagName("pre");
                for(var i = 0; i < lis.length; i ++){
                    if(i == 0){
                        lis[i].prepend("A、");
                    } else
                        if (i == 1){
                            lis[i].prepend("B、");
                        } else
                            if(i == 2) {
                                lis[i].prepend("C、");
                            } else
                                if(i == 3) {
                                    lis[i].prepend("D、");
                                }
                }
            }
        })
    }
})