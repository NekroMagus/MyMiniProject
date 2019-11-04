package com.nekromagus.github.controller;

import com.nekromagus.github.dao.ProductDao;
import com.nekromagus.github.domain.Product;
import com.nekromagus.github.dto.JsonResponseProduct;
import com.nekromagus.github.dto.JsonSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * RestController for search of {@link Product}
 *
 * @author Igor Fliginskikh
 * @version 1.0
 */
@RestController
@RequestMapping("/search")
public class SearchProductController {

    @Autowired
    private ProductDao dao;

    /*
        Поиск всех продуктов
    */
    @GetMapping("/all")
    public List<JsonResponseProduct> getAllProducts() {
        List<JsonResponseProduct> resp = new ArrayList<>();
        List<Product> products = dao.findAll();
        setJsonResponseProduct(products, resp);
        return resp;
    }

    /*
           Поиск по максимальной цене
    */
    @PostMapping("/maxPrice")
    public List<JsonResponseProduct> getProductsWithMaxPrice(@RequestBody JsonSearchCriteria criteria) {
        List<JsonResponseProduct> resp = new ArrayList<>();
        List<Product> products = dao.findByPriceLessThanEqual(criteria.getMaxPrice());
        setJsonResponseProduct(products, resp);
        return resp;
    }

    /*
           Поиск по минимальной цене
    */
    @PostMapping("/minPrice")
    public List<JsonResponseProduct> getProductsWithMinPrice(@RequestBody JsonSearchCriteria criteria) {
        List<JsonResponseProduct> resp = new ArrayList<>();
        List<Product> products = dao.findByPriceGreaterThanEqual(criteria.getMinPrice());
        setJsonResponseProduct(products, resp);
        return resp;
    }

    /*
           Поиск по модели
    */
    @PostMapping("/model")
    public List<JsonResponseProduct> getProductsByModel(@RequestBody JsonSearchCriteria criteria) {
        List<JsonResponseProduct> resp = new ArrayList<>();
        List<Product> products = dao.findAll();
        for (Product p : products) {
            if (criteria.getModel().contains(p.getModel())) {
                resp.add(new JsonResponseProduct(p.getPrice(), p.getModel(), p.getSeller().getPhone()));
            }
        }
        return resp;
    }
      /*
           Поиск по телефону продавца
    */

    @PostMapping("/phone")
    public List<JsonResponseProduct> getProductsByPhone(@RequestBody JsonSearchCriteria criteria) {
        List<JsonResponseProduct> resp = new ArrayList<>();
        List<Product> products = dao.findBySellerPhone(criteria.getPhoneSeller());
        setJsonResponseProduct(products, resp);
        return resp;
    }

    /*
           Поиск в пределах минимальной и максимального значения
    */
    @PostMapping("/betweenPrice")
    public List<JsonResponseProduct> getProductsBetweenPrice(@RequestBody JsonSearchCriteria criteria) {
        List<JsonResponseProduct> resp = new ArrayList<>();
        List<Product> products = dao.findByPriceBetween(criteria.getMinPrice(), criteria.getMaxPrice());
        setJsonResponseProduct(products, resp);
        return resp;
    }
    /*
            Поиск по введенным значениям
     */

    @PostMapping("/allCriteria")
    public List<JsonResponseProduct> getProductsByAllCriteria(@RequestBody JsonSearchCriteria criteria) {
        List<JsonResponseProduct> resp = new ArrayList<>();
        List<Product> products = dao.findByPriceBetween(criteria.getMinPrice(), criteria.getMaxPrice());
        for (Product p : products) {
            JsonResponseProduct jrp = new JsonResponseProduct(p.getPrice(), p.getModel(), p.getSeller().getPhone());
            if (criteria.getModel().size() == 0 && criteria.getPhoneSeller().equals("")) {
                resp.add(jrp);
            } else if (p.getSeller().getPhone().equals(criteria.getPhoneSeller())
                    && criteria.getModel().contains(p.getModel())) {
                resp.add(jrp);
            } else if (p.getSeller().getPhone().equals(criteria.getPhoneSeller())
                    && criteria.getModel().size() == 0) {
                resp.add(jrp);
            } else if (criteria.getModel().contains(p.getModel())
                    && criteria.getPhoneSeller().equals("")) {
                resp.add(jrp);
            }
        }
        return resp;
    }

    @GetMapping("/min")
    public int getMinPrice() {
        return dao.findByMinPrice();
    }

    @GetMapping("/max")
    public int getMaxPrice() {
        return dao.findByMaxPrice();
    }

    private void setJsonResponseProduct(List<Product> products, List<JsonResponseProduct> resp) {
        for (Product p : products) {
            resp.add(new JsonResponseProduct(p.getPrice(), p.getModel(), p.getSeller().getPhone()));
        }
    }
}