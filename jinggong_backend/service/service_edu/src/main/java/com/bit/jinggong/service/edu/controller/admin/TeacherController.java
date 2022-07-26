package com.bit.jinggong.service.edu.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.service.edu.entity.Teacher;
import com.bit.jinggong.service.edu.entity.vo.TeacherQueryVo;
import com.bit.jinggong.service.edu.feign.OssFileService;
import com.bit.jinggong.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
@Api(description = "讲师管理")
@RestController
//@CrossOrigin //跨域
@RequestMapping("/admin/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private OssFileService ossFileService;

    @ApiOperation("获取所有讲师列表")
    @GetMapping("list")
    public R ListAll() {
        List<Teacher> list = teacherService.list();
        return R.ok().data("items", list);
    }

    @ApiOperation("根据ID删除讲师")
    @DeleteMapping("remove/{id}")
    public R removeById(@ApiParam(value = "讲师ID", required = true) @PathVariable String id) {
        //删除讲师头像
        boolean b = teacherService.removeAvatarById(id);

        //删除讲师
        boolean result = teacherService.removeById(id);
        if(result) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("讲师分页列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam(value = "讲师列表查询对象", required = true) TeacherQueryVo teacherQueryVo) {

        Page<Teacher> pageParam = new Page<>(page, limit);
        IPage<Teacher> pageModel = teacherService.selectPage(pageParam, teacherQueryVo);
        List<Teacher> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("新增讲师")
    @PostMapping("save")
    public R save(@ApiParam(value = "讲师对象", required = true) @RequestBody Teacher teacher) {
        boolean result = teacherService.save(teacher);
        if (result) {
            return R.ok().message("保存成功");
        } else {
            return R.error().message("保存失败");
        }
    }

    @ApiOperation("更新讲师")
    @PutMapping("update")
    public R updateById(@ApiParam(value = "讲师对象", required = true) @RequestBody Teacher teacher) {
        boolean result = teacherService.updateById(teacher);
        if(result){
            return R.ok().message("修改成功");
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("根据id获取讲师信息")
    @GetMapping("get/{id}")
    public R getById(@ApiParam(value = "讲师ID", required = true) @PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        if(teacher != null) {
            return R.ok().data("item", teacher);
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("根据id列表删除讲师")
    @DeleteMapping("batch_remove")
    public R removeRows(@ApiParam(value = "讲师ID列表", required = true)
                        @RequestBody List<String> idList) {
        boolean result = teacherService.removeByIds(idList);
        if(result) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("根据左关键字查询讲师名列表")
    @GetMapping("list/name/{key}")
    public R selectNameListByKey(@ApiParam(value = "查询关键字", required = true)
                                     @PathVariable String key) {
        List<Map<String, Object>> nameList = teacherService.selectNameListByKey(key);
        return R.ok().data("nameList", nameList);
    }

}

