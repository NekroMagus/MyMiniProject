package com.ajax.bootstrap.domain;

import com.ajax.bootstrap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<String, Role> {

    @Autowired
    private RoleService roleService;

    @Override
    public Role convert(String source) {
        return roleService.findRoleByName(source);
    }
}
