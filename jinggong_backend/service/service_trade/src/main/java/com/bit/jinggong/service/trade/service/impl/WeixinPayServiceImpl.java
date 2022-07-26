package com.bit.jinggong.service.trade.service.impl;

import com.bit.jinggong.common.base.result.ResultCodeEnum;
import com.bit.jinggong.common.base.util.ExceptionUtils;
import com.bit.jinggong.common.base.util.HttpClientUtils;
import com.bit.jinggong.service.base.exception.JingGongException;
import com.bit.jinggong.service.trade.entity.Order;
import com.bit.jinggong.service.trade.service.OrderService;
import com.bit.jinggong.service.trade.service.WeixinPayService;
import com.bit.jinggong.service.trade.util.WeixinPayProperties;
import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class WeixinPayServiceImpl implements WeixinPayService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private WeixinPayProperties weixinPayProperties;

    @Override
    public Map<String, Object> createNative(String orderNo, String remoteAddr) {

        try {
            //根据订单号获取订单
            Order order = orderService.getOrderByOrderNo(orderNo);

            //调用微信的统一下单api
            HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/unifiedorder");

            //组装参数
            Map<String, String> params = new HashMap<>();
            params.put("appid", weixinPayProperties.getAppId());//公众号id
            params.put("mch_id", weixinPayProperties.getPartner());//商户号
            params.put("nonce_str", WXPayUtil.generateNonceStr());//随机数
            params.put("body", order.getCourseTitle());//商品描述
            params.put("out_trade_no", orderNo);//订单号
            params.put("total_fee", order.getTotalFee().intValue()+"");//订单金额（单位是分）
            params.put("spbill_create_ip", remoteAddr);//订单金额（单位是分）
            params.put("notify_url", weixinPayProperties.getNotifyUrl());//通知地址（回调地址）
            params.put("trade_type", "NATIVE");//交易类型

//            //将参数转换成xml字符串，并且在字符串的最后追加计算的签名
//            String xmlParams = WXPayUtil.generateSignedXml(params, weixinPayProperties.getPartnerKey());
//            log.info("\n xmlParams：\n" + xmlParams);
//
//            //将参数放入请求对象的方法体
//            client.setXmlParam(xmlParams);
//            //使用https协议传输
//            client.setHttps(true);
//            //使用post方式发送请求
//            client.post();
//            //得到响应
//            String resultXml = client.getContent();
//            log.info("\n resultXml：\n" + resultXml);

//            Map<String, String> resultMap = WXPayUtil.xmlToMap(resultXml);

            //错误处理
//            if("FAIL".equals(resultMap.get("return_code")) || "FAIL".equals(resultMap.get("result_code"))){
//                log.error("微信支付统一下单错误 - "
//                        + "return_code: " + resultMap.get("return_code")
//                        + "return_msg: " + resultMap.get("return_msg")
//                        + "result_code: " + resultMap.get("result_code")
//                        + "err_code: " + resultMap.get("err_code")
//                        + "err_code_des: " + resultMap.get("err_code_des"));
//                throw new JingGongException(ResultCodeEnum.PAY_UNIFIEDORDER_ERROR);
//            }

            //要组装的结果对象
//            Map<String, Object> map = new HashMap<>();
//            map.put("result_code", resultMap.get("result_code")); //交易标识
//            map.put("code_url", resultMap.get("code_url"));//二维码url
//            map.put("course_id", order.getCourseId());//二维码url
//            map.put("total_fee", order.getTotalFee());//二维码url
//            map.put("out_trade_no", orderNo);//二维码url

            Map<String, Object> map = new HashMap<>();
            map.put("result_code", "SUCCESS"); //交易标识
            map.put("code_url", "");//二维码url
            map.put("course_id", order.getCourseId());//二维码url
            map.put("total_fee", order.getTotalFee().intValue()+"");//二维码url
            map.put("out_trade_no", orderNo);//二维码url

            return map;
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new JingGongException(ResultCodeEnum.PAY_UNIFIEDORDER_ERROR);
        }
    }
}
