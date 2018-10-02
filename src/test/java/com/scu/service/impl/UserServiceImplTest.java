package com.scu.service.impl;

import com.scu.model.UserDomain;
import com.scu.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by xing on 2018/10/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() throws Exception {
        UserDomain userDomain = new UserDomain();
        userDomain.setUserName("zxh");
        userDomain.setPassword("121");
        userDomain.setPassword("2333333");
        Assert.assertEquals(1,userService.addUser(userDomain));
    }

    @Test
    public void findAllUser() throws Exception {
    }

    @Test
    public void testException() throws Exception {
    }

}