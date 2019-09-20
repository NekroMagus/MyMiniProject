package com.ajax.bootstrap.dao;

import com.ajax.bootstrap.domain.Role;

import java.util.List;

public interface RoleDao {

    Role findRoleByName(String name);

    List<Role> findAllRoles();
}
