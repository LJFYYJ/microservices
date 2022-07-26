package com.bit.jinggong.service.base.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseDto {

    private static final long serialVersionUID = 1L;

    private String id;//课程ID
    private String title;//课程标题
    private BigDecimal price;//课程销售价格，设置为0则可免费观看
    private String cover;//课程封面图片路径
    private String teacherName;//课程讲师
}
