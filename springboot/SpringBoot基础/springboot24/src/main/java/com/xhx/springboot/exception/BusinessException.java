package com.xhx.springboot.exception;

import com.xhx.springboot.result.ReturnEnum;

/**
 * xuhaixing
 * 2018/6/24 11:38
 **/
public class BusinessException extends Exception {
    private ReturnEnum returnEnum;
    private Throwable cause;

    public BusinessException(ReturnEnum returnEnum) {
        super(returnEnum.getMessage());
        this.returnEnum = returnEnum;
    }

    public BusinessException(ReturnEnum returnEnum, Throwable cause) {
        super(returnEnum.getMessage(), cause);
        this.returnEnum = returnEnum;
        this.cause = cause;
    }
    public BusinessException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public ReturnEnum getReturnEnum() {
        return returnEnum;
    }
}
