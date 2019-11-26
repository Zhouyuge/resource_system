$(function () {
   var f_url = '/st/api/ftype';

   getFType();

   function getFType() {
       $.getJSON(f_url, function(data){
           var html = '';
           if(data.success){
              var i = data.data;
              i.map(function (item, index) {
                  html += '<div style="margin: 22px;background: #E9E7E7"><h3>'+ item.typeName + '</h3>' +
                      '<form class="layui-form" action=""><div class="layui-form-item" style="margin: 22px;" id="f_id'+item.typeId+'"></div></form></div>';
              });
            }
           $('#types').html(html);
       });
   }

    for(var i = 1; i < 7; i++) {
        var s_url = '/st/api/stype/' + i;
        getStype(s_url, i);
    }

});

