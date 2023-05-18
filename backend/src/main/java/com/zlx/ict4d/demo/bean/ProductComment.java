package com.zlx.ict4d.demo.bean;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class ProductComment {

    @Id
    private Integer id;
    private Integer userId;//用户ID
    private String userName;//用户名
    private Double score;//打分
    private Integer productId;//产品id
    private String comment;//评语
    private Date createTime;//评价时间

    private Integer commType;//好中差 123

}
