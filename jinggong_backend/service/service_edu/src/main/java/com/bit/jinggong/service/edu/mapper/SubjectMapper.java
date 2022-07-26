package com.bit.jinggong.service.edu.mapper;

import com.bit.jinggong.service.edu.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.jinggong.service.edu.entity.vo.SubjectVo;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
public interface SubjectMapper extends BaseMapper<Subject> {

    List<SubjectVo> selectNestedListByParentId(String parentId);
}
