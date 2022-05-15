package com.sry.springboot.myblog.dao;

import com.sry.springboot.myblog.entity.AdminUser;
import org.apache.ibatis.annotations.Param;


public interface AdminUserMapper {

    /**
     * 登录方法
     * @param userName
     * @param password
     * @return
     */
    AdminUser login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 通过userId查找
     * @param adminUserId
     * @return
     */
    AdminUser selectByPrimaryKey(Integer adminUserId);

    /**
     * 修改指定的用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AdminUser record);

    /**
     * 修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(AdminUser record);

}
