function getQueryString(name){
    var reg=new RegExp("(^|&)"+name+"=([^&]*)(&|$)");
    var r=window.location.search.substr(1).match(reg);
    if(r!=null){//获取地址不为空的情况下返回 需要的信息
        return decodeURIComponent(r[2]);
    }
    return '';
}

function co(obj){
    var p = obj.parentNode;
    if(p.classList.contains("layui-nav-itemed")){
        p.classList.remove("layui-nav-itemed");     //删除展开
    }else{
        p.classList.add("layui-nav-itemed");                //添加展开

    }
}