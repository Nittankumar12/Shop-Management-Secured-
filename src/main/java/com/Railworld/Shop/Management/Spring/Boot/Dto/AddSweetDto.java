package com.Railworld.Shop.Management.Spring.Boot.Dto;

import lombok.Data;

@Data
public class AddSweetDto {
    private String sweetName;
    private Integer sweetQuantity;
    private Integer sweetCost;
}
