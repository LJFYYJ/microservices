package com.bit.jinggong.service.edu.service;

import com.bit.jinggong.service.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bit.jinggong.service.edu.entity.vo.SubjectVo;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
public interface SubjectService extends IService<Subject> {

    void batchImport(InputStream inputStream);

    List<SubjectVo> nestedList();
}
