package com.nekromagus.github.repository;

import com.nekromagus.github.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, Long> {
}