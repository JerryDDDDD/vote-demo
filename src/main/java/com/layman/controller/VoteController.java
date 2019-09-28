package com.layman.controller;

import com.layman.entity.Result;
import com.layman.entity.StatusCode;
import com.layman.service.VoteService;
import com.layman.vo.VotePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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


    @Autowired
    private VoteService voteService;

    /**    
     * @Author 叶泽文
     * @Description 发起投票
     * @Date 11:30 2019/9/28
     * @Param [votePojo]
     * @return com.layman.entity.Result
     **/
    @PostMapping("/create.json")
    public Result createVote(@RequestBody VotePojo votePojo, HttpServletRequest request) {
        System.out.println(votePojo);
        String voteNum = voteService.createVote(votePojo, request);
        return new Result(true, StatusCode.ok, "成功", voteNum);
    }
}
