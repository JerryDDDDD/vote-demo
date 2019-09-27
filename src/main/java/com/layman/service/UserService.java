package com.layman.service;

import com.layman.entity.WxAuthorizationInfo;
import com.layman.entity.WxUserLoginedInfo;
import com.layman.mapper.UserMapper;
import com.layman.pojo.User;
import com.layman.pojo.UserExample;
import com.layman.utils.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/22 0:01
 * @Version 3.0
 **/
@Service
public class UserService {

    @Value("${wx.auth.code2Session.url}")
    private String WX_CODE_TO_SESSION_URL;

    @Value("${wx.appid}")
    private String WX_APPID;

    @Value("${wx.secret}")
    private String WX_SECRET;

    @Value("${wx.grant_type}")
    private String WX_GRANT_TYPE;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private HttpServletRequest httpRequest;

    @Autowired
    private HttpServletResponse httpResponse;

    @Autowired
    private UserMapper userMapper;

    /**
     * @return void
     * @Author 叶泽文
     * @Description 微信小程序登录 Token_code校验
     * @Date 0:03 2019/9/22
     * @Param [code]
     **/
    public String doLogin(WxUserLoginedInfo wxUserLoginedInfo) {
        Map param = new HashMap();
        param.put("appid", WX_APPID);
        param.put("secret", WX_SECRET);
        param.put("js_code", wxUserLoginedInfo.getCode());
        param.put("grant_type", WX_GRANT_TYPE);
        String doGet = HttpClientUtil.doGet(WX_CODE_TO_SESSION_URL, param);
        WxAuthorizationInfo wxAuthorizationInfo = JsonUtils.jsonToPojo(doGet, WxAuthorizationInfo.class);
        String info = WXBizDataCrypt.getUserInfo(wxUserLoginedInfo.getEncryptedData(), wxAuthorizationInfo.getSession_key(), wxUserLoginedInfo.getIv());
        System.out.println(info);
        User user = JsonUtils.jsonToPojo(info, User.class);
        if (this.getUserByOpenId(user.getOpenId()) == null) {
            // 如果openid 查不到用户 则创建新的用户
            this.createUser(user);
        }
        //登录流程
        String token = this.login(user);
        return token;
    }

    /**
     * @return void
     * @Author 叶泽文
     * @Description 创建用户
     * @Date 0:54 2019/9/22
     * @Param [openId]
     **/
    public void createUser(User user) {
        user.setId(idWorker.nextStringId());
        userMapper.insert(user);
    }

    /**
     * @return void
     * @Author 叶泽文
     * @Description 根据用户openId获取用户
     * @Date 0:55 2019/9/22
     * @Param [openId]
     **/
    public User getUserByOpenId(String openId) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andOpenIdEqualTo(openId);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    /**
     * @return void
     * @Author 叶泽文
     * @Description 本地服务器登录处理流程
     * @Date 10:30 2019/9/25
     * @Param [user]
     **/
    public String login(User user) {
        String token = jwtUtil.createJWT(user.getId(), JsonUtils.objectToJson(user));
        return token;
    }
}
