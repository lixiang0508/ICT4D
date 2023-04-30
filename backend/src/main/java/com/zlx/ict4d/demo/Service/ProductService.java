package com.zlx.ict4d.demo.Service;

import com.zlx.ict4d.demo.Mapper.ProductMapper;
import com.zlx.ict4d.demo.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductMapper  productMapper;

    //获取所有商品
    public List<Product> getAllProducts(){
        return productMapper.selectAllProducts();
    }

    //get products of a specific category
    public List<Product> getProductsByCategory(Integer categoryId){
        return productMapper.selectAllProductsByCategory(categoryId);
    }

    //get products released by a specific user
    public List<Product> getProductsByUserId(Integer userId){
        return productMapper.selectProductsByUserId(userId);
    }

    // get products by product name
    public List<Product> getProductsByName(String name){
        return productMapper.searchProductByName(name);
    }

    public Product getProductById(Integer productId){
        return productMapper.selectProductById(productId);
    }
    //add a product
    public void addProduct(Integer userId, Integer category_id, String name, String userName,
                           Integer quantity, double price, String address,String information){

        productMapper.addProduct(userId, category_id,name,userName,quantity,price,address,information);
    }





}
