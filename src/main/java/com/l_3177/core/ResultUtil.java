package com.l_3177.core;

public class ResultUtil {

    private ResultUtil() {
    }

    public static <T> Result<T> getSuccess(T obj) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(obj);
        return result;
    }

    public static Result getSuccess() {
        return getSuccess(null);
    }

    public static Result getError(Integer code ,String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result getError(Integer code ,String msg) {
        return getError(code,msg,null);
    }



}
