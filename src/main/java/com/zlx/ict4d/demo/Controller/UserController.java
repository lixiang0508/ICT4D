package com.zlx.ict4d.demo.Controller;

import com.zlx.ict4d.demo.Service.LoginService;
import com.zlx.ict4d.demo.bean.User;
import com.zlx.ict4d.demo.utils.JsonData;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import com.zlx.ict4d.demo.Service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Data
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping("")
    public JsonData getByCusId(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("customerId");
        if(userId==null) return JsonData.buildError("请登录");

        User user = userService.findById(userId);
        //Customer customer = customerService.findById(cusId);

        return JsonData.buildSuccess(user,"查找cus成功");

    }




}
