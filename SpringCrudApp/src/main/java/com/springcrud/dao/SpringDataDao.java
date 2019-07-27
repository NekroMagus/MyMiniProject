package com.springcrud.dao;

import com.springcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataDao extends JpaRepository<User, Long> {
}
