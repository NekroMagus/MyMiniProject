package com.ajax.bootstrap.repository;

import com.ajax.bootstrap.domain.Role;

import java.util.List;

public interface RoleDao {

    Role findRoleByName(String name);

    List<Role> findAllRoles();
}
