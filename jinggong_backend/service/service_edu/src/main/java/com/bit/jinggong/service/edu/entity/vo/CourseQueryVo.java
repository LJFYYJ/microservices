package com.bit.jinggong.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String teacherId;
    private String subjectParentId;
    private String subjectId;
}
