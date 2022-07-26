package com.bit.jinggong.service.ucenter.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mobile;
    private String password;
}
