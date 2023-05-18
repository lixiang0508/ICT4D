package com.zlx.ict4d.demo.bean;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Product {

    private Integer id;
    private Integer  userId;// who is selling this product?
    private Integer categoryId;
    private String name;
    private Integer quantity;
    private Double price;
    private String userName;
    private String address; // where to get

    private String contact;// contact information

    private String information;
   // private String image;


}
