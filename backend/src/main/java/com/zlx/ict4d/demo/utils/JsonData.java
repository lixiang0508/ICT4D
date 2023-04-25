package com.zlx.ict4d.demo.utils;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JsonData {
    //private String token;
    private int err;
    private Object data;
    private String msg;
    public JsonData(){

    }
    public JsonData(int err, Object data){
        this.err = err;

        this.data = data;
    }

    public JsonData(int err, Object data, String msg) {
        this.err = err;
        this.data = data;
        this.msg = msg;
    }
    public static JsonData buildSuccess(Object data){
        return new JsonData(0,data);
    }
    public static JsonData buildSuccess1(String msg){
        return new JsonData(0,msg);
    }
    public static JsonData buildSuccess(Object data,String msg){
        return new JsonData(0,data,msg);
    }
    public static JsonData buildError(String msg){
        return new JsonData(-1,"",msg);
    }
    public static JsonData buildError(String msg,int err){

        return new JsonData(err,"",msg);
    }


}

