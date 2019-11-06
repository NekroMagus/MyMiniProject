package com.nekromagus.github.dto;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.nekromagus.github.controller.product.ProductRestController;
import com.nekromagus.github.controller.seller.SellerRestController;
import com.nekromagus.github.domain.Product;
import lombok.*;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
public class JsonResponseProduct extends ResourceSupport {

    private int price;

    private String model;

    private String phoneSeller;

    @JsonCreator
    public JsonResponseProduct(final Product product) {
        this.price = product.getPrice();
        this.model = product.getModel();
        this.phoneSeller = product.getSeller().getPhone();
        final long productId = product.getId();
        final long sellerId = product.getSeller().getId();
        add(linkTo(methodOn(ProductRestController.class).getProduct(productId)).withRel("product"));
        add(linkTo(methodOn(SellerRestController.class).getSellerById(sellerId)).withRel("seller"));
    }

    public JsonResponseProduct(int price, String model, String phoneSeller) {
        this.price = price;
        this.model = model;
        this.phoneSeller = phoneSeller;
    }
}
