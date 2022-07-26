package com.bit.jinggong.service.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bit.jinggong.common.base.result.ResultCodeEnum;
import com.bit.jinggong.common.base.util.FormUtils;
import com.bit.jinggong.common.base.util.JwtInfo;
import com.bit.jinggong.common.base.util.JwtUtils;
import com.bit.jinggong.common.base.util.MD5;
import com.bit.jinggong.service.base.dto.MemberDto;
import com.bit.jinggong.service.base.exception.JingGongException;
import com.bit.jinggong.service.ucenter.entity.Member;
import com.bit.jinggong.service.ucenter.entity.vo.LoginVo;
import com.bit.jinggong.service.ucenter.entity.vo.RegisterVo;
import com.bit.jinggong.service.ucenter.mapper.MemberMapper;
import com.bit.jinggong.service.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-09
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(RegisterVo registerVo) {
        //校验参数
        String nickname = registerVo.getNickname();
        String mobile = registerVo.getMobile();
        String password = registerVo.getPassword();
//        String code = registerVo.getCode();

        if(StringUtils.isEmpty(mobile)
                || !FormUtils.isMobile(mobile)){
            throw new JingGongException(ResultCodeEnum.LOGIN_MOBILE_ERROR);
        }

        if(StringUtils.isEmpty(nickname)
                || StringUtils.isEmpty(password)
//                || StringUtils.isEmpty(code)
        ){
            throw new JingGongException(ResultCodeEnum.PARAM_ERROR);
        }

        //校验验证码：redis
//        String checkCode = (String)redisTemplate.opsForValue().get(mobile);
//        if(!code.equals(checkCode)){
//            throw new JingGongException(ResultCodeEnum.CODE_ERROR);
//        }

        //用户是否注册：mysql
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        Integer count = baseMapper.selectCount(queryWrapper);
        if(count > 0){
            throw new JingGongException(ResultCodeEnum.REGISTER_MOBLE_ERROR);
        }

        //注册
        Member member = new Member();
        member.setNickname(nickname);
        member.setMobile(mobile);
        member.setPassword(MD5.encrypt(password));
        member.setAvatar("https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/08/default.jfif");
        member.setDisabled(false);
        baseMapper.insert(member);
    }

    @Override
    public String login(LoginVo loginVo) {

        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        //校验：参数是否合法
        if(StringUtils.isEmpty(mobile)
                || !FormUtils.isMobile(mobile)
                || StringUtils.isEmpty(password)){
            throw new JingGongException(ResultCodeEnum.PARAM_ERROR);
        }

        //校验手机号是否存在
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        Member member = baseMapper.selectOne(queryWrapper);
        if(member == null){
            throw new JingGongException(ResultCodeEnum.LOGIN_MOBILE_ERROR);
        }

        //校验密码是否正确
        if(!MD5.encrypt(password).equals(member.getPassword())){
            throw new JingGongException(ResultCodeEnum.LOGIN_PASSWORD_ERROR);
        }

        //校验用户是否被禁用
        if(member.getDisabled()){
            throw new JingGongException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
        }

        //登录：生成token
        JwtInfo info = new JwtInfo();
        info.setId(member.getId());
        info.setNickname(member.getNickname());
        info.setAvatar(member.getAvatar());

        String jwtToken = JwtUtils.getJwtToken(info, 1800);

        return jwtToken;
    }

    @Override
    public Member getByOpenid(String openid) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", openid);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public MemberDto getMemberDtoByMemberId(String memberId) {
        Member member = baseMapper.selectById(memberId);
        MemberDto memberDto = new MemberDto();
        BeanUtils.copyProperties(member, memberDto);
        return memberDto;
    }

    @Override
    public Integer countRegisterNum(String day) {
        return baseMapper.selectRegisterNumByDay(day);
    }
}
