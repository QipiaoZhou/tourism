package com.zqp.dao;

import com.zqp.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IRoleDao {

    /**
     * 根据用户id查询对应的角色
     * @param userId
     * @return
     */
    @Select("select * from roles where roleId in(select roleId from user_role where userId=#{userId})")
    @Results({
            @Result(id=true,property = "roleId",column = "roleId"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),

            @Result(property = "permissions",column = "roleId",javaType = List.class,many = @Many(select = "com.zqp.dao.IPermissionDao.findPermissionByRoleId",fetchType = FetchType.LAZY))
    })
    public List<Role> findRolesByUserId(Integer userId);


    @Select("select * from roles")
    List<Role> findAllRoles();


    @Insert("insert into roles (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void saveRole(Role role);

    @Select("select * from roles where roleId=#{id}")
    @Results({
            @Result(id=true,property = "roleId",column = "roleId"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),

            @Result(property = "permissions",column = "roleId",javaType = List.class,many = @Many(select = "com.zqp.dao.IPermissionDao.findPermissionByRoleId",fetchType = FetchType.LAZY)),
//            @Result(property = "users",column = "roleId",javaType = List.class,many = @Many(select = "com.zqp.dao.IUserDao.findUsersByRoleId",fetchType = FetchType.LAZY))
    })
    Role findRoleByRoleId(int id);

    @Delete("delete from roles where roleId=#{id}")
    void deleteRoleById(int id);

    @Delete("delete from user_role where roleId=#{id}")
    void deleteFromUser_RoleByRoleId(int id);

    @Delete("delete from role_permission where roleId=#{id}")
    void deleteFromRole_PermissionByRoleId(int id);
}
