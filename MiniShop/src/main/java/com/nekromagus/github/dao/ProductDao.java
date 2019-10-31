package com.nekromagus.github.dao;

import com.nekromagus.github.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findAll();

    List<Product> findByPriceGreaterThanEqual(int price);

    List<Product> findByPriceLessThanEqual(int price);

    List<Product> findByPriceBetween(int min, int max);


}
