package com.ajax.bootstrap.service.impl;

import com.ajax.bootstrap.repository.RoleDao;
import com.ajax.bootstrap.domain.Role;
import com.ajax.bootstrap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao dao;

    @Override
    public Role findRoleByName(String name) {
        return dao.findRoleByName(name);
    }

    @Override
    public List<Role> findAllRoles() {
        return dao.findAllRoles();
    }
}
