package com.tkmf.utils;

import com.tkmf.constant.CookieConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by VULCAN on 2020/9/22.
 */
@Component
public class CookieUtil {

    /**
     * 配置路径:注意静态属性获取配置内容的方式
     * @Component
     * set方式不是静态变量， @Value("${website.domain-name}")
     */

    public static  String DOMAIN_NAME;
    public  String getDomainName() {
        return DOMAIN_NAME;
    }
//    @Value("${website.domain-name}")
    public  void setDomainName(String domainName) {
        DOMAIN_NAME = domainName;
    }

    /**
     * 设置cookie进行转码
     * @param repsonse
     * @param name
     * @param value
     * @param maxAge
     */
    public static void setCookie(HttpServletResponse repsonse,
                           String name, String value, int maxAge){

        try{
            value = URLEncoder.encode(value,"utf-8");
            setCookieValue(repsonse,name,value,maxAge);
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    /**
     *设置cookie内容
     * @param repsonse
     * @param name
     * @param value
     * @param maxAge
     */
    public static void setCookieValue(HttpServletResponse repsonse,
                                 String name, String value, int maxAge){
        Cookie cookie = new Cookie(name, value);
//        cookie.setDomain(DOMAIN_NAME);
        cookie.setPath("/");//可在同一服务器内使用
        cookie.setMaxAge(maxAge);
        repsonse.addCookie(cookie);
    }

    /**
     * 获取cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name){
        Map<String,Cookie> cookieMap = readCookieMap(request);
        if(cookieMap.containsKey(name)){
           return cookieMap.get(name);
        }
        return null;
    }

    /**
     * 删除cookie
     * @param response
     * @param cookieName
     */
    public static void deleteCookie(HttpServletResponse response, String cookieName) {
        try {
            String deleteValue = URLEncoder.encode("", "utf-8");
            setCookieValue(response, cookieName, deleteValue, CookieConstant.COOKIE_DELETE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    /**
     * 将cookie封装成map
     * @param request
     * @return
     */
    private static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie:cookies) {
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }
}
