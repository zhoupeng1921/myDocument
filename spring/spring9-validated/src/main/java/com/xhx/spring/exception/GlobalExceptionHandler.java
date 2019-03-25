package com.xhx.spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 加@RequestBody  MethodArgumentNotValidException
     * form表单形式  BindException
     *
     * @param request
     * @param e
     * @return
     */

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Map<String, Object> bindExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("参数校验错误",e);
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String msg = allErrors.stream().map(err->String.format("%s:%s", allErrors.get(0).getCodes()[0],err.getDefaultMessage())).collect(Collectors.joining(","));
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 500);
        map.put("msg", msg);
        return map;
    }

    @ExceptionHandler(value = {BindException.class})
    public Map<String, Object> bindExceptionHandler(HttpServletRequest request, BindException e) {
        log.error("参数校验错误",e);
        List<ObjectError> allErrors = e.getAllErrors();
        String msg = allErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 500);
        map.put("msg", msg);
        return map;
    }


    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("参数校验错误",e);
        log.error("服务器发生错误", e);
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 500);
        map.put("msg", "服务器发生错误");
        return map;
    }
}
