package com.zlx.ict4d.demo.Controller;


import com.zlx.ict4d.demo.Service.ProductCommentService;
import com.zlx.ict4d.demo.bean.NutrInfo;
import com.zlx.ict4d.demo.bean.ProductComment;
import com.zlx.ict4d.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class ProductCommentController {

@Autowired
    ProductCommentService productCommentService;

    @GetMapping("")
    public JsonData getAllComments(){
        List<ProductComment> ans = productCommentService.getAllComments();
        return JsonData.buildSuccess(ans,"get all the product comments");
    }
    
    @PostMapping("")
    public JsonData addProductComment(@RequestBody ProductComment productComment, HttpServletRequest request){
        Integer userId=(Integer)request.getAttribute("userId");
        if(userId==null){
            return JsonData.buildError("please log in",-1);
        }
        String userName=(String)request.getAttribute("userName");

        productComment.setUserId(userId);
        productComment.setUserName(userName);
        productComment.setCreateTime(new Date());
        productCommentService.addComment(productComment);
        return JsonData.buildSuccess(productComment,"add comment success");

    }

    @GetMapping("/{id}")
    public JsonData getProductCommentById(@PathVariable("id")Integer productCommentId){

      ProductComment productComment=  productCommentService.getCommentById(productCommentId);


      return JsonData.buildSuccess(productComment,"get productComment success");

    }


}
