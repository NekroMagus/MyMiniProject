package com.nekromagus.github.controller.seller;

import com.nekromagus.github.dao.seller.SellerDao;
import com.nekromagus.github.domain.Seller;
import com.nekromagus.github.dao.seller.exception.SellerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerRestController {

    @Autowired
    private SellerDao dao;

    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable("id") long id) {
        Seller seller = dao.findById(id);
        if (seller == null) {
            throw new SellerNotFoundException();
        }
        return seller;
    }
}
