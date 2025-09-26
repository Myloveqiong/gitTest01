package com.tkmf.interceptor;

import com.tkmf.constant.RedisConstant;
import com.tkmf.utils.CookieUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserTokenInterceptor extends BaseInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //这是获取到前端的 header 头内容
//        String userId =request.getHeader("headerUserId");
//        String userToken =request.getHeader( "headerUserToken");
        String token = CookieUtil.getCookie(request, "token").getValue();
        String uid = CookieUtil.getCookie(request, "uid").getValue();
        //判断用户是否合法
        boolean run = verifyUserIdToken(uid, token, RedisConstant.REDIS_USER_TOKEN);
        return run;
    }
}