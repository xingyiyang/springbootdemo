package com.scu.controller;

import com.scu.model.Result;
import com.scu.model.UserDomain;
import com.scu.service.UserService;
import com.scu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xing on 2018/9/29.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("add")
    public int addUser(UserDomain user){
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }

    @GetMapping("testresult")
    public Result<UserDomain> testException(BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }else {
            UserDomain userDomain = new UserDomain();
            userDomain.setUserName("xyy");
            userDomain.setPassword("520");
            userDomain.setPhone("12345678900");
            return ResultUtil.success(userDomain);
        }
    }

    @GetMapping("testexception/{id}")
    public void testException(@PathVariable("id") Integer id) throws Exception{
        userService.testException(id);
    }
}
