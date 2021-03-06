package com.bishe.main.entity.result;

/**
 * @author Kirito
 * @Date 2020/2/18 17:22
 */
public class CodeMsg {
     private int code;

     private String msg;

     //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常: %s");

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public CodeMsg fillArgs(Object... args){
        int code = this.code;
        String msg = String.format(this.msg, args);
        return  new CodeMsg(code, msg);
    }

    public CodeMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
