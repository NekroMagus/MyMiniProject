package com.bootstrap.springboot.dao;

import com.bootstrap.springboot.domain.Role;

public interface RoleDao {

    Role findRoleByName(String name);
}
