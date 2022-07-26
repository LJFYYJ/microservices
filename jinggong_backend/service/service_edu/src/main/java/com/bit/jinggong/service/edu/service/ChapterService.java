package com.bit.jinggong.service.edu.service;

import com.bit.jinggong.service.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bit.jinggong.service.edu.entity.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
public interface ChapterService extends IService<Chapter> {

    boolean removeChapterById(String id);

    List<ChapterVo> nestedList(String courseId);
}
