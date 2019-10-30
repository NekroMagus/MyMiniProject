package com.nekromagus.github.controller;

import com.nekromagus.github.domain.Product;
import com.nekromagus.github.dto.JsonResponseProduct;
import com.nekromagus.github.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchProductController {

    @Autowired
    private ProductDao dao;

    @PostMapping
    public List<JsonResponseProduct> getPrice(@RequestBody Product product) {
        List<JsonResponseProduct> resp = new ArrayList<>();
        List<Product> products = dao.findProductsByPriceLessThanEqual(product.getPrice());
        for(Product p: products){
            resp.add(new JsonResponseProduct(p.getPrice(),p.getModel(),p.getSeller().getPhone()));
        }
        return resp;
    }
}