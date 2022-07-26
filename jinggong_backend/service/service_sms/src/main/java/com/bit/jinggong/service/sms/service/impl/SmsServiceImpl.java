package com.bit.jinggong.service.sms.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.bit.jinggong.common.base.result.ResultCodeEnum;
import com.bit.jinggong.service.base.exception.JingGongException;
import com.bit.jinggong.service.sms.service.SmsService;
import com.bit.jinggong.service.sms.util.SmsProperties;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {
    @Autowired
    private SmsProperties smsProperties;

    @SneakyThrows
    @Override
    public void send(String mobile, String checkCode) throws ClientException {

        //创建配置对象
        DefaultProfile profile = DefaultProfile.getProfile(
                smsProperties.getRegionId(),
                smsProperties.getKeyId(),
                smsProperties.getKeySecret());

        //创建client对象
        IAcsClient client = new DefaultAcsClient(profile);

        //创建参数对象
        CommonRequest request = new CommonRequest();
        //组装参数对象
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", smsProperties.getRegionId());
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", smsProperties.getSignName());
        request.putQueryParameter("TemplateCode", smsProperties.getTemplateCode());

        Map<String, String> param = new HashMap<>();
        param.put("code", checkCode);
        Gson gson = new Gson();
        String json = gson.toJson(param);

        request.putQueryParameter("TemplateParam", json);

        //发送短信
        CommonResponse response = client.getCommonResponse(request);

        //得到响应结果
        String data = response.getData();

        //解析响应结果
        HashMap<String, String> map = gson.fromJson(data, HashMap.class);
        String code = map.get("Code");
        String message = map.get("Message");

        if("isv.BUSINESS_LIMIT_CONTROL".equals(code)){
            log.error("发送短信过于频繁：" + "code-" + code + ", message-" + message);
            throw new JingGongException(ResultCodeEnum.SMS_SEND_ERROR_BUSINESS_LIMIT_CONTROL);
        }

        if(!"OK".equals(code)){
            log.error("短信发送失败：" + "code-" + code + ", message-" + message);
            throw new JingGongException(ResultCodeEnum.SMS_SEND_ERROR);
        }
    }
}
