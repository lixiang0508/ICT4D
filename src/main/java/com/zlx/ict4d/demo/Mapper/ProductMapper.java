package com.zlx.ict4d.demo.Mapper;


import com.zlx.ict4d.demo.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> selectAllProducts();//查找所有的商品详情


    List<Product> selectAllProductsByCategory(@Param("categoryId") Integer categoryId);

    Product selectProductById(@Param("productId")Integer productId);//根据id 查找商品详情


    List<Product> selectProductsByUserId(@Param("userId") Integer userId); // select all the products released by a specific user

    List<Product> searchProductByName(@Param("name") String name);

    void addProduct(@Param("userId") Integer userId, @Param("categoryId") Integer category_id, @Param("name") String name,
                    @Param("quantity") Integer quantity, @Param("price") Double price, @Param("address") String address);




}
