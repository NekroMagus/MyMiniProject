package com.nekromagus.github.dao;

import com.nekromagus.github.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerDao extends JpaRepository<Seller, Long> {
}