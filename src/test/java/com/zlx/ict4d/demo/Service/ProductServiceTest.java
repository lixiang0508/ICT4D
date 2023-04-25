package com.zlx.ict4d.demo.Service;

import com.zlx.ict4d.demo.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProductServiceTest {


    @Autowired
    ProductService productService;


    @Test
    void getProductsByUserId() {
        List<Product> lst=productService.getProductsByUserId(1);
        System.out.println(lst);
        log.info(String.valueOf(lst));
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getProductsByCategory() {
    }

    @Test
    void testGetProductsByUserId() {
    }

    @Test
    void getProductsByName() {
    }

    @Test
    void addProduct() {

        productService.addProduct(19,2,"ntfp3",4,15.6,"somewhere");
    }
}