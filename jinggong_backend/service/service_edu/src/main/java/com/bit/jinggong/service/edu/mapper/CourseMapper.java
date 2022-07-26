package com.bit.jinggong.service.edu.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bit.jinggong.service.base.dto.CourseDto;
import com.bit.jinggong.service.edu.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.jinggong.service.edu.entity.vo.CoursePublishVo;
import com.bit.jinggong.service.edu.entity.vo.CourseVo;
import com.bit.jinggong.service.edu.entity.vo.WebCourseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {

    List<CourseVo> selectPageByCourseQueryVo(
            //mp会自动组装分页参数
            Page<CourseVo> pageParam,
            //mp会自动组装queryWrapper
            //@Param(Constants.WRAPPER) 和 xml文件中的 ${ew.customSqlSegment} 对应
            @Param(Constants.WRAPPER) QueryWrapper<CourseVo> queryWrapper);

    CoursePublishVo selectCoursePublishVoById(String id);

    WebCourseVo selectWebCourseVoById(String courseId);

    CourseDto selectCourseDtoById(String courseId);
}
