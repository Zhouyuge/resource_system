$(function () {
    var type = getQueryString('category');           //分类
    var page = getQueryString('page');               //页数
    if (page == '' || page < 1) {
        page = 1;
    }
    var url = '/zt/api/etile/' + type + '/' + page;          //地址
    getEtiles();

    function getEtiles() {
        var pic_html = '<img style="position: absolute; left: 15%" src="http://39.106.218.135:10086/img/img/b' + type + '.png"/>'
        var html = '<table class="table">'
            + '<caption><div class="row"><div class="col-lg-1"></div>'
            + '<div class="input-group col-md-4"><input type="text" class="form-control" aria-describedby="sizing-addon1" placeholder="请输入题目名称..."><span style="background: #5bc0de" class="glyphicon glyphicon-search input-group-addon" id="sizing-addon1"></span></div></div>'
            + '</caption><div class="row"><div class="col-lg-1"></div>'
            + '<thead style="background: #c4e3f3"><tr>'
            + '<th>考点</th> '
            + '<th>题目</th></tr></thead>'
            + '<tbody>'
        $.getJSON(url, function (data) {
            if (data.success) {
                var e = data.etiles;
                e.map(function (item, index) {
                    html += '<tr>'
                        + item.etilePoint
                        + '<td><a href = "detail_etile?etile_no=' + item.etileNo + '&etile_no_ali=' + item.etileNoAli + '">' + item.etileName + '</a></td></tr>';
                });
            }
            html += '</tbody></table>';
            $('#etiles').html(html);
            $('#pic_bg').html(pic_html);
        });
    }
});