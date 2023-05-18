package com.zlx.ict4d.demo.Controller;

import com.zlx.ict4d.demo.Service.PhotoService;
import com.zlx.ict4d.demo.Service.ProductService;
import com.zlx.ict4d.demo.bean.Photo;
import com.zlx.ict4d.demo.bean.Product;
import com.zlx.ict4d.demo.utils.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Random;


import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
@Slf4j
public class ProductController {

@Autowired
ProductService productService;

@Autowired
PhotoService photoService;

@Value("${file.path}")
private String filePath;

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
    public JsonData addProduct(@RequestParam("image") MultipartFile file,@RequestParam("categoryId") Integer categoryId,@RequestParam("name") String name, @RequestParam("address") String address,@RequestParam("information") String information,
                               @RequestParam("price") Double price,@RequestParam("quantity") Integer quantity,@RequestParam("userName") String userName, @RequestParam("contact") String contact){


        Integer productId = new Random().nextInt(10000);
        log.info("productId is",productId);
        productService.addProduct(productId,null,categoryId,name,userName,quantity,price,address,information,contact);

        if(file == null || file.isEmpty()){
            log.info("File is null");
            return JsonData.buildSuccess(null,"add product success");
        }
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        //String filePath = "/Users/zhanglixiang/Desktop/CSMaster/ict4d/ict4d_demo_backend/Ict4d_backend/src/main/resources/static/img/";
       // String filePath ="/Users/zhanglixiang/Desktop/Ict4d_shop1/images/";
        try {
            productService.uploadFile(file.getBytes(),filePath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Photo photo = new Photo(productId,filePath+fileName);
        photoService.addPhoto(photo);

        return JsonData.buildSuccess(null,"add product success");

    }


    @PostMapping("/vadd")
    public JsonData  addProduct1(@RequestBody Product product) throws IOException {
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
        String information = product.getInformation();
        String userName = product.getUserName();
        String contact = product.getContact();
        log.info("address",address);
        log.info("userId",userId,"categoryId",categoryId,"name",name,"quantity",quantity,"price",price,"address",address);
        Integer productId = new Random().nextInt(10000);
        productService.addProduct(productId,userId,categoryId,name,userName,quantity,price,address,information,contact);



        return JsonData.buildSuccess(null,"add product success");
    }



}
