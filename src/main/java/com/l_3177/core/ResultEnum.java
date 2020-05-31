package com.l_3177.core;

public enum ResultEnum {

    SUCCESS(200,"成功"),
    SystemException(-1, "系统异常"),
    UnknowException(-2,"未知异常"),
    ServiceException(-3,"服务异常"),
    CommonException(-4, "业务异常"),
    DBException(-5, "数据库操作异常"),
    ParamException(-6, "参数检验异常"),
    InfoException(1, "提示级别异常");


    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
