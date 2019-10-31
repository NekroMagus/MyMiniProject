package com.nekromagus.github.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonSearchCriteria {

    private int minPrice;

    private int maxPrice;

    private String model;

    private String phoneSeller;
}
