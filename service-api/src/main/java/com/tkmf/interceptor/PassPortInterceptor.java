package com.tkmf.interceptor;

import com.tkmf.controller.BaseController;
import com.tkmf.exception.GraceException;
import com.tkmf.grace.enums.ResponseStatusEnum;
import com.tkmf.utils.IPUtil;
import com.tkmf.utils.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class PassPortInterceptor extends BaseController implements HandlerInterceptor {

    //在controller方法执行之前，自动执行改方法
    //return true 表示拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestIp = IPUtil.getRequestIp(request);
        boolean isExist = redisOperator.keyIsExist(MOBILE_SMSCODE + requestIp);
        if (isExist) {
            log.info("请求被拦截请60秒后重试");
            GraceException.display(ResponseStatusEnum.SMS_NEED_WAIT_ERROR);
            return false;
        }
        return true;
    }
    //执行之后视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //执行之后视图渲染之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
