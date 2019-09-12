package com.bootstrap.springboot.service;

import com.bootstrap.springboot.dao.RoleDao;
import com.bootstrap.springboot.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findRoleByName(String name) {
        return roleDao.findRoleByName(name);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleDao.findAllRoles();
    }
}
