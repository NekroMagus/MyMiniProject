package com.springcrud.dao;

import java.util.List;

public interface Dao<T> {

    void insert(T user);

    void update(T user);

    void delete(long userId);

    T findById(long id);

    List<T> findAll();
}
