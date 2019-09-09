package com.springboot.dao;

import com.springboot.domain.Role;

public interface RoleDao {

    Role findRoleByName(String name);
}
