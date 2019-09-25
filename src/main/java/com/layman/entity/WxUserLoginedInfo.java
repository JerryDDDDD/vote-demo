package com.layman.entity;

/**
 * @ClassName WxUserLoginedInfo
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/24 13:03
 * @Version 3.0
 **/
public class WxUserLoginedInfo {

    private WxUserInfo userInfo;

    private String rawData;

    private String signature;

    private String encryptedData;

    private String iv;

    private String code;

    public WxUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(WxUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
