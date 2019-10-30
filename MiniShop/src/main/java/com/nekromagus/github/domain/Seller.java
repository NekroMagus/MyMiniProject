package com.nekromagus.github.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Product> productList;

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", productList=" + productList +
                '}';
    }
}