package com.nekromagus.github.controller;

import com.nekromagus.github.domain.Product;
import com.nekromagus.github.dto.JsonSearchCriteria;
import com.nekromagus.github.dto.JsonResponseProduct;
import com.nekromagus.github.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * RestController for search of {@link Product}
 */
@RestController
@RequestMapping("/search")
public class SearchProductController {

    @Autowired
    private ProductDao dao;

    private List<JsonResponseProduct> resp;

    /*
        Поиск всех продуктов
    */
    @PostMapping("/all")
    public List<JsonResponseProduct> getAllProducts() {
        resp = new ArrayList<>();
        List<Product> products = dao.findAll();
        for (Product p : products) {
            resp.add(new JsonResponseProduct(p.getPrice(), p.getModel(), p.getSeller().getPhone()));
        }
        return resp;
    }

    /*
           Поиск по максимальной цене
    */
    @PostMapping("/maxPrice")
    public List<JsonResponseProduct> getProductsWithMaxPrice(@RequestBody JsonSearchCriteria criteria) {
        resp = new ArrayList<>();
        List<Product> products = dao.findByPriceLessThanEqual(criteria.getMaxPrice());
        for (Product p : products) {
            resp.add(new JsonResponseProduct(p.getPrice(), p.getModel(), p.getSeller().getPhone()));
        }
        return resp;
    }

    /*
           Поиск по минимальной цене
    */
    @PostMapping("/minPrice")
    public List<JsonResponseProduct> getProductsWithMinPrice(@RequestBody JsonSearchCriteria criteria) {
        resp = new ArrayList<>();
        List<Product> products = dao.findByPriceGreaterThanEqual(criteria.getMinPrice());
        for (Product p : products) {
            resp.add(new JsonResponseProduct(p.getPrice(), p.getModel(), p.getSeller().getPhone()));
        }
        return resp;
    }
    /*
           Поиск по модели
    */
    @PostMapping("/model")
    public List<JsonResponseProduct> getProductsByModel(@RequestBody JsonSearchCriteria criteria) {
        resp = new ArrayList<>();
        List<Product> products = dao.findAll();
        for (Product p : products) {
            if(criteria.getModel().contains(p.getModel())){
                resp.add(new JsonResponseProduct(p.getPrice(), p.getModel(), p.getSeller().getPhone()));
            }
        }
        return resp;
    }
    /*
           Поиск в пределах минимальной и максимального значения
    */
    @PostMapping("/betweenPrice")
    public List<JsonResponseProduct> getProductsBetweenPrice(@RequestBody JsonSearchCriteria criteria) {
        resp = new ArrayList<>();
        List<Product> products = dao.findByPriceBetween(criteria.getMinPrice(), criteria.getMaxPrice());
        for (Product p : products) {
            resp.add(new JsonResponseProduct(p.getPrice(), p.getModel(), p.getSeller().getPhone()));
        }
        return resp;
    }
}