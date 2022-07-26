package com.bit.jinggong.service.oss.controller.admin;

import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.common.base.result.ResultCodeEnum;
import com.bit.jinggong.common.base.util.ExceptionUtils;
import com.bit.jinggong.service.base.exception.JingGongException;
import com.bit.jinggong.service.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Api(description="阿里云文件管理")
//@CrossOrigin //跨域
@RestController
@Slf4j
@RequestMapping("/admin/oss/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     * @param file 文件
     * @param module 目录
     * @return 统一返回接口
     * @throws IOException 输入输出异常
     */
    @ApiOperation("文件上传")
    @PostMapping("upload")
    public R upload(@ApiParam(value = "文件", required = true)
                        @RequestParam("file") MultipartFile file,
                    @ApiParam(value = "模块", required = true)
                    @RequestParam("module") String module) {

        try {

            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String uploadUrl = fileService.upload(inputStream, module, originalFilename);
            //返回r对象
            return R.ok().message("文件上传成功").data("url", uploadUrl);
        } catch(Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new JingGongException(ResultCodeEnum.FILE_UPLOAD_ERROR);
        }
    }

    @ApiOperation(value = "文件删除")
    @DeleteMapping("remove")
    public R removeFile(
        @ApiParam(value = "要删除的文件路径", required = true)
        @RequestBody String url) {
        fileService.removeFile(url);
        return R.ok().message("文件刪除成功");
    }
}