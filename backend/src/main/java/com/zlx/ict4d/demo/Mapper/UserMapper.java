package com.zlx.ict4d.demo.Mapper;

import com.zlx.ict4d.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {


    //根据id 找到 user
    User findById(@Param("id")Integer id);
    User findByUserName(@Param("userName") String userName);
    User findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    int countUserName(@Param("userName")String userName); //指定用户名有多少数据
    void addUser(User user);


    void updateUser(@Param("user")User user);

    void deleteUser(@Param("cusId")Integer userId);

    List<User> getAllUsers();
}
