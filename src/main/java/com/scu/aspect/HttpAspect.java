package com.scu.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xing on 2018/9/30.
 */
@Aspect
@Component
public class HttpAspect {
    //spring自带的日志框架slf4j，底层实现是logback
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //两个点表示任何参数都会被拦截,*号表示拦截所有方法，否则填写具体的方法名
//    @Before("execution(public * com.scu.controller.UserController.*(..))")
//    public void log(){
//        System.out.println("loglog");
//    }
//
//    @After("execution(public * com.scu.controller.UserController.addUser(..))")
//    public void closeSomething(){
//
//    }

    //更简便的方法，减少重复代码
    @Pointcut("execution(public * com.scu.controller.UserController.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(){
        System.out.println("before");
        logger.info("before");
        logger.error("beffore");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURI());
        logger.info("method={}",request.getMethod());
    }

    @After("log()")
    public void doAfter(){
        System.out.println("after");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void getReturn(Object object){
        logger.info("response={}",object.toString());
    }
}
