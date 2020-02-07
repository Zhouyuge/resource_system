$(function(){
    var id = getQueryString('cir_id');

    var url = '/cir/api/circle_detail/' + id;

    getCircleDetail();

    function getCircleDetail(){
        $.getJSON(url, function (data) {
            var circleDetail = data.data;
            var html = '';
            html += '<div class="layui-col-md1" style="margin: 20px;">\n' +
                '          <img width="110px" height="110px" src="' + circleDetail.circlePic + '">\n' +
                '       </div>\n' +
                '       <div style="margin-left: 20px; margin-top: 20px" class="layui-col-md7">\n' +
                '            <b style="font-size: 18px">' + circleDetail.circleName + '</b>\n' +
                '            <br/>\n' +
                '            <span style="color: grey">' + circleDetail.circleInstruction + '</span>\n' +
                '            <br/>\n' +
                '            <br/>\n';
            var labels = circleDetail.circleLabel.split(' ');
            labels.map(function (value) {
                html += '<button class="layui-btn-primary layui-btn-radius layui-btn-sm">' + value + '</button>\n';
            });

            html+='       </div>\n' +
                '       <div class="layui-col-md-offset1 layui-col-md1" style="margin-top: 40px; text-align: center" >\n' +
                '            <button class="layui-btn-radius layui-btn layui-btn-lg">+加入圈子</button>\n' +
                '            <span style="color: grey">' + circleDetail.circleUserNum + '个圈友</span>\n' +
                '       </div>';

            $('#circle_detail').html(html);
            $('#title').append(circleDetail.circleName);
        });
    }

});