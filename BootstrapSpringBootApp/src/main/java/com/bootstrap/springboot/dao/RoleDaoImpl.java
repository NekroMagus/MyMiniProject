package com.bootstrap.springboot.dao;

import com.bootstrap.springboot.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Role findRoleByName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Role role =(Role) em.createQuery("SELECT u from Role u where u.name=:name")
                .setParameter("name",name)
                .getSingleResult();
        em.close();
        return role;
    }

    @Override
    public List<Role> findAllRoles() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Role> roleList = em.createQuery("SELECT u from Role u", Role.class).getResultList();
        return roleList;
    }
}
