package com.nekromagus.github.config;

import com.nekromagus.github.domain.Product;
import com.nekromagus.github.domain.Seller;
import com.nekromagus.github.dao.SellerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс для заполнения базы данных случайными продавцами и товарами
 */
@Component
public class DbInit {

    @Autowired
    private SellerDao dao;

    private Random random = new Random();
    private String[] allPhones = {"+79998887766", "+78889995544", "+76669998877", "+71112223344"};
    private String[] allModels = {"Samsung", "Apple", "Nokia"};

    @PostConstruct
    public void createSellers() {
        for (int i = 0; i < 4; i++) {
            Seller seller = new Seller();
            String phoneSeller = allPhones[i];
            seller.setPhone(phoneSeller);
            List<Product> allProducts = new ArrayList<>();
            for (int j = 0; j < 250; j++) {
                int price = 500 + random.nextInt(10001 - 500);
                String model = allModels[random.nextInt(3)];
                Product product = new Product();
                product.setPrice(price);
                product.setModel(model);
                product.setSeller(seller);
                allProducts.add(product);
            }
            seller.setProductList(allProducts);
            dao.save(seller);
        }
    }
}
