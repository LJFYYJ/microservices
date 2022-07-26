package com.bit.jinggong.service.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.bit.jinggong.service.edu.entity.Subject;
import com.bit.jinggong.service.edu.entity.vo.SubjectVo;
import com.bit.jinggong.service.edu.excel.ExcelSubjectData;
import com.bit.jinggong.service.edu.listener.ExcelSubjectDataListener;
import com.bit.jinggong.service.edu.mapper.SubjectMapper;
import com.bit.jinggong.service.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public void batchImport(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelSubjectData.class, new ExcelSubjectDataListener(baseMapper))
                .excelType(ExcelTypeEnum.XLS).sheet().doRead();
    }

    @Override
    public List<SubjectVo> nestedList() {
        //得到嵌套数据列表
        return baseMapper.selectNestedListByParentId("0");
    }
}
