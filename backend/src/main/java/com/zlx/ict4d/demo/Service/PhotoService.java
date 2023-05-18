package com.zlx.ict4d.demo.Service;


import com.zlx.ict4d.demo.Mapper.PhotoMapper;
import com.zlx.ict4d.demo.bean.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PhotoService {

    @Autowired
    PhotoMapper photoMapper;

   public void addPhoto(Photo photo){
        photoMapper.addPhoto(photo);
    }

    public String getImage(Integer productId){
       return photoMapper.getImage(productId);
    }



}
