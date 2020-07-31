package com.zqp.dao;

import com.zqp.domain.Role;
import com.zqp.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserDao {


    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    @Select("select * from users where userName=#{username}")
    @Results({
            @Result(id = true, property = "userId", column = "userId"),
            @Result(property = "email", column = "email"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "userStatus",column = "userStatus"),
            @Result(property = "roles",column = "userId",javaType = List.class,many = @Many(select = "com.zqp.dao.IRoleDao.findRolesByUserId",fetchType = FetchType.LAZY))

    })
    public UserInfo findUserByUserName(String username);


    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAllUsers();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into users (email,userName,password,phoneNum,userStatus) values(#{email},#{userName},#{password},#{phoneNum},#{userStatus})")
    void saveUser(UserInfo user);


    @Select("select * from users where userId=#{id}")
    @Results({
            @Result(id = true, property = "userId", column = "userId"),
            @Result(property = "email", column = "email"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "userStatus",column = "userStatus"),
            @Result(property = "roles",column = "userId",javaType = List.class,many = @Many(select = "com.zqp.dao.IRoleDao.findRolesByUserId",fetchType = FetchType.LAZY))
    })
    UserInfo findUserById(int id);


    @Select("select * from users where userId in (select userId from user_role where roleId=#{roleId})")
    List<UserInfo> findUsersByRoleId(int roleId);

    @Select("select * from roles where roleId not in (select roleId from user_role where userId=#{id})")
    List<Role> findOtherRoles(int id);


    @Insert("insert into user_role (userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);
}
