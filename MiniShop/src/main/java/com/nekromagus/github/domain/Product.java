package com.nekromagus.github.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int price;

    private String model;

    @ManyToOne(optional =false, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private Seller seller;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", seller=" + seller +
                '}';
    }
}