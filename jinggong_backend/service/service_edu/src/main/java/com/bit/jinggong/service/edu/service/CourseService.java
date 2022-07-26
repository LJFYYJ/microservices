package com.bit.jinggong.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bit.jinggong.service.base.dto.CourseDto;
import com.bit.jinggong.service.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bit.jinggong.service.edu.entity.form.CourseInfoForm;
import com.bit.jinggong.service.edu.entity.vo.*;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
public interface CourseService extends IService<Course> {

    String saveCourseInfoForm(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseInfoById(String id);

    void updateCourseInfoById(CourseInfoForm courseInfoForm);

    IPage<CourseVo> selectPage(Page<CourseVo> pageParam, CourseQueryVo courseQueryVo);

    boolean removeCoverById(String id);

    boolean removeCourseById(String id);

    CoursePublishVo getCoursePublishVoById(String id);

    boolean publishCourseById(String id);

    List<Course> webSelectList(WebCourseQueryVo webCourseQueryVo);

    /**
     * 获取课程信息并更新浏览量
     * @param id
     * @return
     */
    WebCourseVo selectWebCourseVoById(String id);

    List<Course> selectHotCourse();

    CourseDto getCourseDtoById(String courseId);

    void updateBuyCountById(String id);
}
