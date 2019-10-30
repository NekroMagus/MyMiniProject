package com.nekromagus.github.dao;

import com.nekromagus.github.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findProductsByPrice(int price);

    List<Product> findProductsByPriceLessThanEqual(int price);

    List<Product> findProductsByPriceBetween(int min, int max);
}
