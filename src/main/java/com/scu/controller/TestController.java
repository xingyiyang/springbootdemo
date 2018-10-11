package com.scu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xing on 2018/10/11.
 */
@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("aa")
    public String test(){
        return "test";
    }
}
