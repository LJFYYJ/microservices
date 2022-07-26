package com.bit.jinggong.service.ucenter.mapper;

import com.bit.jinggong.service.ucenter.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-09
 */
public interface MemberMapper extends BaseMapper<Member> {


    Integer selectRegisterNumByDay(String day);

}
