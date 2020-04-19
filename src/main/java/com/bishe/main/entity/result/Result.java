package com.bishe.main.entity.result;

/**
 * @author Kirito
 * @Date 2020/2/18 17:17
 */
public class Result<T> {
    private int code;

    private String msg;

    private T data;

    private Integer page;
    /**
     * 请求成功时调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 请求失败或发生异常时的调用
     * @param codeMsg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<T>(codeMsg);
    }


    /**
     * 只传入数据默认成功，所以默认添加的code和msg
     * @param data
     */
    private Result(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    public Result(T data, String msg, Integer code){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(CodeMsg codeMsg) {
        if (codeMsg == null) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
