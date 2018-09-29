package com.scu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scu.dao.UserDao;
import com.scu.model.UserDomain;
import com.scu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xing on 2018/9/29.
 */
@Service(value="userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(UserDomain user) {
        return userDao.insert(user);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public PageInfo<UserDomain> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserDomain> userDomainList = userDao.selectUsers();
        PageInfo result = new PageInfo(userDomainList);
        return result;
    }
}
