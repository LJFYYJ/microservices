package com.bit.jinggong.service.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.service.edu.entity.Course;
import com.bit.jinggong.service.edu.entity.Teacher;
import com.bit.jinggong.service.edu.entity.vo.TeacherQueryVo;
import com.bit.jinggong.service.edu.feign.OssFileService;
import com.bit.jinggong.service.edu.mapper.CourseMapper;
import com.bit.jinggong.service.edu.mapper.TeacherMapper;
import com.bit.jinggong.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    private OssFileService ossFileService;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public IPage<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo) {

        // 第一步：排序
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        // 分页查询
        if(teacherQueryVo == null) {
            return baseMapper.selectPage(pageParam, queryWrapper);
        }

        // 条件查询
        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();

        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        if (level != null) {
            queryWrapper.eq("level", level);
        }

        if (!StringUtils.isEmpty(joinDateBegin)) {
            queryWrapper.ge("join_date", joinDateBegin);
        }

        if (!StringUtils.isEmpty(joinDateEnd)) {
            queryWrapper.le("join_date", joinDateEnd);
        }

        return baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public List<Map<String, Object>> selectNameListByKey(String key) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.select("name");
        teacherQueryWrapper.likeRight("name", key);
        List<Map<String, Object>> list = baseMapper.selectMaps(teacherQueryWrapper);
        return list;
    }

    @Override
    public boolean removeAvatarById(String id) {

        Teacher teacher = baseMapper.selectById(id);
        if(teacher != null) {
            String avatar = teacher.getAvatar();
            if(!StringUtils.isEmpty(avatar)) {
                R r = ossFileService.removeFile(avatar);
                return r.getSuccess();
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> selectTeacherInfoById(String id) {

        Teacher teacher = baseMapper.selectById(id);

        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("teacher_id", id);
        List<Course> courseList = courseMapper.selectList(courseQueryWrapper);

        Map<String, Object> map = new HashMap<>();
        map.put("teacher", teacher);
        map.put("courseList", courseList);

        return map;
    }

    @Cacheable(value = "index", key = "'selectHotTeacher'")
    @Override
    public List<Teacher> selectHotTeacher() {

        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("sort");
        queryWrapper.last("limit 4");

        return baseMapper.selectList(queryWrapper);
    }
}
