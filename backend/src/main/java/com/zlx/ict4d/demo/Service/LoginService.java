package com.zlx.ict4d.demo.Service;

import com.zlx.ict4d.demo.Mapper.UserMapper;
import com.zlx.ict4d.demo.bean.User;
import com.zlx.ict4d.demo.exception.AuthException;
import com.zlx.ict4d.demo.request.LoginRequest;
import com.zlx.ict4d.demo.request.RegisterRequest;
import com.zlx.ict4d.demo.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class LoginService {

    @Autowired
    UserMapper userMapper;
    private boolean checkStr(String str) {
        if(str.length()==0 ||str.length()>20 )  return false;
        for(int i=0;i<str.length();i+=1){
            if(((int)str.charAt(i)>='a'&&(int)str.charAt(i)<='z') ||
                    ((int)str.charAt(i)>='A'&&(int)str.charAt(i)<='Z')||
                    ((int)str.charAt(i)>='0'&&(int)str.charAt(i)<='9')){
                continue;
            }  else{
                return false;
            }
        }

        return true;
    }
    public User login(LoginRequest loginRequest) throws AuthException {
        String username = loginRequest.getUserName();
        log.info("{}is trying to login",username);
        String phoneNumber = loginRequest.getPhoneNumber();
        log.info("phone number is {}",phoneNumber);
        User user = userMapper.findByPhoneNumber(phoneNumber);

        if(user==null){
            log.info("can not find the user with phone Number");
            user=userMapper.findByUserName(username);
        }
        log.info(user.toString());
        log.info("current user is{}",user.getUserName());
        log.info("current user's phone is{}",user.getPhone());
        String s = MD5Utils.md5(loginRequest.getPassword());

         log.info("encoded password is{}",s);
         log.info("user's encoded password is{}",user.getPassword());

        if(!s.equals(user.getPassword())){
           throw new AuthException("用户名或者密码错误，请重新登录");
       }


        return user;
    }

    public User register(RegisterRequest registerRequest) throws  AuthException{
        User user = new User();
        //Customer newCus = new Customer();
        String userName = registerRequest.getUserName();
        String pwd = registerRequest.getPassword();
        String md5pwd = MD5Utils.md5(pwd);
       // String email = registerRequest.getEmail();
        if(userMapper.countUserName(userName)>0){
            throw new AuthException("用户名已经存在,请更换用户名");
        }
        /*
        if(customerMapper.countEmail(email)>0){
            throw new AuthException("邮箱已经存在,请更换邮箱");
        }

         */
        if(!checkStr(userName) || !checkStr(pwd)){
            throw new AuthException("Username and password not valid");
        }

        //BeanUtils.copyProperties(registerRequest,user);
        user.setUserName(registerRequest.getUserName());
        user.setPhone(registerRequest.getPhone());
        //newCus.setCreateTime(new Date());
        //newCus.setUpdateTime(new Date());
        user.setPassword(md5pwd);
        log.info("newly registered, name  is{}",user.getUserName());
        log.info("newly password is{}",user.getPassword());
        log.info("newly phone is{}",user.getPhone());
        userMapper.addUser(user);
        //customerMapper.addCustomer(user);



        return user;
    }

}
