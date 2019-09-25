package com.layman.controller;

import com.layman.entity.Result;
import com.layman.entity.WxUserLoginedInfo;
import com.layman.service.UserService;
import com.layman.utils.WXBizDataCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/doLogin.json")
    public Result doLogin(WxUserLoginedInfo wxUserLoginedInfo) {
        userService.doLogin(wxUserLoginedInfo);
        return new Result(true, 200, "成功");
    }
}
