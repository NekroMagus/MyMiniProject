package com.simple.springmvc.dao;

import com.simple.springmvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
