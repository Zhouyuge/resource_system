$(function () {
    getTechDetail();

    function getTechDetail() {
        var id = getQueryString('tech_id');
        var url = "/tech/api/tech/" + id;

        $.getJSON(url, function (data) {
            if(data.success) {
                var techDetail = data.data;
                var html = '';
                var btn_html = '';
                var tech_html = '';
                html += '<div class="layui-col-md1" style="margin: 20px">\n' +
                    '            <img width="105px" height="105px" src = "' + techDetail.technologyPic + '" />\n' +
                    '        </div>\n' +
                    '        <div class="layui-col-md8" style="margin: 20px">\n' +
                    '            <b style="font-size: 20px">' + techDetail.technologyName + '</b>\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '            <button type="button" class="layui-btn layui-btn-xs layui-btn-primary layui-btn-radius">' + techDetail.technologyTypeName + '</button>\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '            <span>' + techDetail.technologyIntroduction + '</span>\n' +
                    '        </div>\n' +
                    '\n' +
                    '        <div class="layui-col-md1" style="margin-left: 20px; margin-top: 40px">\n' +
                    '            <button class="layui-btn layui-btn-lg layui-btn-normal">我使用过</button>\n' +
                    '            <br/>\n' +
                    '            <span style="color: #888">共' + techDetail.technologyNum + '人使用</span>\n' +
                    '        </div>'

                btn_html += '<button id="' + techDetail.id + '" onclick="fileUpload(this)" class="layui-btn layui-btn-danger">添加资料</button>\n' +
                    '                <br/>\n' +
                    '                <br/>';
                var techFiles = techDetail.techFileList;
                if(techFiles.length > 0) {
                    var no_sty = document.getElementById("no_sty");
                    no_sty.style.display = "none";
                    techFiles.map(function (item, index) {
                        if(item.fileType == 1) {
                            tech_html += '                <div style="margin: 20px; border: 1px solid #e0e0e0;" class="layui-col-md4 layui-row">\n' +
                                '                    <div class="layui-col-md1" style="background: #e7e7e7; text-align: center; height: 77px; ">\n' +
                                '                        <div style="margin-top: 15px">\n' +
                                '                            <i class="layui-icon layui-icon-up"></i><br/>\n' +
                                '                            <span>' + item.viewNum + '</span>\n' +
                                '                        </div>\n' +
                                '                    </div>\n' +
                                '                    <div class="layui-col-md11" style="background: #d9edf7">\n' +
                                '                        <a id="' + item.fileDownUrl + '" onclick="toPdfDetail(this)">\n' +
                                '                            <img style="margin-left: 10px; margin-top: 20px; margin-bottom: 20px" src = "http://localhost:10086/img/tech_img/mod1.png" />\n' +
                                '                            <span style="margin-left: 5px;" title="' + item.fileName + '">' + item.simpleName + '</span>\n' +
                                '                        </a>\n' +
                                '                    </div>\n' +
                                '                </div>\n';
                        } else {
                            tech_html += '                <div style="margin: 20px; border: 1px solid #e0e0e0;" class="layui-col-md4 layui-row">\n' +
                                '                    <div class="layui-col-md1" style="background: #e7e7e7; text-align: center; height: 77px; ">\n' +
                                '                        <div style="margin-top: 15px">\n' +
                                '                            <i class="layui-icon layui-icon-up"></i><br/>\n' +
                                '                            <span>' + item.viewNum + '</span>\n' +
                                '                        </div>\n' +
                                '                    </div>\n' +
                                '                    <div class="layui-col-md11" style="background: #d9edf7">\n' +
                                '                        <a href="' + item.fileUrl + '">\n' +
                                '                            <img style="margin-left: 10px; margin-top: 20px; margin-bottom: 20px" src = "http://localhost:10086/img/tech_img/mod1.png" />\n' +
                                '                            <span style="margin-left: 5px;" title="' + item.fileName + '">' + item.simpleName + '</span>\n' +
                                '                        </a>\n' +
                                '                    </div>\n' +
                                '                </div>\n';
                        }
                    });
                 }
            }
            $('#tech_detail').html(html);
            $('#file_btn').html(btn_html);
            $('#tech_material').html(tech_html);
        })
    }
})