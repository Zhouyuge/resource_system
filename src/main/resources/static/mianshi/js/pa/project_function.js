function downloadFile(obj) {
    var url = obj.getAttribute("self-data2");
    window.open(url);
}

function deleteItem(obj) {
    alert(obj.id);
    var id = obj.id;
    var url = '/pa/api/project_demo';

    $.ajax({
        url: url,
        data: {_method : "DELETE", "demoId": id},
        type: "POST",
        dataType: "json",
        success: function (res) {
            if(res.code == 200) {
                location.reload();
            }
        }

    })
}