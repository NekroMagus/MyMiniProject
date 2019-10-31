package com.nekromagus.github.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonSearchCriteria {

    private int minPrice;

    private int maxPrice;

    private List<String> model;

    private String phoneSeller;
}
