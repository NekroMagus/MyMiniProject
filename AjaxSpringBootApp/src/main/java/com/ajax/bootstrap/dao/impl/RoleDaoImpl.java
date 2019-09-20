package com.ajax.bootstrap.dao.impl;

import com.ajax.bootstrap.dao.RoleDao;
import com.ajax.bootstrap.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional(readOnly = true)
    @Override
    public Role findRoleByName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Role role=(Role) em.createQuery("SELECT u from Role u where name=:name")
                .setParameter("name",name)
                .getSingleResult();
        em.close();
        return role;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> findAllRoles() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Role> roleList = em.createQuery("SELECT u from Role u", Role.class).getResultList();
        em.close();
        return roleList;
    }
}
