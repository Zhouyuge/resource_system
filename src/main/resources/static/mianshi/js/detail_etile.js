$(function () {
    var no = getQueryString('etile_no');             //分类no
    var no_ali = getQueryString('etile_no_ali');     //分类下题号ali
    if (no_ali == '' || no_ali <= 0) {
        no_ali = 1;
    }
    var url = "/zt/api/etile_detail/" + no + "/" + no_ali;
    getEtileByNum();

    function getEtileByNum() {
        var html = '';                       //问题拼接
        var ans_html = '';                   //答案拼接
        $.getJSON(url, function (data) {
            if (data.success) {
                var etile = data.etile;
                html += etile.etitleQuestion;
                ans_html += etile.etitleAnswer;
                $('#question').html(html);
                $('#answer').html(ans_html);
                $('#title_e').append(etile.etileName);
                $('#no').append(etile.etileNoAli);
                $('#no_2').append(etile.etileNoAli);
                $('#count_q').append(data.size);
            } else {
                alert(data.errMsg);
            }
        });
    }

    layui.use('laypage', function () {
        var laypage = layui.laypage;
        var size = 0;       //总数大小
        var now = 0;        //当前页
        var no = 0;         //当前专题类别
        $.ajaxSettings.async = false;       //开启同步
        $.getJSON(url, function (data) {
            if (data.success) {
                size = data.size;
                now = data.etile.etileNoAli;
                no = data.etile.etileNo
            }
        });
        var re_url = 'http://localhost:8080/bs/index/topics/detail_etile?etile_no=' + no;
        //执行一个laypage实例
        laypage.render({
            elem: 'page_helper' //注意，这里的 page_helper 是 ID，不用加 # 号
            , count: size //数据总数，从服务端得到
            , limit: 1   //限制为1个
            , curr: now
            , layout: ['count', 'prev', 'page', 'next', 'refresh', 'skip']
            , jump: function (obj, first) {
                if (now > obj.count) {
                    alert("没有更多了哟！！");
                    window.location.href = re_url + '&etile_no_ali=' + obj.count;
                }
                if (!first) {         //第一次加载不执行
                    window.location.href = re_url + '&etile_no_ali=' + obj.curr;
                }
            }
        });
    });
});