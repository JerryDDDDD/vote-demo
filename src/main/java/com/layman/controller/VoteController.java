package com.layman.controller;

import com.layman.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName VoteController
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/27 11:04
 * @Version 3.0
 **/
@RestController
@RequestMapping("/vote")
public class VoteController {


    @PostMapping("/create.json")
    public Result createVote() {
        return null;
    }
}
