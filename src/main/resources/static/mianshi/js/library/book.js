$(function () {
    var url = '/lib/api/book'
    getBookInfos();

    function getBookInfos() {
        $.ajaxSettings.async = false;
        $.getJSON(url, function (data) {
            var html = '';
            if (data.success) {
                var bookList = data.data;
                bookList.map(function (item, index) {
                    html += ' <div class="layui-col-md2" style="margin: 12px; text-align: center">\n' +
                        '                <a onclick="toBookDetail('+item.bookId+')"><img height="152px" width="130px" src="' + item.bookPic + '" />\n' +
                        '                <br/><span style="width:50px;white-space:nowrap;text-overflow:ellipsis;overflow:hidden;" title="' + item.bookName + '">' + item.bookName + '</span><br/>\n</a>' +
                        '                <span style="color: #7c7c7c;">' + item.bookRecomendNum + '牛油</span>\n' +
                        '                <span style="color: #7c7c7c;">推荐</span>\n' +
                        '              </div>';
                });
                $('#books').html(html);
            }
        });
    }

    var id = getQueryString('book_id')
    getBookDetail();
    function getBookDetail() {
        var book_url = '/lib/api/book/' + id;
        $.ajaxSettings.async = false;
        $.getJSON(book_url, function (result) {
            var html = '';
            if (result.success) {
                var book = result.data;
                html += '            <div style="position: relative; left: 20px; top: 20px; height: 200px" class="layui-row">\n' +
                    '                <img class="layui-col-md2" src="' + book.bookPic + '">\n' +
                    '                <div class="layui-col-md-offset1 layui-col-md5">\n' +
                    '                    <b style="font-size: 16px">'+ book.bookName + '</b>\n' +
                    '                    <ul>\n' +
                    '                        <li style="color: #9F9F9F; margin-top: 7px">作者: ' + book.bookAuthor + '</li>\n' +
                    '                        <li style="color: #9F9F9F; margin-top: 7px">定价: ' + book.bookPrice + '</li>\n' +
                    '                        <li style="color: #9F9F9F; margin-top: 7px">ISBN: ' + book.bookCode + '</li>\n' +
                    '                        <li style="color: #9F9F9F; margin-top: 7px">出版社:' + book.bookPress + '</li>\n' +
                    '                        <li style="color: #9F9F9F; margin-top: 7px">上架时间:' + book.bookTime + '</li>\n' +
                    '                    </ul>\n' +
                    '                </div>\n' +
                    '\n' +
                    '                <div style="text-align: center" class="layui-col-md-offset8">\n' +
                    '                    <span>' + book.bookRecomendNum + '牛油推荐</span><br/><br/><br/>\n' +
                    '                    <button type="button" class="layui-btn">我要推荐</button><br/><br/>\n' +
                    '                    <span style="color: #5FB878; font-size: 11px" class="layui-icon layui-icon-addition">添加到书单</span>\n' +
                    '                </div>\n' +
                        '            </div>\n'
            }
            $('#book_detail').html(html);
            $('#book_title').append(result.data.bookName);
        })
    }

})