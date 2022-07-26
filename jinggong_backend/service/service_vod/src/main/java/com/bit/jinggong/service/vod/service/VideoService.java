package com.bit.jinggong.service.vod.service;

import com.aliyun.oss.ClientException;

import java.io.InputStream;
import java.util.List;

public interface VideoService {

    String uploadVideo(InputStream file, String originalFilename);


    void removeVideo(String videoId) throws ClientException;

    void removeVideoByIdList(List<String> videoIdList);

    String getPlayAuth(String videoSourceId);
}
