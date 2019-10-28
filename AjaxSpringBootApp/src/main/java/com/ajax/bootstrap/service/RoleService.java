package com.ajax.bootstrap.service;

import com.ajax.bootstrap.domain.Role;

import java.util.List;

public interface RoleService {

    Role findRoleByName(String name);

    List<Role> findAllRoles();
}
