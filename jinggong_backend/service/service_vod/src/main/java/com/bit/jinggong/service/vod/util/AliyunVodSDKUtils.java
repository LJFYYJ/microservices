package com.bit.jinggong.service.vod.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;

public class AliyunVodSDKUtils {

    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) {
        String regionId = "cn-beijing";  // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }
}
