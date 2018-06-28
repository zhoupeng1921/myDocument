package com.xhx.springboot.config;

import com.xhx.springboot.exception.BusinessException;
import com.xhx.springboot.result.JsonResult;
import com.xhx.springboot.result.ReturnEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * xuhaixing
 * 2018/6/24 11:00
 * 返回string或者json需要@ResponseBody
 * 用RestControllerAdvice，就不用加@ResponseBody了
 **/
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public JsonResult<ReturnEnum> exceptionHandler(HttpServletRequest request, Exception e) {
        Throwable throwable = getBusinessException(e);
        if (!Objects.isNull(throwable)) {
            ReturnEnum returnEnum = ((BusinessException) throwable).getReturnEnum();
            if(((BusinessException)throwable).getReturnEnum()!=null) {
                return JsonResult.error(returnEnum);
            }
        }
        return JsonResult.error();
    }

    /**
     * 若有异常进行嵌套，打印出每个异常的堆栈信息，若包含自定义异常，返回最内部的BusinessException异常。
     * @param e
     * @return
     */
    private Throwable getBusinessException(Throwable e) {
        if (e == null) {
            return null;
        } else if (e instanceof BusinessException) {
            if(((BusinessException)e).getReturnEnum()!=null) {
                logger.info(((BusinessException) e).getReturnEnum().toString());
            }
            e.printStackTrace();
            Throwable temp = getBusinessException(e.getCause());
            if (temp == null) {
                return e;
            } else {
                return temp;
            }
        } else {
            e.printStackTrace();
            return getBusinessException(e.getCause());
        }
    }

}
