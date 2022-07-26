package com.bit.jinggong.service.edu.service;

import com.bit.jinggong.service.edu.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
public interface VideoService extends IService<Video> {
    void removeMediaVideoById(String id);

    void removeMediaVideoByChapterId(String chapterId);

    void removeMediaVideoByCourseId(String courseId);
}
