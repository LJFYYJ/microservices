package com.bit.jinggong.service.edu.mapper;

import com.bit.jinggong.service.edu.entity.CourseCollect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.jinggong.service.edu.entity.vo.CourseCollectVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程收藏 Mapper 接口
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
@Repository
public interface CourseCollectMapper extends BaseMapper<CourseCollect> {

    List<CourseCollectVo> selectPageByMemberId(String memberId);
}
