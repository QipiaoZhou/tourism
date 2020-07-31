package com.zqp.service.impl;

import com.zqp.dao.IPermissionDao;
import com.zqp.domain.Permission;
import com.zqp.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAllPermissions() {
        return permissionDao.findAllPermissions();
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }

    @Override
    public Permission findPermissionById(int id) {
        return permissionDao.findPermissionById(id);
    }
}
