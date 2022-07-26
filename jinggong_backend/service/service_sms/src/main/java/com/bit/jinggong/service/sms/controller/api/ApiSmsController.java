package com.bit.jinggong.service.sms.controller.api;

import com.aliyuncs.exceptions.ClientException;
import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.common.base.result.ResultCodeEnum;
import com.bit.jinggong.common.base.util.FormUtils;
import com.bit.jinggong.common.base.util.RandomUtils;
import com.bit.jinggong.service.base.exception.JingGongException;
import com.bit.jinggong.service.sms.service.SmsService;
import io.swagger.annotations.Api;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/sms")
@Api(description = "短信管理")
//@CrossOrigin //跨域
@Slf4j
public class ApiSmsController {
    @Autowired
    private SmsService smsService;

    @Autowired
    private RedisTemplate redisTemplate;

    @SneakyThrows
    @GetMapping("send/{mobile}")
    public R getCode(@PathVariable String mobile) throws ClientException {

        //校验手机号是否合法
        if(StringUtils.isEmpty(mobile) || !FormUtils.isMobile(mobile)){
            log.error("手机号不正确");
            new JingGongException(ResultCodeEnum.LOGIN_MOBILE_ERROR);
//            return R.error().message("手机号不正确").code(28001);
        }

        //生成验证码
        String checkCode = RandomUtils.getFourBitRandom();

        //发送验证码
        // smsService.send(mobile, checkCode);

        //存储验证码到redis
        redisTemplate.opsForValue().set(mobile, checkCode, 5, TimeUnit.MINUTES);

        return R.ok().message("短信发送成功");
    }
}
