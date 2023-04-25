package com.zlx.ict4d.demo.Service;


import com.zlx.ict4d.demo.Mapper.ProductCommentMapper;
import com.zlx.ict4d.demo.Mapper.ProductMapper;
import com.zlx.ict4d.demo.bean.ProductComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCommentService {


    @Autowired
    ProductCommentMapper productCommentMapper;

    public void addComment(ProductComment productComment){
        productCommentMapper.addProductComment(productComment);
    }

    public ProductComment getCommentById(Integer id){
        return productCommentMapper.getProductCommentById(id);

    }

    public List<ProductComment> getAllComments(){
        return productCommentMapper.getAllComments();
    }
}
