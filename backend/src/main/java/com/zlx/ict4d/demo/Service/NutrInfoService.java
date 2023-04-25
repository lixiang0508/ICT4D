package com.zlx.ict4d.demo.Service;


import com.zlx.ict4d.demo.Mapper.NutrInfoMapper;
import com.zlx.ict4d.demo.bean.NutrInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutrInfoService {


    @Autowired
    NutrInfoMapper nutrInfoMapper;

    public List<NutrInfo> getAllNutrInfo(){

        return nutrInfoMapper.getAllNutrInfos();

    }

    public void addNutrInfo(NutrInfo nutrInfo){
        nutrInfoMapper.addNutrInfo(nutrInfo);
    }

    public NutrInfo getNutrInfoById(Integer id){
        return nutrInfoMapper.getNutrInfoById(id);
    }
}
