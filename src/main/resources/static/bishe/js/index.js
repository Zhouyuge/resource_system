
// 显示时间
function showTime() {
        var week = ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"];
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDay();
        var hours = date.getHours();
        var minute = date.getMinutes();
        var seconds = date.getSeconds();
        var index = date.getDay();
        var html = year + "-" + month + "-" + day + "  " +
            hours + ":" + minute + ":" + seconds + "   " + week[index] ;
        $('#time').html(html);
    }
    // 1秒执行一次
    setInterval("showTime()", 1000);