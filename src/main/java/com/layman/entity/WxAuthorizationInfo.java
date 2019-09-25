package com.layman.entity;

/**
 * @ClassName WxAuthorizationInfo
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/24 16:56
 * @Version 3.0
 **/
public class WxAuthorizationInfo {
    private String session_key;

    private String openid;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
