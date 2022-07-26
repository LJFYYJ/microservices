package com.bit.jinggong.service.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bit.jinggong.service.edu.entity.Chapter;
import com.bit.jinggong.service.edu.entity.Video;
import com.bit.jinggong.service.edu.entity.vo.ChapterVo;
import com.bit.jinggong.service.edu.entity.vo.VideoVo;
import com.bit.jinggong.service.edu.mapper.ChapterMapper;
import com.bit.jinggong.service.edu.mapper.VideoMapper;
import com.bit.jinggong.service.edu.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    private VideoMapper videoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeChapterById(String id) {
        //课时信息：video
        QueryWrapper<Video> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.eq("chapter_id", id);
        videoMapper.delete(videoQueryWrapper);

        //章节信息：chapter
        return this.removeById(id);
    }

    @Override
    public List<ChapterVo> nestedList(String courseId) {
        List<ChapterVo> chapterVoList = new ArrayList<>();

        //获取章节信息
        QueryWrapper<Chapter> queryWrapperChapter = new QueryWrapper<>();
        queryWrapperChapter.eq("course_id", courseId);
        queryWrapperChapter.orderByAsc("sort", "id");
        List<Chapter> chapterList = baseMapper.selectList(queryWrapperChapter);

        //获取课时信息
        QueryWrapper<Video> queryWrapperVideo = new QueryWrapper<>();
        queryWrapperVideo.eq("course_id", courseId); // 通过冗余字段course_id获取video信息，只需要1+N个sql
        queryWrapperVideo.orderByAsc("sort", "id");
        List<Video> videoList = videoMapper.selectList(queryWrapperVideo);

        // 填充列表数据：Chapter列表
        for(int i=0; i<chapterList.size(); i++) {
            Chapter chapter = chapterList.get(i);

            // 创建ChapterVo对象
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            chapterVoList.add(chapterVo);

            // 填充列表数据：Video列表
            List<VideoVo> videoVoList = new ArrayList<>();
            for(int j=0; j<videoList.size(); j++) {
                Video video = videoList.get(j);

                if(chapter.getId().equals(video.getChapterId())) {
                    // 创建VideoVo对象
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videoVoList.add(videoVo);
                }
            }
            chapterVo.setChildren(videoVoList);
        }
        return chapterVoList;
    }
}
