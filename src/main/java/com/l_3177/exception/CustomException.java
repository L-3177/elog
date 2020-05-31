package com.l_3177.exception;

import lombok.Data;

@Data
public class CustomException extends Exception {

    private Integer code;

    public CustomException( Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
