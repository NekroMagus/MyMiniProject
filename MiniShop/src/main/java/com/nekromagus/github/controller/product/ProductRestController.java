package com.nekromagus.github.controller.product;

import com.nekromagus.github.dao.product.ProductDao;
import com.nekromagus.github.domain.Product;
import com.nekromagus.github.dao.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private ProductDao dao;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        Product product = dao.findById(id);
        if (product == null) {
            throw new ProductNotFoundException();
        }
        return product;
    }
}
