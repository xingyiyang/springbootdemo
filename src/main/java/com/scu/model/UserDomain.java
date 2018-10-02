package com.scu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by xing on 2018/9/29.
 */
public class UserDomain {

    private Integer userId;
    private String userName;
    @JsonIgnore
    private String password;
    private String phone;
    @JsonFormat(pattern = "yyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private Date birthday;
    @Min(value = 18, message = "禁止小于18岁")
    private Integer age;
    @JsonInclude(Include.NON_NULL)
    private String desc;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
