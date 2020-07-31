package com.zqp.service;

import com.zqp.domain.Role;
import com.zqp.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {


    /**
     * 查询所有用户信息
     */
    List<UserInfo> findAllUsers();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(UserInfo user);

    UserInfo findUserById(int id);

    List<Role> findOtherRoles(int id);

    void addRoleToUser(int userId, int[] roleIds);
}
