package com.scu.exception;

import com.scu.enums.ResultEnum;

/**
 * Created by xing on 2018/9/30.
 */
public class UserException extends RuntimeException{

    private Integer code;

    public UserException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
