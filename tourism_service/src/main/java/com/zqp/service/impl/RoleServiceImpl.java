package com.zqp.service.impl;

import com.zqp.dao.IRoleDao;
import com.zqp.domain.Role;
import com.zqp.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAllRoles() {
        return roleDao.findAllRoles();
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public Role findRoleByRoleId(int id) {
        return roleDao.findRoleByRoleId(id);
    }

    @Override
    public void deleteRoleById(int id) {

        roleDao.deleteFromUser_RoleByRoleId(id);

        roleDao.deleteFromRole_PermissionByRoleId(id);

        roleDao.deleteRoleById(id);
    }
}
