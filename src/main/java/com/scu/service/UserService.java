package com.scu.service;

import com.github.pagehelper.PageInfo;
import com.scu.model.UserDomain;

/**
 * Created by xing on 2018/9/29.
 */
public interface UserService {
    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
}
