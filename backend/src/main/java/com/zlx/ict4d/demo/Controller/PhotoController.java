package com.zlx.ict4d.demo.Controller;


import com.zlx.ict4d.demo.Service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("")
    public String getImage(@PathParam("productId") Integer productId){
        log.info("Trying to find the image of",productId);
        String[] tmp=photoService.getImage(productId).split("/");
        return tmp[tmp.length-1];

    }
}
