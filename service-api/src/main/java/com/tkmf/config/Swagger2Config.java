package com.tkmf.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2Config {
    // http://localhost:8001/swagger-ui.html  原路径
    // http://localhost:8001/doc.html 新路径
    // 配置 swagger2 核心配置 docket
    @Bean
    public Docket createRestApi(){
        // 可以定义多个*Predicate 类
        Predicate<RequestHandler> userPredicate = RequestHandlerSelectors.basePackage("com.tkmf.user.controller");
        Predicate<RequestHandler> orderPredicate = RequestHandlerSelectors.basePackage("com.tkmf.order.controller");
        return new Docket(DocumentationType.SWAGGER_2) // 指定 api 类型为 swagger2
                .apiInfo(apiInfo()) // 用于定义 api 文档汇总信息
                .select()
                .apis(Predicates.or(userPredicate)) // 使用逗号分割，可以加入多个(***，***)
                .paths(PathSelectors.any())     // 所有 controller
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("hanma-mall.接口 API")         // 文档页标题
                .contact(new Contact("hanma",
                        "http://www.hanmaweilai.com",
                        "hanma@hanma.com"))     // 联系人信息
                .description("mall 平台提供的 API 文档")// 详细信息
                .version("1.0.1")                       // 文档版本号
                .termsOfServiceUrl("http://www.hanmaweilai.com") // 网站地址
                .build();
    }
}