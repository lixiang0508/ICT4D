package com.zlx.ict4d.demo.Mapper;

import com.zlx.ict4d.demo.bean.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PhotoMapper {

    void addPhoto(@Param("photo")Photo photo);
    String getImage(@Param("productId") Integer productId);


}
