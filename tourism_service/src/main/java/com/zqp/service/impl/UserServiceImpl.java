package com.zqp.service.impl;

import com.zqp.dao.IUserDao;
import com.zqp.domain.Role;
import com.zqp.domain.UserInfo;
import com.zqp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findUserByUserName(username);
//        User user = new User(userInfo.getUserName(), "{noop}"+userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUserName(), userInfo.getPassword(), userInfo.getUserStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }


    /**
     * 获取权限
     * @param roles
     * @return
     */
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName().toUpperCase()));

        }
        return list;
    }

    @Override
    public List<UserInfo> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public void saveUser(UserInfo user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Override
    public UserInfo findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<Role> findOtherRoles(int id) {
        return userDao.findOtherRoles(id);
    }

    @Override
    public void addRoleToUser(int userId, int[] roleIds) {

        for (int roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
