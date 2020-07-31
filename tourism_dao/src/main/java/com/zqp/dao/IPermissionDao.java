package com.zqp.dao;

import com.zqp.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {


    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findPermissionByRoleId(int id);

    @Select("select * from permission")
    List<Permission> findAllPermissions();

    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    void savePermission(Permission permission);

    @Select("select * from permission")
    Permission findPermissionById(int id);
}
