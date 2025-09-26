package com.tkmf.config;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        // 支持中文编码
        restTemplate.getMessageConverters().set(1,
                new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }
    /*
    RestTemplate 支持至少三种HTTP客户端库:JDK自带的HttpURLConnection,Apache HttpComponents, OkHttp.
    从各种HTTP客户端性能以及易用程度评测来看，OkHttp 优于 Apache HttpComponents、ApacheHttpComponents 优于 HttpURlConnection.
    所以我个人更建议大家将底层HTTP实现切换为 okHTTP
    */
    @Bean
    public ClientHttpRequestFactory myClientHttpRequestFactory() {
        //此处使用自定义的 OkHttp 客户端，需要引入 OkHttp 依赖，已在pom 中引入
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();
        factory.setReadTimeout(5000);//从服务器获取数据超时时间 单位为 ms
        factory.setConnectTimeout(5000);//连接超时时间 单位为ms
        return factory;
    }

//    @Bean
//    public IRule myRule() {
//        return new NacosRule();
//    }
}