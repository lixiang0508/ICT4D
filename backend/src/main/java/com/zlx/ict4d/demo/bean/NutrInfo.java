package com.zlx.ict4d.demo.bean;


import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@Data
public class NutrInfo {
    // nutritional information of NTFP
    private Integer id;

    private Integer authorId;

    private String authorName;

    private String content;
    private String title;
    private Integer likes;//点赞数


    private Integer comments;//评论数
    private Date createTime;//发表时间


}
