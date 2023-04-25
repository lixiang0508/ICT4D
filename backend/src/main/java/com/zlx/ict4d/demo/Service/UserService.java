package com.zlx.ict4d.demo.Service;


import com.zlx.ict4d.demo.Mapper.UserMapper;
import com.zlx.ict4d.demo.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class UserService {


    @Autowired
    UserMapper UserMapper;

    public User findById(Integer id){
        return UserMapper.findById(id);
    }

    public void updateUser(User User){
        UserMapper.updateUser(User);
    }

    public void deleteUser(Integer cusId){
        UserMapper.deleteUser(cusId);
    }

    public List<User> getAllCus(){

        return UserMapper.getAllUsers();

    }
    
}
