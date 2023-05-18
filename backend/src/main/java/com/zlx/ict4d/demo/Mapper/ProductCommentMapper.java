package com.zlx.ict4d.demo.Mapper;


import com.zlx.ict4d.demo.bean.ProductComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductCommentMapper {

    void addProductComment(@Param("productComment")ProductComment productComment);

    List<ProductComment> getAllComments();

    ProductComment getProductCommentById(@Param("productCommentId") Integer productCommentId);

}
