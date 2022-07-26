package com.bit.jinggong.service.edu.entity.vo;

import lombok.Data;

@Data
public class CoursePublishVo {

    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectParentTitle;
    private String subjectTitle;
    private String teacherName;
    private String price;//只用于显示
}
