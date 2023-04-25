package com.zlx.ict4d.demo.Controller;

import com.zlx.ict4d.demo.Service.ProductService;
import com.zlx.ict4d.demo.bean.Product;
import com.zlx.ict4d.demo.utils.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
@Slf4j
public class ProductController {

@Autowired
ProductService productService;

    @GetMapping("")
    public JsonData getAllProducts(){
        List<Product> allProducts = productService.getAllProducts();
        return JsonData.buildSuccess(allProducts);
    }

    @GetMapping("/{productId}")
    public JsonData getProductById(@PathVariable("productId") Integer productId){
        Product res = productService.getProductById(productId);
        return JsonData.buildSuccess(res,"find product success");
    }

    @GetMapping("/user/{userId}")
    public JsonData getProductsByUserId(@PathVariable Integer userId){
        List<Product> products = productService.getProductsByUserId(userId);
        return JsonData.buildSuccess(products,"based on userId we find the following products");
    }

    @PostMapping("")
    public JsonData  addProduct(@RequestBody Product product){
        //Integer userId=(Integer)product.getAttribute("userId");
        Integer userId= product.getUserId();
        log.info("userId",String.valueOf(userId));
        //Integer categoryId = (Integer) product.getAttribute("categoryId");
        Integer categoryId = product.getCategoryId();
        log.info("categoryId",String.valueOf(categoryId));
        //String name = (String) product.getAttribute("name");
        String name = product.getName();
        log.info("name",name);
        //Integer quantity = (Integer) product.getAttribute("quantity");
        Integer quantity = product.getQuantity();
        log.info("quantity",String.valueOf(quantity));
        //Double price = (Double) product.getAttribute("price");
        Double price = product.getPrice();
        log.info("price",price);
        //String address =(String) product.getAttribute("address");
        String address = product.getAddress();
        log.info("address",address);
        log.info("userId",userId,"categoryId",categoryId,"name",name,"quantity",quantity,"price",price,"address",address);
        productService.addProduct(userId,categoryId,name,quantity,price,address);
        return JsonData.buildSuccess(null,"add product success");
    }



}
