package com.bit.jinggong.service.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bit.jinggong.service.edu.entity.Subject;
import com.bit.jinggong.service.edu.excel.ExcelSubjectData;
import com.bit.jinggong.service.edu.mapper.SubjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor //无参
@AllArgsConstructor //全参
public class ExcelSubjectDataListener extends AnalysisEventListener<ExcelSubjectData> {

    private SubjectMapper subjectMapper;

    /**
     * 遍历每一行的记录
     * @param excelSubjectData
     * @param analysisContext
     */
    @Override
    public void invoke(ExcelSubjectData excelSubjectData, AnalysisContext analysisContext) {
        log.info("解析到一条记录：{}", excelSubjectData);
        String levelOneTitle = excelSubjectData.getLevelOneTitle();//一级标题
        String levelTwoTitle = excelSubjectData.getLevelTwoTitle();//二级标题
        log.info("levelOneTitle: {}", levelOneTitle);
        log.info("levelTwoTitle: {}", levelTwoTitle);

        // 判断一级类别是否已经在数据库中
        Subject subjectLevelOne = this.getByTitle(levelOneTitle);
        String parentId = null;
        if(subjectLevelOne == null) {
            // 组装一级类别
            Subject subject = new Subject();
            subject.setParentId("0");
            subject.setTitle(levelOneTitle);
            // 存入数据库
            subjectMapper.insert(subject);
            parentId = subject.getId();
        } else {
            parentId = subjectLevelOne.getId();
        }

        // 判断二级类别是否已经在数据库中
        Subject subjectLevelTwo = this.getSubByTitle(levelTwoTitle, parentId);
        if(subjectLevelTwo == null) {
            // 组装二级类别
            Subject subject = new Subject();
            subject.setParentId(parentId);
            subject.setTitle(levelTwoTitle);
            // 存入数据库
            subjectMapper.insert(subject);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }

    /**
     * 根据一级类别寻找对象
     * @param title
     * @return
     */
    private Subject getByTitle(String title) {
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", title);
        queryWrapper.eq("parent_id", 0); // 保证是一级类别
        return subjectMapper.selectOne(queryWrapper);
    }

    /**
     * 根据二级类别寻找对象
     * @param title
     * @return
     */
    private Subject getSubByTitle(String title, String parentId) {
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", title);
        queryWrapper.eq("parent_id", parentId); // 保证是一级类别
        return subjectMapper.selectOne(queryWrapper);
    }
}
