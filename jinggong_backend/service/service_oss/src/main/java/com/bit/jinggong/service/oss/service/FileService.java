package com.bit.jinggong.service.oss.service;

import java.io.InputStream;

public interface FileService {

    /**
     * 阿里云oss文件上传
     * @param inputStream 数据流
     * @param module 目录
     * @param originalFilename 文件名
     * @return 文件在OSS服务器上URL地址
     */
    String upload(InputStream inputStream, String module, String originalFilename);

    void removeFile(String url);
}
