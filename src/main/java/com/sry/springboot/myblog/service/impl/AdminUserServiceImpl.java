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
        String passwordMD5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserMapper.login(userName, passwordMD5);
    }

    @Override
    public AdminUser getUserDetailById(Integer loginUserId) {
        return adminUserMapper.selectByPrimaryKey(loginUserId);
    }


    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行修改
        if (adminUser != null) {
            String origignPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            //比较原密码是否正确
            if (origignPasswordMd5.equals(adminUser.getLoginPassword())) {
                //设置新密码并修改
                adminUser.setLoginPassword(newPasswordMd5);
                if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                    //修改成功则返回true
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 修改用户名
     *
     * @param loginUserId
     * @param loginUserName
     * @param nickName
     * @return
     */
    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //修改信息
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                //修改成功则返回true
                return true;
            }
        }
        return false;
    }
}
