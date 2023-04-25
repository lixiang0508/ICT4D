package com.zlx.ict4d.demo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class User {

    private Integer id;
    private String userName;//用户名

    private String phone;//电话号码
    private String password;//密码


    public User(Integer id, String userName, String phoneNumber){
        this.id=id;
        this.userName = userName;
        this.phone =phoneNumber;
    }

    public User( String userName, String phoneNumber){

        this.userName = userName;
        this.phone =phoneNumber;
    }



}
