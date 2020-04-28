package com.bishe.main.handler;

import com.bishe.main.entity.result.CodeMsg;
import com.bishe.main.entity.result.Result;
import com.bishe.main.exception.RunException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/18 17:39
 */

//该注解定义全局异常处理器
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    //该注解声明异常处理方法
    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        //对于自定义异常的处理
        if (e instanceof RunException) {
            RunException ex = (RunException) e;
            return Result.error(ex.getCodeMsg());
        } else
            //对于绑定异常的处理，使用jsr303中的自定义注解抛出的异常属于绑定异常
            if (e instanceof BindException) {
                BindException ex = (BindException) e;
                List<ObjectError> errors = ex.getAllErrors();
                ObjectError objectError = errors.get(0);
                String msg = objectError.getDefaultMessage();
                return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
            } else {
                return Result.error(CodeMsg.SERVER_ERROR);
            }
    }

}
