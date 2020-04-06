package com.bishe.main.ro;

/**
 * @author Kirito
 * @Date 2019/11/14 15:04
 */
public enum LoginRo {
    SUCCESS(200, "登录成功！"), FAIL(400, "账号或密码错误")
    ,ERROR(500, "服务器内部错误"), EXSIT(100, "该账号已经存在")
    ,SUCCESS_MSG(202, ""), TIME_OUT(401,"此session已经过期");

    private Integer code;
    private String msg;

    LoginRo(Integer code, String msg){
        this.code = code;
        this.msg =msg;
    }

    public String getMsg(){
        return this.msg;
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return this.code;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
}
