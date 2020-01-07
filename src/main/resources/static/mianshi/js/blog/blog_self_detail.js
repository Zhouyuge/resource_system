$(function(){
   var id = getQueryString('id');
   var url = "/bc/api/blog_rest_detail/" + id;

   getDetailBlog();

   function getDetailBlog(){
       $.getJSON(url, function(data) {
           var html = '<strong style="font-size: 20px">'+data.blogName+'</strong>\n' +
               '       <div style="margin-top: 15px; color: grey">\n' +
               '            <span>浏览:'+data.viewNum+'&nbsp;|&nbsp;点赞:'+data.agreeNum+'&nbsp;|&nbsp;2019-11-25</span>\n' +
               '            <a href="http://localhost:8082?id='+data.blogId+'" style="margin-left:10px;color: #5FB878">编辑</a>\n' +
               '            <a href="" style="margin-left:10px;color: #5FB878">删除</a>\n' +
               '       </div>\n' +
               '\n' +
               '       <div class="author_info" style="margin-top: 15px">\n' +
               '\n' +
               ' <div>'+data.blogContent+'</div>      </div>'
           $("#blog_infos").html(html);

       });
   }
});