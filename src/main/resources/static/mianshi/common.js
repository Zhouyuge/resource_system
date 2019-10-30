function getQueryString(name){
    var reg=new RegExp("(^|&)"+name+"=([^&]*)(&|$)");
    var r=window.location.search.substr(1).match(reg);
    if(r!=null){//获取地址不为空的情况下返回 需要的信息
        return decodeURIComponent(r[2]);
    }
    return '';
}