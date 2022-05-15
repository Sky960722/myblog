package com.sry.springboot.myblog.service.impl;

import com.sry.springboot.myblog.dao.AdminUserMapper;
import com.sry.springboot.myblog.entity.AdminUser;
import com.sry.springboot.myblog.service.AdminUserService;
import com.sry.springboot.myblog.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMD5 = MD5Util.MD5Encode(password,"UTF-8");
        return adminUserMapper.login(userName,passwordMD5);
    }
}
