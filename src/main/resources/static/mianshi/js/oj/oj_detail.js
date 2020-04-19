$(function () {
    var id = getQueryString('oj_id');
    showOJ();

    function showOJ() {
        var url = '/problem/api/pro/' + id;
        $.getJSON(url, function (data) {
            if(data.code == 200) {
                var item = data.data;
                var html = '';
                $('#title').html(item.problemName);
                $('#oj_detail').html(item.problemContent);
            }
        })
    }
})