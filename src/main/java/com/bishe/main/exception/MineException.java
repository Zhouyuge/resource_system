package com.bishe.main.exception;

import com.bishe.main.entity.result.CodeMsg;

/**
 * @author Kirito
 * @Date 2020/2/18 17:33
 */
public class MineException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private CodeMsg codeMsg;

    public MineException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
