package com.layman.controller;

import com.layman.entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/27 0:20
 * @Version 3.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello.json")
    public String hello() {
        return null;
    }
}
