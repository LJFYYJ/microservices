package com.bit.jinggong.service.ucenter.controller.api;

import com.bit.jinggong.common.base.util.HttpClientUtils;
import com.bit.jinggong.common.base.result.ResultCodeEnum;
import com.bit.jinggong.common.base.util.ExceptionUtils;
import com.bit.jinggong.common.base.util.JwtInfo;
import com.bit.jinggong.common.base.util.JwtUtils;
import com.bit.jinggong.service.base.exception.JingGongException;
import com.bit.jinggong.service.ucenter.entity.Member;
import com.bit.jinggong.service.ucenter.service.MemberService;
import com.bit.jinggong.service.ucenter.util.UcenterProperties;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@CrossOrigin
@Controller//注意这里没有配置 @RestController
@RequestMapping("/api/ucenter/wx")
@Slf4j
public class ApiWxController {

    @Autowired
    private UcenterProperties ucenterProperties;

    @Autowired
    private MemberService memberService;

    @GetMapping("login")
    public String genQrConnect(HttpSession session){

        //组装url：https://open.weixin.qq.com/connect/qrconnect?appid=APPID&redirect_uri=回调地址&response_type=code&scope=snsapi_login&state=随机数#wechat_redirect
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

        //将回调url进行转码
        String redirectUri = "";
        try {
            redirectUri = URLEncoder.encode(ucenterProperties.getRedirectUri(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new JingGongException(ResultCodeEnum.URL_ENCODE_ERROR);
        }

        //生成随机state，防止csrf攻击
        String state = UUID.randomUUID().toString();
        //将state存入session
        session.setAttribute("wx_open_state", state);

        String qrcodeUrl = String.format(
                baseUrl,
                ucenterProperties.getAppId(),
                redirectUri,
                state);


        //跳转到组装的url地址中去
        return "redirect:" + qrcodeUrl;
    }

    @GetMapping("callback")
    public String callback(String code, String state, HttpSession session){
        System.out.println("callback被调用");
        System.out.println("code:" + code);
        System.out.println("state:" + state);

        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(state)){
            log.error("非法回调请求");
            throw new JingGongException(ResultCodeEnum.ILLEGAL_CALLBACK_REQUEST_ERROR);
        }

        String sessionState = (String)session.getAttribute("wx_open_state");
        if(!state.equals(sessionState)){
            log.error("非法回调请求");
            throw new JingGongException(ResultCodeEnum.ILLEGAL_CALLBACK_REQUEST_ERROR);
        }


        //携带code临时票据，和appid以及appsecret请求access_token和openid（微信唯一标识）
        String accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
        //组装参数：?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
        Map<String, String> accessTokenParam = new HashMap<>();
        accessTokenParam.put("appid", ucenterProperties.getAppId());
        accessTokenParam.put("secret", ucenterProperties.getAppSecret());
        accessTokenParam.put("code", code);
        accessTokenParam.put("grant_type", "authorization_code");
        HttpClientUtils client = new HttpClientUtils(accessTokenUrl, accessTokenParam);

        String result = "";
        try {
            //发送请求：组装完整的url字符串、发送请求
            client.get();
            //得到响应
            result = client.getContent();
            System.out.println("result = " + result);
        } catch (Exception e) {
            log.error("获取access_token失败");
            throw new JingGongException(ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
        }

        Gson gson = new Gson();
        HashMap<String, Object> resultMap = gson.fromJson(result, HashMap.class);

        //失败的响应结果
        Object errcodeObj = resultMap.get("errcode");
        if(errcodeObj != null){
            Double errcode = (Double)errcodeObj;
            String errmsg = (String)resultMap.get("errmsg");
            log.error("获取access_token失败：" + "code：" + errcode + ", message：" +  errmsg);
            throw new JingGongException(ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
        }

        //解析出结果中的access_token和openid
        String accessToken = (String)resultMap.get("access_token");
        String openid = (String)resultMap.get("openid");

        System.out.println("accessToken:" + accessToken);
        System.out.println("openid:" + openid);

        //在本地数据库中查找当前微信用户的信息
        Member member = memberService.getByOpenid(openid);

        if(member == null){
            //if：如果当前用户不存在，则去微信的资源服务器获取用户个人信息（携带access_token）
            String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo";
            //组装参数：?access_token=ACCESS_TOKEN&openid=OPENID
            Map<String, String> baseUserInfoParam = new HashMap<>();
            baseUserInfoParam.put("access_token", accessToken);
            baseUserInfoParam.put("openid", openid);
            client = new HttpClientUtils(baseUserInfoUrl, baseUserInfoParam);

            String resultUserInfo = "";
            try {
                client.get();
                resultUserInfo = client.getContent();
            } catch (Exception e) {
                log.error(ExceptionUtils.getMessage(e));
                throw new JingGongException(ResultCodeEnum.FETCH_USERINFO_ERROR);
            }

            HashMap<String, Object> resultUserInfoMap = gson.fromJson(resultUserInfo, HashMap.class);
            //失败的响应结果
            errcodeObj = resultUserInfoMap.get("errcode");
            if(errcodeObj != null){
                Double errcode = (Double)errcodeObj;
                String errmsg = (String)resultMap.get("errmsg");
                log.error("获取用户信息失败：" + "code：" + errcode + ", message：" +  errmsg);
                throw new JingGongException(ResultCodeEnum.FETCH_USERINFO_ERROR);
            }

            //解析出结果中的用户个人信息
            String nickname = (String)resultUserInfoMap.get("nickname");
            String avatar = (String)resultUserInfoMap.get("headimgurl");
            Double sex = (Double)resultUserInfoMap.get("sex");

            //在本地数据库中插入当前微信用户的信息（使用微信账号在本地服务器注册新用户）
            member = new Member();
            member.setOpenid(openid);
            member.setNickname(nickname);
            member.setAvatar(avatar);
            member.setSex(sex.intValue());
            memberService.save(member);
        }

        //则直接使用当前用户的信息登录（生成jwt）
        //member =>Jwt
        JwtInfo jwtInfo = new JwtInfo();
        jwtInfo.setId(member.getId());
        jwtInfo.setNickname(member.getNickname());
        jwtInfo.setAvatar(member.getAvatar());
        String jwtToken = JwtUtils.getJwtToken(jwtInfo, 1800);

        return "redirect:http://localhost:3000?token=" + jwtToken;
    }


}
