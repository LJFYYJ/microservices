package com.bit.jinggong.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String subjectParentTitle;
    private String subjectTitle;
    private String teacherName;
    private Integer lessonNum;
    private String price;
    private String cover;
    private Long buyCount;
    private Long viewCount;
    private String status;
    private String gmtCreate;
}
