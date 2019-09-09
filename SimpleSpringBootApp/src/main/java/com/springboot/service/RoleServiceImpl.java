package com.springboot.service;

import com.springboot.dao.RoleDao;
import com.springboot.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findRoleByName(String role) {
        return roleDao.findRoleByName(role);
    }
}
