package com.springcrud.dao;

import com.springcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataDao extends JpaRepository<User,Long> {

}
