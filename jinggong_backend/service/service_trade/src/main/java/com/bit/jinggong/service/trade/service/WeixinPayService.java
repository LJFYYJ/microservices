package com.bit.jinggong.service.trade.service;

import java.util.Map;

public interface WeixinPayService {
    Map<String, Object> createNative(String orderNo, String remoteAddr);
}
