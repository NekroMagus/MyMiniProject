package com.bootstrap.springboot.service;

import com.bootstrap.springboot.domain.Role;

public interface RoleService {

    Role findRoleByName(String name);
}
