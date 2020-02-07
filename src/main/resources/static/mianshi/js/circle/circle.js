$(function(){
   var id = getQueryString("id");
   var page = getQueryString("pageNum");

   getCircles();

   function getCircles() {
       if(page == '' || page < 0) {
           page = 1;
       }

       var url = '';
       if (id != '' || id > 0) {
           url = '/cir/api/circle/type/' + id + '/' + page;
       } else {
           url ="/cir/api/circle/" + page;
       }
       var total;
       var circleList = [];
       $.ajaxSettings.async = false;
       $.getJSON(url, function (data) {
           var html = '';
           if (data.success) {
            total = data.total;
            circls = data.data;
            circls.map(function (item, index) {
                html += '            <div class="layui-col-md5 layui-row" style="margin: 15px">\n' +
                    '                <a href="circle_detail?cir_id='+ item.id +'"><img class="layui-col-md3" width="80px" height="80px" src="' + item.circlePic + '"></a>\n' +
                    '                <div class="layui-col-md9">\n' +
                    '                    <a href="circle_detail?cri_id=' + item.id + '"><b style="margin-left: 10px">' + item.circleName + '</b></a>\n' +
                    '                    <br/>\n' +
                    '                    <span style="color: grey; margin: 10px">0动态</span>\n' +
                    '                    <span style="color: grey; margin: 10px">' + item.circleUserNum + '圈友</span>\n' +
                    '                    <br/>\n' +
                    '                    <button style="margin: 10px" class="layui-btn layui-btn-radius layui-btn-sm">+ 加入</button>\n' +
                    '                </div>\n' +
                    '            </div>\n'
            });
            $('#circles').html(html);
          }
       });
       layui.use('laypage', function(){
           var laypage = layui.laypage;

           //执行一个laypage实例
           laypage.render({
               elem: 'test1' //注//意，这里的 test1 是 ID，不用加 # 号
               ,count: total //数据总数，从服务端得到
               ,curr: page
               ,jump: function (obj, first) {
                   if(! first) {
                       var url = window.location.href ;
                       if(id != '' || id > 0) {
                           if(url.indexOf("&") > 0) {
                               url = url.split("&")[0];
                               url += '&pageNum=' + obj.curr;
                           } else {
                               url += '&pageNum=' + obj.curr;
                           }
                       } else {
                           if(url.indexOf("?") > 0) {
                               url = url.split("?")[0];
                               url += '?pageNum=' + obj.curr;
                           } else {
                               url += '?pageNum=' + obj.curr;
                           }
                       }
                       window.location.href = url;
                   }
               }
           });
       });
   }

});