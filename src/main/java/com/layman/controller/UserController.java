package com.layman.controller;

import com.layman.entity.Result;
import com.layman.entity.WxUserLoginedInfo;
import com.layman.pojo.User;
import com.layman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/21 23:50
 * @Version 3.0
 **/
@RestController()
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/doLogin.json")
    public Result doLogin(@RequestBody WxUserLoginedInfo wxUserLoginedInfo, HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("token");
        String token = userService.doLogin(wxUserLoginedInfo);
        return new Result(true, 200, "成功", token);
    }
}
