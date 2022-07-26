package com.bit.jinggong.service.oss.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
//读取application.yml中的常量
@ConfigurationProperties(prefix="aliyun.oss")
public class OssProperties {
    private String endpoint;
    private String keyid;
    private String keysecret;
    private String bucketname;
}