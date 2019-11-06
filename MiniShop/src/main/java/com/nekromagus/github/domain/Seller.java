package com.nekromagus.github.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.aspectj.lang.annotation.DeclareAnnotation;

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

    @JsonManagedReference
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