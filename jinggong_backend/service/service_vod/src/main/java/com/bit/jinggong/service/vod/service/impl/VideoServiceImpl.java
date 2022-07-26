package com.bit.jinggong.service.vod.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.bit.jinggong.common.base.result.ResultCodeEnum;
import com.bit.jinggong.service.base.exception.JingGongException;
import com.bit.jinggong.service.vod.service.VideoService;
import com.bit.jinggong.service.vod.util.AliyunVodSDKUtils;
import com.bit.jinggong.service.vod.util.VodProperties;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.List;

@Service
@Slf4j
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VodProperties vodProperties;

    @Override
    public String uploadVideo(InputStream inputStream, String originalFilename) {

        String title = originalFilename.substring(0, originalFilename.lastIndexOf("."));

        UploadStreamRequest request = new UploadStreamRequest(
                vodProperties.getKeyid(),
                vodProperties.getKeysecret(),
                title, originalFilename, inputStream);
        /* 模板组ID(可选) */
        request.setTemplateGroupId(vodProperties.getTemplateGroupId());

        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);

        // 判断videoId是否存在
        String videoId = response.getVideoId();
        if(StringUtils.isEmpty(videoId)){
            log.error("阿里云上传失败：" + response.getCode() + "-" + response.getMessage());
            throw new JingGongException(ResultCodeEnum.VIDEO_UPLOAD_ALIYUN_ERROR);
        }

        return videoId;
    }

    @SneakyThrows
    @Override
    public void removeVideo(String videoId) throws ClientException {
        DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(
                vodProperties.getKeyid(),
                vodProperties.getKeysecret());

        DeleteVideoRequest request = new DeleteVideoRequest();
        //支持传入多个视频ID，多个用逗号分隔
        request.setVideoIds(videoId);
        client.getAcsResponse(request);
    }

    @SneakyThrows
    @Override
    public void removeVideoByIdList(List<String> videoIdList) throws ClientException {
        DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(
                vodProperties.getKeyid(),
                vodProperties.getKeysecret());

        DeleteVideoRequest request = new DeleteVideoRequest();

        int size = videoIdList.size();//id列表的长度
        StringBuffer idListStr = new StringBuffer(); //组装好的字符串
        for (int i = 0; i < size; i++) {
            idListStr.append(videoIdList.get(i));
            //假设取到最后一个ID值 或者 已经取出20个ID值
            if(i == size - 1 || i % 20 == 19){
                //批量删除
                request.setVideoIds(idListStr.toString());
                client.getAcsResponse(request);
                //重置idListStr
                idListStr = new StringBuffer();
            }else if(i % 20 < 19){
                idListStr.append(",");
            }
        }
    }

    @SneakyThrows
    @Override
    public String getPlayAuth(String videoSourceId) throws ClientException {
        DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(
                vodProperties.getKeyid(),
                vodProperties.getKeysecret());

        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();//创建请求对象
        request.setVideoId(videoSourceId);//设置请求参数

        GetVideoPlayAuthResponse response = client.getAcsResponse(request);//发送请求得到响应

        return response.getPlayAuth();
    }
}
