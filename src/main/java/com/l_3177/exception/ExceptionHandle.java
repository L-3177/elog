package com.l_3177.exception;

import com.l_3177.core.ResultEnum;
import com.l_3177.core.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    private static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler
    @ResponseBody
    public Object handle(HttpServletRequest request, Exception e) {
        if(e instanceof CustomException){
            CustomException ce = (CustomException) e;
            return ResultUtil.getError(ce.getCode(), ce.getMessage());
        }else {
            logger.error("【系统异常】: {} ",e.getMessage());
            return ResultUtil.getError(ResultEnum.SystemException.getCode(), ResultEnum.SystemException.getMsg());
        }
    }

}
