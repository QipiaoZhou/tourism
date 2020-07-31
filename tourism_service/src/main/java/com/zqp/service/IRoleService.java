package com.zqp.service;

import com.zqp.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAllRoles();

    void saveRole(Role role);

    Role findRoleByRoleId(int id);

    void deleteRoleById(int id);
}
