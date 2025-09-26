package com.tkmf.config;

import com.tkmf.interceptor.PassPortInterceptor;
import com.tkmf.interceptor.UserTokenInterceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Interceptor implements WebMvcConfigurer {
    @Bean
    public PassPortInterceptor passPortInterceptor(){
        return new PassPortInterceptor();
    }
    @Bean
    public UserTokenInterceptor userTokenInterceptor(){
        return new UserTokenInterceptor();
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passPortInterceptor())
                .addPathPatterns("/user/getSMSCode");
        registry.addInterceptor(userTokenInterceptor())
                .addPathPatterns("/user/orders");
    }


}
