package com.nekromagus.github.dao;

import com.nekromagus.github.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findAll();

    List<Product> findByPriceGreaterThanEqual(int price);

    List<Product> findByPriceLessThanEqual(int price);

    @Query("SELECT product FROM Product product WHERE product.seller.phone in :phone")
    List<Product> findProductsBySellerPhones(@Param("phone")String phone);

    List<Product> findByPriceBetween(int min, int max);

}
