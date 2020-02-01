$(function () {
    var id = getQueryString('id');
    var title = getQueryString('title');
    var url = '/ms/api/getarticle';
    getArticle();
    getTitles();

    function getArticle() {
        $.ajax({
            async : false,
            url : url,
            type : 'get',
            contentType : 'application/x-www-form-urlencoded',
            //或者contentType : 'application/json',
            dataType:'json',
            data : {"id" : id, "title" : title},
            success : function(data) {
                $('#article').html(data.article);
            },
            error:function(data){
                alert(data.errMsg);
            },
        });
    }

    function getTitles() {
        var titleUrl = '/ms/api/gettitles';

        $.ajax({
            async : false,
            url : titleUrl,
            type : 'get',
            contentType : 'application/x-www-form-urlencoded',
            //或者contentType : 'application/json',
            dataType:'json',
            data : {"title" : title},
            success : function(data) {
                var html = '';
                $.each(data.titles, function (key, values) {
                    html += '<li class="layui-nav-item layui-nav-itemed">'
                        + '<a onclick="co(this)">' + key + '<span class = "layui-nav-more"></span></a>'
                        + '<dl class = "layui-nav-child">';
                    $(values).each(function () {
                        var re = new RegExp("\\D")
                        var num = this.split(re);
                        html += '<dd><a href = "mianshi?id=' + num[0] + "." + num[1] + '&title='+ title +'">' + this + '</a></dd>';
                        console.log(num[0]);
                    });
                    html += '</dl></li>';
                });
                $('#menus').html(html);
            },
            error:function(data){
                alert(data.errMsg);
            },
        });
    }
});