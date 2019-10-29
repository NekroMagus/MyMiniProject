package com.nekromagus.github.repository;

import com.nekromagus.github.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
