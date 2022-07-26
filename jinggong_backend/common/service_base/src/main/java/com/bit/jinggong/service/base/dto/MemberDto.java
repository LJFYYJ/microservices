package com.bit.jinggong.service.base.dto;

import lombok.Data;

@Data
public class MemberDto {
    private static final long serialVersionUID = 1L;
    private String id;//会员id
    private String mobile;//手机号
    private String nickname;//昵称
}
