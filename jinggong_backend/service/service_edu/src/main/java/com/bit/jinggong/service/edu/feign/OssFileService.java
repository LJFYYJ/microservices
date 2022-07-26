package com.bit.jinggong.service.edu.feign;


import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.service.edu.feign.fallback.OssFileServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(value = "service-oss", fallback = OssFileServiceFallBack.class) //给出备份方案
public interface OssFileService {

    @DeleteMapping("/admin/oss/file/remove")
    R removeFile(@RequestBody String url);
}
