package com.springboot.service;

import com.springboot.domain.Role;

public interface RoleService {

    Role findRoleByName(String role);
}
