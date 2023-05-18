package com.zlx.ict4d.demo.Mapper;


import com.zlx.ict4d.demo.bean.NutrInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface NutrInfoMapper {

    public List<NutrInfo>  getAllNutrInfos();

    public void addNutrInfo(@Param("nutrInfo")NutrInfo nutrInfo);

    NutrInfo getNutrInfoById(@Param("id") Integer id);

}
