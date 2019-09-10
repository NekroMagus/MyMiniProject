package com.bootstrap.springboot.dao;

import com.bootstrap.springboot.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Override
    public Role findRoleByName(String name) {
        return null;
    }
}
