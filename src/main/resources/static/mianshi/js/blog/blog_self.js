$(function(){
   var url = '/bc/api/blog_rest';

   getBlogs();

   function getBlogs(){
       $.getJSON(url, function(data){
          var html = '';
          data.map(function(item, index){
             html += ' <strong style="font-size: 16px;">'+ item.blogName +'</strong>\n' +
                 '        <div style="margin-top: 10px">\n' +
                 '            <span style="color: grey">'+item.blogNote+'</span>\n' +
                 '        </div>\n' +
                 '        <div style="margin-top: 10px">\n' +
                 '            <i style="color: grey" class="layui-icon layui-icon-date">'+item.blogCreateTime+'</i>\n' +
                 '            <i style="margin-left: 88%;" class="layui-icon layui-icon-praise">'+item.agreeNum+'</i>\n' +
                 '            <i style="margin-left: 2%" class="layui-icon layui-icon-read">'+item.viewNum+'</i>\n' +
                 '        </div>\n' +
                 '        <hr class="layui-bg-grey">'
          });
          $('#blogs').html(html);
       });
   }

});