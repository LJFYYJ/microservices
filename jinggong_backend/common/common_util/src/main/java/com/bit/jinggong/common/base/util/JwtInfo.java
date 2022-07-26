package com.bit.jinggong.common.base.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtInfo {
    private String id;
    private String nickname;
    private String avatar;
    //权限、角色等
    //不要存敏感信息
}
