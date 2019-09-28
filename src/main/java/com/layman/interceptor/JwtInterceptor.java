package com.layman.interceptor;

import com.layman.entity.Result;
import com.layman.entity.StatusCode;
import com.layman.pojo.User;
import com.layman.utils.JsonUtils;
import com.layman.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName JwtInterceptor
 * @Description TODO 鉴权拦截器
 * @Author lizhangjun
 * @Data 2019/5/22 10:51
 * @Version 3.0.0-beta.1
 **/
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("enter JwtInterceptor......");
        String token = request.getHeader("token");
        System.out.println(token);
        if (StringUtils.isNotBlank(token)) {
            try {
                Claims claims = jwtUtil.parseJWT(token);
                System.out.println(claims.get("sub"));
                User user = JsonUtils.jsonToPojo((String) claims.get("sub"), User.class);
                // 获取token信息中的主键
                request.setAttribute("user", user);
            } catch (Exception e) {
                // 令牌过期
                response.setContentType("application/json;charset=UTF-8");
                Result result = new Result(false, StatusCode.tokenExpire, "令牌过期");
                response.getWriter().write(JsonUtils.objectToJson(result));
                return false;
            }
        }
        return true;
    }
}