package com.layman.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName VotePojo
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/27 11:07
 * @Version 3.0
 **/
public class VotePojo implements Serializable {
    private String voteTitle;

    private String voteContent;

    private List<String> voteOption;

    public VotePojo() {
    }

    public VotePojo(String voteTitle, String voteContent, List<String> voteOption) {
        this.voteTitle = voteTitle;
        this.voteContent = voteContent;
        this.voteOption = voteOption;
    }

    public String getVoteTitle() {
        return voteTitle;
    }

    public void setVoteTitle(String voteTitle) {
        this.voteTitle = voteTitle;
    }

    public String getVoteContent() {
        return voteContent;
    }

    public void setVoteContent(String voteContent) {
        this.voteContent = voteContent;
    }

    public List<String> getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(List<String> voteOption) {
        this.voteOption = voteOption;
    }
}
