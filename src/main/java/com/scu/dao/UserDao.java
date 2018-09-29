package com.scu.dao;

import com.scu.model.UserDomain;

import java.util.List;

/**
 * Created by xing on 2018/9/29.
 */
public interface UserDao {
    int insert(UserDomain record);

    List<UserDomain> selectUsers();
}
