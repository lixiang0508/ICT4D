package com.zlx.ict4d.demo.bean;


import lombok.Data;

@Data
public class Photo {

   private Integer id;
   private Integer productId;
   private String image;

    public Photo(Integer productId, String s) {
        this.productId =productId;
        this.image =s;
    }
}
