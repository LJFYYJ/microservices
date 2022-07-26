package com.bit.jinggong.service.edu.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelSubjectData {

    @ExcelProperty(value = "一级分类")
    private String levelOneTitle;

    @ExcelProperty(value = "二级分类")
    private String levelTwoTitle;
}
