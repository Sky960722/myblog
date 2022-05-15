package com.sry.springboot.myblog.service;

import com.sry.springboot.myblog.entity.AdminUser;

public interface AdminUserService {

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    AdminUser login(String userName,String password);

}
