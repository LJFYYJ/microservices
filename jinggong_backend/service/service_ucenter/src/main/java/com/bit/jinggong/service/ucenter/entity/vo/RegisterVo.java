package com.bit.jinggong.service.ucenter.entity.vo;

import lombok.Data;

@Data
public class RegisterVo {
    private static final long serialVersionUID = 1L;
    private String nickname;
    private String mobile;
    private String password;
    // 无法使用短信发送服务，不再用验证码
//    private String code;
}
