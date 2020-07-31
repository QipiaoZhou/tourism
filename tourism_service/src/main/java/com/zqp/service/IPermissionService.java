package com.zqp.service;

import com.zqp.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAllPermissions();

    void savePermission(Permission permission);

    Permission findPermissionById(int id);
}
