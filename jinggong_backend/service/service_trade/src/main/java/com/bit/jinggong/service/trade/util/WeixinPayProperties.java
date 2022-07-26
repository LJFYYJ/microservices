package com.bit.jinggong.service.trade.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="weixin.pay")
public class WeixinPayProperties {
    private String appId;
    private String partner;
    private String partnerKey;
    private String notifyUrl;
}
