package com.bit.jinggong.service.edu.controller.api;

import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.service.edu.entity.vo.SubjectVo;
import com.bit.jinggong.service.edu.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin
@Api(description="课程分类")
@RestController
@RequestMapping("/api/edu/subject")
public class ApiSubjectController {
    @Autowired
    private SubjectService subjectService;

    @ApiOperation("嵌套数据列表")
    @GetMapping("nested-list")
    public R nestedList(){
        List<SubjectVo> subjectVoList = subjectService.nestedList();
        return R.ok().data("items", subjectVoList);
    }
}
