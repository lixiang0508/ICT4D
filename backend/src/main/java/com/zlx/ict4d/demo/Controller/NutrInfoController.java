package com.zlx.ict4d.demo.Controller;


import com.zlx.ict4d.demo.Service.NutrInfoService;
import com.zlx.ict4d.demo.bean.NutrInfo;
import com.zlx.ict4d.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/nutrInfo")
public class NutrInfoController {

    @Autowired
    NutrInfoService nutrInfoService;


    @GetMapping("")
    public JsonData getAllNutrInfo(){
        List<NutrInfo> nutrs = nutrInfoService.getAllNutrInfo();
        return JsonData.buildSuccess(nutrs,"successfully get nutrinfos");
    }

    @PostMapping("")
    public JsonData  addNutrInfo(@RequestBody NutrInfo nutrInfo, HttpServletRequest request){
        Integer userId=(Integer)request.getAttribute("userId");
        if(userId==null){
            return JsonData.buildError("please log in",-1);
        }
        String authorName=(String)request.getAttribute("userName");
        nutrInfo.setAuthorId(userId);
        nutrInfo.setAuthorName(authorName);
        nutrInfo.setCreateTime(new Date());
        nutrInfoService.addNutrInfo(nutrInfo);
        return JsonData.buildSuccess1("add nutrInfo success");
    }

    @GetMapping("/{id}")
    public JsonData getNutrInfoById(@PathVariable("id") Integer id){
       NutrInfo res= nutrInfoService.getNutrInfoById(id);
       return JsonData.buildSuccess(res,"get nutrinfo success");
    }

}
