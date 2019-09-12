package com.bootstrap.springboot.service;

import com.bootstrap.springboot.domain.Role;

import java.util.List;

public interface RoleService {

    Role findRoleByName(String name);

    List<Role> findAllRoles();
}
