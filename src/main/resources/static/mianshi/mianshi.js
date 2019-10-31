$(function(){
   var num = getQueryString('id');
   var url = 'api/getarticle/' + num;
   getArticle();
   getTitles();
    function getArticle(){
        $.getJSON(url, function(data){
            if(data.success){
                $('#article').html(data.article);
            }else{
                alert(data.errMsg);
            }
        });
    }

    function getTitles(){
        var titleUrl = 'api/gettitles';
        $.getJSON(titleUrl, function(data){
                var html = '';
                $.each(data.titles, function (key, values) {
                    html += '<li class="layui-nav-item">'
                        + '<a onclick="co(this)">' + key + '<span class = "layui-nav-more"></span></a>'
                        + '<dl class = "layui-nav-child">';
                    $(values).each(function () {
                        var num = this.split('.');
                        html += '<dd><a href = "test?id=' + num[0] + '">' + this + '</a></dd>';
                    });
                    html += '</dl></li>';
                });
                $('#menus').html(html);
           });
    }
});