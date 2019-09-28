package com.layman.service;

import com.layman.mapper.VoteMapper;
import com.layman.mapper.VoteOptionsMapper;
import com.layman.pojo.User;
import com.layman.pojo.Vote;
import com.layman.pojo.VoteOptions;
import com.layman.utils.IdWorker;
import com.layman.utils.RandomStringUtil;
import com.layman.vo.VotePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName VoteService
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/28 11:29
 * @Version 3.0
 **/
@Service
public class VoteService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private VoteMapper voteMapper;

    @Autowired
    private VoteOptionsMapper voteOptionsMapper;

    /**    
     * @Author 叶泽文
     * @Description 发起投票
     * @Date 11:31 2019/9/28
     * @Param [votePojo]
     * @return void
     **/
    public String createVote(VotePojo votePojo, HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        Vote vote = new Vote();
        String voteId = idWorker.nextStringId();
        vote.setId(voteId);
        vote.setCreateId(user.getId());
        String voteNum = RandomStringUtil.generateRandomStr(10);
        vote.setNumber(voteNum);
        vote.setUserCount(0);
        vote.setVoteContent(votePojo.getVoteContent());
        vote.setVoteTitle(votePojo.getVoteTitle());
        voteMapper.insertSelective(vote);
        for (String option: votePojo.getVoteOption()) {
            VoteOptions optionPojo = new VoteOptions();
            optionPojo.setId(idWorker.nextStringId());
            optionPojo.setVoteOption(option);
            optionPojo.setVoteId(voteId);
            optionPojo.setPoll(0);
            voteOptionsMapper.insert(optionPojo);
        }
        return voteNum;
    }
}
