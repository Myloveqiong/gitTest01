package com.tkmf.utils.extend;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by VULCAN on 2020/11/14.
 */

@Component
@PropertySource("classpath:aliyun.properties")
@ConfigurationProperties(prefix = "aliyun")
@Data
public class AliyunResource {
    private String accessKeyId;
    private String accessKeySecret;
    private String signName;
    private String templateCode;
}


