package com.bit.jinggong.service.ucenter.service;

import com.bit.jinggong.service.base.dto.MemberDto;
import com.bit.jinggong.service.ucenter.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bit.jinggong.service.ucenter.entity.vo.LoginVo;
import com.bit.jinggong.service.ucenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-09
 */
public interface MemberService extends IService<Member> {

    void register(RegisterVo registerVo);

    String login(LoginVo loginVo);


    /**
     * 根据openid返回用户信息
     * @param openid
     * @return
     */
    Member getByOpenid(String openid);

    MemberDto getMemberDtoByMemberId(String memberId);

    Integer countRegisterNum(String day);
}
