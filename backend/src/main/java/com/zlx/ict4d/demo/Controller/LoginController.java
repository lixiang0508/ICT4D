package com.zlx.ict4d.demo.Controller;


import com.zlx.ict4d.demo.Service.LoginService;
import com.zlx.ict4d.demo.bean.User;
import com.zlx.ict4d.demo.exception.AuthException;
import com.zlx.ict4d.demo.request.LoginRequest;
import com.zlx.ict4d.demo.request.RegisterRequest;
import com.zlx.ict4d.demo.utils.JWTUtils;
import com.zlx.ict4d.demo.utils.JsonData;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/auth")
@Api(value="用户管理",tags="提供用户的注册和登录接口")
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;
    //判断用户输入的用户名 和密码是否符合规范


    @PostMapping("/login")
    public JsonData login(@RequestBody LoginRequest loginRequest) throws AuthException {
        User user = loginService.login(loginRequest);

        String token = JWTUtils.geneJsonWebToken(user);
        return JsonData.buildSuccess(user,token);

    }

    @CrossOrigin
    @PostMapping("/register")
    public JsonData register(@RequestBody RegisterRequest registerRequest) throws AuthException{
        return JsonData.buildSuccess(loginService.register(registerRequest),"registration success");
    }

    //校验token是否已经过期了

    @GetMapping("/check")
    public JsonData check(@RequestHeader("token") String token){
        return JsonData.buildSuccess(null,"success");
    }


}
