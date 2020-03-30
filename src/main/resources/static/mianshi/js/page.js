function pre() {
    var num = getQueryString('id');
    if (num <= 1) {
        alert("这是第一章哟~");
    } else {
        num--;
        window.location.href = 'http://39.106.218.135:8080/bs/index/mianshi?id=' + num;
    }
}

function next() {
    var num = getQueryString('id');
    num++;
    window.location.href = 'http://39.106.218.135:8080/bs/index/mianshi?id=' + num;
}