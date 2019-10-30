package com.nekromagus.github.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResponseProduct {

    private int price;

    private String model;

    private String phoneSeller;
}
