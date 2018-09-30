package com.scu.handle;

import com.scu.exception.UserException;
import com.scu.model.Result;
import com.scu.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xing on 2018/9/30.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof UserException){
            UserException userException = (UserException) e;
            return ResultUtil.error(userException.getCode(),userException.getLocalizedMessage());
        }else{
            logger.error("系统异常->{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
