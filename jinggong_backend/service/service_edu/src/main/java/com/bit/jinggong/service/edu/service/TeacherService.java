package com.bit.jinggong.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bit.jinggong.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bit.jinggong.service.edu.entity.vo.TeacherQueryVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
public interface TeacherService extends IService<Teacher> {

    IPage<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo);

    List<Map<String, Object>> selectNameListByKey(String key);

    boolean removeAvatarById(String id);

    Map<String, Object> selectTeacherInfoById(String id);

    List<Teacher> selectHotTeacher();
}
