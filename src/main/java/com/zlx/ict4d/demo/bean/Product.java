package com.zlx.ict4d.demo.bean;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Product {

    private Integer id;
    private Integer  userId;// who is selling this product?
    private Integer categoryId;
    private String name;
    private Integer quantity;
    private Double price;

    private String address; // where to get


}
