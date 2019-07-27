package com.springsecurity.dao;

import java.util.List;

public interface DAO<T> {

    void insert(T t);

    void update(T t);

    void delete(Long id);

    T findById(Long id);

    T findByLogin(String login);

    List<T> findAll();
}
